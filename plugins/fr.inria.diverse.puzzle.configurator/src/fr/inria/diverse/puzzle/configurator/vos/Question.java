package fr.inria.diverse.puzzle.configurator.vos;

import java.util.Collection;
import java.util.LinkedList;

import fr.inria.diverse.puzzle.configurator.vos.Option.State;

public class Question {
	public Collection<Option> options;
	public String name;
	
	public Question(String name){
		this.name=name;
		this.options=new LinkedList<>();
	}

	public boolean hasUndecided() {
		for(Option o:options){
			if(o.state==State.undecided){
				return true;
			}
		}
		return false;
	}
}
