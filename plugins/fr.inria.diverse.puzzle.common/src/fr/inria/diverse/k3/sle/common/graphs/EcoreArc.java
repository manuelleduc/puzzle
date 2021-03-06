package fr.inria.diverse.k3.sle.common.graphs;

public class EcoreArc {

	// -----------------------------------------------
	// Attributes
	// -----------------------------------------------

	private EcoreVertex from;
	private EcoreVertex to;
	
	// -----------------------------------------------
	// Constructor
	// -----------------------------------------------
	
	public EcoreArc(EcoreVertex from, EcoreVertex to) {
		this.from = from;
		this.to = to;
	}
	
	// -----------------------------------------------
	// Getters and setters
	// -----------------------------------------------
	
	public EcoreVertex getFrom() {
		return from;
	}
	
	public void setFrom(EcoreVertex from) {
		this.from = from;
	}
	
	public EcoreVertex getTo() {
		return to;
	}
	
	public void setTo(EcoreVertex to) {
		this.to = to;
	}
	
	// -----------------------------------------------
	// Methods
	// -----------------------------------------------
	
	public String toString(){
		return this.from.getVertexId() + " -> " + this.to.getVertexId();
	}
	
	public boolean equals(Object o){
		EcoreArc ecoreArc = (EcoreArc) o;
		return ecoreArc.from.equals(this.from) && ecoreArc.to.equals(this.to);
	}

	public EcoreArc cloneArc(EcoreVertex from, EcoreVertex to) {
		EcoreArc clone = new EcoreArc(from, to);
		return clone;
	}
}