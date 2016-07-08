/**
 */
package Classes.impl;

import Classes.BehavioralFeature;
import Classes.ClassesPackage;
import Classes.Constraint;
import Classes.ElementImport;
import Classes.NamedElement;
import Classes.Namespace;
import Classes.PackageImport;
import Classes.PackageableElement;
import Classes.Parameter;
import Classes.Type;

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
 * An implementation of the model object '<em><b>Behavioral Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Classes.impl.BehavioralFeatureImpl#getImportedMember <em>Imported Member</em>}</li>
 *   <li>{@link Classes.impl.BehavioralFeatureImpl#getMember <em>Member</em>}</li>
 *   <li>{@link Classes.impl.BehavioralFeatureImpl#getOwnedMember <em>Owned Member</em>}</li>
 *   <li>{@link Classes.impl.BehavioralFeatureImpl#getElementImport <em>Element Import</em>}</li>
 *   <li>{@link Classes.impl.BehavioralFeatureImpl#getPackageImport <em>Package Import</em>}</li>
 *   <li>{@link Classes.impl.BehavioralFeatureImpl#getOwnedRule <em>Owned Rule</em>}</li>
 *   <li>{@link Classes.impl.BehavioralFeatureImpl#getOwnedParameter <em>Owned Parameter</em>}</li>
 *   <li>{@link Classes.impl.BehavioralFeatureImpl#getRaisedException <em>Raised Exception</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BehavioralFeatureImpl extends FeatureImpl implements BehavioralFeature {
	/**
	 * The cached value of the '{@link #getImportedMember() <em>Imported Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedMember()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageableElement> importedMember;

	/**
	 * The cached value of the '{@link #getMember() <em>Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedElement> member;

	/**
	 * The cached value of the '{@link #getOwnedMember() <em>Owned Member</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMember()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedElement> ownedMember;

	/**
	 * The cached value of the '{@link #getElementImport() <em>Element Import</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementImport()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementImport> elementImport;

	/**
	 * The cached value of the '{@link #getPackageImport() <em>Package Import</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageImport()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageImport> packageImport;

	/**
	 * The cached value of the '{@link #getOwnedRule() <em>Owned Rule</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRule()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> ownedRule;

	/**
	 * The cached value of the '{@link #getOwnedParameter() <em>Owned Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> ownedParameter;

	/**
	 * The cached value of the '{@link #getRaisedException() <em>Raised Exception</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRaisedException()
	 * @generated
	 * @ordered
	 */
	protected Type raisedException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehavioralFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassesPackage.Literals.BEHAVIORAL_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageableElement> getImportedMember() {
		if (importedMember == null) {
			importedMember = new EObjectResolvingEList<PackageableElement>(PackageableElement.class, this, ClassesPackage.BEHAVIORAL_FEATURE__IMPORTED_MEMBER);
		}
		return importedMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getMember() {
		if (member == null) {
			member = new EObjectResolvingEList<NamedElement>(NamedElement.class, this, ClassesPackage.BEHAVIORAL_FEATURE__MEMBER);
		}
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getOwnedMember() {
		if (ownedMember == null) {
			ownedMember = new EObjectContainmentWithInverseEList<NamedElement>(NamedElement.class, this, ClassesPackage.BEHAVIORAL_FEATURE__OWNED_MEMBER, ClassesPackage.NAMED_ELEMENT__NAMESPACE);
		}
		return ownedMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementImport> getElementImport() {
		if (elementImport == null) {
			elementImport = new EObjectContainmentWithInverseEList<ElementImport>(ElementImport.class, this, ClassesPackage.BEHAVIORAL_FEATURE__ELEMENT_IMPORT, ClassesPackage.ELEMENT_IMPORT__IMPORTING_NAMESPACE);
		}
		return elementImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageImport> getPackageImport() {
		if (packageImport == null) {
			packageImport = new EObjectContainmentWithInverseEList<PackageImport>(PackageImport.class, this, ClassesPackage.BEHAVIORAL_FEATURE__PACKAGE_IMPORT, ClassesPackage.PACKAGE_IMPORT__IMPORTING_NAMESPACE);
		}
		return packageImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getOwnedRule() {
		if (ownedRule == null) {
			ownedRule = new EObjectContainmentWithInverseEList<Constraint>(Constraint.class, this, ClassesPackage.BEHAVIORAL_FEATURE__OWNED_RULE, ClassesPackage.CONSTRAINT__CONTEXT);
		}
		return ownedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getOwnedParameter() {
		if (ownedParameter == null) {
			ownedParameter = new EObjectContainmentEList<Parameter>(Parameter.class, this, ClassesPackage.BEHAVIORAL_FEATURE__OWNED_PARAMETER);
		}
		return ownedParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getRaisedException() {
		if (raisedException != null && raisedException.eIsProxy()) {
			InternalEObject oldRaisedException = (InternalEObject)raisedException;
			raisedException = (Type)eResolveProxy(oldRaisedException);
			if (raisedException != oldRaisedException) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.BEHAVIORAL_FEATURE__RAISED_EXCEPTION, oldRaisedException, raisedException));
			}
		}
		return raisedException;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetRaisedException() {
		return raisedException;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRaisedException(Type newRaisedException) {
		Type oldRaisedException = raisedException;
		raisedException = newRaisedException;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.BEHAVIORAL_FEATURE__RAISED_EXCEPTION, oldRaisedException, raisedException));
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
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_MEMBER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedMember()).basicAdd(otherEnd, msgs);
			case ClassesPackage.BEHAVIORAL_FEATURE__ELEMENT_IMPORT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getElementImport()).basicAdd(otherEnd, msgs);
			case ClassesPackage.BEHAVIORAL_FEATURE__PACKAGE_IMPORT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPackageImport()).basicAdd(otherEnd, msgs);
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_RULE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRule()).basicAdd(otherEnd, msgs);
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
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_MEMBER:
				return ((InternalEList<?>)getOwnedMember()).basicRemove(otherEnd, msgs);
			case ClassesPackage.BEHAVIORAL_FEATURE__ELEMENT_IMPORT:
				return ((InternalEList<?>)getElementImport()).basicRemove(otherEnd, msgs);
			case ClassesPackage.BEHAVIORAL_FEATURE__PACKAGE_IMPORT:
				return ((InternalEList<?>)getPackageImport()).basicRemove(otherEnd, msgs);
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRule()).basicRemove(otherEnd, msgs);
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_PARAMETER:
				return ((InternalEList<?>)getOwnedParameter()).basicRemove(otherEnd, msgs);
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
			case ClassesPackage.BEHAVIORAL_FEATURE__IMPORTED_MEMBER:
				return getImportedMember();
			case ClassesPackage.BEHAVIORAL_FEATURE__MEMBER:
				return getMember();
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_MEMBER:
				return getOwnedMember();
			case ClassesPackage.BEHAVIORAL_FEATURE__ELEMENT_IMPORT:
				return getElementImport();
			case ClassesPackage.BEHAVIORAL_FEATURE__PACKAGE_IMPORT:
				return getPackageImport();
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_RULE:
				return getOwnedRule();
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_PARAMETER:
				return getOwnedParameter();
			case ClassesPackage.BEHAVIORAL_FEATURE__RAISED_EXCEPTION:
				if (resolve) return getRaisedException();
				return basicGetRaisedException();
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
			case ClassesPackage.BEHAVIORAL_FEATURE__IMPORTED_MEMBER:
				getImportedMember().clear();
				getImportedMember().addAll((Collection<? extends PackageableElement>)newValue);
				return;
			case ClassesPackage.BEHAVIORAL_FEATURE__MEMBER:
				getMember().clear();
				getMember().addAll((Collection<? extends NamedElement>)newValue);
				return;
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_MEMBER:
				getOwnedMember().clear();
				getOwnedMember().addAll((Collection<? extends NamedElement>)newValue);
				return;
			case ClassesPackage.BEHAVIORAL_FEATURE__ELEMENT_IMPORT:
				getElementImport().clear();
				getElementImport().addAll((Collection<? extends ElementImport>)newValue);
				return;
			case ClassesPackage.BEHAVIORAL_FEATURE__PACKAGE_IMPORT:
				getPackageImport().clear();
				getPackageImport().addAll((Collection<? extends PackageImport>)newValue);
				return;
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_PARAMETER:
				getOwnedParameter().clear();
				getOwnedParameter().addAll((Collection<? extends Parameter>)newValue);
				return;
			case ClassesPackage.BEHAVIORAL_FEATURE__RAISED_EXCEPTION:
				setRaisedException((Type)newValue);
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
			case ClassesPackage.BEHAVIORAL_FEATURE__IMPORTED_MEMBER:
				getImportedMember().clear();
				return;
			case ClassesPackage.BEHAVIORAL_FEATURE__MEMBER:
				getMember().clear();
				return;
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_MEMBER:
				getOwnedMember().clear();
				return;
			case ClassesPackage.BEHAVIORAL_FEATURE__ELEMENT_IMPORT:
				getElementImport().clear();
				return;
			case ClassesPackage.BEHAVIORAL_FEATURE__PACKAGE_IMPORT:
				getPackageImport().clear();
				return;
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_PARAMETER:
				getOwnedParameter().clear();
				return;
			case ClassesPackage.BEHAVIORAL_FEATURE__RAISED_EXCEPTION:
				setRaisedException((Type)null);
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
			case ClassesPackage.BEHAVIORAL_FEATURE__IMPORTED_MEMBER:
				return importedMember != null && !importedMember.isEmpty();
			case ClassesPackage.BEHAVIORAL_FEATURE__MEMBER:
				return member != null && !member.isEmpty();
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_MEMBER:
				return ownedMember != null && !ownedMember.isEmpty();
			case ClassesPackage.BEHAVIORAL_FEATURE__ELEMENT_IMPORT:
				return elementImport != null && !elementImport.isEmpty();
			case ClassesPackage.BEHAVIORAL_FEATURE__PACKAGE_IMPORT:
				return packageImport != null && !packageImport.isEmpty();
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_PARAMETER:
				return ownedParameter != null && !ownedParameter.isEmpty();
			case ClassesPackage.BEHAVIORAL_FEATURE__RAISED_EXCEPTION:
				return raisedException != null;
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
		if (baseClass == Namespace.class) {
			switch (derivedFeatureID) {
				case ClassesPackage.BEHAVIORAL_FEATURE__IMPORTED_MEMBER: return ClassesPackage.NAMESPACE__IMPORTED_MEMBER;
				case ClassesPackage.BEHAVIORAL_FEATURE__MEMBER: return ClassesPackage.NAMESPACE__MEMBER;
				case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_MEMBER: return ClassesPackage.NAMESPACE__OWNED_MEMBER;
				case ClassesPackage.BEHAVIORAL_FEATURE__ELEMENT_IMPORT: return ClassesPackage.NAMESPACE__ELEMENT_IMPORT;
				case ClassesPackage.BEHAVIORAL_FEATURE__PACKAGE_IMPORT: return ClassesPackage.NAMESPACE__PACKAGE_IMPORT;
				case ClassesPackage.BEHAVIORAL_FEATURE__OWNED_RULE: return ClassesPackage.NAMESPACE__OWNED_RULE;
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
		if (baseClass == Namespace.class) {
			switch (baseFeatureID) {
				case ClassesPackage.NAMESPACE__IMPORTED_MEMBER: return ClassesPackage.BEHAVIORAL_FEATURE__IMPORTED_MEMBER;
				case ClassesPackage.NAMESPACE__MEMBER: return ClassesPackage.BEHAVIORAL_FEATURE__MEMBER;
				case ClassesPackage.NAMESPACE__OWNED_MEMBER: return ClassesPackage.BEHAVIORAL_FEATURE__OWNED_MEMBER;
				case ClassesPackage.NAMESPACE__ELEMENT_IMPORT: return ClassesPackage.BEHAVIORAL_FEATURE__ELEMENT_IMPORT;
				case ClassesPackage.NAMESPACE__PACKAGE_IMPORT: return ClassesPackage.BEHAVIORAL_FEATURE__PACKAGE_IMPORT;
				case ClassesPackage.NAMESPACE__OWNED_RULE: return ClassesPackage.BEHAVIORAL_FEATURE__OWNED_RULE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //BehavioralFeatureImpl
