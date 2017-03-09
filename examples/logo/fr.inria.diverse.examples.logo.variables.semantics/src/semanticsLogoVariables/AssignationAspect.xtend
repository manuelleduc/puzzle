package semanticsLogoVariables

import fr.inria.diverse.k3.al.annotationprocessor.Aspect

import java.util.Hashtable
import Variables.Assignation

@Aspect(className=Assignation)
class AssignationAspect {
	
	def void evalInstruction(Hashtable<String, Object> context){
		var Hashtable<String, Object> variablesTable = context.get('variables') as Hashtable<String, Object>
		variablesTable.put(_self.ref.name, _self.expr.eval(context))
	}
}