/*
 * generated by Xtext
 */
package fr.inria.diverse.puzzle.adl.language.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class PuzzleAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("fr/inria/diverse/puzzle/adl/language/parser/antlr/internal/InternalPuzzle.tokens");
	}
}