package fr.inria.diverse.puzzle.instancesgenerator.impl;

import java.util.Random;

import fr.inria.diverse.k3.sle.common.graphs.DependencyArc;
import fr.inria.diverse.k3.sle.common.graphs.DependencyGraph;
import fr.inria.diverse.k3.sle.common.graphs.DependencyVertex;

/**
 * Random generator of acyclic directed graph.
 * The algorithm is the one proposed by Malecon et al. 
 * 
 * @author David Mendez-Acuna
 *
 */
public class GraphGenerator {

	// -------------------------------------------------------
	// Methods
	// -------------------------------------------------------
	
	/**
	 * Generates a random acyclic directed graph by using the given seed. 
	 * @param size. Number of vertex of the desired graph.
	 * @param seed. Seed for generation of the random positions of the graph. 
	 * @return
	 */
	public static DependencyGraph generateGraph(int size, long seed){
		Random generator = new Random(seed);
		
		// Creating an empty graph (without arcs)
		DependencyGraph graph = new DependencyGraph();
		for (int i = 1; i <= size; i++) {
			DependencyVertex vertex = new DependencyVertex("F" + Integer.toString(i));
			graph.getVertex().add(vertex);
		}
		
		// Creating the arcs between vertex using a Markov chain. 
		int iterations = size * 2;
		while(iterations > 0){
			int i = 0 + (int)(generator.nextDouble() * (size - 1));
			int j = 0 + (int)(generator.nextDouble() * (size - 1));
			
			DependencyVertex vertexI = graph.getVertex().get(i);
			DependencyVertex vertexJ = graph.getVertex().get(j);
			
			
			if(graph.thereIsArc(vertexI, vertexJ)){
				// (a) If the position (i,j) corresponds to an arc e in Xt, then Xt+1 = Xt\e
				DependencyArc oldArc = graph.getArc(vertexI, vertexJ);
				oldArc.getFrom().getOutgoingArcs().remove(oldArc);
				oldArc.getTo().getIncomingArcs().remove(oldArc);
				graph.getArcs().remove(oldArc);
			}else{
				// (b) If the position (i,j) does not correspond to an arc in Xt, then Xt+1 is obtained from Xt
				//     by adding this arc while avoiding loops. 
				DependencyArc arc = new DependencyArc(vertexI, vertexJ);
				graph.getArcs().add(arc);
				
				if(graph.thereIsLoop()){
					arc.getFrom().getOutgoingArcs().remove(arc);
					arc.getTo().getIncomingArcs().remove(arc);
					graph.getArcs().remove(arc);
				}
			}
			iterations--;
		}
		return graph;
	}
}
