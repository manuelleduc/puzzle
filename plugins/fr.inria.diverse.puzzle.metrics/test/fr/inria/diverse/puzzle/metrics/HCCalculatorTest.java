package fr.inria.diverse.puzzle.metrics;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.inria.diverse.puzzle.metrics.auxiliarMetrics.HCCalculator;
import fr.inria.diverse.puzzle.metrics.auxiliarMetrics.PairwiseCohesionMatrix;
import fr.inria.diverse.puzzle.metrics.vos.HCMatrix;
import fr.inria.diverse.puzzle.metrics.vos.HCMatrixEntry;
import fr.inria.diverse.puzzle.metrics.vos.HCTree;
import fr.inria.diverse.puzzle.metrics.vos.HCTreeNode;

public class HCCalculatorTest {

	// -------------------------------------------------
	// Scenarios
	// -------------------------------------------------
	
	private HCCalculator hcCalculator;
	private EClass stateMachine;
	private EClass state;
	private EClass transition;
	private EClass statement;
	private EClass block;
	private EClass conditional;
	private EClass loop;
	private List<EClass> metaclasses;
	
	// -------------------------------------------------
	// Scenarios loading
	// -------------------------------------------------
	
	@Before
	public void loadScenario(){
		hcCalculator = new HCCalculator();
		
		// Creating EClasses
		stateMachine = EcoreFactory.eINSTANCE.createEClass();
		stateMachine.setName("StateMachine");
		
		state = EcoreFactory.eINSTANCE.createEClass();
		state.setName("State");
		
		transition = EcoreFactory.eINSTANCE.createEClass();
		transition.setName("Transition");
		
		statement = EcoreFactory.eINSTANCE.createEClass();
		statement.setName("Statement");
		statement.setAbstract(true);
		
		block = EcoreFactory.eINSTANCE.createEClass();
		block.setName("Block");
		
		conditional = EcoreFactory.eINSTANCE.createEClass();
		conditional.setName("Conditional");
		
		loop = EcoreFactory.eINSTANCE.createEClass();
		loop.setName("Loop");
		
		metaclasses = new ArrayList<EClass>();
		metaclasses.add(stateMachine);
		metaclasses.add(state);
		metaclasses.add(transition);
		metaclasses.add(statement);
		metaclasses.add(block);
		metaclasses.add(conditional);
		metaclasses.add(loop);
		
		// Creating EReferences
		EReference states = EcoreFactory.eINSTANCE.createEReference();
		states.setContainment(true);
		states.setName("states");
		states.setEType(state);
		stateMachine.getEStructuralFeatures().add(states);
		
		EReference stateMachineStates = EcoreFactory.eINSTANCE.createEReference();
		stateMachineStates.setContainment(false);
		stateMachineStates.setEType(stateMachine);
		stateMachineStates.setName("stateMachine");
		stateMachineStates.setEOpposite(states);
		state.getEStructuralFeatures().add(stateMachineStates);
		
		EReference transitions = EcoreFactory.eINSTANCE.createEReference();
		transitions.setContainment(true);
		transitions.setName("transitions");
		transitions.setEType(transition);
		stateMachine.getEStructuralFeatures().add(transitions);
		
		EReference stateMachineTransitions = EcoreFactory.eINSTANCE.createEReference();
		stateMachineTransitions.setContainment(false);
		stateMachineTransitions.setName("stateMachine");
		stateMachineTransitions.setEType(stateMachine);
		stateMachineTransitions.setEOpposite(transitions);
		transition.getEStructuralFeatures().add(stateMachineTransitions);
		
		EReference incoming = EcoreFactory.eINSTANCE.createEReference();
		incoming.setContainment(false);
		incoming.setName("incoming");
		incoming.setEType(transition);
		incoming.setLowerBound(0);
		incoming.setUpperBound(-1);
		state.getEStructuralFeatures().add(incoming);
		
		EReference target = EcoreFactory.eINSTANCE.createEReference();
		target.setContainment(false);
		target.setName("target");
		target.setEType(state);
		target.setLowerBound(1);
		target.setUpperBound(1);
		target.setEOpposite(incoming);
		transition.getEStructuralFeatures().add(target);
		
		EReference outgoing = EcoreFactory.eINSTANCE.createEReference();
		outgoing.setContainment(false);
		outgoing.setName("outgoing");
		outgoing.setEType(transition);
		outgoing.setLowerBound(0);
		outgoing.setUpperBound(-1);
		state.getEStructuralFeatures().add(outgoing);
		
		EReference source = EcoreFactory.eINSTANCE.createEReference();
		source.setContainment(false);
		source.setName("source");
		source.setEType(state);
		source.setLowerBound(1);
		source.setUpperBound(1);
		source.setEOpposite(outgoing);
		transition.getEStructuralFeatures().add(source);
		
		EReference doAction = EcoreFactory.eINSTANCE.createEReference();
		doAction.setContainment(true);
		doAction.setName("doAction");
		doAction.setEType(block);
		doAction.setLowerBound(0);
		doAction.setUpperBound(1);
		state.getEStructuralFeatures().add(doAction);
		
		EReference conditionalBody = EcoreFactory.eINSTANCE.createEReference();
		conditionalBody.setContainment(true);
		conditionalBody.setName("body");
		conditionalBody.setEType(block);
		conditionalBody.setLowerBound(0);
		conditionalBody.setUpperBound(1);
		conditional.getEStructuralFeatures().add(conditionalBody);
		
		EReference loopBody = EcoreFactory.eINSTANCE.createEReference();
		loopBody.setContainment(true);
		loopBody.setName("body");
		loopBody.setEType(block);
		loopBody.setLowerBound(0);
		loopBody.setUpperBound(1);
		loop.getEStructuralFeatures().add(loopBody);
		
		// Creating ESuperTypes
		block.getESuperTypes().add(statement);
		conditional.getESuperTypes().add(statement);
		loop.getESuperTypes().add(statement);
	}
	
	// -------------------------------------------------
	// Test cases
	// -------------------------------------------------
	
	@Test
	public void testMetricComputation(){
		double[][] matrix = PairwiseCohesionMatrix.computePairwiseCohesionMatrix(metaclasses);
		
		Assert.assertEquals(0.14, matrix[0][1], 0.01);
		Assert.assertEquals(0.14, matrix[0][2], 0.01);
		Assert.assertEquals(0, matrix[0][3], 0);
		Assert.assertEquals(0, matrix[0][4], 0);
		Assert.assertEquals(0, matrix[0][5], 0);
		Assert.assertEquals(0, matrix[0][5], 0);
		
		Assert.assertEquals(0.28, matrix[1][2], 0.01);
		Assert.assertEquals(0, matrix[1][3], 0);
		Assert.assertEquals(0.07, matrix[1][4], 0.01);
		Assert.assertEquals(0, matrix[1][5], 0);
		Assert.assertEquals(0, matrix[1][5], 0);
		
		Assert.assertEquals(0, matrix[2][3], 0);
		Assert.assertEquals(0, matrix[2][4], 0);
		Assert.assertEquals(0, matrix[2][5], 0);
		Assert.assertEquals(0, matrix[2][5], 0);
		
		Assert.assertEquals(0.07, matrix[3][4], 0.01);
		Assert.assertEquals(0.07, matrix[3][5], 0.01);
		Assert.assertEquals(0.07, matrix[3][5], 0.01);
		
		Assert.assertEquals(0.07, matrix[4][5], 0.01);
		Assert.assertEquals(0.07, matrix[4][5], 0.01);
		
		Assert.assertEquals(0, matrix[5][5], 0);
	}
	
	@Test
	public void testBuildInitialHCMatrixFromMetrixMatrix(){
		double[][] metricsMatrix = PairwiseCohesionMatrix.computePairwiseCohesionMatrix(metaclasses);
		HCMatrix initialMatrix = hcCalculator.buildInitialHCMatrixFromMetrixMatrix(metricsMatrix, metaclasses);
		
		// Row y = 0; x >= 1
		Assert.assertEquals("StateMachine", initialMatrix.getEntries()[0][1].getX().geteClass().getName());
		Assert.assertEquals("State", initialMatrix.getEntries()[0][1].getY().geteClass().getName());
		Assert.assertEquals(0.14, initialMatrix.getEntries()[0][1].getValue(), 0.01);
		
		Assert.assertEquals("StateMachine", initialMatrix.getEntries()[0][2].getX().geteClass().getName());
		Assert.assertEquals("Transition", initialMatrix.getEntries()[0][2].getY().geteClass().getName());
		Assert.assertEquals(0.14, initialMatrix.getEntries()[0][2].getValue(), 0.01);
		
		Assert.assertEquals("StateMachine", initialMatrix.getEntries()[0][3].getX().geteClass().getName());
		Assert.assertEquals("Statement", initialMatrix.getEntries()[0][3].getY().geteClass().getName());
		Assert.assertEquals(0, initialMatrix.getEntries()[0][3].getValue(), 0);
		
		Assert.assertEquals("StateMachine", initialMatrix.getEntries()[0][4].getX().geteClass().getName());
		Assert.assertEquals("Block", initialMatrix.getEntries()[0][4].getY().geteClass().getName());
		Assert.assertEquals(0, initialMatrix.getEntries()[0][4].getValue(), 0);
		
		Assert.assertEquals("StateMachine", initialMatrix.getEntries()[0][5].getX().geteClass().getName());
		Assert.assertEquals("Conditional", initialMatrix.getEntries()[0][5].getY().geteClass().getName());
		Assert.assertEquals(0, initialMatrix.getEntries()[0][5].getValue(), 0);
		
		Assert.assertEquals("StateMachine", initialMatrix.getEntries()[0][6].getX().geteClass().getName());
		Assert.assertEquals("Loop", initialMatrix.getEntries()[0][6].getY().geteClass().getName());
		Assert.assertEquals(0, initialMatrix.getEntries()[0][6].getValue(), 0);
	
		// Row y = 1; x >= 2
		Assert.assertEquals("State", initialMatrix.getEntries()[1][2].getX().geteClass().getName());
		Assert.assertEquals("Transition", initialMatrix.getEntries()[1][2].getY().geteClass().getName());
		Assert.assertEquals(0.28, initialMatrix.getEntries()[1][2].getValue(), 0.01);
		
		Assert.assertEquals("State", initialMatrix.getEntries()[1][3].getX().geteClass().getName());
		Assert.assertEquals("Statement", initialMatrix.getEntries()[1][3].getY().geteClass().getName());
		Assert.assertEquals(0, initialMatrix.getEntries()[1][3].getValue(), 0);
		
		Assert.assertEquals("State", initialMatrix.getEntries()[1][4].getX().geteClass().getName());
		Assert.assertEquals("Block", initialMatrix.getEntries()[1][4].getY().geteClass().getName());
		Assert.assertEquals(0.07, initialMatrix.getEntries()[1][4].getValue(), 0.01);
		
		Assert.assertEquals("State", initialMatrix.getEntries()[1][5].getX().geteClass().getName());
		Assert.assertEquals("Conditional", initialMatrix.getEntries()[1][5].getY().geteClass().getName());
		Assert.assertEquals(0, initialMatrix.getEntries()[1][5].getValue(), 0);
		
		Assert.assertEquals("State", initialMatrix.getEntries()[1][6].getX().geteClass().getName());
		Assert.assertEquals("Loop", initialMatrix.getEntries()[1][6].getY().geteClass().getName());
		Assert.assertEquals(0, initialMatrix.getEntries()[1][6].getValue(), 0);
		
		// Row y = 2; x >= 3
		Assert.assertEquals("Transition", initialMatrix.getEntries()[2][3].getX().geteClass().getName());
		Assert.assertEquals("Statement", initialMatrix.getEntries()[2][3].getY().geteClass().getName());
		Assert.assertEquals(0, initialMatrix.getEntries()[2][3].getValue(), 0);
		
		Assert.assertEquals("Transition", initialMatrix.getEntries()[2][4].getX().geteClass().getName());
		Assert.assertEquals("Block", initialMatrix.getEntries()[2][4].getY().geteClass().getName());
		Assert.assertEquals(0, initialMatrix.getEntries()[2][4].getValue(), 0);
		
		Assert.assertEquals("Transition", initialMatrix.getEntries()[2][5].getX().geteClass().getName());
		Assert.assertEquals("Conditional", initialMatrix.getEntries()[2][5].getY().geteClass().getName());
		Assert.assertEquals(0, initialMatrix.getEntries()[2][5].getValue(), 0);
		
		Assert.assertEquals("Transition", initialMatrix.getEntries()[2][6].getX().geteClass().getName());
		Assert.assertEquals("Loop", initialMatrix.getEntries()[2][6].getY().geteClass().getName());
		Assert.assertEquals(0, initialMatrix.getEntries()[2][6].getValue(), 0);
		
		// Row y = 3; x >= 4
		Assert.assertEquals("Statement", initialMatrix.getEntries()[3][4].getX().geteClass().getName());
		Assert.assertEquals("Block", initialMatrix.getEntries()[3][4].getY().geteClass().getName());
		Assert.assertEquals(0.07, initialMatrix.getEntries()[3][4].getValue(), 0.01);
		
		Assert.assertEquals("Statement", initialMatrix.getEntries()[3][5].getX().geteClass().getName());
		Assert.assertEquals("Conditional", initialMatrix.getEntries()[3][5].getY().geteClass().getName());
		Assert.assertEquals(0.07, initialMatrix.getEntries()[3][5].getValue(), 0.01);
		
		Assert.assertEquals("Statement", initialMatrix.getEntries()[3][6].getX().geteClass().getName());
		Assert.assertEquals("Loop", initialMatrix.getEntries()[3][6].getY().geteClass().getName());
		Assert.assertEquals(0.07, initialMatrix.getEntries()[3][6].getValue(), 0.01);
		
		// Row y = 4; x >= 5
		Assert.assertEquals("Block", initialMatrix.getEntries()[4][5].getX().geteClass().getName());
		Assert.assertEquals("Conditional", initialMatrix.getEntries()[4][5].getY().geteClass().getName());
		Assert.assertEquals(0.07, initialMatrix.getEntries()[4][5].getValue(), 0.01);
		
		Assert.assertEquals("Block", initialMatrix.getEntries()[4][6].getX().geteClass().getName());
		Assert.assertEquals("Loop", initialMatrix.getEntries()[4][6].getY().geteClass().getName());
		Assert.assertEquals(0.07, initialMatrix.getEntries()[4][6].getValue(), 0.01);
		
		// Row y = 5; x >= 6
		Assert.assertEquals("Conditional", initialMatrix.getEntries()[5][6].getX().geteClass().getName());
		Assert.assertEquals("Loop", initialMatrix.getEntries()[5][6].getY().geteClass().getName());
		Assert.assertEquals(0, initialMatrix.getEntries()[5][6].getValue(), 0);
	}
	
	@Test
	public void testFindBiggerEntry(){
		double[][] metricsMatrix = PairwiseCohesionMatrix.computePairwiseCohesionMatrix(metaclasses);
		HCMatrix initialMatrix = hcCalculator.buildInitialHCMatrixFromMetrixMatrix(metricsMatrix, metaclasses);
		HCMatrixEntry biggerEntry = hcCalculator.findBiggerEntry(initialMatrix.getEntries());
		
		Assert.assertEquals(0.28, biggerEntry.getValue(), 0.01);
		Assert.assertEquals("State", biggerEntry.getX().geteClass().getName());
		Assert.assertEquals("Transition", biggerEntry.getY().geteClass().getName());
	}
	
	@Test
	public void testUpdateHCTreeWithEntry(){
		double[][] metricsMatrix = PairwiseCohesionMatrix.computePairwiseCohesionMatrix(metaclasses);
		hcCalculator.computeHCTree(metricsMatrix, metaclasses);
		
		HCTree currentTree = hcCalculator.getTree();
		Assert.assertEquals(3, currentTree.getNodes().size(), 0);
		
		HCTreeNode stateNode = currentTree.findNodeByIdentifier("State");
		Assert.assertNotNull(stateNode);
		HCTreeNode transitionNode = currentTree.findNodeByIdentifier("Transition");
		Assert.assertNotNull(transitionNode);
		HCTreeNode stateTransitionNode = currentTree.findNodeByIdentifier("(State,Transition)");
		Assert.assertNotNull(stateTransitionNode);
		
		Assert.assertEquals(stateNode, stateTransitionNode.getLeftChild());
		Assert.assertEquals(transitionNode, stateTransitionNode.getRightChild());
	}
}