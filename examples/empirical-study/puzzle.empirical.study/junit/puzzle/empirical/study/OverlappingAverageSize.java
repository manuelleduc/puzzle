package puzzle.empirical.study;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import fr.inria.diverse.k3.sle.common.commands.ConceptComparison;
import fr.inria.diverse.k3.sle.common.comparisonOperators.DeepConceptComparison;
import fr.inria.diverse.k3.sle.common.utils.MelangeServices;
import fr.inria.diverse.melange.metamodel.melange.Language;
import fr.inria.diverse.melange.metamodel.melange.MelangeFactory;
import fr.inria.diverse.melange.metamodel.melange.Metamodel;
import fr.inria.diverse.puzzle.metrics.specialCharts.SyntacticNamingVennDiagram;

public class OverlappingAverageSize {

	// ------------------------------------------------
	// Attributes
	// ------------------------------------------------
	
	private String dataFolder = "githubmetamodels";
	private ArrayList<Language> languages;
	
	// ------------------------------------------------
	// Loading scenarios
	// ------------------------------------------------
	
	@Before
	public void loadScenario(){
		languages = new ArrayList<Language>();
		
		File dataFolderObject = new File(dataFolder);
		
		for (File file : dataFolderObject.listFiles()) {
			if(file.getName().endsWith("ecore")){
				Language currentLanguage = MelangeFactory.eINSTANCE.createLanguage();
				Metamodel currentMetamodel = MelangeFactory.eINSTANCE.createMetamodel();
				currentMetamodel.setEcoreUri(file.getAbsolutePath());
				currentLanguage.setSyntax(currentMetamodel);
				currentLanguage.setName(file.getName());
				languages.add(currentLanguage);
			}
		}
	}

	// ------------------------------------------------
	// Test cases
	// ------------------------------------------------
	
	@Test
	public void computeOverlappingAverageSize() throws Exception{
		ConceptComparison conceptComparisonOperator = new DeepConceptComparison();
		SyntacticNamingVennDiagram metrics = new SyntacticNamingVennDiagram();
		int[][] theMatrix = metrics.getCommonalitiesMatrix(languages, conceptComparisonOperator);
		
		ArrayList<Double> mmaverages = new ArrayList<Double>();
		
		for (int i = 0; i < theMatrix.length; i++) {
			int sum = 0;
			int count = 0;
			for (int j = 0; j < theMatrix[0].length; j++) {
				if(theMatrix[i][j] > 0){
					sum += theMatrix[i][j];
					count ++;
				}
			}
			
			if(count != 0){
				double avg = ((double)sum)/((double)count);
				mmaverages.add(avg);
			}
		}
		
		double sumAVG = 0;
		for (Double _double : mmaverages) {
			sumAVG += _double;
		}
		
		double AVG = sumAVG/((double)mmaverages.size());
		System.out.println("Average of overlapping size: " + AVG);
	}
	
	@Test
	public void computeAverageAmountConstructs() throws Exception {
		double sum = 0;
		for (Language language : languages) {
			sum += MelangeServices.countLanguageConstructs(language);
		}
		double AVG = sum/((double)languages.size());
		System.out.println("Average of language constructs: " + AVG);
	}
}
