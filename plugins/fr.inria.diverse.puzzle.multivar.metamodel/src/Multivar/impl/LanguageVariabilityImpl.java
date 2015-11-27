/**
 */
package Multivar.impl;

import Multivar.LanguageVariability;
import Multivar.MultivarPackage;
import Multivar.VariabilityPoint;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Language Variability</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Multivar.impl.LanguageVariabilityImpl#getVariabilityPoints <em>Variability Points</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LanguageVariabilityImpl extends MinimalEObjectImpl.Container implements LanguageVariability {
	/**
	 * The cached value of the '{@link #getVariabilityPoints() <em>Variability Points</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariabilityPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<VariabilityPoint> variabilityPoints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguageVariabilityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MultivarPackage.Literals.LANGUAGE_VARIABILITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariabilityPoint> getVariabilityPoints() {
		if (variabilityPoints == null) {
			variabilityPoints = new EObjectContainmentEList<VariabilityPoint>(VariabilityPoint.class, this, MultivarPackage.LANGUAGE_VARIABILITY__VARIABILITY_POINTS);
		}
		return variabilityPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MultivarPackage.LANGUAGE_VARIABILITY__VARIABILITY_POINTS:
				return ((InternalEList<?>)getVariabilityPoints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MultivarPackage.LANGUAGE_VARIABILITY__VARIABILITY_POINTS:
				return getVariabilityPoints();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MultivarPackage.LANGUAGE_VARIABILITY__VARIABILITY_POINTS:
				getVariabilityPoints().clear();
				getVariabilityPoints().addAll((Collection<? extends VariabilityPoint>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MultivarPackage.LANGUAGE_VARIABILITY__VARIABILITY_POINTS:
				getVariabilityPoints().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MultivarPackage.LANGUAGE_VARIABILITY__VARIABILITY_POINTS:
				return variabilityPoints != null && !variabilityPoints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LanguageVariabilityImpl
