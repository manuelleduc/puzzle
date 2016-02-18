package fr.inria.diverse.melange.ui.vos

import fr.inria.diverse.puzzle.adl.language.puzzle.Binding

class CompositionTreeNode extends AbstractCompositionTreeNode {
	
	// -------------------------------------------------
	// Attributes
	// -------------------------------------------------
	
	public AbstractCompositionTreeNode _requiring
	public AbstractCompositionTreeNode _providing
	public Binding _binding
	
	// -------------------------------------------------
	// Constructor
	// -------------------------------------------------
	
	new(CompositionGraph graph) {
		super(graph)
	}
}