package fr.inria.diverse.k3.sle.common.utils;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

import fr.inria.diverse.k3.sle.common.vos.ConceptMemberVO;
import fr.inria.diverse.k3.sle.common.vos.ConceptMembersGroupVO;
import fr.inria.diverse.k3.sle.common.vos.ConceptMethodMemberVO;
import fr.inria.diverse.k3.sle.common.vos.ModuleConceptsVO;
import fr.inria.diverse.melange.metamodel.melange.Aspect;
import fr.inria.diverse.melange.metamodel.melange.Language;

/**
 * Services for manipulating families of domain-specific languages
 * @author David Mendez-Acuna
 * 
 * TODO We need to use the name of the language as member name instead of the root package name. 
 */
public class FamiliesServices {
	
	// -----------------------------------------------
	// Attributes
	// -----------------------------------------------
	
	private static FamiliesServices instance;
	
	// -----------------------------------------------
	// Constructor and singleton
	// -----------------------------------------------
	
	private FamiliesServices(){}

	public static FamiliesServices getInstance(){
		if(instance == null){
			instance = new FamiliesServices();
		}
		return instance;
	}
	
	// -----------------------------------------------
	// Methods
	// -----------------------------------------------
	
	/**
	 * Returns a list with the mapping between the concept and the language it belongs to. 
	 * @param ePackages. List of ePackages 
	 * @return
	 */
	public ArrayList<ConceptMemberVO> getConceptMemberMappingList(ArrayList<EPackage> ePackages){
		ArrayList<ConceptMemberVO> conceptMemberList = new ArrayList<ConceptMemberVO>();
		for (EPackage ePackage : ePackages) {
			this.fillConceptMemberList(conceptMemberList, ePackage, ePackage.getName());
		}
		return conceptMemberList;
	}
	
	/**
	 * Fills the list in the parameter with the mapping between the concept and the language it belongs to. 
	 */
	private void fillConceptMemberList(ArrayList<ConceptMemberVO> conceptMemberList, EPackage ePackage, String memberName) {
		for (EClassifier concept : ePackage.getEClassifiers()) {
			ConceptMemberVO conceptMember = new ConceptMemberVO(concept, memberName);
			conceptMemberList.add(conceptMember);
		}
		for (EPackage subPackage : ePackage.getESubpackages()) {
			this.fillConceptMemberList(conceptMemberList, subPackage, memberName);
		}
	}
	
	/**
	 * Returns a list with the mapping between the method and the language it belongs to.
	 * @param languages. List of languages 
	 * @return
	 */
	public ArrayList<ConceptMethodMemberVO> getConceptMethodMemberMappingList(ArrayList<Language> languages){
		System.out.println("FamiliesServices.getConceptMethodMemberMappingList");
		ArrayList<ConceptMethodMemberVO> conceptMethodMemberList = new ArrayList<ConceptMethodMemberVO>();
		for (Language language : languages) {
			EPackage ePackage = MelangeServices.getEPackageFromLanguage(language);
			this.fillConceptMethodMemberList(conceptMethodMemberList, language, ePackage.getName());
		}
		return conceptMethodMemberList;
	}
	
	private void fillConceptMethodMemberList(
			ArrayList<ConceptMethodMemberVO> conceptMethodMemberList, Language language, String memberName) {
		System.out.println("FamiliesServices.fillConceptMethodMemberList");
		System.out.println("language.getSemantics(): " + language.getSemantics());
		for (Aspect aspect : language.getSemantics()) {
			System.out.println("Coucou! " + aspect.getAspectTypeRef().getType().eContents());
		}
	}

	public ArrayList<ConceptMembersGroupVO> getConceptMemberGroupList(ArrayList<ConceptMemberVO> conceptMemberList){
		ArrayList<ConceptMembersGroupVO> conceptMemberGroupList = new ArrayList<ConceptMembersGroupVO>();
		for (ConceptMemberVO conceptMemberVO : conceptMemberList) {
			ConceptMembersGroupVO conceptMemberGroupLegacy = getConceptMemberGroup(conceptMemberGroupList, conceptMemberVO);
			if(conceptMemberGroupLegacy == null){
				ConceptMembersGroupVO conceptMemberGroupVO = new ConceptMembersGroupVO(conceptMemberVO.getConcept());
				conceptMemberGroupVO.getMemberGroup().add(conceptMemberVO.getMemberName());
				conceptMemberGroupList.add(conceptMemberGroupVO);
			}else{
				conceptMemberGroupLegacy.getMemberGroup().add(conceptMemberVO.getMemberName());
			}
		}
		
		return conceptMemberGroupList;
	}
	
	public ArrayList<ModuleConceptsVO> obtainConceptsOwenerLanguagesList(ArrayList<EPackage> ePackages){
		// Step 1: Scan the metamodels creating the concept-member list.
		ArrayList<ConceptMemberVO> conceptMemberList = this.getConceptMemberMappingList(ePackages);
		
		// Step 2: For each concept, get the group of members it belongs.
		ArrayList<ConceptMembersGroupVO> conceptMemberGroupList = this.getConceptMemberGroupList(conceptMemberList);
		
		ArrayList<ModuleConceptsVO> moduleConceptsList = new ArrayList<ModuleConceptsVO>();
		int i = 1;
		for (ConceptMembersGroupVO conceptMembersGroupVO : conceptMemberGroupList) {
			ModuleConceptsVO legacyModule = getLegacyFeature(moduleConceptsList, conceptMembersGroupVO);
			if(legacyModule == null){
				ModuleConceptsVO newModule = new ModuleConceptsVO("module" + i, conceptMembersGroupVO.getMemberGroup().toString());
				newModule.getConcepts().add(conceptMembersGroupVO.getConcept());
				moduleConceptsList.add(newModule);
				i++;
			}else{
				legacyModule.getConcepts().add(conceptMembersGroupVO.getConcept());
			}
		}
		return moduleConceptsList;
	}
	
	
	
	private ConceptMembersGroupVO getConceptMemberGroup(ArrayList<ConceptMembersGroupVO> conceptMemberGroupList,
			ConceptMemberVO conceptMemberVO) {
		for (ConceptMembersGroupVO conceptMembersGroupVO : conceptMemberGroupList) {
			if(conceptMembersGroupVO.getConcept().getName().equals(conceptMemberVO.getConcept().getName()))
				return conceptMembersGroupVO;
		}
		return null;
	}
	
	private ModuleConceptsVO getLegacyFeature(
			ArrayList<ModuleConceptsVO> featureConceptsList,
			ConceptMembersGroupVO conceptMembersGroupVO) {
		for (ModuleConceptsVO featureConceptsVO : featureConceptsList) {
			if(featureConceptsVO.getMembers().equals(conceptMembersGroupVO.getMemberGroup().toString()))
				return featureConceptsVO;
		}
		return null;
	}
}
