/**
 */
package Multivar;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language Product Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Multivar.LanguageProductLine#getImplementationFile <em>Implementation File</em>}</li>
 *   <li>{@link Multivar.LanguageProductLine#getProductLineVariability <em>Product Line Variability</em>}</li>
 *   <li>{@link Multivar.LanguageProductLine#getLanguageVariability <em>Language Variability</em>}</li>
 * </ul>
 * </p>
 *
 * @see Multivar.MultivarPackage#getLanguageProductLine()
 * @model
 * @generated
 */
public interface LanguageProductLine extends EObject {
	/**
	 * Returns the value of the '<em><b>Implementation File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation File</em>' attribute.
	 * @see #setImplementationFile(String)
	 * @see Multivar.MultivarPackage#getLanguageProductLine_ImplementationFile()
	 * @model
	 * @generated
	 */
	String getImplementationFile();

	/**
	 * Sets the value of the '{@link Multivar.LanguageProductLine#getImplementationFile <em>Implementation File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation File</em>' attribute.
	 * @see #getImplementationFile()
	 * @generated
	 */
	void setImplementationFile(String value);

	/**
	 * Returns the value of the '<em><b>Product Line Variability</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product Line Variability</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Line Variability</em>' containment reference.
	 * @see #setProductLineVariability(ProductLineVariability)
	 * @see Multivar.MultivarPackage#getLanguageProductLine_ProductLineVariability()
	 * @model containment="true"
	 * @generated
	 */
	ProductLineVariability getProductLineVariability();

	/**
	 * Sets the value of the '{@link Multivar.LanguageProductLine#getProductLineVariability <em>Product Line Variability</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Line Variability</em>' containment reference.
	 * @see #getProductLineVariability()
	 * @generated
	 */
	void setProductLineVariability(ProductLineVariability value);

	/**
	 * Returns the value of the '<em><b>Language Variability</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language Variability</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language Variability</em>' containment reference.
	 * @see #setLanguageVariability(LanguageVariability)
	 * @see Multivar.MultivarPackage#getLanguageProductLine_LanguageVariability()
	 * @model containment="true"
	 * @generated
	 */
	LanguageVariability getLanguageVariability();

	/**
	 * Sets the value of the '{@link Multivar.LanguageProductLine#getLanguageVariability <em>Language Variability</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language Variability</em>' containment reference.
	 * @see #getLanguageVariability()
	 * @generated
	 */
	void setLanguageVariability(LanguageVariability value);

} // LanguageProductLine
