package semanticsLogoControlStructures

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod

import java.util.Hashtable
import ControlStructures.If

@Aspect(className=If)
class IfAspect extends ControlStructureAspect {
	
	@OverrideAspectMethod
	def void eval(Hashtable<String, Object> context){
		println('')
		var condition = _self.condition.eval(context) as Boolean
		if(condition){
			_self.body.eval(context)
		}
	}
}