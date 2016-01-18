package logos.semantics;

import Logo.Clear;
import java.util.Map;
import logos.semantics.ClearAspectClearAspectProperties;

@SuppressWarnings("all")
public class ClearAspectClearAspectContext {
  public final static ClearAspectClearAspectContext INSTANCE = new ClearAspectClearAspectContext();
  
  public static ClearAspectClearAspectProperties getSelf(final Clear _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new logos.semantics.ClearAspectClearAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Clear, ClearAspectClearAspectProperties> map = new java.util.WeakHashMap<Logo.Clear, logos.semantics.ClearAspectClearAspectProperties>();
  
  public Map<Clear, ClearAspectClearAspectProperties> getMap() {
    return map;
  }
}