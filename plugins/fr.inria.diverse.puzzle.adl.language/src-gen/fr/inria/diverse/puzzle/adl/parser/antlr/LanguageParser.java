/*
 * generated by Xtext
 */
package fr.inria.diverse.puzzle.adl.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import fr.inria.diverse.puzzle.adl.services.LanguageGrammarAccess;

public class LanguageParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private LanguageGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected fr.inria.diverse.puzzle.adl.parser.antlr.internal.InternalLanguageParser createParser(XtextTokenStream stream) {
		return new fr.inria.diverse.puzzle.adl.parser.antlr.internal.InternalLanguageParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "PuzzleComposition";
	}
	
	public LanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(LanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
