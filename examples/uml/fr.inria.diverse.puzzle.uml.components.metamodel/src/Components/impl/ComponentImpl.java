/**
 */
package Components.impl;

import Components.Component;
import Components.ComponentRealization;
import Components.ComponentsPackage;
import Components.Dependency;
import Components.Interface;
import Components.NamedElement;
import Components.PackageableElement;

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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Components.impl.ComponentImpl#getClientDependency <em>Client Dependency</em>}</li>
 *   <li>{@link Components.impl.ComponentImpl#isIsIndirectlyInstantiated <em>Is Indirectly Instantiated</em>}</li>
 *   <li>{@link Components.impl.ComponentImpl#getRequired <em>Required</em>}</li>
 *   <li>{@link Components.impl.ComponentImpl#getProvided <em>Provided</em>}</li>
 *   <li>{@link Components.impl.ComponentImpl#getRealization <em>Realization</em>}</li>
 *   <li>{@link Components.impl.ComponentImpl#getPackagedElement <em>Packaged Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentImpl extends ClassImpl implements Component {
	/**
	 * The cached value of the '{@link #getClientDependency() <em>Client Dependency</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientDependency()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> clientDependency;

	/**
	 * The default value of the '{@link #isIsIndirectlyInstantiated() <em>Is Indirectly Instantiated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsIndirectlyInstantiated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INDIRECTLY_INSTANTIATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsIndirectlyInstantiated() <em>Is Indirectly Instantiated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsIndirectlyInstantiated()
	 * @generated
	 * @ordered
	 */
	protected boolean isIndirectlyInstantiated = IS_INDIRECTLY_INSTANTIATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRequired() <em>Required</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequired()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> required;

	/**
	 * The cached value of the '{@link #getProvided() <em>Provided</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvided()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> provided;

	/**
	 * The cached value of the '{@link #getRealization() <em>Realization</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealization()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentRealization> realization;

	/**
	 * The cached value of the '{@link #getPackagedElement() <em>Packaged Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackagedElement()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageableElement> packagedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentsPackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dependency> getClientDependency() {
		if (clientDependency == null) {
			clientDependency = new EObjectWithInverseResolvingEList.ManyInverse<Dependency>(Dependency.class, this, ComponentsPackage.COMPONENT__CLIENT_DEPENDENCY, ComponentsPackage.DEPENDENCY__CLIENT);
		}
		return clientDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsIndirectlyInstantiated() {
		return isIndirectlyInstantiated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsIndirectlyInstantiated(boolean newIsIndirectlyInstantiated) {
		boolean oldIsIndirectlyInstantiated = isIndirectlyInstantiated;
		isIndirectlyInstantiated = newIsIndirectlyInstantiated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.COMPONENT__IS_INDIRECTLY_INSTANTIATED, oldIsIndirectlyInstantiated, isIndirectlyInstantiated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getRequired() {
		if (required == null) {
			required = new EObjectResolvingEList<Interface>(Interface.class, this, ComponentsPackage.COMPONENT__REQUIRED);
		}
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getProvided() {
		if (provided == null) {
			provided = new EObjectResolvingEList<Interface>(Interface.class, this, ComponentsPackage.COMPONENT__PROVIDED);
		}
		return provided;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentRealization> getRealization() {
		if (realization == null) {
			realization = new EObjectContainmentWithInverseEList<ComponentRealization>(ComponentRealization.class, this, ComponentsPackage.COMPONENT__REALIZATION, ComponentsPackage.COMPONENT_REALIZATION__ABSTRACTION);
		}
		return realization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageableElement> getPackagedElement() {
		if (packagedElement == null) {
			packagedElement = new EObjectContainmentEList<PackageableElement>(PackageableElement.class, this, ComponentsPackage.COMPONENT__PACKAGED_ELEMENT);
		}
		return packagedElement;
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
			case ComponentsPackage.COMPONENT__CLIENT_DEPENDENCY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getClientDependency()).basicAdd(otherEnd, msgs);
			case ComponentsPackage.COMPONENT__REALIZATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRealization()).basicAdd(otherEnd, msgs);
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
			case ComponentsPackage.COMPONENT__CLIENT_DEPENDENCY:
				return ((InternalEList<?>)getClientDependency()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.COMPONENT__REALIZATION:
				return ((InternalEList<?>)getRealization()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.COMPONENT__PACKAGED_ELEMENT:
				return ((InternalEList<?>)getPackagedElement()).basicRemove(otherEnd, msgs);
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
			case ComponentsPackage.COMPONENT__CLIENT_DEPENDENCY:
				return getClientDependency();
			case ComponentsPackage.COMPONENT__IS_INDIRECTLY_INSTANTIATED:
				return isIsIndirectlyInstantiated();
			case ComponentsPackage.COMPONENT__REQUIRED:
				return getRequired();
			case ComponentsPackage.COMPONENT__PROVIDED:
				return getProvided();
			case ComponentsPackage.COMPONENT__REALIZATION:
				return getRealization();
			case ComponentsPackage.COMPONENT__PACKAGED_ELEMENT:
				return getPackagedElement();
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
			case ComponentsPackage.COMPONENT__CLIENT_DEPENDENCY:
				getClientDependency().clear();
				getClientDependency().addAll((Collection<? extends Dependency>)newValue);
				return;
			case ComponentsPackage.COMPONENT__IS_INDIRECTLY_INSTANTIATED:
				setIsIndirectlyInstantiated((Boolean)newValue);
				return;
			case ComponentsPackage.COMPONENT__REQUIRED:
				getRequired().clear();
				getRequired().addAll((Collection<? extends Interface>)newValue);
				return;
			case ComponentsPackage.COMPONENT__PROVIDED:
				getProvided().clear();
				getProvided().addAll((Collection<? extends Interface>)newValue);
				return;
			case ComponentsPackage.COMPONENT__REALIZATION:
				getRealization().clear();
				getRealization().addAll((Collection<? extends ComponentRealization>)newValue);
				return;
			case ComponentsPackage.COMPONENT__PACKAGED_ELEMENT:
				getPackagedElement().clear();
				getPackagedElement().addAll((Collection<? extends PackageableElement>)newValue);
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
			case ComponentsPackage.COMPONENT__CLIENT_DEPENDENCY:
				getClientDependency().clear();
				return;
			case ComponentsPackage.COMPONENT__IS_INDIRECTLY_INSTANTIATED:
				setIsIndirectlyInstantiated(IS_INDIRECTLY_INSTANTIATED_EDEFAULT);
				return;
			case ComponentsPackage.COMPONENT__REQUIRED:
				getRequired().clear();
				return;
			case ComponentsPackage.COMPONENT__PROVIDED:
				getProvided().clear();
				return;
			case ComponentsPackage.COMPONENT__REALIZATION:
				getRealization().clear();
				return;
			case ComponentsPackage.COMPONENT__PACKAGED_ELEMENT:
				getPackagedElement().clear();
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
			case ComponentsPackage.COMPONENT__CLIENT_DEPENDENCY:
				return clientDependency != null && !clientDependency.isEmpty();
			case ComponentsPackage.COMPONENT__IS_INDIRECTLY_INSTANTIATED:
				return isIndirectlyInstantiated != IS_INDIRECTLY_INSTANTIATED_EDEFAULT;
			case ComponentsPackage.COMPONENT__REQUIRED:
				return required != null && !required.isEmpty();
			case ComponentsPackage.COMPONENT__PROVIDED:
				return provided != null && !provided.isEmpty();
			case ComponentsPackage.COMPONENT__REALIZATION:
				return realization != null && !realization.isEmpty();
			case ComponentsPackage.COMPONENT__PACKAGED_ELEMENT:
				return packagedElement != null && !packagedElement.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case ComponentsPackage.COMPONENT__CLIENT_DEPENDENCY: return ComponentsPackage.NAMED_ELEMENT__CLIENT_DEPENDENCY;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case ComponentsPackage.NAMED_ELEMENT__CLIENT_DEPENDENCY: return ComponentsPackage.COMPONENT__CLIENT_DEPENDENCY;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isIndirectlyInstantiated: ");
		result.append(isIndirectlyInstantiated);
		result.append(')');
		return result.toString();
	}

} //ComponentImpl
