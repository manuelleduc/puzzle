package simple.imperative.aspects

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod

import java.util.Hashtable
import simpleimperative.Loop
import simpleimperative.Statement

@Aspect(className=Loop)
class LoopAspect extends StatementAspect {
	
	@OverrideAspectMethod
	def void eval(Hashtable<String, Object> context){
		var Boolean guardEval = _self.guard.eval(context) as Boolean
		while(guardEval){
			for(Statement _statement : _self.body){
				_statement.eval(context)
			}
		}
	}
}
