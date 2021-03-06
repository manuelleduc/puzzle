/**
 */
package BinaryExpressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link BinaryExpressions.BinaryExpr#getLeftExpr <em>Left Expr</em>}</li>
 *   <li>{@link BinaryExpressions.BinaryExpr#getRightExpr <em>Right Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see BinaryExpressions.BinaryExpressionsPackage#getBinaryExpr()
 * @model abstract="true"
 * @generated
 */
public interface BinaryExpr extends Expression {
	/**
	 * Returns the value of the '<em><b>Left Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Expr</em>' containment reference.
	 * @see #setLeftExpr(Expression)
	 * @see BinaryExpressions.BinaryExpressionsPackage#getBinaryExpr_LeftExpr()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getLeftExpr();

	/**
	 * Sets the value of the '{@link BinaryExpressions.BinaryExpr#getLeftExpr <em>Left Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Expr</em>' containment reference.
	 * @see #getLeftExpr()
	 * @generated
	 */
	void setLeftExpr(Expression value);

	/**
	 * Returns the value of the '<em><b>Right Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Expr</em>' containment reference.
	 * @see #setRightExpr(Expression)
	 * @see BinaryExpressions.BinaryExpressionsPackage#getBinaryExpr_RightExpr()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getRightExpr();

	/**
	 * Sets the value of the '{@link BinaryExpressions.BinaryExpr#getRightExpr <em>Right Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Expr</em>' containment reference.
	 * @see #getRightExpr()
	 * @generated
	 */
	void setRightExpr(Expression value);

} // BinaryExpr
