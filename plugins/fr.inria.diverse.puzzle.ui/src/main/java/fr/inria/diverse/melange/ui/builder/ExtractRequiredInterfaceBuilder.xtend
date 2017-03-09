package fr.inria.diverse.melange.ui.builder

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IProgressMonitor
import fr.inria.diverse.puzzle.utilities.impl.RequiredInterfaceExtractor
import org.eclipse.emf.ecore.EPackage
import fr.inria.diverse.k3.sle.common.utils.ModelUtils
import org.eclipse.core.resources.IResource

/**
 * Builder for the action: Analyze Family.
 * Loads the input and performs the delegation to the corresponding plug-in.
 * 
 * @author David Mendez-Acuna
 */
class ExtractRequiredInterfaceBuilder extends AbstractBuilder {
	
	// -------------------------------------------------
	// Attributes
	// -------------------------------------------------
	
	private IProject targetProject
	
	// -------------------------------------------------
	// Methods
	// -------------------------------------------------
	
	/**
	 * Compose the language modules referenced in the melange and puzzle scripts given in the parameters
	 */
	def String extractRequiredInterface(IResource ecoreResource, IProject project, IProgressMonitor monitor) {
		this.targetProject = project;
		var EPackage metamodel = ModelUtils.loadEcoreFile(ecoreResource.location.toString)
		var EPackage requiredInterface = RequiredInterfaceExtractor.instance.extractRequiredInterface(metamodel)
		ModelUtils.saveEcoreFile(ecoreResource.location.toString.replace(".ecore","") + "-required.ecore", requiredInterface)
		this.targetProject.refreshLocal(IResource.DEPTH_INFINITE, monitor)
		return "Interface successfully extracted"
	}
	
	
}