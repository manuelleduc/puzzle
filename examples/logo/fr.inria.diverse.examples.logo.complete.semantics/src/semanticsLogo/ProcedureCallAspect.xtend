package semanticsLogo

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod

import java.util.Hashtable
import Logo.ProcedureCall

import static extension semanticsLogo.ProcedureAspect.*

@Aspect(className=ProcedureCall)
class ProcedureCallAspect extends InstructionAspect {
	
	@OverrideAspectMethod
	def void eval(Hashtable<String, Object> context){
		_self.ref.eval(context)
	}
}