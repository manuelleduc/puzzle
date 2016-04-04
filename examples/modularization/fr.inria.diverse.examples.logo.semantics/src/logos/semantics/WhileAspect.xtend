package logos.semantics


import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import Logo.While
import java.util.Hashtable

@Aspect(className=While)
public class WhileAspect extends ControlStructureAspect{
	
	@OverrideAspectMethod
	def int eval (Hashtable<String, Object> context) {
		while((_self.condition.eval(context) as Integer) > 0){
			_self.block.eval(context)
		}
		return 0
	}
}
