package fr.inria.diverse.k3.sle.common.tuples;

import java.util.ArrayList;

public class TupleMembersConcepts {

	// -----------------------------------------------
	// Attributes
	// -----------------------------------------------
	
	private String members;
	private ArrayList<String> concepts;
	
	// -----------------------------------------------
	// Constructor
	// -----------------------------------------------

	public TupleMembersConcepts(String membersGroup) {
		this.members = membersGroup;
		this.concepts = new ArrayList<String>();
	}
	
	// -----------------------------------------------
	// Getters and setters
	// -----------------------------------------------
	
	public String getMembersGroup() {
		return members;
	}
	
	public void setMembers(String members) {
		this.members = members;
	}
	
	public ArrayList<String> getConcepts() {
		return concepts;
	}

	public void setConcepts(ArrayList<String> concepts) {
		this.concepts = concepts;
	}

	public boolean equals(Object toCompare){
		TupleMembersConcepts toCompareObject = (TupleMembersConcepts) toCompare;
		return toCompareObject.members.equals(this.members);
	}
}