package logos.semantics

import fr.inria.diverse.k3.al.annotationprocessor.Aspect

import Logo.Primitive
import java.util.Hashtable

@Aspect(className=Primitive) 
public class PrimitiveAspect {  
	
	def int eval (Hashtable<String, Object> context) {
		return 0
	} 
} 
