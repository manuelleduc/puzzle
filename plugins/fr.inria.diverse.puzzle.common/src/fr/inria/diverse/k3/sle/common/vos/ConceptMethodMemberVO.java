package fr.inria.diverse.k3.sle.common.vos;

import org.eclipse.emf.ecore.EClassifier;

public class ConceptMethodMemberVO {

	// -----------------------------------------------
	// Attributes
	// -----------------------------------------------
	
	private EClassifier concept;
	private String methodSignature;
	private String memberName;

	// -----------------------------------------------
	// Constructor
	// -----------------------------------------------
	
	public ConceptMethodMemberVO(EClassifier concept, String methodSignature, String memberName) {
		this.concept = concept;
		this.methodSignature = methodSignature;
		this.memberName = memberName;
	}
	
	// -----------------------------------------------
	// Getters and setters
	// -----------------------------------------------
	
	public EClassifier getConcept() {
		return concept;
	}
	
	public void setConcept(EClassifier concept) {
		this.concept = concept;
	}
	
	public String getMethodSignature() {
		return methodSignature;
	}

	public void setMethodSignature(String methodSignature) {
		this.methodSignature = methodSignature;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String toString(){
		return this.memberName + " - " + this.concept.getName();
	}
}