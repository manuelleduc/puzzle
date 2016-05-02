package fr.inria.diverse.puzzle.metrics.actions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

import fr.inria.diverse.k3.sle.common.vos.SynthesisProperties;

/**
 * Action responsible to analyze the domains hierarchy of a given DSL. 
 * 
 * @author David Mendez-Acuna
 */
public class PerformHierarchicalDomainAnalysisActionImpl {

	// -----------------------------------------------
	// Attributes
	// -----------------------------------------------
	
	private static PerformHierarchicalDomainAnalysisActionImpl instance;
	
	// -----------------------------------------------
	// Constructor and singleton
	// -----------------------------------------------
	
	private PerformHierarchicalDomainAnalysisActionImpl(){}
	
	public static PerformHierarchicalDomainAnalysisActionImpl getInstance(){
		if(instance == null)
			instance = new PerformHierarchicalDomainAnalysisActionImpl();
		return instance;
	}
	
	// -----------------------------------------------
	// Methods
	// -----------------------------------------------
	
	/**
	 * Performs the hierarchical domain analysis in the given domain model and generates the corresponding report in HTML. 
	 * @param selectedResource
	 * @return
	 * @throws IOException
	 * @throws CoreException
	 * @throws URISyntaxException
	 */
	public String performDomainAnalysis(SynthesisProperties synthesisProperties, EPackage metamodel, IProject project) throws Exception {
		System.out.println("Performs the domain analysis");
		System.out.println(metamodel.getEClassifiers());

		
		
		return "DONE...";
	}
	
	/**
	 * Filters the list of eclassifiers by returning only those which are eclasses. 
	 * @param eClassifiers
	 * @return
	 */
	public List<EClass> filterEClasses(EList<EClassifier> eClassifiers){
		List<EClass> answer = new ArrayList<EClass>();
		for (EClassifier eClassifier : eClassifiers) {
			if(eClassifier instanceof EClass)
				answer.add((EClass)eClassifier);
		}
		return answer;
	}
}