package logos.semantics

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import Logo.If
import java.util.Hashtable

@Aspect(className=If)
public class IfAspect extends ControlStructureAspect{
	
	@OverrideAspectMethod
	def int eval (Hashtable<String, Object> context) {
		if (_self.condition.eval(context) != 0) {
			return _self.thenPart.eval(context)
		}
		else{
			return _self.elsePart.eval(context)
		}
	}
}
