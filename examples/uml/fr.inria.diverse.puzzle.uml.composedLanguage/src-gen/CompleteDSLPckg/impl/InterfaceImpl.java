/**
 */
package CompleteDSLPckg.impl;

import CompleteDSLPckg.Classifier;
import CompleteDSLPckg.CompleteDSLPckgPackage;
import CompleteDSLPckg.Interface;
import CompleteDSLPckg.Operation;
import CompleteDSLPckg.Property;
import CompleteDSLPckg.Reception;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link CompleteDSLPckg.impl.InterfaceImpl#getNestedClassifier <em>Nested Classifier</em>}</li>
 *   <li>{@link CompleteDSLPckg.impl.InterfaceImpl#getRedefinedInterface <em>Redefined Interface</em>}</li>
 *   <li>{@link CompleteDSLPckg.impl.InterfaceImpl#getOwnedAttribute <em>Owned Attribute</em>}</li>
 *   <li>{@link CompleteDSLPckg.impl.InterfaceImpl#getOwnedOperation <em>Owned Operation</em>}</li>
 *   <li>{@link CompleteDSLPckg.impl.InterfaceImpl#getOwnedReception <em>Owned Reception</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceImpl extends ClassifierImpl implements Interface {
	/**
	 * The cached value of the '{@link #getNestedClassifier() <em>Nested Classifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedClassifier()
	 * @generated
	 * @ordered
	 */
	protected Classifier nestedClassifier;

	/**
	 * The cached value of the '{@link #getRedefinedInterface() <em>Redefined Interface</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedefinedInterface()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> redefinedInterface;

	/**
	 * The cached value of the '{@link #getOwnedAttribute() <em>Owned Attribute</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> ownedAttribute;

	/**
	 * The cached value of the '{@link #getOwnedOperation() <em>Owned Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOperation()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> ownedOperation;

	/**
	 * The cached value of the '{@link #getOwnedReception() <em>Owned Reception</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedReception()
	 * @generated
	 * @ordered
	 */
	protected EList<Reception> ownedReception;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompleteDSLPckgPackage.eINSTANCE.getInterface();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getNestedClassifier() {
		return nestedClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNestedClassifier(Classifier newNestedClassifier, NotificationChain msgs) {
		Classifier oldNestedClassifier = nestedClassifier;
		nestedClassifier = newNestedClassifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompleteDSLPckgPackage.INTERFACE__NESTED_CLASSIFIER, oldNestedClassifier, newNestedClassifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNestedClassifier(Classifier newNestedClassifier) {
		if (newNestedClassifier != nestedClassifier) {
			NotificationChain msgs = null;
			if (nestedClassifier != null)
				msgs = ((InternalEObject)nestedClassifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompleteDSLPckgPackage.INTERFACE__NESTED_CLASSIFIER, null, msgs);
			if (newNestedClassifier != null)
				msgs = ((InternalEObject)newNestedClassifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompleteDSLPckgPackage.INTERFACE__NESTED_CLASSIFIER, null, msgs);
			msgs = basicSetNestedClassifier(newNestedClassifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompleteDSLPckgPackage.INTERFACE__NESTED_CLASSIFIER, newNestedClassifier, newNestedClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getRedefinedInterface() {
		if (redefinedInterface == null) {
			redefinedInterface = new EObjectResolvingEList<Interface>(Interface.class, this, CompleteDSLPckgPackage.INTERFACE__REDEFINED_INTERFACE);
		}
		return redefinedInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getOwnedAttribute() {
		if (ownedAttribute == null) {
			ownedAttribute = new EObjectContainmentWithInverseEList<Property>(Property.class, this, CompleteDSLPckgPackage.INTERFACE__OWNED_ATTRIBUTE, CompleteDSLPckgPackage.PROPERTY__INTERFACE);
		}
		return ownedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getOwnedOperation() {
		if (ownedOperation == null) {
			ownedOperation = new EObjectContainmentWithInverseEList<Operation>(Operation.class, this, CompleteDSLPckgPackage.INTERFACE__OWNED_OPERATION, CompleteDSLPckgPackage.OPERATION__INTERFACE);
		}
		return ownedOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Reception> getOwnedReception() {
		if (ownedReception == null) {
			ownedReception = new EObjectContainmentEList<Reception>(Reception.class, this, CompleteDSLPckgPackage.INTERFACE__OWNED_RECEPTION);
		}
		return ownedReception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompleteDSLPckgPackage.INTERFACE__OWNED_ATTRIBUTE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedAttribute()).basicAdd(otherEnd, msgs);
			case CompleteDSLPckgPackage.INTERFACE__OWNED_OPERATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperation()).basicAdd(otherEnd, msgs);
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
			case CompleteDSLPckgPackage.INTERFACE__NESTED_CLASSIFIER:
				return basicSetNestedClassifier(null, msgs);
			case CompleteDSLPckgPackage.INTERFACE__OWNED_ATTRIBUTE:
				return ((InternalEList<?>)getOwnedAttribute()).basicRemove(otherEnd, msgs);
			case CompleteDSLPckgPackage.INTERFACE__OWNED_OPERATION:
				return ((InternalEList<?>)getOwnedOperation()).basicRemove(otherEnd, msgs);
			case CompleteDSLPckgPackage.INTERFACE__OWNED_RECEPTION:
				return ((InternalEList<?>)getOwnedReception()).basicRemove(otherEnd, msgs);
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
			case CompleteDSLPckgPackage.INTERFACE__NESTED_CLASSIFIER:
				return getNestedClassifier();
			case CompleteDSLPckgPackage.INTERFACE__REDEFINED_INTERFACE:
				return getRedefinedInterface();
			case CompleteDSLPckgPackage.INTERFACE__OWNED_ATTRIBUTE:
				return getOwnedAttribute();
			case CompleteDSLPckgPackage.INTERFACE__OWNED_OPERATION:
				return getOwnedOperation();
			case CompleteDSLPckgPackage.INTERFACE__OWNED_RECEPTION:
				return getOwnedReception();
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
			case CompleteDSLPckgPackage.INTERFACE__NESTED_CLASSIFIER:
				setNestedClassifier((Classifier)newValue);
				return;
			case CompleteDSLPckgPackage.INTERFACE__REDEFINED_INTERFACE:
				getRedefinedInterface().clear();
				getRedefinedInterface().addAll((Collection<? extends Interface>)newValue);
				return;
			case CompleteDSLPckgPackage.INTERFACE__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				getOwnedAttribute().addAll((Collection<? extends Property>)newValue);
				return;
			case CompleteDSLPckgPackage.INTERFACE__OWNED_OPERATION:
				getOwnedOperation().clear();
				getOwnedOperation().addAll((Collection<? extends Operation>)newValue);
				return;
			case CompleteDSLPckgPackage.INTERFACE__OWNED_RECEPTION:
				getOwnedReception().clear();
				getOwnedReception().addAll((Collection<? extends Reception>)newValue);
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
			case CompleteDSLPckgPackage.INTERFACE__NESTED_CLASSIFIER:
				setNestedClassifier((Classifier)null);
				return;
			case CompleteDSLPckgPackage.INTERFACE__REDEFINED_INTERFACE:
				getRedefinedInterface().clear();
				return;
			case CompleteDSLPckgPackage.INTERFACE__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				return;
			case CompleteDSLPckgPackage.INTERFACE__OWNED_OPERATION:
				getOwnedOperation().clear();
				return;
			case CompleteDSLPckgPackage.INTERFACE__OWNED_RECEPTION:
				getOwnedReception().clear();
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
			case CompleteDSLPckgPackage.INTERFACE__NESTED_CLASSIFIER:
				return nestedClassifier != null;
			case CompleteDSLPckgPackage.INTERFACE__REDEFINED_INTERFACE:
				return redefinedInterface != null && !redefinedInterface.isEmpty();
			case CompleteDSLPckgPackage.INTERFACE__OWNED_ATTRIBUTE:
				return ownedAttribute != null && !ownedAttribute.isEmpty();
			case CompleteDSLPckgPackage.INTERFACE__OWNED_OPERATION:
				return ownedOperation != null && !ownedOperation.isEmpty();
			case CompleteDSLPckgPackage.INTERFACE__OWNED_RECEPTION:
				return ownedReception != null && !ownedReception.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InterfaceImpl