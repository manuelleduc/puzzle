package fr.inria.diverse.puzzle.vmsynthesis.tests;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import vm.PFeatureModel;
import fr.inria.diverse.k3.sle.common.graphs.DependencyGraph;
import fr.inria.diverse.puzzle.instancesgenerator.impl.GraphGenerator;
import fr.inria.diverse.puzzle.instancesgenerator.impl.PCMGenerator;
import fr.inria.diverse.puzzle.vmsynthesis.impl.PCMQueryServices;
import fr.inria.diverse.puzzle.vmsynthesis.impl.VmSynthesis;

public class RandomTest {

	// -------------------------------------------------
	// Attributes
	// -------------------------------------------------
	
	private VmSynthesis synthesis;
	
	// -------------------------------------------------
	// Loading scenarios
	// -------------------------------------------------
	
	@Before
	public void loadScenarios() throws Exception{
		synthesis = VmSynthesis.getInstance();
	}
	
	// -------------------------------------------------
	// Test Cases
	// -------------------------------------------------
	
	@Test
	public void testRandom() throws Exception {
		DependencyGraph randomAciclic = GraphGenerator.generateGraph(25, 880608);
		System.out.println("open fm: " + randomAciclic.toString());
		System.out.println("there is loop: " + randomAciclic.thereIsLoop());
		
		PFeatureModel openFM = VmSynthesis.getInstance().synthesizeOpenFeatureModel(randomAciclic);
		System.out.println(openFM.getRootFeature().getChildren().size());
		
		System.out.println("openFM");
		TestServices.printFM(openFM);
		
		ArrayList<String> PCMs = PCMGenerator.generatePCMs(randomAciclic, 1, 2, 880608, 3);
		for (String PCM : PCMs) {
			
			PFeatureModel closedFM = synthesis.cloneFeatureModel(openFM);
			PCMQueryServices.getInstance().loadPCM(PCM);
			System.out.println("Cloned OpenFM");
			TestServices.printAllValidProducts(closedFM, PCM);
			
			synthesis.identifyMandatoryFeatures(closedFM);
			TestServices.printFM(closedFM);
			System.out.println("IdentifyMandatoryFeatures OpenFM");
			TestServices.printAllValidProducts(closedFM, PCM);
			
			synthesis.identifyXORs(closedFM);
			TestServices.printFM(closedFM);
			System.out.println("IdentifyXORs OpenFM");
			TestServices.printAllValidProducts(closedFM, PCM);
			
			synthesis.identifyORs(closedFM);
			TestServices.printFM(closedFM);
			System.out.println("IdentifyORs OpenFM");
			TestServices.printAllValidProducts(closedFM, PCM);
			
			synthesis.addAdditionalImpliesConstraints(closedFM);
			TestServices.printFM(closedFM);
			System.out.println("AddAdditionalImpliesConstraints OpenFM");
			TestServices.printAllValidProducts(closedFM, PCM);
			
			synthesis.addAdditionalExcludesConstraints(closedFM);
			TestServices.printFM(closedFM);
			System.out.println("AddAdditionalExcludesConstraints OpenFM");
			TestServices.printAllValidProducts(closedFM, PCM);
		}
	}
}