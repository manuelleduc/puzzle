package fr.inria.diverse.puzzle.metrics.actions;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EPackage;

import fr.inria.diverse.k3.sle.common.utils.ModelUtils;
import fr.inria.diverse.puzzle.metrics.evaluators.syntax.IndividualizationRatio;
import fr.inria.diverse.puzzle.metrics.evaluators.syntax.ProductRelatedReusability;
import fr.inria.diverse.puzzle.metrics.evaluators.syntax.RelationshipRatio;
import fr.inria.diverse.puzzle.metrics.evaluators.syntax.ReusabilityBenefit;
import fr.inria.diverse.puzzle.metrics.evaluators.syntax.SizeOfCommonality;
import fr.inria.diverse.puzzle.metrics.evaluators.syntax.TotalAmountOfConcepts;

public class ComputeMetricsActionImpl {

	private static ComputeMetricsActionImpl instance;
	
	private ComputeMetricsActionImpl(){
		
	}
	
	public static ComputeMetricsActionImpl getInstance(){
		if(instance == null)
			instance = new ComputeMetricsActionImpl();
		return instance;
	}
	
	public String computeMetrics(ArrayList<IResource> selectedResources){
		ArrayList<EPackage> ePackages = new ArrayList<EPackage>();
		for (IResource iResource : selectedResources) {
			IFile currentFile = (IFile) iResource;
			EPackage currentMetamodel = ModelUtils.loadEcoreFile(currentFile.getLocation().toString());
			ePackages.add(currentMetamodel);
		}
		
		String metrics = "Size of syntactic commonality: " + SizeOfCommonality.evaluateMetric(ePackages);
		
		metrics += "\n\n" + "Total amount of concepts: " + TotalAmountOfConcepts.evaluateMetric(ePackages);
		metrics += "\n\n" + "Product-related reusability: " + ProductRelatedReusability.evaluate(ePackages);
		metrics += "\n\n" + "Individualization ratio: " + IndividualizationRatio.evaluate(ePackages);
		metrics += "\n\n" + "Individualization ratio: " + ReusabilityBenefit.evaluate(ePackages);
		metrics += "\n\n" + "Relationship ratio: " + RelationshipRatio.evaluate(ePackages);
		
		return metrics;
	}
}
