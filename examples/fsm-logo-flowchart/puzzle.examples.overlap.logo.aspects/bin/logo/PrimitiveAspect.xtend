package logo

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod

import kmLogo.Primitive
import java.util.Hashtable
import kmLogo.Back
import kmLogo.Forward
import kmLogo.Left
import kmLogo.Right
import kmLogo.PenDown
import kmLogo.PenUp
import kmLogo.Clear

import static extension logo.BackAspect.*
import static extension logo.ForwardAspect.*
import static extension logo.LeftAspect.*
import static extension logo.RightAspect.*
import static extension logo.PenDownAspect.*
import static extension logo.PenUpAspect.*
import static extension logo.ClearAspect.*


@Aspect(className=Primitive) 
public class PrimitiveAspect extends InstructionAspect {  

	@OverrideAspectMethod
	def void eval (Hashtable<String, Object> context) {
		if(_self instanceof Back)
			(_self as Back).eval(context)
		else if(_self instanceof Forward)
			(_self as Forward).eval(context)
		else if(_self instanceof Left)
			(_self as Left).eval(context)
		else if(_self instanceof Right)
			(_self as Right).eval(context)
		else if(_self instanceof PenDown)
			(_self as PenDown).eval(context)
		else if(_self instanceof PenUp)
			(_self as PenUp).eval(context)
		else if(_self instanceof Clear)
			(_self as Clear).eval(context)
	} 
} 