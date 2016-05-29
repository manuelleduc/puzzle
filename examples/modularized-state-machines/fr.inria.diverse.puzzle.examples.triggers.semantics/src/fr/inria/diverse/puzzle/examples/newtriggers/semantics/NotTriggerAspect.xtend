package fr.inria.diverse.puzzle.examples.newtriggers.semantics

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import puzzle.annotations.processor.OverrideSuperAspectMethod

import org.eclipse.emf.common.util.EList
import complextriggers.NotTrigger

// *.*
// ASPECT
@Aspect(className=NotTrigger)
class NotTriggerAspect {
	
	@OverrideSuperAspectMethod 
	def public boolean evalTrigger(EList<String> events){
		return !_self.trigger.evalTrigger(events)
	}
}