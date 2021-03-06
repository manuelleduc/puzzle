package semanticsLogo

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod

import java.util.Hashtable
import Logo.Assignation

import static extension semanticsLogo.ExpressionAspect.*


@Aspect(className=Assignation)
class AssignationAspect extends InstructionAspect {
	
	@OverrideAspectMethod
	def void eval(Hashtable<String, Object> context){
		var Hashtable<String, Object> variablesTable = context.get('variables') as Hashtable<String, Object>
		variablesTable.put(_self.ref.name, _self.expr.eval(context))
	}
}