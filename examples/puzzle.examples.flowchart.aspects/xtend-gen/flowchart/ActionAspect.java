package flowchart;

import flowchart.Action;
import flowchart.ActionAspectActionAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.util.Hashtable;

@Aspect(className = Action.class)
@SuppressWarnings("all")
public class ActionAspect {
  public static void eval(final Action _self, final Hashtable<String, Object> context) {
    flowchart.ActionAspectActionAspectProperties _self_ = flowchart.ActionAspectActionAspectContext.getSelf(_self);
    _privk3_eval(_self_, _self,context);
  }
  
  protected static void _privk3_eval(final ActionAspectActionAspectProperties _self_, final Action _self, final Hashtable<String, Object> context) {
  }
}