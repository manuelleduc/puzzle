package fr.inria.diverse.puzzle.breaker.command;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

import fr.inria.diverse.k3.sle.common.commands.ConceptComparison;
import fr.inria.diverse.k3.sle.common.commands.GraphPartition;
import fr.inria.diverse.k3.sle.common.graphs.EcoreGraph;
import fr.inria.diverse.k3.sle.common.graphs.EcoreGroup;
import fr.inria.diverse.k3.sle.common.graphs.EcoreVertex;
import fr.inria.diverse.k3.sle.common.tuples.TupleConceptMember;
import fr.inria.diverse.k3.sle.common.tuples.TupleConceptMembers;
import fr.inria.diverse.k3.sle.common.tuples.TupleMembersConcepts;
import fr.inria.diverse.k3.sle.common.utils.EcoreCloningServices;
import fr.inria.diverse.k3.sle.common.utils.FamiliesServices;
import fr.inria.diverse.k3.sle.common.utils.ModelUtils;
import fr.inria.diverse.k3.sle.common.utils.ProjectManagementServices;
import fr.inria.diverse.k3.sle.common.vos.SynthesisProperties;
import fr.inria.diverse.melange.metamodel.melange.Language;
import fr.inria.diverse.puzzle.metrics.componentsMetrics.ModularizationQuality;

public class BreakerImpl {

	// ---------------------------------------------
	// Attributes
	// ---------------------------------------------
	
	private static BreakerImpl instance;
	
	// ---------------------------------------------
	// Constructor and singleton
	// ---------------------------------------------
	
	private BreakerImpl(){
		
	}
	
	public static BreakerImpl getInstance(){
		if(instance == null)
			instance = new BreakerImpl();
		return instance;
	}
	
	// ---------------------------------------------
	// Methods
	// ---------------------------------------------
	
	/**
	 * Breaks-down the family in the parameter using the comparison operators and the decomposition strategy in the parameters (TODO) 
	 * @param languages
	 * @throws Exception
	 */
	public EcoreGraph breakDownFamily(ArrayList<Language> languages, SynthesisProperties synthesisProperties, IProject lplProject) throws Exception{
		ConceptComparison conceptComparisonOperator = synthesisProperties.getConceptComparisonOperator();
		GraphPartition graphPartition = synthesisProperties.getGraphPartition();
		
		ArrayList<TupleConceptMember> conceptMemberList = FamiliesServices.getInstance().getConceptMemberMappingList(languages);
		ArrayList<TupleConceptMembers> conceptMembersList = FamiliesServices.getInstance().getConceptMemberGroupList(conceptMemberList, conceptComparisonOperator);
		ArrayList<TupleMembersConcepts> membersConceptList = FamiliesServices.getInstance().getMembersGroupVsConceptVOList(conceptMembersList);
		EcoreGraph dependenciesGraph = new EcoreGraph(membersConceptList, conceptComparisonOperator);
		graphPartition.graphPartition(dependenciesGraph, membersConceptList, conceptComparisonOperator);
		buildSyntacticModules(dependenciesGraph);
		buildSemanticModules(dependenciesGraph, languages);
		
		double mq = (new ModularizationQuality()).compute(dependenciesGraph);
		System.out.println("Modularization Quality: " + mq);
		
		return dependenciesGraph;
	}

	/**
	 * Builds the syntactic modules according to the decomposed dependencies graph. 
	 * @param ecoreGraph
	 * @throws CoreException
	 */
	private void buildSyntacticModules(EcoreGraph ecoreGraph) throws CoreException {
		for (EcoreGroup group : ecoreGraph.getGroups()) {
			// Build the module metamodel with the required interface.
			EPackage moduleEPackage = this.createEPackageByModule(group);

			// Create the module project with the folders.
			IProject moduleProject = ProjectManagementServices.createEclipseProject("fr.inria.diverse.module." + 
					EcoreGraph.getLanguageModuleName(group.getVertex()).trim() + ".syntax");
			String modelsFolderPath = ProjectManagementServices.createFolderByName(moduleProject, "models");
						
			// Serialize the module metamodel in the corresponding project. 
			ModelUtils.saveEcoreFile(modelsFolderPath + "/" + EcoreGraph.getLanguageModuleName(group.getVertex()) + ".ecore", moduleEPackage);
			
			// Create the genmodel and generate the code of the module.
			// TODO
			
			// Refresh projects
			ProjectManagementServices.refreshProject(moduleProject);
		}
	}

	/**
	 * Builds the semantic modules according to the decomposed dependencies graph. 
	 * @param ecoreGraph
	 * @throws CoreException
	 * @throws IOException 
	 */
	private void buildSemanticModules(EcoreGraph dependenciesGraph, ArrayList<Language> languages) throws CoreException, IOException{
		for (EcoreGroup group : dependenciesGraph.getGroups()) {
			// Create the module project with the folders.
			IProject moduleProject = ProjectManagementServices.createEclipseProject("fr.inria.diverse.module." + 
				EcoreGraph.getLanguageModuleName(group.getVertex()).trim() + ".semantics");
			ProjectManagementServices.createXtendConfigurationFile(moduleProject);
			
			// Refresh projects
			ProjectManagementServices.refreshProject(moduleProject);
		}
	}
	
	// ---------------------------------------------
	// Utilities
	// ---------------------------------------------
	
	/**
	 * Creates a metamodel by module taking into consideration the corresponding dependencies with other modules
	 * by establishing the required interfaces.
	 * @param moduleConceptsVO
	 * @return
	 */
	private EPackage createEPackageByModule(EcoreGroup group) {
		EcoreCloningServices.getInstance().resetClonedClassifiers();
		EPackage newPackage = EcoreFactory.eINSTANCE.createEPackage();
		String moduleName = EcoreGraph.getLanguageModuleName(group.getVertex());
		newPackage.setName(moduleName.trim());
		newPackage.setNsPrefix(moduleName.trim());
		newPackage.setNsURI(moduleName.trim());
		
		for (EcoreVertex vertex : group.getVertex()) {
			if(vertex.getClassifier() instanceof EClass){
				EClass newClass = EcoreCloningServices.getInstance().cloneEClass((EClass)vertex.getClassifier());
				newPackage.getEClassifiers().add(newClass);
			}
			else if(vertex.getClassifier() instanceof EEnum){
				EEnum newEEnum = EcoreCloningServices.getInstance().cloneEEnum((EEnum)vertex.getClassifier());
				newPackage.getEClassifiers().add(newEEnum);
			}
		}
		EcoreCloningServices.getInstance().resolveLocalReferences(newPackage);
		EcoreCloningServices.getInstance().resolveInterfaceReferences(newPackage);
		EcoreCloningServices.getInstance().resolveLocalSuperTypes(newPackage);
		return newPackage;
	}
}