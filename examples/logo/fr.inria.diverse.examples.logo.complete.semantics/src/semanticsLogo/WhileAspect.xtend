package semanticsLogo

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod

import java.util.Hashtable
import Logo.While

import static extension semanticsLogo.ExpressionAspect.*
import static extension semanticsLogo.BlockAspect.*

@Aspect(className=While)
class WhileAspect extends ControlStructureAspect {
	
	@OverrideAspectMethod
	def void eval(Hashtable<String, Object> context){
		println('')
		var condition = _self.guard.eval(context) as Boolean
		while(condition){
			_self.body.eval(context)
			condition = _self.guard.eval(context) as Boolean
		}
	}
}