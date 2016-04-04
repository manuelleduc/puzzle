package logos.semantics


import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import java.util.Hashtable
import Logo.ProcCall
import Logo.Expression

import static extension logos.semantics.InstructionAspect.*
import java.util.ArrayList

@Aspect(className=ProcCall)


public class ProcCallAspect {
	
	def Object eval (Hashtable<String, Object> context) {
		println("Calling of : " + _self.declaration.name)
		var Hashtable<String,Integer> params = new Hashtable<String,Integer>()
		
		var int i = 0
		for (Expression exp : _self.actualArgs){
			var int currentArg = exp.eval(context) as Integer
			params.put(_self.declaration.args.get(i).name,currentArg)
			i= i+1
		}
		
		(context.get("stack") as ArrayList<Hashtable<String,Integer>>).add(params)
		
		 _self.res = 0
		_self.declaration.instructions.forEach[instr | _self.res = instr.eval(context)]
		(context.get("stack") as ArrayList<Hashtable<String,Integer>>).remove((context.get("stack") as ArrayList<Hashtable<String,Integer>>).size - 1)
		
		return _self.res
	}
	 int res = 0
}
