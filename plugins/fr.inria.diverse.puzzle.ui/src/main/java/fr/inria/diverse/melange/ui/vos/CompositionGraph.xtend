package fr.inria.diverse.melange.ui.vos

import java.util.List
import java.util.ArrayList
import fr.inria.diverse.melange.metamodel.melange.Language
import fr.inria.diverse.puzzle.adl.language.puzzle.Binding
import fr.inria.diverse.melange.metamodel.melange.ModelTypingSpace

class CompositionGraph {
	
	public List<CompositionNode> nodes
	public List<CompositionArc> arcs
	
	new(ArrayList<Language> bindedLanguages, List<Binding> statements, ModelTypingSpace modelTypingSpace){
		
		this.nodes = new ArrayList<CompositionNode>()
		this.arcs = new ArrayList<CompositionArc>()
		
		for(Language language : bindedLanguages){
			var CompositionNode newNode = new CompositionNode()
			newNode.language = language
			
			if(!this.nodes.contains(newNode))
				this.nodes.add(newNode)
		}
		
		for(Binding binding : statements){
			var CompositionArc newArc = new CompositionArc()
			
			val Language leftLanguage = modelTypingSpace.elements.findFirst[ element |
				element instanceof Language && (element as Language).requires.exists[ req | req.name.equals(binding.left)]] as Language
			
			val Language rightLanguage = modelTypingSpace.elements.findFirst[ element |
				element instanceof Language && leftLanguage != element && (element as Language).implements.exists[ impl | 
					impl.name.equals(binding.right)
				]] as Language
			
			newArc.from = this.nodes.findFirst[node | node.language == leftLanguage]
			newArc.to = this.nodes.findFirst[node | node.language == rightLanguage]
			this.arcs.add(newArc)
		}
	}
}