package logos.semantics


import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import Logo.LogoProgram

import static extension logos.semantics.InstructionAspect.*
import java.util.Hashtable

@Aspect(className=LogoProgram)
public class LogoProgramAspect {
	
	def int eval (Hashtable<String, Object> context) {
		println("LogoProgram eval !")
		_self.instructions.forEach[instr  | instr.eval(context)]
		return 0
	}
}
