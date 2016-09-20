/**
 */
package CompleteDSLPckg;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CompleteDSLPckg.Package#getURI <em>URI</em>}</li>
 *   <li>{@link CompleteDSLPckg.Package#getNestedPackage <em>Nested Package</em>}</li>
 *   <li>{@link CompleteDSLPckg.Package#getNestingPackage <em>Nesting Package</em>}</li>
 *   <li>{@link CompleteDSLPckg.Package#getPackagedElement <em>Packaged Element</em>}</li>
 *   <li>{@link CompleteDSLPckg.Package#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link CompleteDSLPckg.Package#getPackageMerge <em>Package Merge</em>}</li>
 * </ul>
 * </p>
 *
 * @see CompleteDSLPckg.CompleteDSLPckgPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends Namespace, PackageableElement {
	/**
	 * Returns the value of the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>URI</em>' attribute.
	 * @see #setURI(String)
	 * @see CompleteDSLPckg.CompleteDSLPckgPackage#getPackage_URI()
	 * @model
	 * @generated
	 */
	String getURI();

	/**
	 * Sets the value of the '{@link CompleteDSLPckg.Package#getURI <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URI</em>' attribute.
	 * @see #getURI()
	 * @generated
	 */
	void setURI(String value);

	/**
	 * Returns the value of the '<em><b>Nested Package</b></em>' containment reference list.
	 * The list contents are of type {@link CompleteDSLPckg.Package}.
	 * It is bidirectional and its opposite is '{@link CompleteDSLPckg.Package#getNestingPackage <em>Nesting Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Package</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Package</em>' containment reference list.
	 * @see CompleteDSLPckg.CompleteDSLPckgPackage#getPackage_NestedPackage()
	 * @see CompleteDSLPckg.Package#getNestingPackage
	 * @model opposite="nestingPackage" containment="true"
	 * @generated
	 */
	EList<Package> getNestedPackage();

	/**
	 * Returns the value of the '<em><b>Nesting Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link CompleteDSLPckg.Package#getNestedPackage <em>Nested Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nesting Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nesting Package</em>' container reference.
	 * @see #setNestingPackage(Package)
	 * @see CompleteDSLPckg.CompleteDSLPckgPackage#getPackage_NestingPackage()
	 * @see CompleteDSLPckg.Package#getNestedPackage
	 * @model opposite="nestedPackage" transient="false"
	 * @generated
	 */
	Package getNestingPackage();

	/**
	 * Sets the value of the '{@link CompleteDSLPckg.Package#getNestingPackage <em>Nesting Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nesting Package</em>' container reference.
	 * @see #getNestingPackage()
	 * @generated
	 */
	void setNestingPackage(Package value);

	/**
	 * Returns the value of the '<em><b>Packaged Element</b></em>' containment reference list.
	 * The list contents are of type {@link CompleteDSLPckg.PackageableElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packaged Element</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packaged Element</em>' containment reference list.
	 * @see CompleteDSLPckg.CompleteDSLPckgPackage#getPackage_PackagedElement()
	 * @model containment="true"
	 * @generated
	 */
	EList<PackageableElement> getPackagedElement();

	/**
	 * Returns the value of the '<em><b>Owned Type</b></em>' containment reference list.
	 * The list contents are of type {@link CompleteDSLPckg.Type}.
	 * It is bidirectional and its opposite is '{@link CompleteDSLPckg.Type#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Type</em>' containment reference list.
	 * @see CompleteDSLPckg.CompleteDSLPckgPackage#getPackage_OwnedType()
	 * @see CompleteDSLPckg.Type#getPackage
	 * @model opposite="package" containment="true"
	 * @generated
	 */
	EList<Type> getOwnedType();

	/**
	 * Returns the value of the '<em><b>Package Merge</b></em>' containment reference list.
	 * The list contents are of type {@link CompleteDSLPckg.PackageMerge}.
	 * It is bidirectional and its opposite is '{@link CompleteDSLPckg.PackageMerge#getReceivingPackage <em>Receiving Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Merge</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Merge</em>' containment reference list.
	 * @see CompleteDSLPckg.CompleteDSLPckgPackage#getPackage_PackageMerge()
	 * @see CompleteDSLPckg.PackageMerge#getReceivingPackage
	 * @model opposite="receivingPackage" containment="true"
	 * @generated
	 */
	EList<PackageMerge> getPackageMerge();

} // Package