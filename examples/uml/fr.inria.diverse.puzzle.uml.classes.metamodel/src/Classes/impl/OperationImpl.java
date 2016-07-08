/**
 */
package Classes.impl;

import Classes.ClassesPackage;
import Classes.Constraint;
import Classes.DataType;
import Classes.Interface;
import Classes.Operation;
import Classes.Type;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Classes.impl.OperationImpl#isIsQuery <em>Is Query</em>}</li>
 *   <li>{@link Classes.impl.OperationImpl#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link Classes.impl.OperationImpl#isIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link Classes.impl.OperationImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link Classes.impl.OperationImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link Classes.impl.OperationImpl#getType <em>Type</em>}</li>
 *   <li>{@link Classes.impl.OperationImpl#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link Classes.impl.OperationImpl#getBodyCondition <em>Body Condition</em>}</li>
 *   <li>{@link Classes.impl.OperationImpl#getPostcondition <em>Postcondition</em>}</li>
 *   <li>{@link Classes.impl.OperationImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link Classes.impl.OperationImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link Classes.impl.OperationImpl#getInterface <em>Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationImpl extends BehavioralFeatureImpl implements Operation {
	/**
	 * The default value of the '{@link #isIsQuery() <em>Is Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsQuery()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_QUERY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsQuery() <em>Is Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsQuery()
	 * @generated
	 * @ordered
	 */
	protected boolean isQuery = IS_QUERY_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ORDERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected boolean isOrdered = IS_ORDERED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNIQUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnique()
	 * @generated
	 * @ordered
	 */
	protected boolean isUnique = IS_UNIQUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected static final int UPPER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected int upper = UPPER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected static final int LOWER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected int lower = LOWER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

	/**
	 * The cached value of the '{@link #getPrecondition() <em>Precondition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecondition()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> precondition;

	/**
	 * The cached value of the '{@link #getBodyCondition() <em>Body Condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyCondition()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> bodyCondition;

	/**
	 * The cached value of the '{@link #getPostcondition() <em>Postcondition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostcondition()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> postcondition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassesPackage.Literals.OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsQuery() {
		return isQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsQuery(boolean newIsQuery) {
		boolean oldIsQuery = isQuery;
		isQuery = newIsQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.OPERATION__IS_QUERY, oldIsQuery, isQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsOrdered() {
		return isOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOrdered(boolean newIsOrdered) {
		boolean oldIsOrdered = isOrdered;
		isOrdered = newIsOrdered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.OPERATION__IS_ORDERED, oldIsOrdered, isOrdered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsUnique() {
		return isUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsUnique(boolean newIsUnique) {
		boolean oldIsUnique = isUnique;
		isUnique = newIsUnique;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.OPERATION__IS_UNIQUE, oldIsUnique, isUnique));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUpper() {
		return upper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpper(int newUpper) {
		int oldUpper = upper;
		upper = newUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.OPERATION__UPPER, oldUpper, upper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLower() {
		return lower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLower(int newLower) {
		int oldLower = lower;
		lower = newLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.OPERATION__LOWER, oldLower, lower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.OPERATION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.OPERATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getPrecondition() {
		if (precondition == null) {
			precondition = new EObjectContainmentEList<Constraint>(Constraint.class, this, ClassesPackage.OPERATION__PRECONDITION);
		}
		return precondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getBodyCondition() {
		if (bodyCondition == null) {
			bodyCondition = new EObjectContainmentEList<Constraint>(Constraint.class, this, ClassesPackage.OPERATION__BODY_CONDITION);
		}
		return bodyCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getPostcondition() {
		if (postcondition == null) {
			postcondition = new EObjectContainmentEList<Constraint>(Constraint.class, this, ClassesPackage.OPERATION__POSTCONDITION);
		}
		return postcondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classes.Class getClass_() {
		if (eContainerFeatureID() != ClassesPackage.OPERATION__CLASS) return null;
		return (Classes.Class)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClass(Classes.Class newClass, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newClass, ClassesPackage.OPERATION__CLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(Classes.Class newClass) {
		if (newClass != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.OPERATION__CLASS && newClass != null)) {
			if (EcoreUtil.isAncestor(this, newClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newClass != null)
				msgs = ((InternalEObject)newClass).eInverseAdd(this, ClassesPackage.CLASS__OWNED_OPERATION, Classes.Class.class, msgs);
			msgs = basicSetClass(newClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.OPERATION__CLASS, newClass, newClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getDataType() {
		if (eContainerFeatureID() != ClassesPackage.OPERATION__DATA_TYPE) return null;
		return (DataType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataType(DataType newDataType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDataType, ClassesPackage.OPERATION__DATA_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataType(DataType newDataType) {
		if (newDataType != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.OPERATION__DATA_TYPE && newDataType != null)) {
			if (EcoreUtil.isAncestor(this, newDataType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDataType != null)
				msgs = ((InternalEObject)newDataType).eInverseAdd(this, ClassesPackage.DATA_TYPE__OWNED_OPERATION, DataType.class, msgs);
			msgs = basicSetDataType(newDataType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.OPERATION__DATA_TYPE, newDataType, newDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getInterface() {
		if (eContainerFeatureID() != ClassesPackage.OPERATION__INTERFACE) return null;
		return (Interface)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterface(Interface newInterface, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInterface, ClassesPackage.OPERATION__INTERFACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterface(Interface newInterface) {
		if (newInterface != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.OPERATION__INTERFACE && newInterface != null)) {
			if (EcoreUtil.isAncestor(this, newInterface))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInterface != null)
				msgs = ((InternalEObject)newInterface).eInverseAdd(this, ClassesPackage.INTERFACE__OWNED_OPERATION, Interface.class, msgs);
			msgs = basicSetInterface(newInterface, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.OPERATION__INTERFACE, newInterface, newInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassesPackage.OPERATION__CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetClass((Classes.Class)otherEnd, msgs);
			case ClassesPackage.OPERATION__DATA_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDataType((DataType)otherEnd, msgs);
			case ClassesPackage.OPERATION__INTERFACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInterface((Interface)otherEnd, msgs);
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
			case ClassesPackage.OPERATION__PRECONDITION:
				return ((InternalEList<?>)getPrecondition()).basicRemove(otherEnd, msgs);
			case ClassesPackage.OPERATION__BODY_CONDITION:
				return ((InternalEList<?>)getBodyCondition()).basicRemove(otherEnd, msgs);
			case ClassesPackage.OPERATION__POSTCONDITION:
				return ((InternalEList<?>)getPostcondition()).basicRemove(otherEnd, msgs);
			case ClassesPackage.OPERATION__CLASS:
				return basicSetClass(null, msgs);
			case ClassesPackage.OPERATION__DATA_TYPE:
				return basicSetDataType(null, msgs);
			case ClassesPackage.OPERATION__INTERFACE:
				return basicSetInterface(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ClassesPackage.OPERATION__CLASS:
				return eInternalContainer().eInverseRemove(this, ClassesPackage.CLASS__OWNED_OPERATION, Classes.Class.class, msgs);
			case ClassesPackage.OPERATION__DATA_TYPE:
				return eInternalContainer().eInverseRemove(this, ClassesPackage.DATA_TYPE__OWNED_OPERATION, DataType.class, msgs);
			case ClassesPackage.OPERATION__INTERFACE:
				return eInternalContainer().eInverseRemove(this, ClassesPackage.INTERFACE__OWNED_OPERATION, Interface.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassesPackage.OPERATION__IS_QUERY:
				return isIsQuery();
			case ClassesPackage.OPERATION__IS_ORDERED:
				return isIsOrdered();
			case ClassesPackage.OPERATION__IS_UNIQUE:
				return isIsUnique();
			case ClassesPackage.OPERATION__UPPER:
				return getUpper();
			case ClassesPackage.OPERATION__LOWER:
				return getLower();
			case ClassesPackage.OPERATION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ClassesPackage.OPERATION__PRECONDITION:
				return getPrecondition();
			case ClassesPackage.OPERATION__BODY_CONDITION:
				return getBodyCondition();
			case ClassesPackage.OPERATION__POSTCONDITION:
				return getPostcondition();
			case ClassesPackage.OPERATION__CLASS:
				return getClass_();
			case ClassesPackage.OPERATION__DATA_TYPE:
				return getDataType();
			case ClassesPackage.OPERATION__INTERFACE:
				return getInterface();
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
			case ClassesPackage.OPERATION__IS_QUERY:
				setIsQuery((Boolean)newValue);
				return;
			case ClassesPackage.OPERATION__IS_ORDERED:
				setIsOrdered((Boolean)newValue);
				return;
			case ClassesPackage.OPERATION__IS_UNIQUE:
				setIsUnique((Boolean)newValue);
				return;
			case ClassesPackage.OPERATION__UPPER:
				setUpper((Integer)newValue);
				return;
			case ClassesPackage.OPERATION__LOWER:
				setLower((Integer)newValue);
				return;
			case ClassesPackage.OPERATION__TYPE:
				setType((Type)newValue);
				return;
			case ClassesPackage.OPERATION__PRECONDITION:
				getPrecondition().clear();
				getPrecondition().addAll((Collection<? extends Constraint>)newValue);
				return;
			case ClassesPackage.OPERATION__BODY_CONDITION:
				getBodyCondition().clear();
				getBodyCondition().addAll((Collection<? extends Constraint>)newValue);
				return;
			case ClassesPackage.OPERATION__POSTCONDITION:
				getPostcondition().clear();
				getPostcondition().addAll((Collection<? extends Constraint>)newValue);
				return;
			case ClassesPackage.OPERATION__CLASS:
				setClass((Classes.Class)newValue);
				return;
			case ClassesPackage.OPERATION__DATA_TYPE:
				setDataType((DataType)newValue);
				return;
			case ClassesPackage.OPERATION__INTERFACE:
				setInterface((Interface)newValue);
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
			case ClassesPackage.OPERATION__IS_QUERY:
				setIsQuery(IS_QUERY_EDEFAULT);
				return;
			case ClassesPackage.OPERATION__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case ClassesPackage.OPERATION__IS_UNIQUE:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case ClassesPackage.OPERATION__UPPER:
				setUpper(UPPER_EDEFAULT);
				return;
			case ClassesPackage.OPERATION__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case ClassesPackage.OPERATION__TYPE:
				setType((Type)null);
				return;
			case ClassesPackage.OPERATION__PRECONDITION:
				getPrecondition().clear();
				return;
			case ClassesPackage.OPERATION__BODY_CONDITION:
				getBodyCondition().clear();
				return;
			case ClassesPackage.OPERATION__POSTCONDITION:
				getPostcondition().clear();
				return;
			case ClassesPackage.OPERATION__CLASS:
				setClass((Classes.Class)null);
				return;
			case ClassesPackage.OPERATION__DATA_TYPE:
				setDataType((DataType)null);
				return;
			case ClassesPackage.OPERATION__INTERFACE:
				setInterface((Interface)null);
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
			case ClassesPackage.OPERATION__IS_QUERY:
				return isQuery != IS_QUERY_EDEFAULT;
			case ClassesPackage.OPERATION__IS_ORDERED:
				return isOrdered != IS_ORDERED_EDEFAULT;
			case ClassesPackage.OPERATION__IS_UNIQUE:
				return isUnique != IS_UNIQUE_EDEFAULT;
			case ClassesPackage.OPERATION__UPPER:
				return upper != UPPER_EDEFAULT;
			case ClassesPackage.OPERATION__LOWER:
				return lower != LOWER_EDEFAULT;
			case ClassesPackage.OPERATION__TYPE:
				return type != null;
			case ClassesPackage.OPERATION__PRECONDITION:
				return precondition != null && !precondition.isEmpty();
			case ClassesPackage.OPERATION__BODY_CONDITION:
				return bodyCondition != null && !bodyCondition.isEmpty();
			case ClassesPackage.OPERATION__POSTCONDITION:
				return postcondition != null && !postcondition.isEmpty();
			case ClassesPackage.OPERATION__CLASS:
				return getClass_() != null;
			case ClassesPackage.OPERATION__DATA_TYPE:
				return getDataType() != null;
			case ClassesPackage.OPERATION__INTERFACE:
				return getInterface() != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (isQuery: ");
		result.append(isQuery);
		result.append(", isOrdered: ");
		result.append(isOrdered);
		result.append(", isUnique: ");
		result.append(isUnique);
		result.append(", upper: ");
		result.append(upper);
		result.append(", lower: ");
		result.append(lower);
		result.append(')');
		return result.toString();
	}

} //OperationImpl
