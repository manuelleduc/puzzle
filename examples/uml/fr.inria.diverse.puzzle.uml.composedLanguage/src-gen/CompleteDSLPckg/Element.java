/**
 */
package CompleteDSLPckg;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CompleteDSLPckg.Element#getOwnedComment <em>Owned Comment</em>}</li>
 *   <li>{@link CompleteDSLPckg.Element#getOwnedElement <em>Owned Element</em>}</li>
 *   <li>{@link CompleteDSLPckg.Element#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see CompleteDSLPckg.CompleteDSLPckgPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends EObject {
	/**
	 * Returns the value of the '<em><b>Owned Comment</b></em>' containment reference list.
	 * The list contents are of type {@link CompleteDSLPckg.Comment}.
	 * It is bidirectional and its opposite is '{@link CompleteDSLPckg.Comment#getOwningElement <em>Owning Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Comment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Comment</em>' containment reference list.
	 * @see CompleteDSLPckg.CompleteDSLPckgPackage#getElement_OwnedComment()
	 * @see CompleteDSLPckg.Comment#getOwningElement
	 * @model opposite="owningElement" containment="true"
	 * @generated
	 */
	EList<Comment> getOwnedComment();

	/**
	 * Returns the value of the '<em><b>Owned Element</b></em>' containment reference list.
	 * The list contents are of type {@link CompleteDSLPckg.Element}.
	 * It is bidirectional and its opposite is '{@link CompleteDSLPckg.Element#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Element</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Element</em>' containment reference list.
	 * @see CompleteDSLPckg.CompleteDSLPckgPackage#getElement_OwnedElement()
	 * @see CompleteDSLPckg.Element#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Element> getOwnedElement();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link CompleteDSLPckg.Element#getOwnedElement <em>Owned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Element)
	 * @see CompleteDSLPckg.CompleteDSLPckgPackage#getElement_Owner()
	 * @see CompleteDSLPckg.Element#getOwnedElement
	 * @model opposite="ownedElement" transient="false"
	 * @generated
	 */
	Element getOwner();

	/**
	 * Sets the value of the '{@link CompleteDSLPckg.Element#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Element value);

} // Element