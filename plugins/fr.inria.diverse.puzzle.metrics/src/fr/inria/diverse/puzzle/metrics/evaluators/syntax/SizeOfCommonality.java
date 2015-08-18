package fr.inria.diverse.puzzle.metrics.evaluators.syntax;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EPackage;

import fr.inria.diverse.k3.sle.common.utils.FamiliesServices;
import fr.inria.diverse.k3.sle.common.vos.ConceptMemberVO;
import fr.inria.diverse.k3.sle.common.vos.ConceptMembersGroupVO;

public class SizeOfCommonality {

	public static double evaluateMetric(ArrayList<EPackage> ePackages){
		ArrayList<ConceptMemberVO> conceptMemberList = FamiliesServices.getInstance().getConceptMemberMappingList(ePackages);
		ArrayList<ConceptMembersGroupVO> conceptMemberGroupList = FamiliesServices.getInstance().getConceptMemberGroupList(conceptMemberList);
		
		double count = 0;
		for (ConceptMembersGroupVO conceptMembersGroupVO : conceptMemberGroupList) {
			if(conceptMembersGroupVO.getMemberGroup().size() == ePackages.size()){
				count++;
			}
		}
		
		return count;
	}
	
	public static String getMetricDetails(ArrayList<EPackage> ePackages){
		ArrayList<ConceptMemberVO> conceptMemberList = FamiliesServices.getInstance().getConceptMemberMappingList(ePackages);
		ArrayList<ConceptMembersGroupVO> conceptMemberGroupList = FamiliesServices.getInstance().getConceptMemberGroupList(conceptMemberList);
		
		String concepts = "";
		for (ConceptMembersGroupVO conceptMembersGroupVO : conceptMemberGroupList) {
			if(conceptMembersGroupVO.getMemberGroup().size() == ePackages.size()){
				concepts += conceptMembersGroupVO.getConcept().getName() + " \n";
			}
		}
		
		return concepts;
	}
}
