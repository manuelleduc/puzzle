/**
 */
package AndTriggerModuleReq.impl;

import AndTriggerModuleReq.AndTriggerModuleReqFactory;
import AndTriggerModuleReq.AndTriggerModuleReqPackage;
import AndTriggerModuleReq.Pseudostate;
import AndTriggerModuleReq.Trigger;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AndTriggerModuleReqPackageImpl extends EPackageImpl implements AndTriggerModuleReqPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass triggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pseudostateEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see AndTriggerModuleReq.AndTriggerModuleReqPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AndTriggerModuleReqPackageImpl() {
		super(eNS_URI, AndTriggerModuleReqFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link AndTriggerModuleReqPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AndTriggerModuleReqPackage init() {
		if (isInited) return (AndTriggerModuleReqPackage)EPackage.Registry.INSTANCE.getEPackage(AndTriggerModuleReqPackage.eNS_URI);

		// Obtain or create and register package
		AndTriggerModuleReqPackageImpl theAndTriggerModuleReqPackage = (AndTriggerModuleReqPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AndTriggerModuleReqPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AndTriggerModuleReqPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theAndTriggerModuleReqPackage.createPackageContents();

		// Initialize created meta-data
		theAndTriggerModuleReqPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAndTriggerModuleReqPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AndTriggerModuleReqPackage.eNS_URI, theAndTriggerModuleReqPackage);
		return theAndTriggerModuleReqPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrigger() {
		return triggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrigger_Expression() {
		return (EAttribute)triggerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTrigger__EvalTrigger__Object() {
		return triggerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPseudostate() {
		return pseudostateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndTriggerModuleReqFactory getAndTriggerModuleReqFactory() {
		return (AndTriggerModuleReqFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		triggerEClass = createEClass(TRIGGER);
		createEAttribute(triggerEClass, TRIGGER__EXPRESSION);
		createEOperation(triggerEClass, TRIGGER___EVAL_TRIGGER__OBJECT);

		pseudostateEClass = createEClass(PSEUDOSTATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(triggerEClass, Trigger.class, "Trigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTrigger_Expression(), ecorePackage.getEString(), "expression", null, 0, 1, Trigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getTrigger__EvalTrigger__Object(), ecorePackage.getEBoolean(), "evalTrigger", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "events", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(pseudostateEClass, Pseudostate.class, "Pseudostate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //AndTriggerModuleReqPackageImpl