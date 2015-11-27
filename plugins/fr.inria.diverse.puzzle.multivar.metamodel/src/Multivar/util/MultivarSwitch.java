/**
 */
package Multivar.util;

import Multivar.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see Multivar.MultivarPackage
 * @generated
 */
public class MultivarSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MultivarPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultivarSwitch() {
		if (modelPackage == null) {
			modelPackage = MultivarPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MultivarPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultivarPackage.LANGUAGE_PRODUCT_LINE: {
				LanguageProductLine languageProductLine = (LanguageProductLine)theEObject;
				T result = caseLanguageProductLine(languageProductLine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultivarPackage.PRODUCT_LINE_VARIABILITY: {
				ProductLineVariability productLineVariability = (ProductLineVariability)theEObject;
				T result = caseProductLineVariability(productLineVariability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultivarPackage.LANGUAGE_FEATURE: {
				LanguageFeature languageFeature = (LanguageFeature)theEObject;
				T result = caseLanguageFeature(languageFeature);
				if (result == null) result = caseNamedElement(languageFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultivarPackage.RELATION: {
				Relation relation = (Relation)theEObject;
				T result = caseRelation(relation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultivarPackage.MANDATORY_CHILD: {
				MandatoryChild mandatoryChild = (MandatoryChild)theEObject;
				T result = caseMandatoryChild(mandatoryChild);
				if (result == null) result = caseRelation(mandatoryChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultivarPackage.OPTIONAL_CHILD: {
				OptionalChild optionalChild = (OptionalChild)theEObject;
				T result = caseOptionalChild(optionalChild);
				if (result == null) result = caseRelation(optionalChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultivarPackage.OR_GROUP_CHILD: {
				OrGroupChild orGroupChild = (OrGroupChild)theEObject;
				T result = caseOrGroupChild(orGroupChild);
				if (result == null) result = caseRelation(orGroupChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultivarPackage.ALTERNATIVE_GROUP: {
				AlternativeGroup alternativeGroup = (AlternativeGroup)theEObject;
				T result = caseAlternativeGroup(alternativeGroup);
				if (result == null) result = caseRelation(alternativeGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultivarPackage.LANGUAGE_VARIABILITY: {
				LanguageVariability languageVariability = (LanguageVariability)theEObject;
				T result = caseLanguageVariability(languageVariability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultivarPackage.VARIABILITY_POINT: {
				VariabilityPoint variabilityPoint = (VariabilityPoint)theEObject;
				T result = caseVariabilityPoint(variabilityPoint);
				if (result == null) result = caseNamedElement(variabilityPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultivarPackage.VARIATION: {
				Variation variation = (Variation)theEObject;
				T result = caseVariation(variation);
				if (result == null) result = caseNamedElement(variation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Language Product Line</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Language Product Line</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLanguageProductLine(LanguageProductLine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Product Line Variability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product Line Variability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProductLineVariability(ProductLineVariability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Language Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Language Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLanguageFeature(LanguageFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelation(Relation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mandatory Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mandatory Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMandatoryChild(MandatoryChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Optional Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Optional Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOptionalChild(OptionalChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Group Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Group Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrGroupChild(OrGroupChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alternative Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alternative Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlternativeGroup(AlternativeGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Language Variability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Language Variability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLanguageVariability(LanguageVariability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variability Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variability Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariabilityPoint(VariabilityPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariation(Variation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MultivarSwitch
