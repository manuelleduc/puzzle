package fr.inria.diverse.melange.ui.builder

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IProgressMonitor
import fr.inria.diverse.k3.sle.common.vos.SynthesisProperties
import fr.inria.diverse.k3.sle.common.utils.ProjectManagementServices
import fr.inria.diverse.puzzle.metrics.actions.PerformHierarchicalDomainAnalysisActionImpl
import fr.inria.diverse.k3.sle.common.utils.ModelUtils
import org.eclipse.emf.ecore.EPackage
import org.eclipse.core.resources.IResource

/**
 * Builder for the action: Perform Hierarchical Domain Analysis
 * Loads the input and performs the delegation to the corresponding plug-in.
 * 
 * @author David Mendez-Acuna
 */
class PerformHierarchicalDomainAnalysisBuilder extends AbstractBuilder {
	
	/**
	 * Delegates the analysis action to the metrics plug-in.
	 */
	def void performAnalysis(IResource res, IProject project, IProgressMonitor monitor) {
		var EPackage metamodel = ModelUtils.loadEcoreFile(res.location.toString)
		var SynthesisProperties properties = this.synthesisProperties
		this.decorateProjectWithFolderStructure(project)
		PerformHierarchicalDomainAnalysisActionImpl.instance.performDomainAnalysis(properties, metamodel, project);
	}
	
	/**
	 * Decorates the project in the parameter with the structure to store the reports
	 * @param project. Project to decorate.
	 */
	def decorateProjectWithFolderStructure(IProject project) {
		if(!project.getFolder("reports").exists)
			ProjectManagementServices.createFolderByName(project, "reports")
	}
}