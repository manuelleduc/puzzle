package fr.inria.diverse.puzzle.vmsynthesis.tests;

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
	
	public String executeTest(int numFeatures, int numProducts) throws Exception {
		DependencyGraph randomAciclic = GraphGenerator.generateGraph(numFeatures, 880608);
		System.out.println("open fm: " + randomAciclic.toString());
		System.out.println("there is loop: " + randomAciclic.thereIsLoop());
		
		PFeatureModel openFM = VmSynthesis.getInstance().synthesizeOpenFeatureModel(randomAciclic);
		System.out.println(openFM.getRootFeature().getChildren().size());
		
		System.out.println("openFM");
		TestServices.printFM(openFM);
		
		String PCM = PCMGenerator.generatePCMs(randomAciclic, numProducts, 880608, 2);
		System.out.println("Original: "+ PCM);
		updatePCM(PCM,randomAciclic);
		System.out.println("Update: "+ PCM);
		
		numProducts = PCM.split("\n").length - 1;
		System.out.println("ya la calcule");
		
		System.out.println("Cloned OpenFM");
		PFeatureModel closedFM = synthesis.cloneFeatureModel(openFM);
		PCMQueryServices.getInstance().loadPCM(PCM);
		TestServices.printAllValidProducts(closedFM, PCM);
		
		System.out.println("IdentifyMandatoryFeatures OpenFM");
		long before = System.currentTimeMillis();
		synthesis.identifyMandatoryFeatures(closedFM);
		TestServices.printFM(closedFM);
		TestServices.printAllValidProducts(closedFM, PCM);
		
		System.out.println("IdentifyXORs OpenFM");
		synthesis.identifyXORs(closedFM);
		TestServices.printFM(closedFM);
		TestServices.printAllValidProducts(closedFM, PCM);
		
		System.out.println("IdentifyORs OpenFM");
		synthesis.identifyORs(closedFM);
		TestServices.printFM(closedFM);
		TestServices.printAllValidProducts(closedFM, PCM);
		
		System.out.println("AddAdditionalImpliesConstraints OpenFM");
		synthesis.addAdditionalImpliesConstraints(closedFM);
		TestServices.printFM(closedFM);
		TestServices.printAllValidProducts(closedFM, PCM);
		
		System.out.println("AddAdditionalExcludesConstraints OpenFM");
		synthesis.addAdditionalExcludesConstraints(closedFM);
		TestServices.printFM(closedFM);
		TestServices.printAllValidProducts(closedFM, PCM);
		
//		System.out.println("GroupingImplicationsByRightSide OpenFM");
//		synthesis.groupImplicationsByRightSide(closedFM);
//		TestServices.printFM(closedFM);
//		TestServices.printAllValidProducts(closedFM, PCM);
//		
//		System.out.println("GroupingNotImplicationsByRightSide OpenFM");
//		synthesis.groupNotImplicationsByRightSide(closedFM);
//		TestServices.printFM(closedFM);
//		TestServices.printAllValidProducts(closedFM, PCM);
		
		System.out.println("GroupingImplicationsByLeftSide OpenFM");
		synthesis.groupImplicationsByLeftSide(closedFM);
		TestServices.printFM(closedFM);
		double result = TestServices.printAllValidProducts(closedFM, PCM);
		
		long after = System.currentTimeMillis();
		long time = after - before;
		String resultMessage = "";
		
		if(result != numProducts){
			resultMessage += "Time: " + time + "; FAIL: " + "No. Features: " + numFeatures + 
					"; No. Products: " + numProducts + "; Result: " + result + "\n";
		}else{
			resultMessage += "Time: " + time + "; SUCCESS: " + "No. Features: " + numFeatures + 
					"; No. Products: " + numProducts + " Result: " + result + "\n";
		}
		
		return resultMessage;
		
	}
	
	private void updatePCM(String PCM, DependencyGraph randomAciclic) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testRandom() throws Exception{
//		int[] dataFeatures = {5, 8, 10, 15, 20};
//		int[] dataNumProducts = {2, 4, 6, 7, 8};
//		String resultMessage = "";
//		for (int i = 0; i < dataFeatures.length; i++) {
//			for (int j = 0; j < dataNumProducts.length; j++) {
//				resultMessage += this.executeTest(dataFeatures[i], dataNumProducts[j]);
//			}
//		}
//		
//		System.out.println(resultMessage);
	
		String resultMessage = "";

		resultMessage += this.executeTest(6, 3);
		resultMessage += this.executeTest(10, 3);
		resultMessage += this.executeTest(15, 3);
		resultMessage += this.executeTest(20, 3);
		resultMessage += this.executeTest(25, 3);
		resultMessage += this.executeTest(30, 3);
		resultMessage += this.executeTest(35, 3);

		resultMessage += this.executeTest(6, 4);
		resultMessage += this.executeTest(10, 4);
		resultMessage += this.executeTest(15, 4);
		resultMessage += this.executeTest(20, 4);
		resultMessage += this.executeTest(25, 4);
		resultMessage += this.executeTest(30, 4);
		resultMessage += this.executeTest(35, 4);
		
		resultMessage += this.executeTest(10, 5);
		resultMessage += this.executeTest(15, 5);
		resultMessage += this.executeTest(20, 5);
		resultMessage += this.executeTest(25, 5);
		resultMessage += this.executeTest(30, 5);
		resultMessage += this.executeTest(35, 5);
		
		resultMessage += this.executeTest(10, 8);
		resultMessage += this.executeTest(15, 8);
		resultMessage += this.executeTest(20, 8);
		resultMessage += this.executeTest(25, 8);
		resultMessage += this.executeTest(30, 8);
		resultMessage += this.executeTest(35, 8);
		
		resultMessage += this.executeTest(10, 10);
		resultMessage += this.executeTest(15, 10);
		resultMessage += this.executeTest(20, 10);
		resultMessage += this.executeTest(25, 10);
		resultMessage += this.executeTest(30, 10);
		resultMessage += this.executeTest(35, 10);
		
		resultMessage += this.executeTest(10, 15);
		resultMessage += this.executeTest(15, 15);
		resultMessage += this.executeTest(20, 15);
		resultMessage += this.executeTest(25, 15);
		resultMessage += this.executeTest(30, 15);
		resultMessage += this.executeTest(35, 15);
		
		System.out.println(resultMessage);
	}
	
}
