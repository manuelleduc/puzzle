package fr.inria.diverse.puzzle.extractor.impl;

import java.util.ArrayList;

import org.eclipse.core.resources.IProject;

import fr.inria.diverse.k3.sle.common.graphs.DependencyGraph;
import fr.inria.diverse.k3.sle.common.graphs.EcoreGraph;
import fr.inria.diverse.k3.sle.common.vos.SynthesisProperties;
import fr.inria.diverse.melange.metamodel.melange.Language;
import fr.inria.diverse.puzzle.breaker.command.BreakerImpl;
import fr.inria.diverse.puzzle.metrics.managers.ProductLinesMetricManager;

public class ExtractorImpl {

	// --------------------------------------------------
	// Attributes
	// --------------------------------------------------
	
	private static ExtractorImpl instance;
	
	// --------------------------------------------------
	// Constructor and singleton
	// --------------------------------------------------
	
	private ExtractorImpl(){
		
	}
	
	public static ExtractorImpl getInstance(){
		if(instance == null)
			instance = new ExtractorImpl();
		return instance;
	}
	
	// --------------------------------------------------
	// Methods
	// --------------------------------------------------
	
	public void extractReusableModules(SynthesisProperties properties, ArrayList<Language> languages, IProject project) throws Exception{
		ProductLinesMetricManager metricsManager = new ProductLinesMetricManager(project);
		metricsManager.createDependenciesGraph();
		EcoreGraph graph = BreakerImpl.getInstance().breakDownFamily(languages, properties, project);
		DependencyGraph dependenciesGraph = new DependencyGraph(graph);
		metricsManager.createDependenciesGraphData(languages, properties.getConceptComparisonOperator(), dependenciesGraph);
	}
}
