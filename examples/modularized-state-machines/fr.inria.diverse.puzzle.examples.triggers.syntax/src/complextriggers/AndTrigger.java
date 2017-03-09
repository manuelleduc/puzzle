/**
 */
package complextriggers;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>And Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link complextriggers.AndTrigger#getLeft <em>Left</em>}</li>
 *   <li>{@link complextriggers.AndTrigger#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see complextriggers.ComplextriggersPackage#getAndTrigger()
 * @model
 * @generated
 */
public interface AndTrigger extends Trigger {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Trigger)
	 * @see complextriggers.ComplextriggersPackage#getAndTrigger_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Trigger getLeft();

	/**
	 * Sets the value of the '{@link complextriggers.AndTrigger#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Trigger value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Trigger)
	 * @see complextriggers.ComplextriggersPackage#getAndTrigger_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Trigger getRight();

	/**
	 * Sets the value of the '{@link complextriggers.AndTrigger#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Trigger value);

} // AndTrigger