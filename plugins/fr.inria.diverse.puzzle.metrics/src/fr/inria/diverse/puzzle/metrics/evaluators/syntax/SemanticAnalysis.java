package fr.inria.diverse.puzzle.metrics.evaluators.syntax;

import java.util.ArrayList;

import org.eclipse.xtext.common.types.JvmFormalParameter;

import fr.inria.diverse.k3.sle.common.comparisonOperators.ConceptComparison;
import fr.inria.diverse.k3.sle.common.comparisonOperators.MethodComparison;
import fr.inria.diverse.k3.sle.common.tuples.ConceptMethodMemberVO;
import fr.inria.diverse.k3.sle.common.tuples.ConceptMethodMembersGroupVO;
import fr.inria.diverse.k3.sle.common.tuples.TupleConceptMethodsMembers;
import fr.inria.diverse.k3.sle.common.tuples.TupleMethodMembers;
import fr.inria.diverse.k3.sle.common.utils.FamiliesServices;
import fr.inria.diverse.melange.metamodel.melange.Language;

public class SemanticAnalysis {

	public static String getVariablesDeclaration(ArrayList<Language> languages, ConceptComparison conceptComparisonOperator, MethodComparison methodComparisonOperator){
		String answer = "";
		ArrayList<ConceptMethodMemberVO> conceptMethodMemberList = FamiliesServices.getInstance().getConceptMethodMemberMappingList(languages);
		ArrayList<ConceptMethodMembersGroupVO> conceptMethodMemberGroupList = FamiliesServices.getInstance().getConceptMethodMemberGroupList(conceptMethodMemberList, conceptComparisonOperator, methodComparisonOperator);
		
//		for (ConceptMethodMembersGroupVO conceptMethodMembersGroupVO : conceptMethodMemberGroupList) {
//			System.out.println("conceptMethodMembersGroupVO*:" + conceptMethodMembersGroupVO);
//		}
//		
		ArrayList<TupleConceptMethodsMembers> conceptsGroupMethodMemberGroupList = FamiliesServices.getInstance().getConceptMethodsMembersGroupTupleList(conceptMethodMemberGroupList, conceptComparisonOperator, methodComparisonOperator);
		
		answer += "var treeData = [\n";
		answer += "    {";
		answer += "    \"name\": \"Family\",\n";
		answer += "    \"parent\": \"null\",\n";
		answer += "    \"children\": [\n";
		
		boolean firstLevel0 = true;
		for (TupleConceptMethodsMembers conceptMethodMembersGroupVO : conceptsGroupMethodMemberGroupList) {
			System.out.println("conceptMethodMembersGroupVO: " + conceptMethodMembersGroupVO);
			if(!firstLevel0) answer += ",\n";
			//FIXME
			String conceptName = conceptMethodMembersGroupVO.getConcept().getSimpleName().replace("Aspect", "");
			answer += "          {\n";
			answer += "          \"name\": \"" + conceptName + "\",\n";
			answer += "          \"parent\": \"Family\"";
			if(conceptMethodMembersGroupVO.getMethodsMembers().size() > 0){
				answer += ",\n";
				answer += "          \"children\": [\n";
				boolean firstLevel1 = true;
				for (TupleMethodMembers methodMembers : conceptMethodMembersGroupVO.getMethodsMembers()) {
					if(!firstLevel1) answer += ",\n";
					String operationSignature = methodMembers.getMethod().getReturnType().getSimpleName() + " " 
													+ methodMembers.getMethod().getSimpleName() + "(";
					for (JvmFormalParameter param : methodMembers.getMethod().getParameters()) {
						operationSignature += param.getParameterType().getSimpleName() + " ";
					}
					operationSignature += ") [from:";
					
					for (String member : methodMembers.getMembers()) {
						operationSignature += " " + member;
					}
					operationSignature += "]";
					
					answer += "               {\n";
					answer += "               \"name\": \"" + operationSignature + "\",\n";
					answer += "               \"parent\": \"" + conceptName + "\"\n";
					answer += "               }";
					firstLevel1 = false;
				}
				answer += "\n";
				answer += "              ]\n";
			}else{
				answer += "\n";
			}
			answer += "          }";
			firstLevel0 = false;
		}
		answer += "\n";
		answer += "     ]\n";
		answer += "    }\n";
		answer += "];\n";
		
		return answer;
	}
}