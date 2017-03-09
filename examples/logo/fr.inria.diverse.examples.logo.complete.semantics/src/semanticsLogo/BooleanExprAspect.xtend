package semanticsLogo

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
 
import java.util.Hashtable
import Logo.BooleanExpr
import Logo.BooleanOperator

@Aspect(className=BooleanExpr)
public class BooleanExprAspect extends BinaryExprAspect{

	@OverrideAspectMethod
	def Object eval (Hashtable<String, Object> context) {
		if(_self.operator == BooleanOperator.EQUAL){
			return (_self.leftExpr.eval(context) as Integer).intValue == (_self.rightExpr.eval(context) as Integer).intValue
		}
		else if(_self.operator == BooleanOperator.DIFF){
			return (_self.leftExpr.eval(context) as Integer).intValue != (_self.rightExpr.eval(context) as Integer).intValue
		}
//		else if(_self.operator == Logo.BinaryOperator.GREATER_THAN){
//			return _self.leftExpr.eval(context).(_self.rightExpr.eval(context))
//		}
		else 
			return null
	}
}