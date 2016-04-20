package logos.semantics


import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import Logo.Back
import java.util.Hashtable

@Aspect(className=Back)
public class BackAspect extends PrimitiveAspect{
 
	@OverrideAspectMethod
	def int eval (Hashtable<String, Object> context) {
		var int param = - 1 *  _self.steps.eval(context) as Integer
		println("BACK "+ param)
		(context.get('turtle') as Turtle).forward(param)
		return 0
	}
}