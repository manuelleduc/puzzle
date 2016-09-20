package semanticsLogo

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod

import java.util.Hashtable
import Logo.Literal

import static extension semanticsLogo.IntegerAspect.*
import static extension semanticsLogo.StringAspect.*
import static extension semanticsLogo.BooleanAspect.*

@Aspect(className=Literal)
public class LiteralAspect extends ExpressionAspect{

	@OverrideAspectMethod
	def Object eval (Hashtable<String, Object> context) {
		if(_self instanceof Logo.Integer)
			return (_self as Logo.Integer).eval(context)
		else if(_self instanceof Logo.String)
			return (_self as Logo.String).eval(context)
		else if(_self instanceof Logo.Boolean)
			return (_self as Logo.Boolean).eval(context)
		else 
			return 0
	}
}