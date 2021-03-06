package semanticsLogo

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod

import java.util.Hashtable
import Logo.Procedure

import static extension semanticsLogo.BlockAspect.*

@Aspect(className=Procedure)
class ProcedureAspect extends InstructionAspect {
	
	@OverrideAspectMethod
	def void eval(Hashtable<String, Object> context){
		_self.body.eval(context)
	}
}