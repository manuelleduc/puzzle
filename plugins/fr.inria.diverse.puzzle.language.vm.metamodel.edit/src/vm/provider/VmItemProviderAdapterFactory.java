/**
 */
package vm.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import vm.util.VmAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VmItemProviderAdapterFactory extends VmAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VmItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link vm.LanguageProductLine} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguageProductLineItemProvider languageProductLineItemProvider;

	/**
	 * This creates an adapter for a {@link vm.LanguageProductLine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLanguageProductLineAdapter() {
		if (languageProductLineItemProvider == null) {
			languageProductLineItemProvider = new LanguageProductLineItemProvider(this);
		}

		return languageProductLineItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vm.LanguageFeatureModel} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguageFeatureModelItemProvider languageFeatureModelItemProvider;

	/**
	 * This creates an adapter for a {@link vm.LanguageFeatureModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLanguageFeatureModelAdapter() {
		if (languageFeatureModelItemProvider == null) {
			languageFeatureModelItemProvider = new LanguageFeatureModelItemProvider(this);
		}

		return languageFeatureModelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vm.LanguageFeature} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguageFeatureItemProvider languageFeatureItemProvider;

	/**
	 * This creates an adapter for a {@link vm.LanguageFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLanguageFeatureAdapter() {
		if (languageFeatureItemProvider == null) {
			languageFeatureItemProvider = new LanguageFeatureItemProvider(this);
		}

		return languageFeatureItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vm.LanguageFeatureGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguageFeatureGroupItemProvider languageFeatureGroupItemProvider;

	/**
	 * This creates an adapter for a {@link vm.LanguageFeatureGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLanguageFeatureGroupAdapter() {
		if (languageFeatureGroupItemProvider == null) {
			languageFeatureGroupItemProvider = new LanguageFeatureGroupItemProvider(this);
		}

		return languageFeatureGroupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vm.LanguageFeatureGroupCardinality} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguageFeatureGroupCardinalityItemProvider languageFeatureGroupCardinalityItemProvider;

	/**
	 * This creates an adapter for a {@link vm.LanguageFeatureGroupCardinality}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLanguageFeatureGroupCardinalityAdapter() {
		if (languageFeatureGroupCardinalityItemProvider == null) {
			languageFeatureGroupCardinalityItemProvider = new LanguageFeatureGroupCardinalityItemProvider(this);
		}

		return languageFeatureGroupCardinalityItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vm.LanguageConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguageConstraintItemProvider languageConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link vm.LanguageConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLanguageConstraintAdapter() {
		if (languageConstraintItemProvider == null) {
			languageConstraintItemProvider = new LanguageConstraintItemProvider(this);
		}

		return languageConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vm.LanguageFeatureRef} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguageFeatureRefItemProvider languageFeatureRefItemProvider;

	/**
	 * This creates an adapter for a {@link vm.LanguageFeatureRef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLanguageFeatureRefAdapter() {
		if (languageFeatureRefItemProvider == null) {
			languageFeatureRefItemProvider = new LanguageFeatureRefItemProvider(this);
		}

		return languageFeatureRefItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vm.UnaryExpression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnaryExpressionItemProvider unaryExpressionItemProvider;

	/**
	 * This creates an adapter for a {@link vm.UnaryExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUnaryExpressionAdapter() {
		if (unaryExpressionItemProvider == null) {
			unaryExpressionItemProvider = new UnaryExpressionItemProvider(this);
		}

		return unaryExpressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vm.BinaryExpression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryExpressionItemProvider binaryExpressionItemProvider;

	/**
	 * This creates an adapter for a {@link vm.BinaryExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBinaryExpressionAdapter() {
		if (binaryExpressionItemProvider == null) {
			binaryExpressionItemProvider = new BinaryExpressionItemProvider(this);
		}

		return binaryExpressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vm.OrthogonalVariabilityModel} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrthogonalVariabilityModelItemProvider orthogonalVariabilityModelItemProvider;

	/**
	 * This creates an adapter for a {@link vm.OrthogonalVariabilityModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOrthogonalVariabilityModelAdapter() {
		if (orthogonalVariabilityModelItemProvider == null) {
			orthogonalVariabilityModelItemProvider = new OrthogonalVariabilityModelItemProvider(this);
		}

		return orthogonalVariabilityModelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vm.SemanticVariationPoint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticVariationPointItemProvider semanticVariationPointItemProvider;

	/**
	 * This creates an adapter for a {@link vm.SemanticVariationPoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSemanticVariationPointAdapter() {
		if (semanticVariationPointItemProvider == null) {
			semanticVariationPointItemProvider = new SemanticVariationPointItemProvider(this);
		}

		return semanticVariationPointItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vm.SemanticInterpretation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticInterpretationItemProvider semanticInterpretationItemProvider;

	/**
	 * This creates an adapter for a {@link vm.SemanticInterpretation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSemanticInterpretationAdapter() {
		if (semanticInterpretationItemProvider == null) {
			semanticInterpretationItemProvider = new SemanticInterpretationItemProvider(this);
		}

		return semanticInterpretationItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (languageProductLineItemProvider != null) languageProductLineItemProvider.dispose();
		if (languageFeatureModelItemProvider != null) languageFeatureModelItemProvider.dispose();
		if (languageFeatureItemProvider != null) languageFeatureItemProvider.dispose();
		if (languageFeatureGroupItemProvider != null) languageFeatureGroupItemProvider.dispose();
		if (languageFeatureGroupCardinalityItemProvider != null) languageFeatureGroupCardinalityItemProvider.dispose();
		if (languageConstraintItemProvider != null) languageConstraintItemProvider.dispose();
		if (languageFeatureRefItemProvider != null) languageFeatureRefItemProvider.dispose();
		if (unaryExpressionItemProvider != null) unaryExpressionItemProvider.dispose();
		if (binaryExpressionItemProvider != null) binaryExpressionItemProvider.dispose();
		if (orthogonalVariabilityModelItemProvider != null) orthogonalVariabilityModelItemProvider.dispose();
		if (semanticVariationPointItemProvider != null) semanticVariationPointItemProvider.dispose();
		if (semanticInterpretationItemProvider != null) semanticInterpretationItemProvider.dispose();
	}

}
