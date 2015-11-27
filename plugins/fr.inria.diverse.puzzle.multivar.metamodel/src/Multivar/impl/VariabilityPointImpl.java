/**
 */
package Multivar.impl;

import Multivar.LanguageFeature;
import Multivar.MultivarPackage;
import Multivar.VariabilityPoint;
import Multivar.Variation;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variability Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Multivar.impl.VariabilityPointImpl#getVariations <em>Variations</em>}</li>
 *   <li>{@link Multivar.impl.VariabilityPointImpl#getInvolvedFeatures <em>Involved Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariabilityPointImpl extends NamedElementImpl implements VariabilityPoint {
	/**
	 * The cached value of the '{@link #getVariations() <em>Variations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariations()
	 * @generated
	 * @ordered
	 */
	protected EList<Variation> variations;

	/**
	 * The cached value of the '{@link #getInvolvedFeatures() <em>Involved Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvolvedFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<LanguageFeature> involvedFeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariabilityPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MultivarPackage.Literals.VARIABILITY_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variation> getVariations() {
		if (variations == null) {
			variations = new EObjectContainmentEList<Variation>(Variation.class, this, MultivarPackage.VARIABILITY_POINT__VARIATIONS);
		}
		return variations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LanguageFeature> getInvolvedFeatures() {
		if (involvedFeatures == null) {
			involvedFeatures = new EObjectResolvingEList<LanguageFeature>(LanguageFeature.class, this, MultivarPackage.VARIABILITY_POINT__INVOLVED_FEATURES);
		}
		return involvedFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MultivarPackage.VARIABILITY_POINT__VARIATIONS:
				return ((InternalEList<?>)getVariations()).basicRemove(otherEnd, msgs);
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
			case MultivarPackage.VARIABILITY_POINT__VARIATIONS:
				return getVariations();
			case MultivarPackage.VARIABILITY_POINT__INVOLVED_FEATURES:
				return getInvolvedFeatures();
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
			case MultivarPackage.VARIABILITY_POINT__VARIATIONS:
				getVariations().clear();
				getVariations().addAll((Collection<? extends Variation>)newValue);
				return;
			case MultivarPackage.VARIABILITY_POINT__INVOLVED_FEATURES:
				getInvolvedFeatures().clear();
				getInvolvedFeatures().addAll((Collection<? extends LanguageFeature>)newValue);
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
			case MultivarPackage.VARIABILITY_POINT__VARIATIONS:
				getVariations().clear();
				return;
			case MultivarPackage.VARIABILITY_POINT__INVOLVED_FEATURES:
				getInvolvedFeatures().clear();
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
			case MultivarPackage.VARIABILITY_POINT__VARIATIONS:
				return variations != null && !variations.isEmpty();
			case MultivarPackage.VARIABILITY_POINT__INVOLVED_FEATURES:
				return involvedFeatures != null && !involvedFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VariabilityPointImpl
