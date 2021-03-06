/**
 */
package complextriggers;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link complextriggers.NotTrigger#getTrigger <em>Trigger</em>}</li>
 * </ul>
 * </p>
 *
 * @see complextriggers.ComplextriggersPackage#getNotTrigger()
 * @model
 * @generated
 */
public interface NotTrigger extends Trigger {
	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' containment reference.
	 * @see #setTrigger(Trigger)
	 * @see complextriggers.ComplextriggersPackage#getNotTrigger_Trigger()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Trigger getTrigger();

	/**
	 * Sets the value of the '{@link complextriggers.NotTrigger#getTrigger <em>Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger</em>' containment reference.
	 * @see #getTrigger()
	 * @generated
	 */
	void setTrigger(Trigger value);

} // NotTrigger
