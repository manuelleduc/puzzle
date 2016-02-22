package fr.inria.diverse.k3.sle.common.graphs;

import java.util.ArrayList;
import org.eclipse.emf.ecore.EClassifier;
import fr.inria.diverse.k3.sle.common.commands.ConceptComparison;

/**
 * Class representing a set of vertexes in an ecore graph. 
 * 
 * @author David Mendez-Acuna
 *
 */
public class EcoreGroup {
	
	// -----------------------------------------------
	// Attributes
	// -----------------------------------------------
	
	private String name;
	private ArrayList<EcoreVertex> vertex;
	private ArrayList<EcoreVertex> requiredVertex;

	// -----------------------------------------------
	// Constructor
	// -----------------------------------------------
	
	public EcoreGroup(String name){
		this.name = name;
		this.vertex = new ArrayList<EcoreVertex>();
		this.requiredVertex = new ArrayList<EcoreVertex>();
	}

	// -----------------------------------------------
	// Getters and setters
	// -----------------------------------------------
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<EcoreVertex> getVertex() {
		return this.vertex;
	}
	
	public ArrayList<EcoreVertex> getRequiredVertex() {
		return this.requiredVertex;
	}

	// -----------------------------------------------
	// Methods
	// -----------------------------------------------
	
	/**
	 * Finds the vertex that matches the ecore type given in the parameter.
	 * @param eType
	 * @param conceptComparisonOperator
	 * @return
	 * 
	 * FIXME: You are not identifying correctly the vertex!
	 */
	public EcoreVertex findVertexByEcoreReference(EClassifier eType,
			ConceptComparison conceptComparisonOperator) {
		for (EcoreVertex ecoreVertex : vertex) {
			if(conceptComparisonOperator.equals(eType, ecoreVertex.getClassifier())){
				return ecoreVertex;
			}
		}
		return null;
	}
}