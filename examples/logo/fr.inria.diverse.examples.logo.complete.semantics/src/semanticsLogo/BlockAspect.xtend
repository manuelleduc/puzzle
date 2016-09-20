package semanticsLogo

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod

import java.util.Hashtable
import Logo.Block
import Logo.Instruction

import static extension semanticsLogo.InstructionAspect.*

@Aspect(className=Block)
class BlockAspect extends ControlStructureAspect {
	
	@OverrideAspectMethod
	def void eval(Hashtable<String, Object> context){
		for(Instruction instruction : _self.instructions){
			println(instruction)
			instruction.eval(context)
		}
	}
}