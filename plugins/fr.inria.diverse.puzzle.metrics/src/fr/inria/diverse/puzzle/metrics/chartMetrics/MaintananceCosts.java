package fr.inria.diverse.puzzle.metrics.chartMetrics;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;

import fr.inria.diverse.k3.sle.common.comparisonOperators.ConceptComparison;
import fr.inria.diverse.k3.sle.common.comparisonOperators.MethodComparison;
import fr.inria.diverse.melange.metamodel.melange.Language;
import fr.inria.diverse.puzzle.metrics.auxiliarMetrics.CollectConstructs;
import fr.inria.diverse.puzzle.metrics.auxiliarMetrics.CountConstructs;
import fr.inria.diverse.puzzle.metrics.auxiliarMetrics.CountConstructsOccurrences;
import fr.inria.diverse.puzzle.metrics.auxiliarMetrics.CountMethods;

/**
 * Chart metric for the family's maintenance costs versus product line maintenance costs.
 * @author David Mendez-Acuna
 */
public class MaintananceCosts implements ChartMetric {

	// ---------------------------------------------------
	// Methods
	// ---------------------------------------------------
	
	@Override
	public String getVariablesDeclaration(ArrayList<Language> languages,
			ConceptComparison conceptComparisonOperator,
			MethodComparison methodComparisonOperator) throws Exception {
		
		String labelsSyntaxMaintenance = this.getLabelsSyntaxMaintenance(languages, conceptComparisonOperator);
		String labelsSyntaxFamilyMaintenanceData = this.getLabelsFamilySyntaxMaintenanceData(languages, conceptComparisonOperator, methodComparisonOperator);
		String labelsSyntaxLanguageLineMaintenanceData = this.getLabelsLanguageLineSyntaxMaintenanceData(languages, conceptComparisonOperator, methodComparisonOperator);
		
		String javaScriptData = "var barsDataSyntaxMaintainanceCosts = {\n";
		javaScriptData += "    labels: [" + labelsSyntaxMaintenance + "],\n";
		javaScriptData += "    datasets: [\n";
		javaScriptData += "        {\n";
		javaScriptData += "            label: \"My First dataset\",\n";
		javaScriptData += "            fillColor: \"rgba(220,220,220,0.2)\",\n";
		javaScriptData += "            strokeColor: \"rgba(220,220,220,1)\",\n";
		javaScriptData += "            pointColor: \"rgba(220,220,220,1)\",\n";
		javaScriptData += "            pointStrokeColor: \"#fff\",\n";
		javaScriptData += "            pointHighlightFill: \"#fff\",\n";
		javaScriptData += "            pointHighlightStroke: \"rgba(220,220,220,1)\",\n";
		javaScriptData += "            data: [" + labelsSyntaxFamilyMaintenanceData + "]\n";
		javaScriptData += "        },\n";
		javaScriptData += "        {\n";
		javaScriptData += "            label: \"My Second dataset\",\n";
		javaScriptData += "            fillColor: \"rgba(151,187,205,0.2)\",\n";
		javaScriptData += "            strokeColor: \"rgba(151,187,205,1)\",\n";
		javaScriptData += "            pointColor: \"rgba(151,187,205,1)\",\n";
		javaScriptData += "            pointStrokeColor: \"#fff\",\n";
		javaScriptData += "            pointHighlightFill: \"#fff\",\n";
		javaScriptData += "            pointHighlightStroke: \"rgba(151,187,205,1)\",\n";
		javaScriptData += "            data: [" + labelsSyntaxLanguageLineMaintenanceData + "]\n";
		javaScriptData += "        }\n";
		javaScriptData += "    ]\n";
		javaScriptData += "};\n\n";
		
		String labelsSemanticsMaintenance = this.getLabelsSemanticsMaintenance(languages, conceptComparisonOperator, methodComparisonOperator);
		javaScriptData += "var barsDataSemanticMaintainanceCosts = {\n";
		javaScriptData += "    labels: [" + labelsSemanticsMaintenance + "],\n";
		javaScriptData += "    datasets: [\n";
		javaScriptData += "        {\n";
		javaScriptData += "            label: \"My First dataset\",\n";
		javaScriptData += "            fillColor: \"rgba(220,220,220,0.2)\",\n";
		javaScriptData += "            strokeColor: \"rgba(220,220,220,1)\",\n";
		javaScriptData += "            pointColor: \"rgba(220,220,220,1)\",\n";
		javaScriptData += "            pointStrokeColor: \"#fff\",\n";
		javaScriptData += "            pointHighlightFill: \"#fff\",\n";
		javaScriptData += "            pointHighlightStroke: \"rgba(220,220,220,1)\",\n";
		javaScriptData += "            data: [65, 59, 80, 81]\n";
		javaScriptData += "        },\n";
		javaScriptData += "        {\n";
		javaScriptData += "            label: \"My Second dataset\",\n";
		javaScriptData += "            fillColor: \"rgba(151,187,205,0.2)\",\n";
		javaScriptData += "            strokeColor: \"rgba(151,187,205,1)\",\n";
		javaScriptData += "            pointColor: \"rgba(151,187,205,1)\",\n";
		javaScriptData += "            pointStrokeColor: \"#fff\",\n";
		javaScriptData += "            pointHighlightFill: \"#fff\",\n";
		javaScriptData += "            pointHighlightStroke: \"rgba(151,187,205,1)\",\n";
		javaScriptData += "            data: [28, 48, 40, 19]\n";
		javaScriptData += "        }\n";
		javaScriptData += "    ]\n";
		javaScriptData += "};\n\n";
		return javaScriptData;
	}

	@Override
	public String getWindow(ArrayList<Language> languages) {
		String javaScriptWindow = "    var ctxLineChartSyntaxMaintaince = document.getElementById(\"chart-maintainance-costs-syntax\").getContext(\"2d\");\n";
		javaScriptWindow += "    window.myLineChartSyntaxMaintaince = new Chart(ctxLineChartSyntaxMaintaince).Line(barsDataSyntaxMaintainanceCosts,{\n";
		javaScriptWindow += "       datasetFill : false\n";
		javaScriptWindow += "    });\n\n";
		
		javaScriptWindow += "    var ctxLineChartSemanticsMaintaince = document.getElementById(\"chart-maintainance-costs-semantics\").getContext(\"2d\");\n";
		javaScriptWindow += "    window.myLineChartSemanticsMaintaince = new Chart(ctxLineChartSemanticsMaintaince).Line(barsDataSemanticMaintainanceCosts,{\n";
		javaScriptWindow += "       datasetFill : false\n";
		javaScriptWindow += "    });\n\n";
		return javaScriptWindow;
	}
	
	// ---------------------------------------------------
	// Auxiliar services
	// ---------------------------------------------------
	
	private String getLabelsSyntaxMaintenance(ArrayList<Language> languages, ConceptComparison conceptComparisonOperator) throws Exception {
		String labels = "";
		int constructsAmount = CountConstructs.countFamilyConstructs(languages, conceptComparisonOperator);
		int interval = constructsAmount/4;
		boolean first = true;
		for (int i = 1; i <= 4; i++) {
			if(!first) labels += ",";
			labels += "\"" + interval * i + "\"";
			first = false;
		}
		return labels;
	}
	
	private String getLabelsSemanticsMaintenance(ArrayList<Language> languages,
			ConceptComparison conceptComparisonOperator,
			MethodComparison methodComparisonOperator) {
		String labels = "";
		int methodsAmount = CountMethods.countFamilyMethods(languages, conceptComparisonOperator, methodComparisonOperator);
		int interval = methodsAmount/4;
		boolean first = true;
		for (int i = 1; i <= 4; i++) {
			if(!first) labels += ",";
			labels += "\"" + interval * i + "\"";
			first = false;
		}
		return labels;
	}
	
	public double getAverageCostSyntax(ArrayList<Language> languages,
			ConceptComparison conceptComparisonOperator,
			MethodComparison methodComparisonOperator) throws Exception{
		double totalCost = 0;
		List<EClassifier> constructs = CollectConstructs.collectFamilyConstructs(languages, conceptComparisonOperator);
		for (EClassifier eClassifier : constructs) {
			totalCost += CountConstructsOccurrences.intCountConstructOccurrences(languages, conceptComparisonOperator, eClassifier);
		}
		if(constructs.size() == 0)
			return 0;
		else
			return totalCost/constructs.size();
	}
	
	private String getLabelsFamilySyntaxMaintenanceData(ArrayList<Language> languages, ConceptComparison conceptComparisonOperator,
			MethodComparison methodComparisonOperator) throws Exception {
		String labels = "";
		int constructsAmount = CountConstructs.countFamilyConstructs(languages, conceptComparisonOperator);
		int interval = constructsAmount/4;
		boolean first = true;
		for (int i = 1; i <= 4; i++) {
			if(!first) labels += " ,";
			double value = interval * i * getAverageCostSyntax(languages, conceptComparisonOperator, methodComparisonOperator);
			labels += value ;
			first = false;
		}
		return labels;
	}
	
	private String getLabelsLanguageLineSyntaxMaintenanceData(ArrayList<Language> languages, ConceptComparison conceptComparisonOperator,
			MethodComparison methodComparisonOperator) throws Exception {
		String labels = "";
		int constructsAmount = CountConstructs.countFamilyConstructs(languages, conceptComparisonOperator);
		int interval = constructsAmount/4;
		boolean first = true;
		for (int i = 1; i <= 4; i++) {
			if(!first) labels += " ,";
			double value = interval * i;
			labels += value ;
			first = false;
		}
		return labels;
	}
}