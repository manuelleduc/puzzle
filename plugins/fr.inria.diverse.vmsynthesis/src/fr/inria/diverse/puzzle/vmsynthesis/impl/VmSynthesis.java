package fr.inria.diverse.puzzle.vmsynthesis.impl;

import java.util.ArrayList;
import java.util.List;

import fr.inria.diverse.graph.Arc;
import fr.inria.diverse.graph.Graph;
import fr.inria.diverse.graph.Vertex;
import vm.PBinaryExpression;
import vm.PBinaryOperator;
import vm.PBooleanExpression;
import vm.PConstraint;
import vm.PFeature;
import vm.PFeatureGroup;
import vm.PFeatureGroupCardinality;
import vm.PFeatureModel;
import vm.PFeatureRef;
import vm.PUnaryExpression;
import vm.PUninaryOperator;
import vm.VmFactory;

/**
 * Algorithm for synthesizing feature models from PCMs and dependencies graphs.
 * 
 * @author David Mendez-Acuna
 *
 */
public class VmSynthesis {

	// ----------------------------------------------------------
	// Attributes
	// ----------------------------------------------------------

	private static VmSynthesis instance;

	// ----------------------------------------------------------
	// Constructor and singleton
	// ----------------------------------------------------------

	private VmSynthesis() {

	}

	public static VmSynthesis getInstance() {
		if (instance == null)
			instance = new VmSynthesis();
		return instance;
	}

	// ----------------------------------------------------------
	// Methods
	// ----------------------------------------------------------

	/**
	 * Synthesizes an open feature model from the given dependencies graph.
	 * 
	 * @param dependenciesGraph
	 * @return
	 */
	public PFeatureModel synthesizeOpenFeatureModel(Graph<Vertex, Arc> dependenciesGraph) {
		PFeatureModel featureModel = VmFactory.eINSTANCE.createPFeatureModel();

		// TODO Put a real family name to the feature model.
		featureModel.setName("FeatureModel");

		PFeature rootFeature = VmFactory.eINSTANCE.createPFeature();
		rootFeature.setMandatory(true);
		rootFeature.setName("Root");

		// Step 2: The first level features are those vertex in the graph such
		// that they have not dependencies with other vertex.
		List<Vertex> firstLevelVertex = dependenciesGraph.getIndendependentVertex();
		for (Vertex dependencyVertex : firstLevelVertex) {
			dependencyVertex.setIncluded(true);

			PFeature feature = VmFactory.eINSTANCE.createPFeature();
			feature.setName(dependencyVertex.getIdentifier());
			feature.setParent(rootFeature);

			PFeatureGroup featureGroup = VmFactory.eINSTANCE.createPFeatureGroup();
			featureGroup.getFeatures().add(feature);

			PFeatureGroupCardinality cardinality = VmFactory.eINSTANCE.createPFeatureGroupCardinality();
			cardinality.setLowerBound(0);
			cardinality.setUpperBound(1);
			featureGroup.setCardinality(cardinality);
			rootFeature.getGroups().add(featureGroup);
		}

		List<Vertex> currentLevel = firstLevelVertex;

		while (!dependenciesGraph.allIncluded()) {
			List<Vertex> directDependentVertex = dependenciesGraph.getDirectDependentVertex(currentLevel);
			for (Vertex dependencyVertex : directDependentVertex) {
				if (!dependencyVertex.isIncluded()) {
					PFeature feature = VmFactory.eINSTANCE.createPFeature();
					feature.setName(dependencyVertex.getIdentifier());
					dependencyVertex.setIncluded(true);

					boolean first = true;
					for (Arc dependencyArc : dependencyVertex.getOutgoingArcs()) {
						if (currentLevel.contains(dependencyArc.getTo())) {
							if (first) {
								// Esta feature no tiene padre. Asignelo.
								PFeature parent = this.getPFeatureByName(dependencyArc.getTo().getIdentifier(),
										rootFeature);
								feature.setParent(parent);

								PFeatureGroup featureGroup = VmFactory.eINSTANCE.createPFeatureGroup();
								featureGroup.getFeatures().add(feature);

								PFeatureGroupCardinality cardinality = VmFactory.eINSTANCE
										.createPFeatureGroupCardinality();
								cardinality.setLowerBound(0);
								cardinality.setUpperBound(1);
								featureGroup.setCardinality(cardinality);

								parent.getGroups().add(featureGroup);
							}
							first = false;
						}
					}
				}
			}
			currentLevel = directDependentVertex;
		}

		featureModel.setRootFeature(rootFeature);
		this.addCrosslevelRequires(featureModel, dependenciesGraph);
		return featureModel;
	}

	private void addCrosslevelRequires(PFeatureModel featureModel, Graph<Vertex, Arc> dependenciesGraph) {
		for (Arc arc : dependenciesGraph.getArcs()) {
			if (!this.isFather(featureModel.getRootFeature(), arc.getTo().getIdentifier(),
					arc.getFrom().getIdentifier())) {
				PFeature requiredFeature = this.getPFeatureByName(arc.getTo().getIdentifier(),
						featureModel.getRootFeature());
				PConstraint constraint = VmFactory.eINSTANCE.createPConstraint();
				PBinaryExpression binaryExpression = VmFactory.eINSTANCE.createPBinaryExpression();
				PFeatureRef left = VmFactory.eINSTANCE.createPFeatureRef();
				left.setRef(this.getPFeatureByName(arc.getFrom().getIdentifier(), featureModel.getRootFeature()));
				PFeatureRef right = VmFactory.eINSTANCE.createPFeatureRef();
				right.setRef(requiredFeature);
				binaryExpression.setLeft(left);
				binaryExpression.setRight(right);
				binaryExpression.setOperator(PBinaryOperator.IMPLIES);
				constraint.setExpression(binaryExpression);
				constraint.setName(left.getRef().getName() + " implies " + right.getRef().getName());
				featureModel.getConstraints().add(constraint);
			}
		}

	}

	private boolean isFather(PFeature root, String father, String child) {
		if (root.getName().equals(father)) {
			for (PFeature children : root.getChildren()) {
				if (children.getName().equals(child)) {
					return true;
				}
			}
		} else {
			for (PFeature children : root.getChildren()) {
				boolean isFather = this.isFather(children, father, child);
				if (isFather) {
					return true;
				}
			}
		}
		return false;
	}

	public PFeatureModel synthesizeClosedFeatureModel(String PCM, PFeatureModel openFeatureModel) throws Exception {
		PFeatureModel closedFeatureModel = this.cloneFeatureModel(openFeatureModel);
		PCMQueryServices.getInstance().loadPCM(PCM);

		this.identifyMandatoryFeatures(closedFeatureModel);
		this.identifyXORs(closedFeatureModel);
		this.identifyORs(closedFeatureModel);
		this.addAdditionalImpliesConstraints(closedFeatureModel);
		this.addAdditionalExcludesConstraints(closedFeatureModel);
		this.groupImplicationsByLeftSide(closedFeatureModel);
		
		return closedFeatureModel;
	}



	/**
	 * Identifies the mandatory features in the feature model received in the
	 * parameter.
	 * 
	 * @param fm.
	 *            Feature model under study.
	 */
	public void identifyMandatoryFeatures(PFeatureModel fm) {
		for (PFeature child : fm.getRootFeature().getChildren()) {
			this.identifyMandatoryFeatures(child, true);
		}
	}

	/**
	 * Identifies the mandatory features recursively starting by the feature in
	 * the parameter.
	 * 
	 * @param rootFeature.
	 *            The root feature of the hierarchy.
	 * @param isRoot.
	 *            Indicates if the current feature is the feature of the feature
	 *            model.
	 */
	private void identifyMandatoryFeatures(PFeature rootFeature, boolean isRoot) {
		if (isRoot) {
			if (PCMQueryServices.getInstance().existsProductWithoutFeature(rootFeature.getName()))
				rootFeature.setMandatory(false);
			else {
				rootFeature.setMandatory(true);
				if (rootFeature.getParent() != null) {
					for (PFeatureGroup parentGroup : rootFeature.getParent().getGroups()) {
						if (parentGroup.getFeatures().get(0).getName().equals(rootFeature.getName())) {
							parentGroup.getCardinality().setLowerBound(1);
							parentGroup.getCardinality().setUpperBound(1);
						}
					}
				}
			}
		} else {
			boolean optional = PCMQueryServices.getInstance()
					.existsProductWithFeatureAWithoutFeatureB(rootFeature.getParent().getName(), rootFeature.getName());

			if (optional) {
				rootFeature.setMandatory(false);
			} else {
				rootFeature.setMandatory(true);
				if (rootFeature.getParent() != null) {
					for (PFeatureGroup parentGroup : rootFeature.getParent().getGroups()) {
						if (parentGroup.getFeatures().get(0).getName().equals(rootFeature.getName())) {
							parentGroup.getCardinality().setLowerBound(1);
							parentGroup.getCardinality().setUpperBound(1);
						}
					}
				}
			}
		}

		for (PFeature child : rootFeature.getChildren()) {
			this.identifyMandatoryFeatures(child, false);
		}
	}

	/**
	 * Identifies the XOR groups in the feature model received in the parameter.
	 * 
	 * @param fm.
	 *            Feature model under study.
	 */
	public void identifyXORs(PFeatureModel fm) {
		this.identifyXORs(fm.getRootFeature());
	}

	/**
	 * Identifies the XOR groups recursively starting by the feature in the
	 * parameter.
	 * 
	 * @param rootFeature.
	 *            The root feature of the hierarchy.
	 * @param allXORs.
	 *            A collection where the XOR groups will be stored.
	 */
	private void identifyXORs(PFeature rootFeature) {
		ArrayList<ArrayList<PFeature>> allXORs = new ArrayList<ArrayList<PFeature>>();
		ArrayList<PFeature> initialGroup = new ArrayList<PFeature>();
		for (PFeatureGroup group : rootFeature.getGroups()) {
			if (group.getCardinality().getLowerBound() == 0 && group.getCardinality().getUpperBound() == 1
					&& group.getFeatures().size() > 0) {
				initialGroup.add(group.getFeatures().get(0));
			}
		}
		this.identifyXORByCombination(initialGroup, allXORs);
		this.sortBySize(allXORs);
		ArrayList<PFeature> added = new ArrayList<PFeature>();

		for (ArrayList<PFeature> xor : allXORs) {
			if (this.isStillValid(added, xor)) {
				// Create new XOR group
				for (PFeature pFeature : xor) {
					PFeatureGroup featureGroup = this.getGroupByFeature(rootFeature, pFeature);
					rootFeature.getGroups().remove(featureGroup);
				}
				this.createXORGroup(rootFeature, xor);
				// Add to the already considered elements.
				if(xor.size() >= 2)
					added.addAll(xor);
			}
		}

		for (PFeature child : rootFeature.getChildren()) {
			this.identifyXORs(child);
		}
	}

	/**
	 * Searches the group containing the feature in the parameter starting by
	 * the given root feature.
	 * 
	 * @param rootFeature
	 * @param feature
	 * @return
	 */
	private PFeatureGroup getGroupByFeature(PFeature rootFeature, PFeature feature) {
		for (PFeatureGroup currentGroup : rootFeature.getGroups()) {
			if (currentGroup.getFeatures().contains(feature))
				return currentGroup;
		}
		return null;
	}

	/**
	 * Creates an XOR group with the features in the parameter and add it to the
	 * root feature.
	 * 
	 * @param rootFeature
	 * @param xor
	 */
	private void createXORGroup(PFeature rootFeature, ArrayList<PFeature> xorFeatures) {
		PFeatureGroup XORGroup = VmFactory.eINSTANCE.createPFeatureGroup();
		XORGroup.getFeatures().addAll(xorFeatures);

		PFeatureGroupCardinality cardinality = VmFactory.eINSTANCE.createPFeatureGroupCardinality();
		ArrayList<String> features = new ArrayList<String>();
		for (PFeature pFeature : xorFeatures) {
			features.add(pFeature.getName());
		}

		ArrayList<String> consideredProducts = null;
		if (rootFeature.getName().equals("Root"))
			consideredProducts = PCMQueryServices.getInstance().getAllProducts();
		else
			consideredProducts = PCMQueryServices.getInstance().getProductsContainingFeature(rootFeature.getName());

		cardinality.setLowerBound(PCMQueryServices.getInstance().minFeaturesOccurrences(features, consideredProducts));
		cardinality.setUpperBound(1);
		XORGroup.setCardinality(cardinality);
		rootFeature.getGroups().add(XORGroup);
	}

	/**
	 * Sorts the array of groups in the parameter by size.
	 * 
	 * @param group
	 */
	private void sortBySize(ArrayList<ArrayList<PFeature>> group) {
		// TODO Implement it!!
	}

	/**
	 * Returns true if the XOR in the parameter does not contains any of the
	 * features in the array
	 * 
	 * @param features
	 * @param xor
	 * @return
	 */
	private boolean isStillValid(ArrayList<PFeature> features, ArrayList<PFeature> xor) {
		for (int i = 0; i < features.size(); i++) {
			for (int j = 0; j < xor.size(); j++) {
				if (features.get(i).getName().equals(xor.get(j).getName()))
					return false;
			}
		}
		return true;
	}

	/**
	 * Identifies the XOR groups existing in the feature in the parameter. This
	 * method considers all the possible group combinations.
	 * 
	 * @param group
	 * @param allXORs
	 */
	private void identifyXORByCombination(ArrayList<PFeature> group, ArrayList<ArrayList<PFeature>> allXORs) {
		ArrayList<String> features = new ArrayList<String>();
		for (PFeature feature : group) {
			features.add(feature.getName());
		}
		boolean xor = PCMQueryServices.getInstance().xor(features);
		if (xor && group.size() >= 2) {
			allXORs.add(group);
			return;
		} else {
//			for (PFeature feature : group) {
//				ArrayList<PFeature> recursiveFeatures = new ArrayList<PFeature>();
//				for (PFeature recursiveFeature : group) {
//					if (!recursiveFeature.getName().equals(feature.getName()))
//						recursiveFeatures.add(recursiveFeature);
//				}
//				if (recursiveFeatures.size() >= 2) {
//					this.identifyXORByCombination(recursiveFeatures, allXORs);
//				}
//			}
		}
	}

	/**
	 * Identifies the OR groups in the feature model received in the parameter.
	 * 
	 * @param fm.
	 *            Feature model under study.
	 */
	public void identifyORs(PFeatureModel fm) {
		this.identifyORs(fm.getRootFeature());
	}

	/**
	 * Identifies the OR groups recursively starting by the feature in the
	 * parameter.
	 * 
	 * @param rootFeature.
	 *            The root feature of the hierarchy.
	 */
	private void identifyORs(PFeature rootFeature) {
		ArrayList<PFeature> or = new ArrayList<PFeature>();
		for (PFeatureGroup group : rootFeature.getGroups()) {
			if (group.getCardinality().getLowerBound() == 0 && group.getCardinality().getUpperBound() == 1
					&& group.getFeatures().size() == 1) {
				or.add(group.getFeatures().get(0));
			}
		}

		if (or.size() > 1) {
			for (PFeature pFeature : or) {
				PFeatureGroup featureGroup = this.getGroupByFeature(rootFeature, pFeature);
				rootFeature.getGroups().remove(featureGroup);
			}
			this.createORGroup(rootFeature, or);
		}

		for (PFeature child : rootFeature.getChildren()) {
			this.identifyORs(child);
		}
	}

	/**
	 * Creates an OR group with the features in the parameter and adds it to the
	 * root feature.
	 * 
	 * @param rootFeature
	 * @param or
	 */
	private void createORGroup(PFeature rootFeature, ArrayList<PFeature> orFeatures) {
		PFeatureGroup ORGroup = VmFactory.eINSTANCE.createPFeatureGroup();
		ORGroup.getFeatures().addAll(orFeatures);

		PFeatureGroupCardinality cardinality = VmFactory.eINSTANCE.createPFeatureGroupCardinality();
		ArrayList<String> features = new ArrayList<String>();
		for (PFeature pFeature : orFeatures) {
			features.add(pFeature.getName());
		}

		ArrayList<String> consideredProducts = null;
		if (rootFeature.getName().equals("Root"))
			consideredProducts = PCMQueryServices.getInstance().getAllProducts();
		else
			consideredProducts = PCMQueryServices.getInstance().getProductsContainingFeature(rootFeature.getName());

		cardinality.setLowerBound(PCMQueryServices.getInstance().minFeaturesOccurrences(features, consideredProducts));
		cardinality.setUpperBound(PCMQueryServices.getInstance().maxFeaturesOccurrences(features, consideredProducts));
		ORGroup.setCardinality(cardinality);
		rootFeature.getGroups().add(ORGroup);
	}

	/**
	 * Identifies the implications existing between the features of the feature model given in the parameter.
	 * @param fm
	 */
	public void addAdditionalImpliesConstraints(PFeatureModel fm) {
		ArrayList<PFeature> features = new ArrayList<PFeature>();
		this.collectPFeatures(features, fm.getRootFeature());

		for (int i = 1; i < features.size(); i++) {
			for (int j = 1; j < features.size(); j++) {
				PFeature origin = features.get(i);
				PFeature destination = features.get(j);

				if (!origin.getName().equals(destination.getName())) {
					boolean child = this.featureAIsParentOfB(destination, origin);
					if (!child && !destination.isMandatory() && PCMQueryServices.getInstance()
							.allProductsWithFeatureAHaveAlsoFeatureB(origin.getName(), destination.getName()) &&
							!this.implicationExists(origin, destination, fm)) {
						this.createImplies(origin, destination, fm);
					}
				}
			}
		}
	}

	/**
	 * Indicates if in the feature model in the parameter there is already an implication between the origin and the destination. 
	 * @param origin
	 * @param destination
	 * @param fm
	 * @return
	 */
	private boolean implicationExists(PFeature origin, PFeature destination,
			PFeatureModel fm) {
		
		PConstraint implies = VmFactory.eINSTANCE.createPConstraint();
		PFeatureRef left = VmFactory.eINSTANCE.createPFeatureRef();
		left.setRef(origin);
		PFeatureRef right = VmFactory.eINSTANCE.createPFeatureRef();
		right.setRef(destination);

		PBinaryExpression pBinaryExpression = VmFactory.eINSTANCE.createPBinaryExpression();
		pBinaryExpression.setLeft(left);
		pBinaryExpression.setRight(right);
		pBinaryExpression.setOperator(PBinaryOperator.IMPLIES);

		implies.setExpression(pBinaryExpression);
		
		for (PConstraint constraint : fm.getConstraints()) {
			if(pBooleanExpressionEquals(constraint.getExpression(), implies.getExpression())){
				return true;
			}
		}
		return false;
	}

	private boolean featureAIsParentOfB(PFeature A, PFeature B) {
		if (B.getParent() == null)
			return false;
		else if (A.getName().equals(B.getParent().getName()))
			return true;
		else {
			return this.featureAIsParentOfB(A, B.getParent());
		}
	}

	/**
	 * Creates an implies constraint from the origin to the destination in the feature model given in the parameter.
	 * @param origin
	 * @param destination
	 * @param fm
	 */
	private void createImplies(PFeature origin, PFeature destination,
			PFeatureModel fm) {
		
		PConstraint implies = VmFactory.eINSTANCE.createPConstraint();
		PFeatureRef left = VmFactory.eINSTANCE.createPFeatureRef();
		left.setRef(origin);
		PFeatureRef right = VmFactory.eINSTANCE.createPFeatureRef();
		right.setRef(destination);

		PBinaryExpression pBinaryExpression = VmFactory.eINSTANCE.createPBinaryExpression();
		pBinaryExpression.setLeft(left);
		pBinaryExpression.setRight(right);
		pBinaryExpression.setOperator(PBinaryOperator.IMPLIES);

		implies.setExpression(pBinaryExpression);
		implies.setName(left.getRef().getName() + " implies " + right.getRef().getName());
	
		fm.getConstraints().add(implies);
	}

	/**
	 * Adds the additional excludes constraints to the closed feature model.
	 * 
	 * @param fm
	 */
	public void addAdditionalExcludesConstraints(PFeatureModel fm) {
		ArrayList<PFeature> features = new ArrayList<PFeature>();
		this.collectPFeatures(features, fm.getRootFeature());

		for (int i = 1; i < features.size(); i++) {
			for (int j = 1; j < features.size(); j++) {
				PFeature origin = features.get(i);
				PFeature destination = features.get(j);

				if (!origin.getName().equals(destination.getName())) {
					if (!origin.getParentGroup().equals(destination.getParentGroup()) && PCMQueryServices.getInstance()
							.allProductsWithFeatureAExcludeFeatureB(origin.getName(), destination.getName())) {
						this.createExcludes(origin, destination, fm);
					}
				}
			}
		}
	}

	
	/**
	 * Creates an excludes (implies not) constraint from the origin to the destination in the feature model given in the parameter.
	 * @param origin
	 * @param destination
	 * @param fm
	 */
	private void createExcludes(PFeature origin, PFeature destination,
			PFeatureModel fm) {
		

		PConstraint excludes = VmFactory.eINSTANCE.createPConstraint();
		PFeatureRef left = VmFactory.eINSTANCE.createPFeatureRef();
		left.setRef(origin);

		PFeatureRef right = VmFactory.eINSTANCE.createPFeatureRef();
		right.setRef(destination);

		PUnaryExpression notImplies = VmFactory.eINSTANCE.createPUnaryExpression();
		notImplies.setExpr(right);
		notImplies.setOperator(PUninaryOperator.NOT);

		PBinaryExpression pBinaryExpression = VmFactory.eINSTANCE.createPBinaryExpression();
		pBinaryExpression.setLeft(left);
		pBinaryExpression.setRight(notImplies);
		pBinaryExpression.setOperator(PBinaryOperator.IMPLIES);

		excludes.setExpression(pBinaryExpression);
		excludes.setName(left.getRef().getName() + " excludes " + right.getRef().getName());
		fm.getConstraints().add(excludes);
	}


	/**
	 * Groups the includes constraints in the given feature model that have the same right side. 
	 * @param featureModel. 
	 */
	public void groupImplicationsByRightSide(PFeatureModel featureModel) {
		
		// Step 1. Collect the implication groups in the variable 'groups'
		ArrayList<RightImplicationsGroup> groups = new ArrayList<RightImplicationsGroup>();
		for (PConstraint constraintI : featureModel.getConstraints()) {
			if(constraintI.getExpression() instanceof PBinaryExpression
					&& ((PBinaryExpression)constraintI.getExpression()).getOperator().getName().equals(PBinaryOperator.IMPLIES.getName())){
				
				PBinaryExpression impliesI = (PBinaryExpression) constraintI.getExpression();
				
				if(impliesI.getRight() instanceof PFeatureRef){
					PFeatureRef rightFeatureRefI = (PFeatureRef) impliesI.getRight();
					if(!this.existsImplicationGroup(groups, rightFeatureRefI)){
						RightImplicationsGroup newGroup = new RightImplicationsGroup(rightFeatureRefI, false);
						
						for (PConstraint constraintJ : featureModel.getConstraints()) {
							if(constraintJ.getExpression() instanceof PBinaryExpression
									&& ((PBinaryExpression)constraintJ.getExpression()).getOperator().getName().equals(PBinaryOperator.IMPLIES.getName())
									&& constraintI != constraintJ){
								
								PBinaryExpression impliesJ = (PBinaryExpression) constraintJ.getExpression();
								
								if(impliesI.getRight() instanceof PFeatureRef &&
										impliesJ.getRight() instanceof PFeatureRef){
									PFeatureRef leftFeatureRef = (PFeatureRef) impliesJ.getLeft();
									PFeatureRef rightFeatureRefJ = (PFeatureRef) impliesJ.getRight();
									
									if(rightFeatureRefI.getRef().getName().equals(rightFeatureRefJ.getRef().getName())){
										if(!this.containsFeatureRef(newGroup.getLeftSide(), leftFeatureRef))
											newGroup.getLeftSide().add(leftFeatureRef);
									}
								}
							}
						}
						if(newGroup.getLeftSide().size() >= 2)
							groups.add(newGroup);
					}
				}
			}
		}
		
		// Step 2. Filtering the real groups!
		ArrayList<RightImplicationsGroup> realGroups = new ArrayList<RightImplicationsGroup>();
		for (RightImplicationsGroup group : groups) {
			this.searchRealRightImplicationsGroupByCombinatory(realGroups, group);
		}
		
		// Step 3. Creating one constraint for each real group. 
		for (RightImplicationsGroup group : realGroups) {
			if(group.getRightSide() != null){
				PConstraint constraint = this.fromRightImplicationToConstraint(group);
				featureModel.getConstraints().add(constraint);
			}
		}
	}
	
	/**
	 * Groups the excludes constraints contained in the given feature model that have the same right side. 
	 * @param featureModel
	 */
	public void groupNotImplicationsByRightSide(PFeatureModel featureModel) {
		// Step 1. Collect the implication groups in the variable 'groups'
		ArrayList<RightImplicationsGroup> groups = new ArrayList<RightImplicationsGroup>();
		for (PConstraint constraintI : featureModel.getConstraints()) {
			if(constraintI.getExpression() instanceof PBinaryExpression
					&& ((PBinaryExpression)constraintI.getExpression()).getOperator().getName().equals(PBinaryOperator.IMPLIES.getName())){
			
				PBinaryExpression impliesI = (PBinaryExpression) constraintI.getExpression();
			
				if(impliesI.getRight() instanceof PUnaryExpression){
					PUnaryExpression unaryExprssionI = (PUnaryExpression) impliesI.getRight();
					PFeatureRef rightFeatureRefI = (PFeatureRef) unaryExprssionI.getExpr();
					if(!this.existsImplicationGroup(groups, rightFeatureRefI)){
						RightImplicationsGroup newGroup = new RightImplicationsGroup(rightFeatureRefI, true);
						
						for (PConstraint constraintJ : featureModel.getConstraints()) {
							if(constraintJ.getExpression() instanceof PBinaryExpression
									&& ((PBinaryExpression)constraintJ.getExpression()).getOperator().getName().equals(PBinaryOperator.IMPLIES.getName())
									&& constraintI != constraintJ){
								
								PBinaryExpression impliesJ = (PBinaryExpression) constraintJ.getExpression();
								
								if(impliesI.getRight() instanceof PUnaryExpression &&
										impliesJ.getRight() instanceof PUnaryExpression){
									
									PFeatureRef leftFeatureRef = (PFeatureRef) impliesJ.getLeft();
									
									PUnaryExpression unaryExprssionJ = (PUnaryExpression) impliesJ.getRight();
									PFeatureRef rightFeatureRefJ = (PFeatureRef) unaryExprssionJ.getExpr();
									
									if(rightFeatureRefI.getRef().getName().equals(rightFeatureRefJ.getRef().getName())){
										if(!this.containsFeatureRef(newGroup.getLeftSide(), leftFeatureRef))
											newGroup.getLeftSide().add(leftFeatureRef);
									}
								}
							}
						}
						if(newGroup.getLeftSide().size() >= 2)
							groups.add(newGroup);
					}
				}
			}
		}
		
		// Step 2. Filtering the real groups!
		ArrayList<RightImplicationsGroup> realGroups = new ArrayList<RightImplicationsGroup>();
		for (RightImplicationsGroup group : groups) {
			this.searchRealRightNotImplicationsGroupByCombinatory(realGroups, group);
		}
		
		// Step 3. Creating one constraint for each real group. 
		for (RightImplicationsGroup group : realGroups) {
			PConstraint constraint = this.fromRightNotImplicationToConstraint(group);
			featureModel.getConstraints().add(constraint);
		}
	}
	
	/**
	 * Searches all the possible implications in the implications group in the parameter. 
	 * It explores all the possible combinations of the involved features.
	 * @param realGroups. The parameter in which the result is stored.
	 * @param group. The group under study.
	 */
	private void searchRealRightImplicationsGroupByCombinatory(
			ArrayList<RightImplicationsGroup> realGroups,
			RightImplicationsGroup group) {
		
		if(group.getLeftSide().size() >= 2){
			ArrayList<String> leftFeatures = new ArrayList<String>();
			for (PFeatureRef featureRef : group.getLeftSide()) {
				leftFeatures.add(featureRef.getRef().getName());
			}
			
			// Base case: The current group is a real group
			if(PCMQueryServices.getInstance().allProductsWithFeaturesSetAHaveAlsoFeatureB(leftFeatures, 
					group.getRightSide().getRef().getName())){
				realGroups.add(group);
			}
			
			// Recursive case: Now we need to search for real groups in the combinations of the features of the current real group. 
			for (PFeatureRef currentFeature : group.getLeftSide()) {
				RightImplicationsGroup newGroup = new RightImplicationsGroup(group.getRightSide(), false);
				for (PFeatureRef fRef : group.getLeftSide()) {
					if(!fRef.getRef().getName().equals(currentFeature.getRef().getName()))
						newGroup.getLeftSide().add(fRef);
				}
				this.searchRealRightImplicationsGroupByCombinatory(realGroups, newGroup);
			}
		}
	}
	
	/**
	 * Searches all the possible not-implications in the implications group in the parameter. 
	 * It explores all the possible combinations of the involved features.
	 * @param realGroups. The parameter in which the result is stored.
	 * @param group. The group under study.
	 */
	private void searchRealRightNotImplicationsGroupByCombinatory(
			ArrayList<RightImplicationsGroup> realGroups,
			RightImplicationsGroup group) {
		
		if(group.getLeftSide().size() >= 2){
			ArrayList<String> leftFeatures = new ArrayList<String>();
			for (PFeatureRef featureRef : group.getLeftSide()) {
				leftFeatures.add(featureRef.getRef().getName());
			}
			
			// Base case: The current group is a real group
			if(PCMQueryServices.getInstance().allProductsWithFeaturesSetAExcludeFeatureB(leftFeatures, 
					group.getRightSide().getRef().getName())){
				realGroups.add(group);
			}
			
			// Recursive case: Now we need to search for real groups in the combinations of the features of the current real group. 
			for (PFeatureRef currentFeature : group.getLeftSide()) {
				RightImplicationsGroup newGroup = new RightImplicationsGroup(group.getRightSide(), true);
				for (PFeatureRef fRef : group.getLeftSide()) {
					if(!fRef.getRef().getName().equals(currentFeature.getRef().getName()))
						newGroup.getLeftSide().add(fRef);
				}
				this.searchRealRightNotImplicationsGroupByCombinatory(realGroups, newGroup);
			}
		}
	}

	/**
	 * Creates an implies constraint from the right implication group in the paramter.
	 * @param group
	 * @return
	 */
	private PConstraint fromRightImplicationToConstraint(
			RightImplicationsGroup group) {
		
		PConstraint constraint = VmFactory.eINSTANCE.createPConstraint();
		constraint.setName(group.toString());
		
		PBinaryExpression implies = VmFactory.eINSTANCE.createPBinaryExpression();
		implies.setOperator(PBinaryOperator.IMPLIES);
		implies.setRight(this.clonePFeatureRef(group.getRightSide()));
		
		PBooleanExpression currentExpression = this.clonePFeatureRef(group.getLeftSide().get(0));
		for (int i = 1; i < group.getLeftSide().size(); i++) {
			PBinaryExpression binary = VmFactory.eINSTANCE.createPBinaryExpression();
			binary.setOperator(PBinaryOperator.AND);
			binary.setLeft(currentExpression);
			binary.setRight(this.clonePFeatureRef(group.getLeftSide().get(i)));
			currentExpression = binary;
		}
		
		implies.setLeft(currentExpression);
		constraint.setExpression(implies);
		return constraint;
	}

	/**
	 * Creates a not-implies constraint from the right implication group in the paramter.
	 * @param group
	 * @return
	 */
	private PConstraint fromRightNotImplicationToConstraint(
			RightImplicationsGroup group) {
		PConstraint constraint = VmFactory.eINSTANCE.createPConstraint();
		constraint.setName(group.toString());
		
		PBinaryExpression implies = VmFactory.eINSTANCE.createPBinaryExpression();
		implies.setOperator(PBinaryOperator.IMPLIES);
		
		PUnaryExpression notImplies = VmFactory.eINSTANCE.createPUnaryExpression();
		notImplies.setOperator(PUninaryOperator.NOT);
		notImplies.setExpr(this.clonePFeatureRef(group.getRightSide()));
		implies.setRight(notImplies);
		
		PBooleanExpression currentExpression = this.clonePFeatureRef(group.getLeftSide().get(0));
		for (int i = 1; i < group.getLeftSide().size(); i++) {
			PBinaryExpression binary = VmFactory.eINSTANCE.createPBinaryExpression();
			binary.setOperator(PBinaryOperator.AND);
			binary.setLeft(currentExpression);
			binary.setRight(this.clonePFeatureRef(group.getLeftSide().get(i)));
			currentExpression = binary;
		}
		
		implies.setLeft(currentExpression);
		constraint.setExpression(implies);
		return constraint;
	}
	
	
	public void groupImplicationsByLeftSide(PFeatureModel featureModel) throws Exception {
		ArrayList<LeftImplicationsGroup> groups = new ArrayList<LeftImplicationsGroup>();
		for (PConstraint constraintI : featureModel.getConstraints()) {
			
			if(constraintI.getExpression() instanceof PBinaryExpression
					&& ((PBinaryExpression)constraintI.getExpression()).getOperator().getName().equals(PBinaryOperator.IMPLIES.getName())){
				
				PBinaryExpression impliesI = (PBinaryExpression) constraintI.getExpression();
				if(!this.existsGroup(groups, impliesI.getLeft())){
					LeftImplicationsGroup newGroup = new LeftImplicationsGroup(impliesI.getLeft());
					newGroup.getRightSide().add(impliesI.getRight());
					
					for (PConstraint constraintJ : featureModel.getConstraints()) {
						PBinaryExpression impliesJ = (PBinaryExpression) constraintJ.getExpression();
						if(this.pBooleanExpressionEquals(impliesI.getLeft(), impliesJ.getLeft()) && constraintI != constraintJ){
							newGroup.getRightSide().add(impliesJ.getRight());
						}
					}
					if(newGroup.getRightSide().size() > 0)
						groups.add(newGroup);
				}
			}
		}
		
		featureModel.getConstraints().clear();
		
		for (LeftImplicationsGroup group : groups) {
			PConstraint constraint = this.fromLeftImplicationToConstraint(featureModel.getRootFeature(), group);
			featureModel.getConstraints().add(constraint);
		}
	}
	
	private PConstraint fromLeftImplicationToConstraint(PFeature root, LeftImplicationsGroup group) throws Exception {
		
		PConstraint constraint = VmFactory.eINSTANCE.createPConstraint();
		constraint.setName(group.toString());
		
		PBinaryExpression implies = VmFactory.eINSTANCE.createPBinaryExpression();
		implies.setOperator(PBinaryOperator.IMPLIES);
		implies.setLeft(this.cloneExpression(root, group.getLeftSide()));
		
		PBooleanExpression currentExpression = this.cloneExpression(root, group.getRightSide().get(0));
		for (int i = 1; i < group.getRightSide().size(); i++) {
			PBinaryExpression binary = VmFactory.eINSTANCE.createPBinaryExpression();
			binary.setOperator(PBinaryOperator.AND);
			binary.setLeft(currentExpression);
			binary.setRight(this.cloneExpression(root, group.getRightSide().get(i)));
			currentExpression = binary;
		}
		
		implies.setRight(currentExpression);
		constraint.setExpression(implies);
		return constraint;
	}


	// ----------------------------------------------------------
	// Auxiliary Methods
	// ----------------------------------------------------------
	
	private boolean existsGroup(ArrayList<LeftImplicationsGroup> groups,
			PBooleanExpression expr) {
		for (LeftImplicationsGroup group : groups) {
			if(this.pBooleanExpressionEquals(group.getLeftSide(), expr)){
				return true;
			}
		}
		return false;
	}
	
	private boolean pBooleanExpressionEquals(PBooleanExpression o1, PBooleanExpression o2){
		if(o1 instanceof PBinaryExpression && o2 instanceof PBinaryExpression){
			PBinaryExpression o1Binary = (PBinaryExpression) o1;
			PBinaryExpression o2Binary = (PBinaryExpression) o2;
			boolean operator = o1Binary.getOperator().getName().equals(o2Binary.getOperator().getName());
			boolean leftSideEquals = this.pBooleanExpressionEquals(o1Binary.getLeft(), o2Binary.getLeft());
			boolean rightSideEquals = this.pBooleanExpressionEquals(o1Binary.getRight(), o2Binary.getRight());
			return operator && leftSideEquals && rightSideEquals;
		}
		else if(o1 instanceof PUnaryExpression && o2 instanceof PUnaryExpression){
			PUnaryExpression o1Unary = (PUnaryExpression) o1;
			PUnaryExpression o2Unary = (PUnaryExpression) o2;
			boolean operator = o1Unary.getOperator().getName().equals(o2Unary.getOperator().getName());
			boolean expr = this.pBooleanExpressionEquals(o1Unary.getExpr(), o2Unary.getExpr());
			return operator && expr;
		}
		else if(o1 instanceof PFeatureRef && o2 instanceof PFeatureRef){
			PFeatureRef o1FeatureRef = (PFeatureRef) o1;
			PFeatureRef o2FeatureRef = (PFeatureRef) o2;
			return o1FeatureRef.getRef().getName().equals(o2FeatureRef.getRef().getName());
		}
		else{
			return false;
		}
	}
	
	/**
	 * Returns true if there is an implication group in the given list and for the given feature ref.
	 * @param groups
	 * @param featureRef
	 * @return
	 */
	private boolean existsImplicationGroup(
			ArrayList<RightImplicationsGroup> groups,
			PFeatureRef featureRef) {
		for (RightImplicationsGroup group : groups) {
			if(group.getRightSide().getRef().getName().equals(featureRef.getRef().getName()))
				return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the feature reference in the parameter exists within the given list of feature references.
	 * @param refs
	 * @param featureRef
	 * @return
	 */
	private boolean containsFeatureRef(ArrayList<PFeatureRef> refs,
			PFeatureRef featureRef) {
		for (PFeatureRef pFeatureRef : refs) {
			if(pFeatureRef.getRef().getName().equals(featureRef.getRef().getName()))
				return true;
		}
		return false;
	}
	
	/**
	 * Returns an exact clone of the feature reference given in the parameter.
	 * @param pFeatureRef
	 * @return
	 */
	private PBooleanExpression clonePFeatureRef(PFeatureRef pFeatureRef) {
		PFeatureRef clone = VmFactory.eINSTANCE.createPFeatureRef();
		clone.setRef(pFeatureRef.getRef());
		return clone;
	}
	
	/**
	 * Collects all the features of the feature model whose root is given in the parameter.
	 * The collection is returned in the parameter 'arrayList'.
	 * 
	 * @param arrayList
	 * @param root
	 */
	private void collectPFeatures(ArrayList<PFeature> arrayList, PFeature root){
		arrayList.add(root);
		for (PFeature pFeature : root.getChildren()) {
			this.collectPFeatures(arrayList, pFeature);
		}
	}
	

	/**
	 * Clones the feature model in the parameter.
	 * 
	 * @param openFeatureModel
	 * @return
	 * @throws Exception
	 */
	public PFeatureModel cloneFeatureModel(PFeatureModel openFeatureModel) throws Exception {
		PFeatureModel clone = VmFactory.eINSTANCE.createPFeatureModel();
		clone.setName(openFeatureModel.getName());
		clone.setRootFeature(this.cloneFeature(openFeatureModel.getRootFeature()));

		for (PConstraint constraint : openFeatureModel.getConstraints()) {
			PConstraint clonedConstraint = this.cloneConstraint(clone.getRootFeature(), constraint);
			clone.getConstraints().add(clonedConstraint);
		}
		return clone;
	}

	/**
	 * Clones (recursively) the feature in the parameter.
	 * 
	 * @param rootFeature
	 * @return
	 */
	private PFeature cloneFeature(PFeature rootFeature) {
		PFeature clone = VmFactory.eINSTANCE.createPFeature();
		clone.setMandatory(rootFeature.isMandatory());
		clone.setName(rootFeature.getName());

		for (PFeature child : rootFeature.getChildren()) {
			PFeature cloneChild = this.cloneFeature(child);
			clone.getChildren().add(cloneChild);
		}

		for (PFeatureGroup group : rootFeature.getGroups()) {
			PFeatureGroup newGroup = this.cloneFeatureGroup(group);
			clone.getGroups().add(newGroup);

			for (PFeature feature : group.getFeatures()) {
				PFeature groupFeature = this.getPFeatureByName(feature.getName(), clone);
				newGroup.getFeatures().add(groupFeature);
			}
		}
		return clone;
	}

	/**
	 * Clones the group in the parameter.
	 * 
	 * @param group
	 * @return
	 */
	private PFeatureGroup cloneFeatureGroup(PFeatureGroup group) {
		PFeatureGroup clone = VmFactory.eINSTANCE.createPFeatureGroup();
		PFeatureGroupCardinality clonedCardinality = this.cloneFeatureGroupCardinality(group.getCardinality());
		clone.setCardinality(clonedCardinality);
		return clone;
	}

	/**
	 * Clones the feature group cardinality in the parameter.
	 * 
	 * @param cardinality
	 * @return
	 */
	private PFeatureGroupCardinality cloneFeatureGroupCardinality(PFeatureGroupCardinality cardinality) {
		PFeatureGroupCardinality clone = VmFactory.eINSTANCE.createPFeatureGroupCardinality();
		clone.setLowerBound(cardinality.getLowerBound());
		clone.setUpperBound(cardinality.getUpperBound());
		return clone;
	}

	/**
	 * Clones the constraint in the parameter.
	 * 
	 * @param root
	 * @param constraint
	 * @return
	 * @throws Exception
	 */
	private PConstraint cloneConstraint(PFeature root, PConstraint constraint) throws Exception {
		PConstraint clone = VmFactory.eINSTANCE.createPConstraint();
		clone.setName(constraint.getName());
		clone.setExpression(this.cloneExpression(root, constraint.getExpression()));
		return clone;
	}

	/**
	 * Clones the expression in the parameter.
	 * 
	 * @param root
	 * @param expression
	 * @return
	 * @throws Exception
	 */
	private PBooleanExpression cloneExpression(PFeature root, PBooleanExpression expression) throws Exception {
		if (expression instanceof PBinaryExpression) {
			PBinaryExpression binaryExpression = (PBinaryExpression) expression;
			PBinaryExpression clone = VmFactory.eINSTANCE.createPBinaryExpression();
			clone.setLeft(this.cloneExpression(root, binaryExpression.getLeft()));
			clone.setRight(this.cloneExpression(root, binaryExpression.getRight()));
			clone.setOperator(this.getOperator(binaryExpression.getOperator()));
			return clone;
		} else if (expression instanceof PFeatureRef) {
			PFeatureRef featureRef = (PFeatureRef) expression;
			PFeatureRef clone = VmFactory.eINSTANCE.createPFeatureRef();
			clone.setRef(this.getPFeatureByName(featureRef.getRef().getName(), root));
			return clone;
		} else if (expression instanceof PUnaryExpression) {
			PUnaryExpression punaryExpression = (PUnaryExpression) expression;
			PUnaryExpression clone = VmFactory.eINSTANCE.createPUnaryExpression();
			clone.setExpr(this.cloneExpression(root, punaryExpression.getExpr()));
			clone.setOperator(this.getOperator(punaryExpression.getOperator()));
			return clone;
		} else {
			throw new Exception("Type does not supported!");
		}
	}

	private PBinaryOperator getOperator(PBinaryOperator operator) {
		if (operator.getName().equals(PBinaryOperator.AND.getName()))
			return PBinaryOperator.AND;
		else if (operator.getName().equals(PBinaryOperator.OR.getName()))
			return PBinaryOperator.OR;
		else if (operator.getName().equals(PBinaryOperator.IMPLIES.getName()))
			return PBinaryOperator.IMPLIES;
		else if (operator.getName().equals(PBinaryOperator.XOR.getName()))
			return PBinaryOperator.XOR;
		else
			return null;
	}

	private PUninaryOperator getOperator(PUninaryOperator operator) {
		if (operator.getName().equals(PUninaryOperator.NOT))
			return PUninaryOperator.NOT;
		else
			return null;
	}

	/**
	 * Finds a PFeature by the name in the features model in the parameter.
	 * 
	 * @param featureName.
	 *            Name of the feature.
	 * @param featuresModelRoot.
	 *            Root of the features model where the feature should be
	 *            searched.
	 * @return
	 */
	private PFeature getPFeatureByName(String featureName, PFeature featureModelRoot) {
		if (featureModelRoot.getName().equals(featureName)) {
			return featureModelRoot;
		}
		for (PFeature feature : featureModelRoot.getChildren()) {
			PFeature found = this.getPFeatureByName(featureName, feature);
			if (found != null)
				return found;
		}
		return null;
	}
	
	public static void main(String[] args){
		VmSynthesis synthesis = VmSynthesis.getInstance();
	}
}