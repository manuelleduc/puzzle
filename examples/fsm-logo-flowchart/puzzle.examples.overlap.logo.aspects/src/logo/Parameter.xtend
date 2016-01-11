package logo

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import kmLogo.Parameter

@Aspect(className=Parameter)
public class ParameterAspect {

	def int eval (Context context) {
		return context.peek.get(_self.name)
	}

}