package fr.inria.diverse.puzzle.examples.fsm.semantics

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fsm.State
import java.util.Hashtable

@Aspect(className=State)
class StateAspect {
	
	def public void entryState(Hashtable<String, Object> context){
		
	}
	
	def public void evalState(Hashtable<String, Object> context) {
		
	}
	
	def public void exitState(Hashtable<String, Object> context){
		
	}
}