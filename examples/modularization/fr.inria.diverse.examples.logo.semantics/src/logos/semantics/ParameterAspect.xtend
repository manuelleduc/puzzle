package logos.semantics


import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import Logo.Parameter
import java.util.ArrayList
import java.util.Hashtable

@Aspect(className=Parameter)
public class ParameterAspect {
	
	def int eval (Hashtable<String, Object> context) {
		return (context.get("stack") as ArrayList<Hashtable<String,Integer>>).last().get(_self.name)
	}
}
