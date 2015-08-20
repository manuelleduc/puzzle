package fr.inria.diverse.puzzle.metrics.evaluators.syntax;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EPackage;

public class ProductRelatedReusability {

	public static String evaluate(ArrayList<EPackage> ePackages){
		double SoSC = SizeOfCommonality.evaluateMetric(ePackages);
		String result = "";
		
		for (EPackage ePackage : ePackages) {
			double currentValue = SoSC / countConstructs(ePackage);
			result += ePackage.getName() + ": " + currentValue + "\n";
		}
		
		return result;
	}
	
	private static double countConstructs(EPackage ePackage){
		double count = ePackage.getEClassifiers().size();
		
		for (EPackage eSubPackage : ePackage.getESubpackages()) {
			count += countConstructs(eSubPackage);
		}
		
		return count;
	}
	
	public static String printMetricsResults(ArrayList<EPackage> ePackages){
		String answer = "var barProductRelatedReusability = {\n";
		
		boolean first = true;
		String labels = "";
		for (EPackage ePackage : ePackages) {
			if(!first) labels += ",";
			labels += "\"" + ePackage.getName() + "\"";
			first = false;
		}
		
		answer += "   labels : [" + labels + "],\n";
		answer += "   datasets : [\n";
		answer += "     {\n";
		answer += "        fillColor : \"rgba(220,220,220,0.5)\",\n";
		answer += "        strokeColor : \"rgba(220,220,220,0.8)\",\n";
		answer += "        highlightFill: \"rgba(220,220,220,0.75)\",\n";
		answer += "        highlightStroke: \"rgba(220,220,220,1)\",\n";
		
		String values = "";
		double SoSC = SizeOfCommonality.evaluateMetric(ePackages);
		first = true;
		for (EPackage ePackage : ePackages) {
			double currentValue = SoSC / countConstructs(ePackage);
			if(!first)
				values +=  ",";
			values += currentValue;
			first = false;
		}
		
		answer += "        data : [" + values + "]\n";
		answer += "      },\n";
		answer += "      {\n";
		answer += "        fillColor : \"rgba(151,187,205,0.5)\",\n";
		answer += "        strokeColor : \"rgba(151,187,205,0.8)\",\n";
		answer += "        highlightFill : \"rgba(151,187,205,0.75)\",\n";
		answer += "        highlightStroke : \"rgba(151,187,205,1)\",\n";
		answer += "        data : [" + values + "]\n"; // TODO Semantic values here
		answer += "      }\n";
		answer += "    ]\n";
		answer += "};\n";
		
		return answer;
	}
}