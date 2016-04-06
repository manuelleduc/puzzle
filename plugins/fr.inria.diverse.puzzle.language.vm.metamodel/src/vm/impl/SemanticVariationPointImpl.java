/**
 */
package vm.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import vm.LanguageFeature;
import vm.SemanticInterpretation;
import vm.SemanticVariationPoint;
import vm.VmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Semantic Variation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link vm.impl.SemanticVariationPointImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link vm.impl.SemanticVariationPointImpl#getInterpretations <em>Interpretations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SemanticVariationPointImpl extends NamedElementImpl implements SemanticVariationPoint {
	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected LanguageFeature feature;

	/**
	 * The cached value of the '{@link #getInterpretations() <em>Interpretations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterpretations()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticInterpretation> interpretations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticVariationPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VmPackage.Literals.SEMANTIC_VARIATION_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageFeature getFeature() {
		if (feature != null && feature.eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = (LanguageFeature)eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VmPackage.SEMANTIC_VARIATION_POINT__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageFeature basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFeature(LanguageFeature newFeature, NotificationChain msgs) {
		LanguageFeature oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VmPackage.SEMANTIC_VARIATION_POINT__FEATURE, oldFeature, newFeature);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(LanguageFeature newFeature) {
		if (newFeature != feature) {
			NotificationChain msgs = null;
			if (feature != null)
				msgs = ((InternalEObject)feature).eInverseRemove(this, VmPackage.LANGUAGE_FEATURE__SEMANTIC_VARIATION_POINT, LanguageFeature.class, msgs);
			if (newFeature != null)
				msgs = ((InternalEObject)newFeature).eInverseAdd(this, VmPackage.LANGUAGE_FEATURE__SEMANTIC_VARIATION_POINT, LanguageFeature.class, msgs);
			msgs = basicSetFeature(newFeature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VmPackage.SEMANTIC_VARIATION_POINT__FEATURE, newFeature, newFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SemanticInterpretation> getInterpretations() {
		if (interpretations == null) {
			interpretations = new EObjectContainmentEList<SemanticInterpretation>(SemanticInterpretation.class, this, VmPackage.SEMANTIC_VARIATION_POINT__INTERPRETATIONS);
		}
		return interpretations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VmPackage.SEMANTIC_VARIATION_POINT__FEATURE:
				if (feature != null)
					msgs = ((InternalEObject)feature).eInverseRemove(this, VmPackage.LANGUAGE_FEATURE__SEMANTIC_VARIATION_POINT, LanguageFeature.class, msgs);
				return basicSetFeature((LanguageFeature)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VmPackage.SEMANTIC_VARIATION_POINT__FEATURE:
				return basicSetFeature(null, msgs);
			case VmPackage.SEMANTIC_VARIATION_POINT__INTERPRETATIONS:
				return ((InternalEList<?>)getInterpretations()).basicRemove(otherEnd, msgs);
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
			case VmPackage.SEMANTIC_VARIATION_POINT__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
			case VmPackage.SEMANTIC_VARIATION_POINT__INTERPRETATIONS:
				return getInterpretations();
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
			case VmPackage.SEMANTIC_VARIATION_POINT__FEATURE:
				setFeature((LanguageFeature)newValue);
				return;
			case VmPackage.SEMANTIC_VARIATION_POINT__INTERPRETATIONS:
				getInterpretations().clear();
				getInterpretations().addAll((Collection<? extends SemanticInterpretation>)newValue);
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
			case VmPackage.SEMANTIC_VARIATION_POINT__FEATURE:
				setFeature((LanguageFeature)null);
				return;
			case VmPackage.SEMANTIC_VARIATION_POINT__INTERPRETATIONS:
				getInterpretations().clear();
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
			case VmPackage.SEMANTIC_VARIATION_POINT__FEATURE:
				return feature != null;
			case VmPackage.SEMANTIC_VARIATION_POINT__INTERPRETATIONS:
				return interpretations != null && !interpretations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SemanticVariationPointImpl
