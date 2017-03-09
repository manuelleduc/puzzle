package semanticsLogo;

import Logo.Literal;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import java.util.Hashtable;
import semanticsLogo.BooleanAspect;
import semanticsLogo.ExpressionAspect;
import semanticsLogo.IntegerAspect;
import semanticsLogo.LiteralAspectLiteralAspectProperties;
import semanticsLogo.StringAspect;

@Aspect(className = Literal.class)
@SuppressWarnings("all")
public class LiteralAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Object eval(final Literal _self, final Hashtable<String, Object> context) {
    semanticsLogo.LiteralAspectLiteralAspectProperties _self_ = semanticsLogo.LiteralAspectLiteralAspectContext.getSelf(_self);
    Object result = null;
    result =_privk3_eval(_self_, _self,context);
    return (java.lang.Object)result;
  }
  
  private static Object super_eval(final Literal _self, final Hashtable<String, Object> context) {
    semanticsLogo.ExpressionAspectExpressionAspectProperties _self_ = semanticsLogo.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  semanticsLogo.ExpressionAspect._privk3_eval(_self_, _self,context);
  }
  
  protected static Object _privk3_eval(final LiteralAspectLiteralAspectProperties _self_, final Literal _self, final Hashtable<String, Object> context) {
    if ((_self instanceof Logo.Integer)) {
      return IntegerAspect.eval(((Logo.Integer) _self), context);
    } else {
      if ((_self instanceof Logo.String)) {
        return StringAspect.eval(((Logo.String) _self), context);
      } else {
        if ((_self instanceof Logo.Boolean)) {
          return BooleanAspect.eval(((Logo.Boolean) _self), context);
        } else {
          return Integer.valueOf(0);
        }
      }
    }
  }
}