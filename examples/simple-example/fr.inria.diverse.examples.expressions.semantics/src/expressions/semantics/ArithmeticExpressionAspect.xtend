package expressions.semantics

import fr.inria.diverse.k3.al.annotationprocessor.Aspect

import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import ExpressionPck.ArithmeticExpression
import ExpressionPck.ArithmeticOperator
import java.util.Hashtable

@Aspect(className=ArithmeticExpression)
public class ArithmeticExpressionAspect extends ExpressionAspect{
	
	@OverrideAspectMethod 
	def Object eval (Hashtable<String, Object> context) {
		var int result = 0
		if(_self.operator == ArithmeticOperator.PLUS){
			result = (_self.left.eval(context) as Integer) + (_self.right.eval(context) as Integer)
		}
		else if(_self.operator == ArithmeticOperator.MINUS){
			result = (_self.left.eval(context) as Integer) - (_self.right.eval(context) as Integer)
		}
		else if(_self.operator == ArithmeticOperator.MULT){
			result = (_self.left.eval(context) as Integer) * (_self.right.eval(context) as Integer)
		}
		else if(_self.operator == ArithmeticOperator.DIV){
			result = (_self.left.eval(context) as Integer) / (_self.right.eval(context) as Integer)
		}
		return result
	}
}
