package fr.inria.diverse.puzzle.metrics.actions;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EPackage;

import fr.inria.diverse.k3.sle.common.commands.ConceptComparison;
import fr.inria.diverse.k3.sle.common.utils.ModelUtils;
import fr.inria.diverse.k3.sle.common.utils.ProjectManagementServices;
import fr.inria.diverse.k3.sle.common.vos.SynthesisProperties;
import fr.inria.diverse.melange.metamodel.melange.Element;
import fr.inria.diverse.melange.metamodel.melange.Language;
import fr.inria.diverse.melange.metamodel.melange.ModelTypingSpace;
import fr.inria.diverse.puzzle.metrics.managers.FamilysMetricManager;
import fr.inria.diverse.puzzle.metrics.specialCharts.SpecialFamilySyntacticChart;
import fr.inria.diverse.puzzle.metrics.specialCharts.SyntacticVennDiagram;

public class ComputeLargeMetricsActionImpl {

	// -----------------------------------------------
	// Attributes
	// -----------------------------------------------
	
	private static ComputeLargeMetricsActionImpl instance;
	
	// -----------------------------------------------
	// Constructor and singleton
	// -----------------------------------------------
	
	private ComputeLargeMetricsActionImpl(){}
	
	public static ComputeLargeMetricsActionImpl getInstance(){
		if(instance == null)
			instance = new ComputeLargeMetricsActionImpl();
		return instance;
	}
	
	// -----------------------------------------------
	// Methods
	// -----------------------------------------------
	
	/**
	 * Computes the metrics defined in Mendez-Acuna et. al and generates the corresponding report in HTML. 
	 * @param selectedResource
	 * @return
	 * @throws IOException
	 * @throws CoreException
	 * @throws URISyntaxException
	 */
	public String computeMetrics(SynthesisProperties synthesisProperties, ModelTypingSpace familyTypingSpace, IProject project) throws Exception {
		ConceptComparison conceptComparisonOperator = synthesisProperties.getConceptComparisonOperator();
		
		ArrayList<EPackage> ePackages = new ArrayList<EPackage>();
		ArrayList<Language> languages = new ArrayList<Language>();
		
		for (Element element : familyTypingSpace.getElements()) {
			if(element instanceof Language){
				Language language = (Language)element;
				languages.add(language);
				EPackage currentMetamodel = ModelUtils.loadEcoreResource(language.getSyntax().getEcoreUri());
				ePackages.add(currentMetamodel);
			}
		}
		
		String metrics = "Metrics calculated"; 
		
		File syntacticVennData = new File(project.getLocation().toString() + "/libVenn/syntacticVennData.jsonp" );
		if(!syntacticVennData.exists())
			syntacticVennData.createNewFile();
		PrintWriter out = new PrintWriter( syntacticVennData );
		SpecialFamilySyntacticChart syntacticVennDiagram = new SyntacticVennDiagram();
        out.print(syntacticVennDiagram.getVariablesDeclaration(languages, conceptComparisonOperator));
        out.close();
        
		FamilysMetricManager familysMetric = new FamilysMetricManager(project);
		familysMetric.createReport1LargeAnalysis(languages);
		ProjectManagementServices.refreshProject(project);
		
		return metrics;
	}
}