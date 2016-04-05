package fr.inria.diverse.puzzle.engine

import com.google.inject.Provider
import fr.inria.diverse.commons.asm.shade.DirectoryShader
import fr.inria.diverse.commons.asm.shade.ShadeRequest
import fr.inria.diverse.commons.asm.shade.relocation.Relocator
import fr.inria.diverse.commons.asm.shade.relocation.SimpleRelocator
import fr.inria.diverse.melange.eclipse.EclipseProjectHelper
import fr.inria.diverse.melange.metamodel.melange.Aspect
import fr.inria.diverse.melange.ui.builder.RefactoringPatternsBuilder
import fr.inria.diverse.melange.ui.vos.LanguageVO
import fr.inria.diverse.puzzle.match.vo.MatchingDiagnostic
import fr.inria.diverse.puzzle.match.vo.MatchingDiagnosticItem
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.PrintWriter
import java.net.URLClassLoader
import java.util.ArrayList
import java.util.Hashtable
import java.util.List
import javax.inject.Inject
import org.autorefactor.ui.OverlappingAspectsVO
import org.autorefactor.ui.OverridingAspectsVO
import org.autorefactor.ui.PrepareApplyRefactoringsJob
import org.autorefactor.ui.PropertiesSetVO
import org.autorefactor.ui.RefactoringPatternVO
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IResourceVisitor
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Path
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.jdt.core.IJavaElement
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext

/**
 * Builder for the action: Analyze Family.
 * Loads the input and performs the delegation to the corresponding plug-in.
 * 
 * @author David Mendez-Acuna
 */
class SemanticsCompositionEngine {
	
	// -------------------------------------------------
	// Attributes
	// -------------------------------------------------
	
	@Inject EclipseProjectHelper eclipseHelper
	@Inject extension EcoreQueries
	@Inject extension PuzzleXbaseInterpreter puzzleXbaseInterpreter
	@Inject private Provider<IEvaluationContext> contextProvider;
	private IProject targetProject
	private Hashtable<String, IJavaElement> cacheJavaElements = new Hashtable<String, IJavaElement>()
	
	// -------------------------------------------------
	// Methods
	// -------------------------------------------------
	
	/**
	 * Executes the composition of the semantics of the languages in the parameters. 
	 */
	def launchSemanticsComposition(LanguageVO mergedLanguage, LanguageVO requiringLanguage, LanguageVO providingLanguage, 
		MatchingDiagnostic comparison, ArrayList<OverlappingAspectsVO> overlappingAspects, ArrayList<OverridingAspectsVO> overridingAspects,
		ArrayList<RefactoringPatternVO> refactoringPatterns, IProject targetProject) {
		
		this.targetProject = targetProject
		println("launchSemanticsComposition")
		for(Aspect _providingAspect : providingLanguage.aspects){
			mergedLanguage.aspects.add(_providingAspect)
		}
		
		for(Aspect _requiringAspect : requiringLanguage.aspects){
			var boolean repeated = false
			if(_requiringAspect.aspectTypeRef.qualifiedName.lastIndexOf(".") != -1){
				var String requiringAspectClassName = _requiringAspect.aspectedClass.name

				// Collecting the repeated (overlapping) aspects				
				for(Aspect _providingAspect : providingLanguage.aspects){
					if(_providingAspect.aspectTypeRef.qualifiedName.lastIndexOf(".") != -1){
						var String providingAspectedClassName = _providingAspect.aspectedClass.name
						if(requiringAspectClassName.equals(providingAspectedClassName)){
							repeated = true
							val overlappingAspect = new OverlappingAspectsVO(_providingAspect, providingAspectedClassName, _requiringAspect, requiringAspectClassName)
							overlappingAspect.rightFile = _providingAspect.aspectTypeRef.identifier.replace(".", "/") + ".java"
							overlappingAspect.leftFile = _requiringAspect.aspectTypeRef.identifier.replace(".", "/") + ".java"
							overlappingAspects.add(overlappingAspect)
						}
					}
				}
				
				// Collecting the overriding aspects
				for(Aspect _providingAspect : providingLanguage.aspects){
					if(_providingAspect.aspectTypeRef.qualifiedName.lastIndexOf(".") != -1){
						val String providingAspectedClassName = _providingAspect.aspectedClass.name
						
						if(_requiringAspect.aspectedClass != null && !_requiringAspect.aspectedClass.ESuperTypes.filter[ _superType |
								_superType.name.equals(providingAspectedClassName)].isEmpty){
							val overridingAspect = new OverridingAspectsVO(_providingAspect, providingAspectedClassName, _requiringAspect, requiringAspectClassName)
							overridingAspect.baseFile = _providingAspect.aspectTypeRef.identifier.replace(".", "/") + ".java"
							overridingAspect.leftFile = _requiringAspect.aspectTypeRef.identifier.replace(".", "/") + ".java"
							overridingAspects.add(overridingAspect)
							
							println("OVERRIDING ASPECT: " + _requiringAspect.aspectedClass)	
						}
					}
				}
				
			}
			mergedLanguage.aspects.add(_requiringAspect)
		}
		
		mergedLanguage.oldNamespaces.add(requiringLanguage.metamodel.name)
		mergedLanguage.oldNamespaces.add(providingLanguage.metamodel.name)
		
		for(Aspect _aspect : mergedLanguage.aspects){
//			// Changing the namespaces of the required types of the extension language that still required in the merged language.
//			if(mergedLanguage.requiredInterface != null){
//				for(EClassifier _requiredClassifier : mergedLanguage.requiredInterface.EClassifiers){
//				var RefactoringPatternVO pattern = RefactoringPatternsBuilder.buildMetaclassReferencePattern(
//					requiringLanguage.metamodel.name, _requiredClassifier.name, mergedLanguage.requiredInterface.name, 
//						_requiredClassifier.name)
//				if(!refactoringPatterns.contains(pattern))
//					refactoringPatterns.add(pattern)
//				}
//				
//				// Changing the namespaces of the required types of the base language that still required in the merged language. 
//				for(EClassifier _requiredClassifier : mergedLanguage.requiredInterface.EClassifiers){
//					var RefactoringPatternVO pattern = RefactoringPatternsBuilder.buildMetaclassReferencePattern(
//						providingLanguage.metamodel.name, _requiredClassifier.name, mergedLanguage.requiredInterface.name, 
//							_requiredClassifier.name)
//					if(!refactoringPatterns.contains(pattern))
//						refactoringPatterns.add(pattern)
//				}
//			}
			
			// Changing the namespaces of the required types of the extension language that were provided by the merged language. 
			for(EClassifier _requiredClassifier : mergedLanguage.metamodel.EClassifiers){
				if(searchClassByName(requiringLanguage.requiredInterface, _requiredClassifier.name) != null){
					var RefactoringPatternVO pattern = RefactoringPatternsBuilder.buildMetaclassReferencePattern(
						requiringLanguage.metamodel.name, _requiredClassifier.name, mergedLanguage.metamodel.name, 
							_requiredClassifier.name)
					if(!refactoringPatterns.contains(pattern)){
						refactoringPatterns.add(pattern)
					}
						
				}
				
			}
			
			// Copying the aspect files to the target project
			if(_aspect.aspectTypeRef != null && _aspect.aspectTypeRef.type != null 
					&& _aspect.aspectTypeRef.identifier != null && _aspect.aspectTypeRef.type.eResource != null){
				
				val ws = targetProject.project.workspace.root
				val shader = new DirectoryShader
				val request = new ShadeRequest
				val relocators = new ArrayList<Relocator>
				val sourceEmfNamespace = "FSM"
				val targetEmfNamespace = "FSM"
				val sourceAspectNamespace = _aspect.aspectTypeRef.qualifiedName.replace("." + _aspect.aspectTypeRef.simpleName, "")
				val targetAspectNamespace = mergedLanguage.name
				
				if(_aspect.aspectTypeRef.type.eResource.contents.get(0) instanceof XtendFile){
					var XtendFile xtendFile = _aspect.aspectTypeRef.type.eResource.contents.get(0) as XtendFile;
					
					try{
						EcoreUtil.resolveAll(xtendFile)
					}catch(IllegalStateException e){
						println("Crying because of indexing")
					}
					
					for(MatchingDiagnosticItem _mapping : comparison.items){
						var EObject _input = _mapping.left;
						var EObject _output = _mapping.right;
						
						if(_input instanceof EClassifier && _output instanceof EClassifier){
							
							var EClassifier sourceClass = mergedLanguage.metamodel.searchClassByName((_input as EClassifier).name)
							var EClassifier targetClass = mergedLanguage.metamodel.searchClassByName((_output as EClassifier).name)
							var RefactoringPatternVO pattern = new RefactoringPatternVO()
							pattern.sourcePattern = sourceClass.getQualifiedName//leftLanguage.requiredInterface.name + "." + (_input as EClassifier).name
							pattern.targetPattern = targetClass.getQualifiedName.replace(sourceAspectNamespace, targetAspectNamespace)
							
							if(!refactoringPatterns.contains(pattern))
								refactoringPatterns.add(pattern)
								
							if((_input instanceof EClass) && (_output instanceof EClass)){
								var EClass _inputClass = _input as EClass;
								var EClass _outputClass = _output as EClass;

									var List<EReference> incomingReferences = newArrayList;
									_inputClass.getIncomingReferences(requiringLanguage.metamodel, incomingReferences)
									
									for(EReference _eRequiringReference : incomingReferences){
										var RefactoringPatternVO referenceCallPattern = RefactoringPatternsBuilder.buildReferenceCallPattern(_inputClass.name, 
											_eRequiringReference.name, _outputClass.name, _eRequiringReference.name);
										
										if(!refactoringPatterns.contains(referenceCallPattern))
											refactoringPatterns.add(referenceCallPattern);
								}
							}
						}
						
						for(XtendTypeDeclaration _typeDeclaration : xtendFile.xtendTypes){
							buildPatternsByType(_typeDeclaration, refactoringPatterns, requiringLanguage, mergedLanguage, _input, _output, _aspect.aspectTypeRef.identifier)
						}
					}
					
					for(String _MetamodelNamespace : mergedLanguage.oldNamespaces){
						var RefactoringPatternVO pattern = RefactoringPatternsBuilder.buildNamespacePattern(_MetamodelNamespace, mergedLanguage.mergedPackage)
						if(!refactoringPatterns.contains(pattern))
							refactoringPatterns.add(pattern)
					}
					
					val projectPathTmp = new StringBuilder
					val projectNameTmp = new StringBuilder
					
					ws.accept(
					new IResourceVisitor {
						override visit(IResource resource) throws CoreException {
							if (resource instanceof IFile) {
								val resourcePath = resource.locationURI.path
								if(_aspect.aspectTypeRef != null && _aspect.aspectTypeRef.identifier != null){
									val String currentAspectIdentifier = _aspect.aspectTypeRef.identifier
									val toBeMatched = currentAspectIdentifier.replace(".", "/") + ".java"
									if (resourcePath.endsWith(toBeMatched)) {
										
										val projectPath = resource.project.locationURI.path
										if (projectPathTmp.length == 0)
											projectPathTmp.append(projectPath)
										if (projectNameTmp.length == 0)
											projectNameTmp.append(resource.project.name)
									}
								}
								return false
							}
							return true
						}
					})
					
					
					val sourceAspectFolder = projectPathTmp + "/xtend-gen/"
					val sourceFolderFile = new File(sourceAspectFolder)
					val targetAspectFolder = targetProject.locationURI.path + "/xtend-gen/"
					
					if(sourceFolderFile != null && sourceFolderFile.exists){
						val targetFolderFile = new File(targetAspectFolder)
						relocators += new SimpleRelocator(sourceAspectNamespace.toString, targetAspectNamespace.toString, null, #[])
						relocators += new SimpleRelocator(sourceEmfNamespace.toString, targetEmfNamespace.toString, null, #[])
						
						var RefactoringPatternVO namespaceRefactoringPattern = new RefactoringPatternVO()
						namespaceRefactoringPattern.sourcePattern = sourceAspectNamespace.toString
						namespaceRefactoringPattern.targetPattern = targetAspectNamespace.toString
						 
						if(!refactoringPatterns.contains(namespaceRefactoringPattern))
						 refactoringPatterns.add(namespaceRefactoringPattern)
						
						request.inputFolders = #{sourceFolderFile}
						request.outputFolder = targetFolderFile
						request.filters = #[]
						request.relocators = relocators
						request.resourceTransformers = new ArrayList
						shader.shade(request)
					}
					
					for(OverlappingAspectsVO _overlappingAspect : overlappingAspects){
						if(_aspect.aspectTypeRef.identifier.equals(_overlappingAspect.leftAspect.aspectTypeRef.identifier)){
							_overlappingAspect.leftFile = sourceAspectFolder + _aspect.aspectTypeRef.identifier.replace(".", "/") + ".java"
							_overlappingAspect.mergedFile = targetAspectFolder + targetAspectNamespace.toString + "/" + _aspect.aspectTypeRef.identifier.
								substring(_aspect.aspectTypeRef.identifier.lastIndexOf(".") + 1).replace(".", "/") + ".java"
						}
						if(_aspect.aspectTypeRef.identifier.equals(_overlappingAspect.rightAspect.aspectTypeRef.identifier)){
							_overlappingAspect.rightFile = sourceAspectFolder + _aspect.aspectTypeRef.identifier.replace(".", "/") + ".java"
							_overlappingAspect.mergedFile = targetAspectFolder + targetAspectNamespace.toString + "/" + _aspect.aspectTypeRef.identifier.
								substring(_aspect.aspectTypeRef.identifier.lastIndexOf(".") + 1).replace(".", "/") + ".java"
						}
					}
					
					for(OverridingAspectsVO _overridingAspect : overridingAspects){
						if(_aspect.aspectTypeRef.identifier.equals(_overridingAspect.leftAspect.aspectTypeRef.identifier))
							_overridingAspect.leftFile = sourceAspectFolder + _aspect.aspectTypeRef.identifier.replace(".", "/") + ".java"
						if(_aspect.aspectTypeRef.identifier.equals(_overridingAspect.baseAspect.aspectTypeRef.identifier)){
							_overridingAspect.baseFile = sourceAspectFolder + _aspect.aspectTypeRef.identifier.replace(".", "/") + ".java"
							_overridingAspect.mergedFile = targetAspectFolder + targetAspectNamespace.toString + "/" + _aspect.aspectTypeRef.identifier.
								substring(_aspect.aspectTypeRef.identifier.lastIndexOf(".") + 1).replace(".", "/") + ".java"
						}
					}
				}
			}
		}
	}
	
	def executeRefactorings(ArrayList<OverlappingAspectsVO> overlappingAspects, ArrayList<OverridingAspectsVO> overridingAspects,
		ArrayList<RefactoringPatternVO> refactoringPatterns) {
			
		val ws = targetProject.project.workspace.root
			
		// Loading the java elements in the overlapping aspects needed for the java AST refactoring
		var ArrayList<OverlappingAspectsVO> cleanListOverlappingAspects = overlappingAspects.removeRepeatedElements()
		var Hashtable<String, PropertiesSetVO> propertiesFiles = new Hashtable<String, PropertiesSetVO>()
		var Hashtable<String, String> mergedFiles = new Hashtable<String, String>()
			
		for(OverlappingAspectsVO _overlappingAspect : overlappingAspects){
			if(mergedFiles.get(_overlappingAspect.mergedFile) == null){
				overrideMethod(_overlappingAspect.rightFile, _overlappingAspect.mergedFile);
				mergedFiles.put(_overlappingAspect.mergedFile,_overlappingAspect.mergedFile);
			}
			
			var String aspectName = _overlappingAspect.leftAspect.aspectTypeRef.identifier.substring(
					_overlappingAspect.leftAspect.aspectTypeRef.identifier.lastIndexOf(".") + 1)
				
			var String mergedPropertiesFile = _overlappingAspect.mergedFile.replace(aspectName, aspectName + aspectName + "Properties")
			var String leftPropertiesFile = _overlappingAspect.rightFile.replace(aspectName, aspectName + aspectName + "Properties")
			var String rightPropertiesFile = _overlappingAspect.rightFile.replace(aspectName, aspectName + aspectName + "Properties")
			
			var PropertiesSetVO propertiesSet = propertiesFiles.get(mergedPropertiesFile)
			if(propertiesSet == null){
					propertiesSet = new PropertiesSetVO()
					propertiesSet.mergedPropertiesFile = mergedPropertiesFile
					propertiesSet.allPropertiesFiles.add(mergedPropertiesFile)
				}
			if(!propertiesSet.allPropertiesFiles.contains(leftPropertiesFile))
				propertiesSet.allPropertiesFiles.add(leftPropertiesFile)
			if(!propertiesSet.allPropertiesFiles.contains(rightPropertiesFile))
				propertiesSet.allPropertiesFiles.add(rightPropertiesFile)
			
			propertiesFiles.put(mergedPropertiesFile, propertiesSet)
			
			targetProject.refreshLocal(IResource.DEPTH_INFINITE, null);
			JavaCore.initializeAfterLoad(null)
			
			val String mergedPathString = _overlappingAspect.mergedFile.replace(ws.location.toString, "")
			var IJavaElement mergedElement = cacheJavaElements.get(mergedPathString)
			if(mergedElement == null){
				val IPath mergedPath = new Path(mergedPathString)
				mergedElement = JavaCore.create(ws.getFile(mergedPath))
				cacheJavaElements.put(mergedPathString, mergedElement)
			}
			
			val String leftPathString = _overlappingAspect.leftFile.replace(ws.location.toString, "")
			var IJavaElement extensionElement = cacheJavaElements.get(leftPathString)
			if(extensionElement == null){
				val IPath leftPath = new Path(leftPathString)
				val IFile leftFile = ws.getFile(leftPath);
				extensionElement = JavaCore.create(leftFile)
				cacheJavaElements.put(leftPathString, extensionElement)
			}
			
			val String righPathString = _overlappingAspect.rightFile.replace(ws.location.toString, "")
			var IJavaElement baseElement = cacheJavaElements.get(righPathString)
			if(baseElement == null){
				val IPath rightPath = new Path(righPathString)
				val IFile rightFile = ws.getFile(rightPath);
				baseElement = JavaCore.create(rightFile)
				cacheJavaElements.put(righPathString, baseElement)
			}
			_overlappingAspect.extensionElement = extensionElement
			_overlappingAspect.mergedElement = mergedElement
			_overlappingAspect.baseElement = baseElement
		}
		
		for(OverridingAspectsVO _overridingAspect : overridingAspects){
			if(_overridingAspect.mergedFile!=null){
				val String mergedPathString = _overridingAspect.mergedFile.replace(ws.location.toString, "")
				var IJavaElement mergedElement = cacheJavaElements.get(mergedPathString)
				if(mergedElement == null){
					val IPath mergedPath = new Path(mergedPathString)
					mergedElement = JavaCore.create(ws.getFile(mergedPath))
					cacheJavaElements.put(mergedPathString, mergedElement)
				}
				
				val String rightPathString = _overridingAspect.baseFile.replace(ws.location.toString, "")
				var IJavaElement rightElement = cacheJavaElements.get(rightPathString)
				if(rightElement == null){
					val IPath rightPath = new Path(rightPathString)
					rightElement = JavaCore.create(ws.getFile(rightPath))
					cacheJavaElements.put(rightPathString, rightElement)
				}
				
				val String leftPathString = _overridingAspect.leftFile.replace(ws.location.toString, "")
				var IJavaElement extensionElement = cacheJavaElements.get(leftPathString)
				if(extensionElement == null){
					val IPath leftPath = new Path(leftPathString)
					val IFile leftFile = ws.getFile(leftPath);
					extensionElement = JavaCore.create(leftFile)
					cacheJavaElements.put(leftPathString, extensionElement)
				}
				
				_overridingAspect.mergedElement = mergedElement
				_overridingAspect.extensionElement = extensionElement
				_overridingAspect.baseElement = rightElement
			}
		}
		
		for(RefactoringPatternVO pattern : refactoringPatterns ){
				println("RefactoringPatternVO pattern: " + pattern)
			}
		
		val targetFolderFile = new File(targetProject.locationURI.path + "/xtend-gen/")
		var PrepareApplyRefactoringsJob refactoringJob = new PrepareApplyRefactoringsJob(cleanListOverlappingAspects, overridingAspects,
			refactoringPatterns, propertiesFiles, targetFolderFile, targetProject
		)
		refactoringJob.schedule()
	}
	
	def ArrayList<OverlappingAspectsVO> removeRepeatedElements(ArrayList<OverlappingAspectsVO> vos) {
		var ArrayList<OverlappingAspectsVO> answer = newArrayList
		for(OverlappingAspectsVO _overlappingAspect : vos){
			if(!answer.contains(_overlappingAspect))
				answer.add(_overlappingAspect)
		}
		return answer
	}
	
	def private overrideMethod(String sourceFilePath, String targetFilePath){
		var String baseContent = ""
			val BufferedReader br = new BufferedReader(new FileReader(sourceFilePath));
			var String line = br.readLine();
			
	        while (line != null) {
	           baseContent = baseContent + line + "\n"
	           line = br.readLine();
	        }
			br.close()
			
			var PrintWriter writer = new PrintWriter(new File(targetFilePath));
			writer.print(baseContent);
			writer.close();
	}
	
	def private buildPatternsByType(XtendTypeDeclaration _typeDeclaration, ArrayList<RefactoringPatternVO> refactoringPattern, 
		LanguageVO leftLanguage, LanguageVO result, EObject _input, EObject _output, String aspectIdentifier) {
		
		for(XtendMember _member : _typeDeclaration.members){
			if((_member instanceof XtendField) && (_input instanceof EClass && _output instanceof EClass)){
				var String requiredTypeQualifiedName = (_input as EClassifier).qualifiedName//leftLanguage.requiredInterface.name + "." + (_input as EClassifier).name
				var String currentTypeQualifiedName = (_member as XtendField).type.qualifiedName
				if(currentTypeQualifiedName == null || currentTypeQualifiedName.equals("null")){
					currentTypeQualifiedName = (_member as XtendField).type.toString.substring((_member as XtendField).type.toString.indexOf("#") + 1, (_member as XtendField).type.toString.length-1)
				}
				if(currentTypeQualifiedName.equals(requiredTypeQualifiedName)){
					var List<RefactoringPatternVO> variablePatterns = RefactoringPatternsBuilder.buildVariablesPattern((_input as EClassifier).name, 
						(_member as XtendField).name, (_output as EClassifier).name)
					
					variablePatterns.forEach[ pattern |
						if(!refactoringPattern.contains(pattern))
							refactoringPattern.add(pattern)
					]
				}
			}
			else if((_member instanceof XtendFunction) && (_input instanceof EOperation && _output instanceof EOperation)){
				var String requiringClassName = (_input as EOperation).EContainingClass.name
				var String providingClassName = (_output as EOperation).EContainingClass.name
				println("(_input as EOperation): " + (_input as EOperation))
				if((_member as XtendFunction).expression != null){
					for(XExpression _currentExpressionStatement : ((_member as XtendFunction).expression as XBlockExpression).expressions){
						var IEvaluationContext evaluationContext = contextProvider.get();
						evaluationContext.newValue(QualifiedName.create("baseLanguage"), leftLanguage)
						evaluationContext.newValue(QualifiedName.create("input"), _input)
						evaluationContext.newValue(QualifiedName.create("output"), _output)
						evaluationContext.newValue(QualifiedName.create("providingClassName"), providingClassName)
						evaluationContext.newValue(QualifiedName.create("requiringClassName"), requiringClassName)
						evaluationContext.newValue(QualifiedName.create("aspects"), result.aspects)
						evaluationContext.newValue(QualifiedName.create("refactoringPatterns"), refactoringPattern)
						evaluationContext.newValue(QualifiedName.create("function"),(_member as XtendFunction))
						puzzleXbaseInterpreter.classLoader = URLClassLoader.getSystemClassLoader()
						puzzleXbaseInterpreter.evaluate(_currentExpressionStatement, evaluationContext, CancelIndicator.NullImpl)
					}
				}
			}
		}
	}
}