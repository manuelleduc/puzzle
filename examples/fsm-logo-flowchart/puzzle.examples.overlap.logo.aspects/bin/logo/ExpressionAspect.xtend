package logo

import fr.inria.diverse.k3.al.annotationprocessor.Aspect

import java.util.Hashtable

import static extension logo.LiteralAspect.*
import static extension logo.ArithmeticExpressionAspect.*
import static extension logo.RelationalExpressionAspect.*
import static extension logo.VarReferenceAspect.*
import kmLogo.Expression
import kmLogo.Literal
import kmLogo.ArithmeticExpression
import kmLogo.RelationalExpression
import kmLogo.VarReference

@Aspect(className=Expression)
public class ExpressionAspect {

	def Object eval(Hashtable<String, Object> context) {
		if(_self instanceof Literal)
			return (_self as Literal).eval(context)
		else if(_self instanceof ArithmeticExpression)
			return (_self as ArithmeticExpression).eval(context)
		else if(_self instanceof RelationalExpression)
			return (_self as RelationalExpression).eval(context)
		else if(_self instanceof VarReference)
			return (_self as VarReference).eval(context)
		else 
			return 0 
	}
}