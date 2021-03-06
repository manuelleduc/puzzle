package flowchartaspects

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod

import flowchartpck.Assignation
import java.util.Hashtable

import static extension flowchartaspects.ExpressionAspect.*

@Aspect(className=Assignation)
class AssignationAspect extends StatementAspect {
	
	@OverrideAspectMethod
	def public void eval(Hashtable<String, Object> context){
		context.put(_self.varRef.key, _self.expression.eval(context))
	}
}
