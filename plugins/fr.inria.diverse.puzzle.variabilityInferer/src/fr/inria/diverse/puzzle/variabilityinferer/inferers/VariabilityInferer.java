package fr.inria.diverse.puzzle.variabilityinferer.inferers;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;

import fr.inria.diverse.k3.sle.common.tuples.EcoreGraph;
import fr.inria.diverse.melange.metamodel.melange.Language;

/**
 * Interface specifying the behavior for variability models inference for language product lines.
 * @author David Mendez-Acuna
 */
public interface VariabilityInferer {

	public EObject inferVariabilityModel(ArrayList<Language> languages, EcoreGraph modularizationGraph);
}
