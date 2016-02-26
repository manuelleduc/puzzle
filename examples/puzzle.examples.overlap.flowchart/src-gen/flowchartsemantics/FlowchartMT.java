package flowchartsemantics;

import flowchartsemantics.flowchartmt.flowchartpck.FlowchartpckFactory;
import fr.inria.diverse.melange.lib.IModelType;
import java.io.IOException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public interface FlowchartMT extends IModelType {
  public abstract EList<EObject> getContents();
  
  public abstract FlowchartpckFactory getFactory();
  
  public abstract void save(final String uri) throws IOException;
}
