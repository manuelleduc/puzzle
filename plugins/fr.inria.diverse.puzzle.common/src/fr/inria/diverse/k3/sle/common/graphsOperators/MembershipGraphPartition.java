package fr.inria.diverse.k3.sle.common.graphsOperators;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClassifier;

import fr.inria.diverse.k3.sle.common.commands.ConceptComparison;
import fr.inria.diverse.k3.sle.common.commands.GraphPartition;
import fr.inria.diverse.k3.sle.common.graphs.EcoreGraph;
import fr.inria.diverse.k3.sle.common.graphs.EcoreVertex;
import fr.inria.diverse.k3.sle.common.tuples.TupleMembersConcepts;

public class MembershipGraphPartition implements GraphPartition {

	@Override
	public void graphPartition(EcoreGraph graph, ArrayList<TupleMembersConcepts> membersConceptList, ConceptComparison conceptComparisonOperator) {
		graph.setGroups(new ArrayList<ArrayList<EcoreVertex>>());
		for (TupleMembersConcepts membersGroupVsConceptVO : membersConceptList) {
			ArrayList<EcoreVertex> currentGroup = new ArrayList<EcoreVertex>();
			for (EClassifier currentConcept : membersGroupVsConceptVO.getConcepts()) {
				currentGroup.add(graph.getNodeByConceptComparisonOperator(graph, currentConcept, conceptComparisonOperator));
			}
			graph.getGroups().add(currentGroup);
		}
	}

}