package semanticsLiteralsLogo

import fr.inria.diverse.k3.al.annotationprocessor.Aspect

import java.util.Hashtable
import LogoLiterals.Literal

import static extension semanticsLiteralsLogo.IntegerAspect.*
import static extension semanticsLiteralsLogo.StringAspect.*
import static extension semanticsLiteralsLogo.BooleanAspect.*

@Aspect(className=Literal)
public class LiteralAspect {

	def Object eval (Hashtable<String, Object> context) {
		if(_self instanceof LogoLiterals.Integer)
			return (_self as LogoLiterals.Integer).eval(context)
		else if(_self instanceof LogoLiterals.String)
			return (_self as LogoLiterals.String).eval(context)
		else if(_self instanceof LogoLiterals.Boolean)
			return (_self as LogoLiterals.Boolean).eval(context)
		else 
			return 0
	}
}