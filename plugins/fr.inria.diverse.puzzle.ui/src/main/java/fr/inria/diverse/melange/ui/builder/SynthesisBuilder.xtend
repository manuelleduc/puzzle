package fr.inria.diverse.melange.ui.builder

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.ecore.resource.Resource
import fr.inria.diverse.melange.metamodel.melange.ModelTypingSpace
import fr.inria.diverse.melange.metamodel.melange.Language
import java.util.ArrayList
import fr.inria.diverse.melange.metamodel.melange.Element
import fr.inria.diverse.puzzle.synthesizer.impl.SynthesizerManager
import fr.inria.diverse.k3.sle.common.utils.ProjectManagementServices
import fr.inria.diverse.k3.sle.common.commands.MethodComparison
import fr.inria.diverse.k3.sle.common.comparisonOperators.SignatureAndSourceMethodComparison
import fr.inria.diverse.k3.sle.common.commands.FeaturesModelInference
import fr.inria.diverse.k3.sle.common.commands.GraphPartition
import fr.inria.diverse.k3.sle.common.commands.ConceptComparison
import fr.inria.diverse.k3.sle.common.vos.SynthesisProperties
import fr.inria.diverse.k3.sle.common.comparisonOperators.DeepConceptComparison
import fr.inria.diverse.puzzle.variabilityinferer.inferers.PuzzleInferrer
import fr.inria.diverse.puzzle.breaker.popup.actions.MinimumAcyclicPartition
import fr.inria.diverse.k3.sle.common.comparisonOperators.NamingConceptComparison
import fr.inria.diverse.puzzle.breaker.popup.actions.SimulatedAnnealingPartitioning

/**
 * Builder for the action: Synthesize Language Product Line (LPL).
 * Loads the input and performs the delegation to the corresponding plug-in.
 * 
 * @author David Mendez-Acuna
 */
class SynthesisBuilder
{
	/**
	 * Synthesizes a language product line from the family of DSLs described in the resource.
	 */
	def void synthesizeLanguageProductLine(Resource res, IProject project, IProgressMonitor monitor) {
		val root = res.contents.head as ModelTypingSpace
		var ArrayList<Language> languages = new ArrayList<Language>()
		
		for(Element element : root.elements){
			if(element instanceof Language)
				languages.add(element as Language);
		}
		
		// Create a module that contains the modeling-in-the large artifacts as well as the metrics. 
		var IProject lplProject = ProjectManagementServices.createEclipseProject("fr.inria.diverse.examples.breaking.lpl");
		var SynthesisProperties properties = this.synthesisProperties
		
		SynthesizerManager.instance.synthesizeLanguageProductLine(properties, languages, lplProject)
		ProjectManagementServices.refreshProject(lplProject)
	}
	
	def private SynthesisProperties getSynthesisProperties(){
		var ConceptComparison conceptComparisonOperator = new NamingConceptComparison();
		var MethodComparison methodComparisonOperator = SignatureAndSourceMethodComparison.getInstance();
		var FeaturesModelInference variabilityInferer = new PuzzleInferrer();
		var GraphPartition graphPartition = new SimulatedAnnealingPartitioning();
		var SynthesisProperties properties = new SynthesisProperties(conceptComparisonOperator, methodComparisonOperator, variabilityInferer, graphPartition);
		return properties;
	}
}