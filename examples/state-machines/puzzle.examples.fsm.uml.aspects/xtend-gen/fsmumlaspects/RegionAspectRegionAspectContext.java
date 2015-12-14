package fsmumlaspects;

import fsm.Region;
import fsmumlaspects.RegionAspectRegionAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class RegionAspectRegionAspectContext {
  public final static RegionAspectRegionAspectContext INSTANCE = new RegionAspectRegionAspectContext();
  
  public static RegionAspectRegionAspectProperties getSelf(final Region _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fsmumlaspects.RegionAspectRegionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Region, RegionAspectRegionAspectProperties> map = new java.util.WeakHashMap<fsm.Region, fsmumlaspects.RegionAspectRegionAspectProperties>();
  
  public Map<Region, RegionAspectRegionAspectProperties> getMap() {
    return map;
  }
}