/**
 */
package Variables;

import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see Variables.VariablesPackage#getExpression()
 * @model abstract="true"
 * @generated
 */
public interface Expression extends Instruction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Object eval(Map<?, ?> context);

} // Expression