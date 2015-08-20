package fr.inria.diverse.puzzle.metrics.evaluators.syntax;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EPackage;

import fr.inria.diverse.k3.sle.common.utils.FamiliesServices;
import fr.inria.diverse.k3.sle.common.vos.ConceptMemberVO;
import fr.inria.diverse.k3.sle.common.vos.ConceptMembersGroupVO;

public class SizeOfCommonality {

	public static int evaluateMetric(ArrayList<EPackage> ePackages){
		ArrayList<ConceptMemberVO> conceptMemberList = FamiliesServices.getInstance().getConceptMemberMappingList(ePackages);
		ArrayList<ConceptMembersGroupVO> conceptMemberGroupList = FamiliesServices.getInstance().getConceptMemberGroupList(conceptMemberList);
		
		int count = 0;
		for (ConceptMembersGroupVO conceptMembersGroupVO : conceptMemberGroupList) {
			if(conceptMembersGroupVO.getMemberGroup().size() == ePackages.size()){
				count++;
			}
		}
		
		return count;
	}
	
	public static String printMetricsResults(ArrayList<EPackage> ePackages){
		String answer = "";
		answer += "var pieDataSyntacticCommonality = [{\n";
		answer += "        value: " + evaluateMetric(ePackages) + ",\n";
		answer += "        color:\"#FAAC58\",\n";
		answer += "        highlight: \"#F7BE81\",\n";
		answer += "        label: \"Commonalities\"\n";
		answer += "    },\n";
		answer += "    {\n";
		answer += "        value: " + TotalAmountOfConcepts.evaluateMetric(ePackages) + ",\n";
		answer += "        color:\"#F5F6CE\",\n";
		answer += "        highlight: \"#FBFBEF\",\n";
		answer += "        label: \"Particularities\"\n";
		answer += "    }\n";
		answer += "];\n\n";
		return answer;
	}
}
