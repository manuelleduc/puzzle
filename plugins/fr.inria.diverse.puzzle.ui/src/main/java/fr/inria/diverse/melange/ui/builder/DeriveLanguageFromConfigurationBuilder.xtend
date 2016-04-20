package fr.inria.diverse.melange.ui.builder

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.resources.IResource
import fr.inria.diverse.k3.sle.common.utils.ModelUtils
import fr.inria.diverse.puzzle.derivator.impl.IDerivator
import fr.inria.diverse.puzzle.derivator.impl.PuzzleDerivator
import PuzzleADL.LanguageArchitecture
import fr.inria.diverse.k3.sle.common.utils.ProjectManagementServices
import vm.LanguageProductLine
import PuzzleADL.LanguageModule

/**
 * Builder for the action: Configure.
 * Loads the input and performs the delegation to the corresponding plug-in.
 * 
 * @author David Mendez-Acuna
 */
class DeriveLanguageFromConfigurationBuilder extends AbstractBuilder {
	
	/**
	 * Derives a language from a configured variability model and a language architecture model.
	 * @param res. Array containing the references to the files with the models.
	 * @param project. The project that contains the files with the models. 
	 * @param monitor. Progress monitor to the Eclipse interface.
	 */
	def void deriveLanguageFromConfigurationBuilder(Object[] res, IProject project, IProgressMonitor monitor) {
		// TODO: Deal with the error where the user selects only one file. 
		var IResource resource0 = res.get(0) as IResource
		var IResource resource1 = res.get(1) as IResource
		var LanguageProductLine configuredFeatureModel = null
		var LanguageArchitecture languageArchitectureModel = null
		
		if(resource0.location.toString.endsWith('vm'))
				configuredFeatureModel = ModelUtils.loadXMIFile(resource0.location.toString) as LanguageProductLine
		else if(resource0.location.toString.endsWith('puzzleadl'))
				languageArchitectureModel = ModelUtils.loadXMIFile(resource0.location.toString) as LanguageArchitecture
		else {
			// TODO: Deal with the error where the user selects a wrong file
		}
		
		if(resource1.location.toString.endsWith('vm'))
				configuredFeatureModel = ModelUtils.loadXMIFile(resource1.location.toString) as LanguageProductLine
		else if(resource1.location.toString.endsWith('puzzleadl'))
				languageArchitectureModel = ModelUtils.loadXMIFile(resource1.location.toString) as LanguageArchitecture
		else {
			// TODO: Deal with the error where the user selects a wrong file
		}
		// TODO: Deal with the error where the user selects two vm models or two puzzleADL models. 
		
		// Create a module that contains the modeling-in-the large artifacts as well as the metrics. 
		var IProject derivationProject = ProjectManagementServices.createEclipseJavaProject("fr.inria.diverse.puzzle.reverseEngineering.derivation");
		this.decorateProjectWithFolderStructure(derivationProject, languageArchitectureModel)
		
		var IDerivator derivator = PuzzleDerivator.instance;
		derivator.derivateLangaugeFromConfiguration(derivationProject, languageArchitectureModel, configuredFeatureModel)
		ProjectManagementServices.refreshProject(derivationProject)
	}
	
	/**
	 * Decorates the project in the parameter with the structure to contain a configured language.
	 * @param project. Project to decorate.
	 */
	def decorateProjectWithFolderStructure(IProject project, LanguageArchitecture languageArchitecture) {
		var String projectDependencies = computeProjectDependencies(languageArchitecture);
		 
		ProjectManagementServices.createXtendConfigurationFile(project, "derivation", false, "family", projectDependencies)
		ProjectManagementServices.createFolderByName(project, "src/family")
	}
	
	def String computeProjectDependencies(LanguageArchitecture architecture) {
		var String dependencies = "";
		for(LanguageModule module : architecture.languageModules ){
			dependencies += " fr.inria.diverse.module." + module.name + ".syntax,\n";
			dependencies += " fr.inria.diverse.module." + module.name + ".semantics,\n";
		}
		return dependencies;
	}
	
}