package fr.inria.diverse.melange.ui.menu

import com.google.inject.Inject
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.handlers.HandlerUtil
import fr.inria.diverse.melange.ui.builder.PerformHierarchicalDomainAnalysisBuilder

/**
 * Hanlder for the action: Perform Hierarchical Domain Analysis
 * @author David Mendez-Acuna
 */
class PerformHierarchicalDomainAnalysis extends AbstractHandler {
	
	@Inject PerformHierarchicalDomainAnalysisBuilder builder

	override execute(ExecutionEvent event) throws ExecutionException {
		new Job("Puzzle: Perform languages analysis") {
			override run(IProgressMonitor monitor) {
				try {
					monitor.beginTask("Puzzle: Perform hierarchical domain analysis", 4)

					val sel = HandlerUtil.getActiveMenuSelection(event)
					val selection = sel as IStructuredSelection
					val resource = selection.firstElement as IResource
					val project = resource.project

					builder.performAnalysis(resource, project, monitor)
					
				} catch (OperationCanceledException e) {
					return Status.CANCEL_STATUS
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
}