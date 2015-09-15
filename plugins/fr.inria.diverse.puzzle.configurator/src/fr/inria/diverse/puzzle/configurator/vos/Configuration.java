package fr.inria.diverse.puzzle.configurator.vos;

import java.util.Collection;
import java.util.LinkedList;

import es.us.isa.FAMA.models.FAMAfeatureModel.Feature;
import fr.inria.diverse.puzzle.configurator.vos.Option.State;

/**
 * Object representing a particular configuration for a FAMA features model. 
 * @author Jose A. Galindo
 *
 */
public class Configuration {
	
	public Collection<Question> questions;

	public Configuration() {
		this.questions = new LinkedList<Question>();
	}

	public es.us.isa.FAMA.stagedConfigManager.Configuration getFAMAConfiguration() {
		es.us.isa.FAMA.stagedConfigManager.Configuration conf = new es.us.isa.FAMA.stagedConfigManager.Configuration();

		for (Question q : questions) {
			for (Option o : q.options) {
				if (o.state == State.selected) {
					conf.addElement(new Feature(o.name), 1);
				} else if (o.state == State.deselected) {
					conf.addElement(new Feature(o.name), 0);
				} else if (o.state == State.undecided) {
					// do nothing
				}
			}
		}
		return conf;
	}

	public void setOption(Feature f, Boolean b) {
		for (Question q : questions) {
			for (Option o : q.options) {
				if (o.name.equals(f.getName())) {
					if (b == null) {
						o.state = State.undecided;
					} else if (b) {
						o.state = State.selected;
					} else if (!b) {
						o.state = State.deselected;
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		String returnStr = "";
		for (Question q : questions) {
			for (Option o : q.options) {
				returnStr += o.name + "=";
				if (o.state == State.selected) {
					returnStr += "selected";
				} else if (o.state == State.deselected) {
					returnStr += "deselected";
				} else if (o.state == State.undecided) {
					returnStr += "undecided";
				}
				returnStr += "\n";
			}

		}
		return returnStr;
	}
}
