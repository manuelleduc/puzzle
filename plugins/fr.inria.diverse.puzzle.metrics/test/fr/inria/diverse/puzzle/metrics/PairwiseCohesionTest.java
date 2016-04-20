package fr.inria.diverse.puzzle.metrics;

import org.junit.Assert;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.junit.Before;
import org.junit.Test;

import fr.inria.diverse.puzzle.metrics.auxiliarMetrics.PairwiseCohesion;

public class PairwiseCohesionTest {

	// -------------------------------------------------
	// Scenarios
	// -------------------------------------------------
	
	private EClass x;
	private EClass y;
	
	// -------------------------------------------------
	// Scenarios' loading
	// -------------------------------------------------
	
	@Before
	public void setupScenario(){
		x = EcoreFactory.eINSTANCE.createEClass();
		x.setName("X");
		
		y = EcoreFactory.eINSTANCE.createEClass();
		y.setName("Y");
		
		EReference a = EcoreFactory.eINSTANCE.createEReference();
		a.setName("a");
		a.setEType(y);
		
		EReference b = EcoreFactory.eINSTANCE.createEReference();
		b.setName("b");
		b.setEType(x);
		
		x.getEStructuralFeatures().add(a);
		x.getEStructuralFeatures().add(b);
	}
	
	// -------------------------------------------------
	// Test cases
	// -------------------------------------------------
	
	@Test
	public void computePairwiseCohesionTest(){
		Assert.assertEquals(0.5, PairwiseCohesion.computePairwiseCohesion(x, y), 0);
	}
	
	@Test
	public void computeCrossReferencesTest(){
		Assert.assertEquals(1, PairwiseCohesion.computeCrossReferences(x, y), 0);
	}
	
	@Test
	public void countEReferencesTest(){
		Assert.assertEquals(2, PairwiseCohesion.countERerences(x), 0);
	}
}
