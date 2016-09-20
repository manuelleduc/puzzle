package fr.inria.diverse.puzzle.examples.statemachine.semantics

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fsm.State
import java.util.Hashtable

@Aspect(className=State)
class StateAspect {
	
	Thread executionThread
	
	def public void entryState(Hashtable<String, Object> context){
	}
	
	def public void evalState(Hashtable<String, Object> context) {
	}
	
	def public void exitState(Hashtable<String, Object> context){
		if(_self.executionThread != null && _self.executionThread.isAlive){
			_self.executionThread.stop
			_self.executionThread = null
		}
	}
}