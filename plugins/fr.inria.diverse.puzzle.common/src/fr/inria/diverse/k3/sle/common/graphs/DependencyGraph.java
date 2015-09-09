package fr.inria.diverse.k3.sle.common.graphs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Class that implements the services of a dependencies graph.
 * @author David Mendez-Acuna
 *
 */
public class DependencyGraph {

	// -----------------------------------------------
	// Attributes
	// -----------------------------------------------
	
	private List<DependencyVertex> vertex;
	private List<DependencyArc> arcs;

	// -----------------------------------------------
	// Constructors
	// -----------------------------------------------
	
	/**
	 * Constructor by default.
	 */
	public DependencyGraph(){
		vertex = new ArrayList<DependencyVertex>();
		arcs = new ArrayList<DependencyArc>();
	}
	
	/**
	 * Builds a dependency graph from a modularization graph.
	 * @param modularizationGraph. Modularization graph that will be used to create the dependencies graph.
	 */
	public DependencyGraph(EcoreGraph modularizationGraph){
		vertex = new ArrayList<DependencyVertex>();
		arcs = new ArrayList<DependencyArc>();
		
		// Create one vertex for each modularization group. 
		for (ArrayList<EcoreVertex> group : modularizationGraph.getGroups()) {
			String moduleName = EcoreGraph.getLanguageModuleName(group);
			DependencyVertex dependencyVertex = new DependencyVertex(moduleName);
			dependencyVertex.geteClassifiers().addAll(EcoreGraph.collectEClassifierByGroup(group));
			this.vertex.add(dependencyVertex);
		}
		
		// Create one arc for each dependency.
		for (int i = 0; i < vertex.size(); i++) {
			DependencyVertex vertexI = vertex.get(i);
			for (int j = 0; j < vertex.size(); j++) {
				if(i!=j){
					DependencyVertex vertexJ = vertex.get(j);
					if(this.dependsOn(vertexI, vertexJ)){
						DependencyArc arc = new DependencyArc(vertexI, vertexJ);
						this.arcs.add(arc);
					}
				}
			}
		}
	}
	
	// -----------------------------------------------
	// Methods
	// -----------------------------------------------
	
	/**
	 * Indicates if the origin depends on the destination.
	 * In other words, returns true if there is at least one eClassifier in the origin that contains a reference to
	 * a classifier in the destination.
	 * 
	 * @param origin
	 * @param destination
	 * @return
	 */
	private boolean dependsOn(DependencyVertex origin, DependencyVertex destination){
		for (int i = 0; i < origin.geteClassifiers().size(); i++) {
			EClassifier originClassifier = origin.geteClassifiers().get(i);
			for (int j = 0; j < origin.geteClassifiers().size(); j++) {
				if(i!=j){
					EClassifier destinationClassifier = origin.geteClassifiers().get(j);
					if(this.dependsOn(originClassifier, destinationClassifier))
						return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Indicates if the origin depends on the destination.
	 * Concretely, returns true of there is any reference from the origin to the destination or if the origin is sub-type of the destination.
	 * @param origin. Origin eClassifier.
	 * @param destination. Destination eClassifier.
	 * @return
	 */
	private boolean dependsOn(EClassifier origin, EClassifier destination){
		if(origin instanceof EClass && destination instanceof EClass){
			// Checking eReferences
			EClass originEClass = (EClass) origin;
			for (EStructuralFeature eStructuralFeature : originEClass.getEStructuralFeatures()) {
				if(eStructuralFeature instanceof EReference){
					EReference eReference = (EReference) eStructuralFeature;
					// TODO Here we need to use the construct comparison operator!
					if(eReference.getEType().getName().equals(destination.getName())){
						return true;
					}
				}
			}
			// Checking eSuperTypes
			for (EClass superType : originEClass.getESuperTypes()) {
				// TODO Here we need to use the construct comparison operator!
				if(superType.getName().equals(destination.getName()))
					return true;
			}
			return false;
		}
		else if(origin instanceof EClass && destination instanceof EEnum){
			EClass originEClass = (EClass) origin;
			for (EStructuralFeature eStructuralFeature : originEClass.getEStructuralFeatures()) {
				if(eStructuralFeature instanceof EAttribute){
					EAttribute eAttribute = (EAttribute) eStructuralFeature;
					// TODO Here we need to use the construct comparison operator!
					if(eAttribute.getEType().getName().equals(destination.getName())){
						return true;
					}
				}
			}
			return false;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Indicates if there is an arc between the origin and the destination given in the parameters. 
	 * @param origin
	 * @param destination
	 * @return
	 */
	public boolean thereIsArc(DependencyVertex origin, DependencyVertex destination){
		for (DependencyArc dependencyArc : arcs) {
			if(dependencyArc.getFrom().getIdentifier().equals(origin.getIdentifier()) &&
					dependencyArc.getTo().getIdentifier().equals(destination.getIdentifier()))
				return true;
		}
		return false;
	}
	
	// -----------------------------------------------
	// Getters
	// -----------------------------------------------
	
	public List<DependencyVertex> getVertex() {
		return vertex;
	}

	public List<DependencyArc> getArcs() {
		return arcs;
	}
}