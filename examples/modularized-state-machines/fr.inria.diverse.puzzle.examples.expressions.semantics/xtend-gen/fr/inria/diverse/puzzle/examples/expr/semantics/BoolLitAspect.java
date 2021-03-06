package fr.inria.diverse.puzzle.examples.expr.semantics;

import ExpressionPck.BoolLit;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import fr.inria.diverse.puzzle.examples.expr.semantics.BoolLitAspectBoolLitAspectProperties;
import fr.inria.diverse.puzzle.examples.expr.semantics.LiteralAspect;
import java.util.Hashtable;

@Aspect(className = BoolLit.class)
@SuppressWarnings("all")
public class BoolLitAspect extends LiteralAspect {
  @OverrideAspectMethod
  public static Object eval(final BoolLit _self, final Hashtable<String, Object> context) {
    fr.inria.diverse.puzzle.examples.expr.semantics.BoolLitAspectBoolLitAspectProperties _self_ = fr.inria.diverse.puzzle.examples.expr.semantics.BoolLitAspectBoolLitAspectContext.getSelf(_self);
    Object result = null;
     if (_self instanceof ExpressionPck.BoolLit){
    result = fr.inria.diverse.puzzle.examples.expr.semantics.BoolLitAspect._privk3_eval(_self_, (ExpressionPck.BoolLit)_self,context);
    } else  { throw new IllegalArgumentException("Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString()); };
    return (java.lang.Object)result;
  }
  
  private static Object super_eval(final BoolLit _self, final Hashtable<String, Object> context) {
    fr.inria.diverse.puzzle.examples.expr.semantics.LiteralAspectLiteralAspectProperties _self_ = fr.inria.diverse.puzzle.examples.expr.semantics.LiteralAspectLiteralAspectContext.getSelf(_self);
    return  fr.inria.diverse.puzzle.examples.expr.semantics.LiteralAspect._privk3_eval(_self_, _self,context);
  }
  
  protected static Object _privk3_eval(final BoolLitAspectBoolLitAspectProperties _self_, final BoolLit _self, final Hashtable<String, Object> context) {
    return Boolean.valueOf(_self.isValue());
  }
}
