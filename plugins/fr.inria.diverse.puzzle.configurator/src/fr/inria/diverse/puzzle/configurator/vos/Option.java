package fr.inria.diverse.puzzle.configurator.vos;

public class Option {
	
	public enum State{selected,deselected,undecided}
	public String name;
	public State state;
	
	public Option(String name) {
		this.name=name;
		this.state=State.undecided;
	}
	
	
}
