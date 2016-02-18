package fr.inria.diverse.melange.ui.vos

import fr.inria.diverse.melange.metamodel.melange.Language

class CompositionTreeLeaf extends AbstractCompositionTreeNode {
	
	public Language language
	
	new(CompositionGraph graph, Language language){
		super(graph)
		this.language = language
	}
}