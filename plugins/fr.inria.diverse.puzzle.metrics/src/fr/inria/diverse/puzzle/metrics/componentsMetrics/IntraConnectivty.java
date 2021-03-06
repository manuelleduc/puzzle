package fr.inria.diverse.puzzle.metrics.componentsMetrics;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import fr.inria.diverse.k3.sle.common.commands.ConceptComparison;
import fr.inria.diverse.k3.sle.common.commands.MethodComparison;
import fr.inria.diverse.k3.sle.common.graphs.DependencyGraph;
import fr.inria.diverse.k3.sle.common.graphs.EcoreArc;
import fr.inria.diverse.k3.sle.common.graphs.EcoreGraph;
import fr.inria.diverse.k3.sle.common.graphs.EcoreGroup;
import fr.inria.diverse.k3.sle.common.graphs.EcoreVertex;
import fr.inria.diverse.melange.metamodel.melange.Language;

public class IntraConnectivty implements LanguageProductLineChartMetric {

	/**
	 * Computes the intra connectivity metric for each of the groups
	 * in the given modularization graph.
	 * 
	 * @param modularizationGraph
	 * @return
	 */
	public Hashtable<String, Double> compute(EcoreGraph modularizationGraph){
		Hashtable<String, Double> data = new Hashtable<String, Double>();
		for (EcoreGroup group : modularizationGraph.getGroups()) {
			data.put(group.getName(), this.computeIntraConnectivity(group));
		}
		return data;
	}

	public double computeAverage(Hashtable<String, Double> data) {
		double count = 0;
		Iterator<String> it = data.keySet().iterator();
		while (it.hasNext()) {
			it.next();
			count++;
		}
		return this.computeSum(data)/count;
	}
	
	public double computeSum(Hashtable<String, Double> data) {
		double sum = 0;
		Iterator<String> it = data.keySet().iterator();
		while (it.hasNext()) {
			String groupName = (String) it.next();
			double metricValue = data.get(groupName).doubleValue();
			sum += metricValue;
		}
		return sum;
	}
	
	/**
	 * Computes the intra-connectivity metric for the given ecore group.
	 * @param group
	 * @return
	 */
	private Double computeIntraConnectivity(EcoreGroup group) {
		double intraEdgeDependencies = this.computeIntraEdgeDependencies(group);
		
		if(group.getVertex().size() == 0)
			return new Double(-1);
		
		double d = group.getVertex().size() * group.getVertex().size();
		double intraConnectivity = (double)intraEdgeDependencies / (double)d;
		return new Double(intraConnectivity);
	}

	/**
	 * Computes the amount of intra edge dependencies in the given group. 
	 * @param group
	 * @return
	 */
	private int computeIntraEdgeDependencies(EcoreGroup group) {
		int intraEdgeDependencies = 0;
		for (EcoreVertex vertex : group.getVertex()) {
			for (EcoreArc arc : vertex.getOutgoingArcs()) {
				if(group.getVertex().contains(arc.getTo())){
					intraEdgeDependencies ++;
				}
			}
		}
		return intraEdgeDependencies;
	}

	@Override
	public String getVariablesDeclaration(ArrayList<Language> languages,
			ConceptComparison conceptComparisonOperator,
			MethodComparison methodComparisonOperator,
			EcoreGraph modularizationGraph, DependencyGraph dependencyGraph)
			throws Exception {
		
		String javaScriptData = "google.load('visualization', '1.1', {packages:['table']});\n";
		javaScriptData += "google.setOnLoadCallback(drawTable);\n\n";
		javaScriptData += "function drawTable() {\n";
		javaScriptData += "  var data = new google.visualization.DataTable();\n";
		javaScriptData += "    data.addColumn('string', 'Group Name');\n";
		javaScriptData += "    data.addColumn('number', 'Coupling');\n";
		javaScriptData += "    data.addRows([";

		Hashtable<String, Double> data = this.compute(modularizationGraph);
		Iterator<String> it = data.keySet().iterator();
		while (it.hasNext()) {
			String groupName = (String) it.next();
			double metricValue = data.get(groupName).doubleValue();
			javaScriptData += "      ['" + groupName + "', " + metricValue + "],\n";
		}
		
		javaScriptData += "      ['Average', " + this.computeAverage(data) + "],\n";
		
		javaScriptData += "  ]);\n\n";
		javaScriptData += "  var table = new google.visualization.Table(document.getElementById('table_div'));";
		javaScriptData += "  table.draw(data, {showRowNumber: false, width: '80%', height: '100%'});\n";
		javaScriptData += "}\n";
		
		return javaScriptData;
	}

	@Override
	public String getWindow(ArrayList<Language> languages) {
		// TODO Auto-generated method stub
		return null;
	}
}
