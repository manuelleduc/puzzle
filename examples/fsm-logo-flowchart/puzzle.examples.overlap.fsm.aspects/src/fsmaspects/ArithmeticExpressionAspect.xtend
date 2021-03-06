package fsmaspects

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod

import java.util.Hashtable
import fsm.ArithmeticExpression
import fsm.ArithmeticOperator

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
		else 
			return result
	}
}