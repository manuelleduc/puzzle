package fr.inria.diverse.k3.sle.common.graphs;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import fr.inria.diverse.k3.sle.common.commands.ConceptComparison;
import fr.inria.diverse.k3.sle.common.tuples.TupleMembersConcepts;

public class EcoreGraph {

	// -----------------------------------------------
	// Attributes
	// -----------------------------------------------
	
	private ArrayList<EcoreVertex> vertex;
	private ArrayList<EcoreArc> arcs;
	private ArrayList<ArrayList<EcoreVertex>> groups;
	
	// -----------------------------------------------
	// Constructor
	// -----------------------------------------------
	
	/**
	 * Constructor by default. Returns an emtpy graph. 
	 */
	public EcoreGraph(){
		this.vertex = new ArrayList<EcoreVertex>();
		this.arcs = new ArrayList<EcoreArc>();
		this.groups = new ArrayList<ArrayList<EcoreVertex>>();
	}
	
	/**
	 * Constructor that builds a dependencies graph from a list of Concept-Members tuple
	 */
	public EcoreGraph(ArrayList<TupleMembersConcepts> membersConceptList, ConceptComparison conceptComparisonOperator){
		this.vertex = new ArrayList<EcoreVertex>();
		this.arcs = new ArrayList<EcoreArc>();
		this.groups = new ArrayList<ArrayList<EcoreVertex>>();
		this.computeDependenciesGraph(membersConceptList, conceptComparisonOperator);
	}
	
	// -----------------------------------------------
	// Getters and setters
	// -----------------------------------------------

	public ArrayList<EcoreVertex> getVertex() {
		return vertex;
	}

	public ArrayList<EcoreArc> getArcs() {
		return arcs;
	}
	
	public ArrayList<ArrayList<EcoreVertex>> getGroups() {
		return groups;
	}
	
	public void setGroups(ArrayList<ArrayList<EcoreVertex>> groups) {
		this.groups = groups;
	}
	
	// -----------------------------------------------
	// Methods
	// -----------------------------------------------

	/**
	 * Computes the dependencies graph from a list of tuples Concept-Members
	 * @param conceptMembersList
	 * @return
	 */
	public void computeDependenciesGraph(ArrayList<TupleMembersConcepts> membersConceptList, ConceptComparison conceptComparisonOperator){
		for (TupleMembersConcepts conceptMembersTuple : membersConceptList) {
			for (EClassifier currentClassifier : conceptMembersTuple.getConcepts()) {
				EcoreVertex node = new EcoreVertex(currentClassifier.getName() + ": " + conceptMembersTuple.getMembersString(), currentClassifier);
				this.getVertex().add(node);
			}
			
		}
		
		// Adding one arc for each reference
		for (EcoreVertex node : this.getVertex()) {
			EClassifier currentClassifier = node.getClassifier();
			
			if(currentClassifier instanceof EClass){
				EClass currentEClass = (EClass) currentClassifier;
				for (EStructuralFeature structuralFeature : currentEClass.getEStructuralFeatures()) {
					if(structuralFeature instanceof EReference){
						EReference currentEReference = (EReference) structuralFeature;
						EcoreVertex toNode = getNodeByConceptComparisonOperator(this, currentEReference.getEType(), conceptComparisonOperator);
						if(toNode != null){
							EcoreArc arc = new EcoreArc(node, toNode);
							this.getArcs().add(arc);
						}
					}
					
					if(structuralFeature instanceof EAttribute){
						EAttribute currentEAttribute = (EAttribute) structuralFeature;
						if(currentEAttribute.getEType() instanceof EEnum){
							EcoreVertex toNode = getNodeByConceptComparisonOperator(this, currentEAttribute.getEType(), conceptComparisonOperator);
							if(toNode != null){
								EcoreArc arc = new EcoreArc(node, toNode);
								this.getArcs().add(arc);
							}
						}
					}
				}
			}
		}
		
		// Adding one arc for each inheritance
		for (EcoreVertex node : this.getVertex()) {
			EClassifier currentClassifier = node.getClassifier();
			
			if(currentClassifier instanceof EClass){
				EClass currentEClass = (EClass) currentClassifier;
				for (EClass superClass : currentEClass.getESuperTypes()) {
					EcoreVertex toNode = getNodeByConceptComparisonOperator(this, superClass, conceptComparisonOperator);
					if(toNode != null){
						EcoreArc arc = new EcoreArc(node, toNode);
						this.getArcs().add(arc);
					}
				}
			}
		}
	}
	
	public EcoreVertex getNodeByConceptComparisonOperator(EcoreGraph graph,
			EClassifier eType, ConceptComparison conceptComparisonOperator) {
		for (EcoreVertex node : graph.getVertex()) {
			if(conceptComparisonOperator.equals(node.getClassifier(),eType))
				return node;
		} return null;
	}

	/**
	 * Returns a node by its name in the graph in the paramter
	 * @param graph
	 * @param nodeName
	 * @return
	 */
	public EcoreVertex getNodeByName(EcoreGraph graph, String nodeName){
		for (EcoreVertex node : graph.getVertex()) {
			if(node.getClassifier().getName().equals(nodeName))
				return node;
		} return null;
	}
	
	/**
	 * Returns a node by its name in the graph in the paramter
	 * @param graph
	 * @param nodeName
	 * @return
	 */
	public EcoreVertex getNodeByEClassifier(EcoreGraph graph, EClassifier eClassifier){
		for (EcoreVertex node : graph.getVertex()) {
			if(node.getClassifier().equals(eClassifier))
				return node;
		} return null;
	}
	
	/**
	 * Returns a node by its string representation in the graph in the paramter
	 * @param graph
	 * @param nodeName
	 * @return
	 */
	public EcoreVertex getNodeById(EcoreGraph graph, String id){
		for (EcoreVertex currentVertex : graph.getVertex()) {
			if(currentVertex.getVertexId().equals(id))
				return currentVertex;
		} return null;
	}
}