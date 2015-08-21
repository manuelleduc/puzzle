package fr.inria.diverse.melange.ui.builder

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.ecore.resource.Resource
import fr.inria.diverse.melange.metamodel.melange.ModelTypingSpace
import fr.inria.diverse.puzzle.metrics.actions.ComputeMetricsActionImpl

class MetricsBuilder
{
	def void computeMetrics(Resource res, IProject project, IProgressMonitor monitor) {
		val root = res.contents.head as ModelTypingSpace
		ComputeMetricsActionImpl.instance.computeMetrics(root, project);
	}	
}