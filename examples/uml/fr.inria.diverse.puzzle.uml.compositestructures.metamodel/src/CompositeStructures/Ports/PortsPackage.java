/**
 */
package CompositeStructures.Ports;

import CompositeStructures.InternalStructures.InternalStructuresPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see CompositeStructures.Ports.PortsFactory
 * @model kind="package"
 * @generated
 */
public interface PortsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Ports";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://fr.inria.diverse.puzzle.uml/CompositeStructures/Ports";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Ports";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PortsPackage eINSTANCE = CompositeStructures.Ports.impl.PortsPackageImpl.init();

	/**
	 * The meta object id for the '{@link CompositeStructures.Ports.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CompositeStructures.Ports.impl.PortImpl
	 * @see CompositeStructures.Ports.impl.PortsPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__END = InternalStructuresPackage.PROPERTY__END;

	/**
	 * The feature id for the '<em><b>Is Behavior</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__IS_BEHAVIOR = InternalStructuresPackage.PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Service</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__IS_SERVICE = InternalStructuresPackage.PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Conjugated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__IS_CONJUGATED = InternalStructuresPackage.PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Required</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__REQUIRED = InternalStructuresPackage.PROPERTY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Provided</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PROVIDED = InternalStructuresPackage.PROPERTY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Redefined Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__REDEFINED_PORT = InternalStructuresPackage.PROPERTY_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = InternalStructuresPackage.PROPERTY_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_OPERATION_COUNT = InternalStructuresPackage.PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CompositeStructures.Ports.impl.InterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CompositeStructures.Ports.impl.InterfaceImpl
	 * @see CompositeStructures.Ports.impl.PortsPackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 1;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link CompositeStructures.Ports.impl.EncapsulatedClassifierImpl <em>Encapsulated Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CompositeStructures.Ports.impl.EncapsulatedClassifierImpl
	 * @see CompositeStructures.Ports.impl.PortsPackageImpl#getEncapsulatedClassifier()
	 * @generated
	 */
	int ENCAPSULATED_CLASSIFIER = 2;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCAPSULATED_CLASSIFIER__FEATURE = InternalStructuresPackage.STRUCTURED_CLASSIFIER__FEATURE;

	/**
	 * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCAPSULATED_CLASSIFIER__COLLABORATION_USE = InternalStructuresPackage.STRUCTURED_CLASSIFIER__COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCAPSULATED_CLASSIFIER__REPRESENTATION = InternalStructuresPackage.STRUCTURED_CLASSIFIER__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Owned Connector</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCAPSULATED_CLASSIFIER__OWNED_CONNECTOR = InternalStructuresPackage.STRUCTURED_CLASSIFIER__OWNED_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCAPSULATED_CLASSIFIER__ROLE = InternalStructuresPackage.STRUCTURED_CLASSIFIER__ROLE;

	/**
	 * The feature id for the '<em><b>Structured Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCAPSULATED_CLASSIFIER__STRUCTURED_OWNED_ATTRIBUTE = InternalStructuresPackage.STRUCTURED_CLASSIFIER__STRUCTURED_OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCAPSULATED_CLASSIFIER__PART = InternalStructuresPackage.STRUCTURED_CLASSIFIER__PART;

	/**
	 * The feature id for the '<em><b>Owned Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCAPSULATED_CLASSIFIER__OWNED_PORT = InternalStructuresPackage.STRUCTURED_CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Encapsulated Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCAPSULATED_CLASSIFIER_FEATURE_COUNT = InternalStructuresPackage.STRUCTURED_CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Encapsulated Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCAPSULATED_CLASSIFIER_OPERATION_COUNT = InternalStructuresPackage.STRUCTURED_CLASSIFIER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link CompositeStructures.Ports.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see CompositeStructures.Ports.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the attribute '{@link CompositeStructures.Ports.Port#isIsBehavior <em>Is Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Behavior</em>'.
	 * @see CompositeStructures.Ports.Port#isIsBehavior()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_IsBehavior();

	/**
	 * Returns the meta object for the attribute '{@link CompositeStructures.Ports.Port#isIsService <em>Is Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Service</em>'.
	 * @see CompositeStructures.Ports.Port#isIsService()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_IsService();

	/**
	 * Returns the meta object for the attribute '{@link CompositeStructures.Ports.Port#isIsConjugated <em>Is Conjugated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Conjugated</em>'.
	 * @see CompositeStructures.Ports.Port#isIsConjugated()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_IsConjugated();

	/**
	 * Returns the meta object for the reference list '{@link CompositeStructures.Ports.Port#getRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required</em>'.
	 * @see CompositeStructures.Ports.Port#getRequired()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Required();

	/**
	 * Returns the meta object for the reference list '{@link CompositeStructures.Ports.Port#getProvided <em>Provided</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Provided</em>'.
	 * @see CompositeStructures.Ports.Port#getProvided()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Provided();

	/**
	 * Returns the meta object for the reference list '{@link CompositeStructures.Ports.Port#getRedefinedPort <em>Redefined Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Redefined Port</em>'.
	 * @see CompositeStructures.Ports.Port#getRedefinedPort()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_RedefinedPort();

	/**
	 * Returns the meta object for class '{@link CompositeStructures.Ports.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see CompositeStructures.Ports.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for class '{@link CompositeStructures.Ports.EncapsulatedClassifier <em>Encapsulated Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Encapsulated Classifier</em>'.
	 * @see CompositeStructures.Ports.EncapsulatedClassifier
	 * @generated
	 */
	EClass getEncapsulatedClassifier();

	/**
	 * Returns the meta object for the containment reference list '{@link CompositeStructures.Ports.EncapsulatedClassifier#getOwnedPort <em>Owned Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Port</em>'.
	 * @see CompositeStructures.Ports.EncapsulatedClassifier#getOwnedPort()
	 * @see #getEncapsulatedClassifier()
	 * @generated
	 */
	EReference getEncapsulatedClassifier_OwnedPort();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PortsFactory getPortsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link CompositeStructures.Ports.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CompositeStructures.Ports.impl.PortImpl
		 * @see CompositeStructures.Ports.impl.PortsPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Is Behavior</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__IS_BEHAVIOR = eINSTANCE.getPort_IsBehavior();

		/**
		 * The meta object literal for the '<em><b>Is Service</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__IS_SERVICE = eINSTANCE.getPort_IsService();

		/**
		 * The meta object literal for the '<em><b>Is Conjugated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__IS_CONJUGATED = eINSTANCE.getPort_IsConjugated();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__REQUIRED = eINSTANCE.getPort_Required();

		/**
		 * The meta object literal for the '<em><b>Provided</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__PROVIDED = eINSTANCE.getPort_Provided();

		/**
		 * The meta object literal for the '<em><b>Redefined Port</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__REDEFINED_PORT = eINSTANCE.getPort_RedefinedPort();

		/**
		 * The meta object literal for the '{@link CompositeStructures.Ports.impl.InterfaceImpl <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CompositeStructures.Ports.impl.InterfaceImpl
		 * @see CompositeStructures.Ports.impl.PortsPackageImpl#getInterface()
		 * @generated
		 */
		EClass INTERFACE = eINSTANCE.getInterface();

		/**
		 * The meta object literal for the '{@link CompositeStructures.Ports.impl.EncapsulatedClassifierImpl <em>Encapsulated Classifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CompositeStructures.Ports.impl.EncapsulatedClassifierImpl
		 * @see CompositeStructures.Ports.impl.PortsPackageImpl#getEncapsulatedClassifier()
		 * @generated
		 */
		EClass ENCAPSULATED_CLASSIFIER = eINSTANCE.getEncapsulatedClassifier();

		/**
		 * The meta object literal for the '<em><b>Owned Port</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENCAPSULATED_CLASSIFIER__OWNED_PORT = eINSTANCE.getEncapsulatedClassifier_OwnedPort();

	}

} //PortsPackage
