/**
 */
package actionscripting;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see actionscripting.ActionscriptingPackage
 * @generated
 */
public interface ActionscriptingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActionscriptingFactory eINSTANCE = actionscripting.impl.ActionscriptingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block</em>'.
	 * @generated
	 */
	Block createBlock();

	/**
	 * Returns a new object of class '<em>Conditional</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional</em>'.
	 * @generated
	 */
	Conditional createConditional();

	/**
	 * Returns a new object of class '<em>Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop</em>'.
	 * @generated
	 */
	Loop createLoop();

	/**
	 * Returns a new object of class '<em>Var Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Var Decl</em>'.
	 * @generated
	 */
	VarDecl createVarDecl();

	/**
	 * Returns a new object of class '<em>Assignation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignation</em>'.
	 * @generated
	 */
	Assignation createAssignation();

	/**
	 * Returns a new object of class '<em>Var Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Var Ref</em>'.
	 * @generated
	 */
	VarRef createVarRef();

	/**
	 * Returns a new object of class '<em>Console Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Console Output</em>'.
	 * @generated
	 */
	ConsoleOutput createConsoleOutput();

	/**
	 * Returns a new object of class '<em>Println</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Println</em>'.
	 * @generated
	 */
	Println createPrintln();

	/**
	 * Returns a new object of class '<em>Print</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Print</em>'.
	 * @generated
	 */
	Print createPrint();

	/**
	 * Returns a new object of class '<em>Wait</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait</em>'.
	 * @generated
	 */
	Wait createWait();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ActionscriptingPackage getActionscriptingPackage();

} //ActionscriptingFactory
