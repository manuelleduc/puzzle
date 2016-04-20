package fr.inria.diverse.puzzle.engine

import fr.inria.diverse.melange.ui.vos.LanguageVO
import org.eclipse.emf.ecore.EPackage
import fr.inria.diverse.puzzle.match.vo.MatchingDiagnostic
import fr.inria.diverse.sle.puzzle.merge.impl.PuzzleMerge

/**
 * Some queries on Ecore models.
 * 
 * @author David Mendez-Acuna
 */
class AbstractSyntaxCompositionEngine {
	
	/**
	 * Executes the composition of the abstract syntax of the languages in the parameters. 
	 */
	def void launchAbstractSyntaxComposition(LanguageVO mergedLanguage, LanguageVO requiringLanguage, 
		LanguageVO providingLanguage, MatchingDiagnostic comparison){
		var EPackage recalculatedRequiredInterface = PuzzleMerge.getInstance().
				recalculateRequiredInterface(requiringLanguage.requiredInterface, 
						comparison, "merged", providingLanguage.requiredInterface);
			 
			val EPackage mergedPackage = PuzzleMerge.instance.mergeAbstractSyntax(providingLanguage.metamodel, providingLanguage.providedInterface, 
				requiringLanguage.metamodel, requiringLanguage.requiredInterface, comparison, recalculatedRequiredInterface, 'CompleteDSLPckg')
			
			var EPackage recalculatedProvidedInterface = PuzzleMerge.instance.
				recalculateProvidedInterface(requiringLanguage.providedInterface, providingLanguage.providedInterface)
			
			
			mergedLanguage.name = 'CompleteDSL'
			mergedLanguage.mergedPackage = 'CompleteDSLPckg'
			mergedLanguage.metamodel = mergedPackage
			mergedLanguage.requiredInterface = recalculatedRequiredInterface
			mergedLanguage.providedInterface = recalculatedProvidedInterface
	}
	
}