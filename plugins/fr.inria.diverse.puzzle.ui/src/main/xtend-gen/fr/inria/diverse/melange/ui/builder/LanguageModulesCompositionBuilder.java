package fr.inria.diverse.melange.ui.builder;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.sle.common.utils.ModelUtils;
import fr.inria.diverse.melange.metamodel.melange.Element;
import fr.inria.diverse.melange.metamodel.melange.ModelType;
import fr.inria.diverse.melange.metamodel.melange.ModelTypingSpace;
import fr.inria.diverse.melange.ui.builder.AbstractBuilder;
import fr.inria.diverse.puzzle.adl.language.puzzle.Binding;
import fr.inria.diverse.puzzle.adl.language.puzzle.LanguageBinding;
import fr.inria.diverse.puzzle.validator.command.ValidatorImpl;
import fr.inria.diverse.puzzle.validator.vos.PuzzleDiagnosis;
import java.util.Map;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Builder for the action: Analyze Family.
 * Loads the input and performs the delegation to the corresponding plug-in.
 * 
 * @author David Mendez-Acuna
 */
@SuppressWarnings("all")
public class LanguageModulesCompositionBuilder extends AbstractBuilder {
  public String validateLanguageModulesComposability(final Resource puzzleResource, final Resource melangeResource, final IProject project, final IProgressMonitor monitor) {
    EList<EObject> _contents = puzzleResource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    final LanguageBinding bindingSpace = ((LanguageBinding) _head);
    EList<EObject> _contents_1 = melangeResource.getContents();
    EObject _head_1 = IterableExtensions.<EObject>head(_contents_1);
    final ModelTypingSpace modelTypingSpace = ((ModelTypingSpace) _head_1);
    String answer = "Puzzle diagnostic: \n\n";
    for (int i = 0; (i < bindingSpace.getBinding().size()); i++) {
      {
        EList<Binding> _binding = bindingSpace.getBinding();
        Binding binding = _binding.get(i);
        final String requiredModelTypeName = binding.getRight();
        final String providedModelTypeName = binding.getLeft();
        EList<Element> _elements = modelTypingSpace.getElements();
        final Function1<Element, Boolean> _function = new Function1<Element, Boolean>() {
          @Override
          public Boolean apply(final Element element) {
            boolean _and = false;
            if (!(element instanceof ModelType)) {
              _and = false;
            } else {
              String _name = ((ModelType) element).getName();
              boolean _equals = _name.equals(requiredModelTypeName);
              _and = _equals;
            }
            return Boolean.valueOf(_and);
          }
        };
        Element _findFirst = IterableExtensions.<Element>findFirst(_elements, _function);
        final ModelType requiredModelType = ((ModelType) _findFirst);
        EList<Element> _elements_1 = modelTypingSpace.getElements();
        final Function1<Element, Boolean> _function_1 = new Function1<Element, Boolean>() {
          @Override
          public Boolean apply(final Element element) {
            boolean _and = false;
            if (!(element instanceof ModelType)) {
              _and = false;
            } else {
              String _name = ((ModelType) element).getName();
              boolean _equals = _name.equals(providedModelTypeName);
              _and = _equals;
            }
            return Boolean.valueOf(_and);
          }
        };
        Element _findFirst_1 = IterableExtensions.<Element>findFirst(_elements_1, _function_1);
        final ModelType providedModelType = ((ModelType) _findFirst_1);
        String _ecoreUri = requiredModelType.getEcoreUri();
        final EPackage requiredEPackage = ModelUtils.loadEcoreResource(_ecoreUri);
        String _ecoreUri_1 = providedModelType.getEcoreUri();
        final EPackage providedEPackage = ModelUtils.loadEcoreResource(_ecoreUri_1);
        Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
        XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
        _extensionToFactoryMap.put("xmi", _xMIResourceFactoryImpl);
        final ResourceSet resourceSet1 = new ResourceSetImpl();
        final ResourceSet resourceSet2 = new ResourceSetImpl();
        String _ecoreUri_2 = requiredModelType.getEcoreUri();
        URI _createURI = URI.createURI(_ecoreUri_2);
        resourceSet1.getResource(_createURI, true);
        String _ecoreUri_3 = providedModelType.getEcoreUri();
        URI _createURI_1 = URI.createURI(_ecoreUri_3);
        resourceSet2.getResource(_createURI_1, true);
        final IComparisonScope scope = new DefaultComparisonScope(resourceSet1, resourceSet2, null);
        EMFCompare.Builder _builder = EMFCompare.builder();
        EMFCompare _build = _builder.build();
        final Comparison comparison = _build.compare(scope);
        ValidatorImpl _instance = ValidatorImpl.getInstance();
        final PuzzleDiagnosis diagnosis = _instance.checkCompatibility(requiredEPackage, providedEPackage, comparison);
        boolean _equals = Objects.equal(diagnosis, null);
        if (_equals) {
          String _answer = answer;
          answer = (_answer + (((("    " + requiredModelTypeName) + " - ") + providedModelTypeName) + ": COMPATIBLE \n"));
        } else {
          String _answer_1 = answer;
          answer = (_answer_1 + (((("    " + requiredModelTypeName) + " - ") + providedModelTypeName) + ": NOT COMPATIBLE \n"));
        }
      }
    }
    return answer;
  }
}