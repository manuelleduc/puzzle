package fr.inria.diverse.melange.ui.menu

import com.google.inject.Inject
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.common.util.URI
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.widgets.Display
import fr.inria.diverse.melange.ui.builder.ComposeLanguageModulesBuilder

/**
 * Handler for the action: Compose language modules
 * @author David Mendez-Acuna
 */
class ComposeLanguageModules extends AbstractHandler {
	
	@Inject ComposeLanguageModulesBuilder builder
	@Inject XtextResourceSetProvider rsProvider

	override execute(ExecutionEvent event) throws ExecutionException {
		new Job("Puzzle: Compose language modules ...") {
			override run(IProgressMonitor monitor) {
				try {
					monitor.beginTask("Composing language modules", 4)

					val sel = HandlerUtil.getActiveMenuSelection(event)
					val selection = sel as IStructuredSelection
					val resource = selection.firstElement as IResource
					val project = resource.project
					val rs = rsProvider.get(project)
					val melangeRes = rs.getResource(URI::createPlatformResourceURI(resource.fullPath.toString, true), true) as DerivedStateAwareResource
					val puzzleRes = rs.getResource(URI::createPlatformResourceURI(resource.fullPath.toString.replace('.melange','.binding'), true), true) as DerivedStateAwareResource

					val composition = builder.composeLanguageModules(puzzleRes, melangeRes, project, monitor)

					display.syncExec(
						  new Runnable() {
						    override void run(){
						     MessageDialog.openInformation(display.activeShell, "Composition result", composition);
						    }
						  });
				} catch (Exception e) {
					e.printStackTrace
					return Status.CANCEL_STATUS
				} finally {
					monitor.done
				}

				return Status.OK_STATUS
			}
		}.schedule
		return null
	}
	
	def static Display getDisplay() {
      var Display display = Display.getCurrent();
      //may be null if outside the UI thread
      if (display == null)
         display = Display.getDefault();
      return display;		
   }
}