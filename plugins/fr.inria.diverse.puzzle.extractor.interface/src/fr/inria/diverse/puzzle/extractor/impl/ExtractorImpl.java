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
		
		// Step 1.1: Break-down the family
		EcoreGraph modularizationGraph = BreakerImpl.getInstance().breakDownFamily(languages, properties, project);
		
		// Step 1.2: Generate reports with modularization metrics and dependencies graph visualizers
		ProductLinesMetricManager metricsManager = new ProductLinesMetricManager(project);
		metricsManager.createProductLineCouplingReport(languages);
		metricsManager.createProductLineCouplingReportData(languages, properties.getConceptComparisonOperator(), 
				properties.getMethodComparisonOperator(), modularizationGraph);
		metricsManager.createProductLineIntraconnectivityReport(languages);
		metricsManager.createProductLineIntraConnectivityReportData(languages, properties.getConceptComparisonOperator(), 
				properties.getMethodComparisonOperator(), modularizationGraph);
		metricsManager.createProductLineInterconnectivityReport(languages);
		metricsManager.createProductLineInterConnectivityReportData(languages, properties.getConceptComparisonOperator(), 
				properties.getMethodComparisonOperator(), modularizationGraph);
		
		// Step 1.3: Compute the dependencies graph.
		DependencyGraph dependenciesGraph = new DependencyGraph(modularizationGraph);
		metricsManager.createDependenciesGraph();
		metricsManager.createDependenciesGraphData(languages, properties.getConceptComparisonOperator(), 
				dependenciesGraph);
		
		// Step 1.4: Validates that the dependencies graph is acyclic.
		if(dependenciesGraph.thereIsLoop())
			throw new Exception("The obtained dependencies graph is not acyclic! Check your graph partitioning algorithm.");
	}
}
