package logo

import fr.inria.diverse.k3.al.annotationprocessor.Aspect

import kmLogo.Instruction
import kmLogo.Primitive
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import kmLogo.Back

import static extension logo.InstructionAspect.*
import static extension logo.BlockAspect.*
import static extension logo.ExpressionAspect.*
import static extension logo.ParameterAspect.*

import kmLogo.Forward
import kmLogo.Left
import kmLogo.Right
import kmLogo.PenDown
import kmLogo.PenUp
import kmLogo.Clear
import kmLogo.Expression
import kmLogo.ProcCall
import java.util.Hashtable
import kmLogo.Block
import kmLogo.ControlStructure
import kmLogo.If
import kmLogo.Repeat
import kmLogo.While
import kmLogo.Parameter
import kmLogo.ParameterCall
import kmLogo.LogoProgram
import kmLogo.Literal
import kmLogo.IntegerLit
import kmLogo.BoolLit
import kmLogo.StringLit
import kmLogo.ArithmeticExpression
import kmLogo.ArithmeticOperator
import kmLogo.RelationalExpression
import kmLogo.RelationalOperator

// *.*
// ASPECT
 @Aspect(className=Instruction) 
class InstructionAspect {
 
	def public int eval (Context context ) {
		return 0
	}  
}

@Aspect(className=Primitive) 
public class PrimitiveAspect extends InstructionAspect{  

	@OverrideAspectMethod
	def int eval (Context context) {
		return 0
	}

} 

@Aspect(className=Back)
public class BackAspect extends PrimitiveAspect{

	@OverrideAspectMethod
	def int eval (Context context) {
		var int param = -1*  _self.steps.eval(context) as Integer
		println("BACK "+ param)
		context.turtle.forward(param)
		return 0
	}
}

@Aspect(className=Forward)
public class ForwardAspect extends PrimitiveAspect{

	@OverrideAspectMethod
	def int eval (Context context) {
		var int param = _self.steps.eval(context) as Integer
		println("FORWARD " + param)
		context.turtle.forward(param)
		return 0
	}

}
 
@Aspect(className=Left)
public class LeftAspect extends PrimitiveAspect{

	@OverrideAspectMethod
	def int eval (Context context) {
		var int param = (-1)  *_self.angle.eval(context) as Integer
		println("LEFT " + param)
		context.turtle.rotate(param)
		return 0
	}

}

@Aspect(className=Right)
public class RightAspect extends PrimitiveAspect{

	@OverrideAspectMethod
	def int eval (Context context) {
		var int param = _self.angle.eval(context) as Integer
		println("RIGHT " + param)
		context.turtle.rotate(param)
		return 0
	}

}

@Aspect(className=PenDown)
public class PenDownAspect extends PrimitiveAspect{

	@OverrideAspectMethod
	def int eval (Context context) {
		println("PENDOWN")
		context.turtle.setPenUp(false)
		return 0
	}

}

@Aspect(className=PenUp)
public class PenUpAspect extends PrimitiveAspect{

	@OverrideAspectMethod
	def int eval (Context context) {
		println("PENUP")
		context.turtle.setPenUp(true)
		return 0
	}

}

@Aspect(className=Clear)
public class ClearAspect extends PrimitiveAspect{
	
	@OverrideAspectMethod
	def int eval (Context context) {
		println("CLEAR")
		context.turtle.reset
		return 0
	}

}

@Aspect(className=Expression)
public class ExpressionAspect extends InstructionAspect{

	@OverrideAspectMethod
	def Object eval (Context context) {
		return 0 
	}

}

@Aspect(className=Literal)
public class LiteralAspect extends ExpressionAspect{

	@OverrideAspectMethod
	def Object eval (Context context) {
		return 0
	}
}

@Aspect(className=IntegerLit)
public class IntegerLitAspect extends LiteralAspect{

	@OverrideAspectMethod
	def Object eval (Context context) {
		return _self.value
	}
}

@Aspect(className=StringLit)
public class StringLitAspect extends LiteralAspect{

	@OverrideAspectMethod
	def Object eval (Context context) {
		return _self.value
	}
}

@Aspect(className=BoolLit)
public class BoolLitAspect extends LiteralAspect{

	@OverrideAspectMethod
	def Object eval (Context context) {
		return _self.value
	}
}

@Aspect(className=ArithmeticExpression)
public class ArithmeticExpressionAspect extends ExpressionAspect{

	@OverrideAspectMethod
	def Object eval (Context context) {
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

@Aspect(className=RelationalExpression)
public class RelationalExpressionAspect extends ExpressionAspect{

	@OverrideAspectMethod
	def Object eval (Context context) {
		var boolean result = false
		if(_self.operator == RelationalOperator.EQUALS){
			result = (_self.left.eval(context) as Integer) == (_self.right.eval(context) as Integer)
		}
		else if(_self.operator == RelationalOperator.NOT_EQUAL){
			result = (_self.left.eval(context) as Integer) != (_self.right.eval(context) as Integer)
		}
		else if(_self.operator == RelationalOperator.LESS_THAN){
			result = (_self.left.eval(context) as Integer) < (_self.right.eval(context) as Integer)
		}
		else if(_self.operator == RelationalOperator.GREATER_THAN){
			result = (_self.left.eval(context) as Integer) > (_self.right.eval(context) as Integer)
		}
		else if(_self.operator == RelationalOperator.LESS_THAN_OR_EQUAL_TO){
			result = (_self.left.eval(context) as Integer) <= (_self.right.eval(context) as Integer)
		}
		else if(_self.operator == RelationalOperator.GREATER_THAN_OR_EQUAL_TO){
			result = (_self.left.eval(context) as Integer) >= (_self.right.eval(context) as Integer)
		}
		return result
	}
}


@Aspect(className=ProcCall)
public class ProcCallAspect extends ExpressionAspect{

	@OverrideAspectMethod
	def Object eval (Context context) {
		println("Calling of : " + _self.declaration.name)
		var Hashtable<String,Integer> params = new Hashtable<String,Integer>()
		
		var int i = 0
		for (Expression exp : _self.actualArgs){
			var int currentArg = exp.eval(context) as Integer
			params.put(_self.declaration.args.get(i).name,currentArg)
			i= i+1
		}
		
		context.push(params)
		
		 _self.res = 0
		_self.declaration.instructions.forEach[instr | _self.res = instr.eval(context)]
		
		context.pop
		return _self.res
	}

	 int res = 0
}

@Aspect(className=Block)
public class BlockAspect extends InstructionAspect{

	int res = 0
	@OverrideAspectMethod
	def int eval (Context context) {
		_self.instructions.forEach[instruction | _self.res = instruction.eval(context)]
		return 0
	}
	
}

@Aspect(className=ControlStructure)
public class ControlStructureAspect extends InstructionAspect{
	@OverrideAspectMethod
	def int eval (Context context) {
		return 0
	}
}

@Aspect(className=If)
public class IfAspect extends ControlStructureAspect{

	@OverrideAspectMethod
	def int eval (Context context) {
		if (_self.condition.eval(context) != 0) {
			return _self.thenPart.eval(context)
		}
		else{
			return _self.elsePart.eval(context)
		}
	}

}

@Aspect(className=Repeat)
public class RepeatAspect extends ControlStructureAspect{

	@OverrideAspectMethod
	def int eval (Context context) {
		var int time =  _self.condition.eval(context) as Integer
		while( time > 0){
			_self.block.eval(context)
			time = time - 1
		}
		return 0
	}

}

@Aspect(className=While)
public class WhileAspect extends ControlStructureAspect{

	@OverrideAspectMethod
	def int eval (Context context) {
		while((_self.condition.eval(context) as Integer) > 0){
			_self.block.eval(context)
		}
		return 0
	}

}

@Aspect(className=Parameter)
public class ParameterAspect {

	def int eval (Context context) {
		return context.peek.get(_self.name)
	}

}

@Aspect(className=ParameterCall)
public class ParameterCallAspect extends ExpressionAspect{

	@OverrideAspectMethod
	def Object eval (Context context) {
		return _self.parameter.eval(context)
	}

}

@Aspect(className=LogoProgram)
public class LogoProgramAspect {

	def int eval (Context context) {
		println("LogoProgram eval !")
		_self.instructions.forEach[instr  | instr.eval(context)]
		return 0
	}

}