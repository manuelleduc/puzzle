package semanticsLogo

import fr.inria.diverse.k3.al.annotationprocessor.Aspect

import java.util.Hashtable

import Logo.Instruction
import Logo.Primitive
import Logo.VarDecl
import Logo.Assignation
import Logo.ControlStructure

import static extension semanticsLogo.PrimitiveAspect.*
import static extension semanticsLogo.VarDeclAspect.*
import static extension semanticsLogo.AssignationAspect.*
import static extension semanticsLogo.ControlStructureAspect.*

// *.*
// ASPECT
 @Aspect(className=Instruction) 
class InstructionAspect {
 
	def public void eval (Hashtable<String, Object> context ) {
		if(_self instanceof Primitive)
			(_self as Primitive).eval(context)
		else if(_self instanceof VarDecl)
			(_self as VarDecl).eval(context)
		else if(_self instanceof Assignation)
			(_self as Assignation).eval(context)
		else if(_self instanceof ControlStructure)
			(_self as ControlStructure).eval(context)
	}  
}