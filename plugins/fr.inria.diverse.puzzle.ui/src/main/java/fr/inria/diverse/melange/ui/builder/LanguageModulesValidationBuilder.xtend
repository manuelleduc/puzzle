package fr.inria.diverse.melange.ui.builder

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.ecore.resource.Resource
import fr.inria.diverse.melange.metamodel.melange.ModelTypingSpace
import fr.inria.diverse.puzzle.adl.language.puzzle.LanguageBinding

/**
 * Builder for the action: Analyze Family.
 * Loads the input and performs the delegation to the corresponding plug-in.
 * 
 * @author David Mendez-Acuna
 */
class LanguageModulesValidationBuilder extends AbstractBuilder {
	
	def void validateLanguageModulesComposability(Resource puzzleResource, Resource melangeResource, IProject project, IProgressMonitor monitor) {
		println('coucou!! validateLanguageModulesComposability')
		println('puzzleResource: ' + puzzleResource)
		println('melangeResource: ' + melangeResource)
		
		val bindingSpace = puzzleResource.contents.head as LanguageBinding
		val modelTypingSpace = melangeResource.contents.head as ModelTypingSpace
		
		println('bindingSpace: ' + bindingSpace)
		println('modelTypingSpace: ' + modelTypingSpace)
		
//		var SynthesisProperties properties = this.synthesisProperties
//		ComputeMetricsActionImpl.instance.computeMetrics(properties, root, project);
	}
}