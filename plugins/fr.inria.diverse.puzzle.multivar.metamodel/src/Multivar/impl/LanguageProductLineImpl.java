/**
 */
package Multivar.impl;

import Multivar.LanguageProductLine;
import Multivar.LanguageVariability;
import Multivar.MultivarPackage;
import Multivar.ProductLineVariability;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Language Product Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Multivar.impl.LanguageProductLineImpl#getImplementationFile <em>Implementation File</em>}</li>
 *   <li>{@link Multivar.impl.LanguageProductLineImpl#getProductLineVariability <em>Product Line Variability</em>}</li>
 *   <li>{@link Multivar.impl.LanguageProductLineImpl#getLanguageVariability <em>Language Variability</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LanguageProductLineImpl extends MinimalEObjectImpl.Container implements LanguageProductLine {
	/**
	 * The default value of the '{@link #getImplementationFile() <em>Implementation File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationFile()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPLEMENTATION_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImplementationFile() <em>Implementation File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationFile()
	 * @generated
	 * @ordered
	 */
	protected String implementationFile = IMPLEMENTATION_FILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProductLineVariability() <em>Product Line Variability</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductLineVariability()
	 * @generated
	 * @ordered
	 */
	protected ProductLineVariability productLineVariability;

	/**
	 * The cached value of the '{@link #getLanguageVariability() <em>Language Variability</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguageVariability()
	 * @generated
	 * @ordered
	 */
	protected LanguageVariability languageVariability;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguageProductLineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MultivarPackage.Literals.LANGUAGE_PRODUCT_LINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImplementationFile() {
		return implementationFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationFile(String newImplementationFile) {
		String oldImplementationFile = implementationFile;
		implementationFile = newImplementationFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultivarPackage.LANGUAGE_PRODUCT_LINE__IMPLEMENTATION_FILE, oldImplementationFile, implementationFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProductLineVariability getProductLineVariability() {
		return productLineVariability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProductLineVariability(ProductLineVariability newProductLineVariability, NotificationChain msgs) {
		ProductLineVariability oldProductLineVariability = productLineVariability;
		productLineVariability = newProductLineVariability;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MultivarPackage.LANGUAGE_PRODUCT_LINE__PRODUCT_LINE_VARIABILITY, oldProductLineVariability, newProductLineVariability);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductLineVariability(ProductLineVariability newProductLineVariability) {
		if (newProductLineVariability != productLineVariability) {
			NotificationChain msgs = null;
			if (productLineVariability != null)
				msgs = ((InternalEObject)productLineVariability).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MultivarPackage.LANGUAGE_PRODUCT_LINE__PRODUCT_LINE_VARIABILITY, null, msgs);
			if (newProductLineVariability != null)
				msgs = ((InternalEObject)newProductLineVariability).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MultivarPackage.LANGUAGE_PRODUCT_LINE__PRODUCT_LINE_VARIABILITY, null, msgs);
			msgs = basicSetProductLineVariability(newProductLineVariability, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultivarPackage.LANGUAGE_PRODUCT_LINE__PRODUCT_LINE_VARIABILITY, newProductLineVariability, newProductLineVariability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageVariability getLanguageVariability() {
		return languageVariability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLanguageVariability(LanguageVariability newLanguageVariability, NotificationChain msgs) {
		LanguageVariability oldLanguageVariability = languageVariability;
		languageVariability = newLanguageVariability;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MultivarPackage.LANGUAGE_PRODUCT_LINE__LANGUAGE_VARIABILITY, oldLanguageVariability, newLanguageVariability);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguageVariability(LanguageVariability newLanguageVariability) {
		if (newLanguageVariability != languageVariability) {
			NotificationChain msgs = null;
			if (languageVariability != null)
				msgs = ((InternalEObject)languageVariability).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MultivarPackage.LANGUAGE_PRODUCT_LINE__LANGUAGE_VARIABILITY, null, msgs);
			if (newLanguageVariability != null)
				msgs = ((InternalEObject)newLanguageVariability).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MultivarPackage.LANGUAGE_PRODUCT_LINE__LANGUAGE_VARIABILITY, null, msgs);
			msgs = basicSetLanguageVariability(newLanguageVariability, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultivarPackage.LANGUAGE_PRODUCT_LINE__LANGUAGE_VARIABILITY, newLanguageVariability, newLanguageVariability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MultivarPackage.LANGUAGE_PRODUCT_LINE__PRODUCT_LINE_VARIABILITY:
				return basicSetProductLineVariability(null, msgs);
			case MultivarPackage.LANGUAGE_PRODUCT_LINE__LANGUAGE_VARIABILITY:
				return basicSetLanguageVariability(null, msgs);
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
			case MultivarPackage.LANGUAGE_PRODUCT_LINE__IMPLEMENTATION_FILE:
				return getImplementationFile();
			case MultivarPackage.LANGUAGE_PRODUCT_LINE__PRODUCT_LINE_VARIABILITY:
				return getProductLineVariability();
			case MultivarPackage.LANGUAGE_PRODUCT_LINE__LANGUAGE_VARIABILITY:
				return getLanguageVariability();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MultivarPackage.LANGUAGE_PRODUCT_LINE__IMPLEMENTATION_FILE:
				setImplementationFile((String)newValue);
				return;
			case MultivarPackage.LANGUAGE_PRODUCT_LINE__PRODUCT_LINE_VARIABILITY:
				setProductLineVariability((ProductLineVariability)newValue);
				return;
			case MultivarPackage.LANGUAGE_PRODUCT_LINE__LANGUAGE_VARIABILITY:
				setLanguageVariability((LanguageVariability)newValue);
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
			case MultivarPackage.LANGUAGE_PRODUCT_LINE__IMPLEMENTATION_FILE:
				setImplementationFile(IMPLEMENTATION_FILE_EDEFAULT);
				return;
			case MultivarPackage.LANGUAGE_PRODUCT_LINE__PRODUCT_LINE_VARIABILITY:
				setProductLineVariability((ProductLineVariability)null);
				return;
			case MultivarPackage.LANGUAGE_PRODUCT_LINE__LANGUAGE_VARIABILITY:
				setLanguageVariability((LanguageVariability)null);
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
			case MultivarPackage.LANGUAGE_PRODUCT_LINE__IMPLEMENTATION_FILE:
				return IMPLEMENTATION_FILE_EDEFAULT == null ? implementationFile != null : !IMPLEMENTATION_FILE_EDEFAULT.equals(implementationFile);
			case MultivarPackage.LANGUAGE_PRODUCT_LINE__PRODUCT_LINE_VARIABILITY:
				return productLineVariability != null;
			case MultivarPackage.LANGUAGE_PRODUCT_LINE__LANGUAGE_VARIABILITY:
				return languageVariability != null;
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
		result.append(" (implementationFile: ");
		result.append(implementationFile);
		result.append(')');
		return result.toString();
	}

} //LanguageProductLineImpl
