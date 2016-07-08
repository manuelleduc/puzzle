/**
 */
package CompositeStructures;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CompositeStructures.Classifier#getFeature <em>Feature</em>}</li>
 *   <li>{@link CompositeStructures.Classifier#getCollaborationUse <em>Collaboration Use</em>}</li>
 *   <li>{@link CompositeStructures.Classifier#getRepresentation <em>Representation</em>}</li>
 * </ul>
 * </p>
 *
 * @see CompositeStructures.CompositeStructuresPackage#getClassifier()
 * @model abstract="true"
 * @generated
 */
public interface Classifier extends Namespace {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference list.
	 * The list contents are of type {@link CompositeStructures.Feature}.
	 * It is bidirectional and its opposite is '{@link CompositeStructures.Feature#getFeaturingClassifier <em>Featuring Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference list.
	 * @see CompositeStructures.CompositeStructuresPackage#getClassifier_Feature()
	 * @see CompositeStructures.Feature#getFeaturingClassifier
	 * @model opposite="featuringClassifier"
	 * @generated
	 */
	EList<Feature> getFeature();

	/**
	 * Returns the value of the '<em><b>Collaboration Use</b></em>' containment reference list.
	 * The list contents are of type {@link CompositeStructures.CollaborationUse}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collaboration Use</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collaboration Use</em>' containment reference list.
	 * @see CompositeStructures.CompositeStructuresPackage#getClassifier_CollaborationUse()
	 * @model containment="true"
	 * @generated
	 */
	EList<CollaborationUse> getCollaborationUse();

	/**
	 * Returns the value of the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Representation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representation</em>' reference.
	 * @see #setRepresentation(CollaborationUse)
	 * @see CompositeStructures.CompositeStructuresPackage#getClassifier_Representation()
	 * @model
	 * @generated
	 */
	CollaborationUse getRepresentation();

	/**
	 * Sets the value of the '{@link CompositeStructures.Classifier#getRepresentation <em>Representation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Representation</em>' reference.
	 * @see #getRepresentation()
	 * @generated
	 */
	void setRepresentation(CollaborationUse value);

} // Classifier
