package fr.inria.diverse.puzzle.examples.newtriggers.semantics

import fr.inria.diverse.k3.al.annotationprocessor.Aspect

import org.eclipse.emf.common.util.EList
import complextriggers.AndTrigger
import puzzle.annotations.processor.OverrideSuperAspectMethod

// *.*
// ASPECT
@Aspect(className=AndTrigger)
class AndTriggerAspect {
	
	@OverrideSuperAspectMethod 
	def public boolean evalTrigger(EList<String> events){
		return _self.right.evalTrigger(events) && _self.left.evalTrigger(events)
	}
}