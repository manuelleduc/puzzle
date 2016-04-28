package fr.inria.diverse.puzzle.metrics.auxiliarMetrics;

import java.util.List;

import org.eclipse.emf.ecore.EClass;

import fr.inria.diverse.puzzle.metrics.vos.HCMatrix;
import fr.inria.diverse.puzzle.metrics.vos.HCMatrixEntry;
import fr.inria.diverse.puzzle.metrics.vos.HCTree;
import fr.inria.diverse.puzzle.metrics.vos.HCTreeNode;

public class HCCalculator {

	// ----------------------------------------------
	// Attributes
	// ----------------------------------------------
	
	private HCTree tree;
	private HCMatrix hcMatrix;
	
	// ----------------------------------------------
	// Constructor
	// ----------------------------------------------
	
	public HCCalculator(){
		tree = new HCTree();
	}
	
	// ----------------------------------------------
	// Methods
	// ----------------------------------------------
	
	/**
	 * Computes the tree with the hierarchical analysis of the domains for the meta-classes in the parameter
	 * by using the matrix metrics also given in the parameter. 
	 * @param inputMatrix
	 * @param metaclasses
	 */
	public void computeHCTree(double[][] inputMatrix, List<EClass> metaclasses){
		hcMatrix = this.buildInitialHCMatrixFromMetrixMatrix(inputMatrix, metaclasses);
		HCMatrixEntry biggerEntry = this.findBiggerEntry(hcMatrix.getEntries());
		updateHCTreeWithEntry(biggerEntry);
		updateHCMatrix(biggerEntry);
	}
	
	/**
	 * Builds the initial HCMatrix from the metrics matrix on the parameter. 
	 * @param inputMatrix
	 * @return
	 */
	public HCMatrix buildInitialHCMatrixFromMetrixMatrix(double[][] inputMatrix, List<EClass> metaclasses){
		HCMatrix matrix = new HCMatrix();
		HCMatrixEntry[][] entryMatrix = new HCMatrixEntry[metaclasses.size()][metaclasses.size()];
		for (int x = 0; x < inputMatrix.length; x++) {
			for (int y = x + 1; y < inputMatrix.length; y++) {
				double value = inputMatrix[x][y];
				
				HCTreeNode xTreeNode = new HCTreeNode();
				xTreeNode.seteClass(metaclasses.get(x));
				xTreeNode.setIdentifier(metaclasses.get(x).getName());
				
				HCTreeNode yTreeNode = new HCTreeNode();
				yTreeNode.seteClass(metaclasses.get(y));
				yTreeNode.setIdentifier(metaclasses.get(y).getName());
				
				HCMatrixEntry entry = new HCMatrixEntry(xTreeNode, yTreeNode, value);
				entryMatrix[x][y] = entry;
			}
		}
		matrix.setEntries(entryMatrix);
		return matrix;
	}
	
	/**
	 * Returns the entry with the bigger value in the entries list given in the parameter. 
	 * @param entries
	 * @return
	 */
	public HCMatrixEntry findBiggerEntry(HCMatrixEntry[][] entries){
		HCMatrixEntry biggerEntry = null;
		double biggerValue = -1;
		
		for (int x = 0; x < entries.length; x++) {
			for (int y = x + 1; y < entries.length; y++) {
				if(entries[x][y].getValue() > biggerValue){
					biggerEntry = entries[x][y];
					biggerValue = entries[x][y].getValue();
				}
			}
		}
		return biggerEntry;
	}

	/**
	 * Updates the current hierarchical clustering tree with the new entry given in the parameter. 
	 * @param biggerEntry
	 */
	public void updateHCTreeWithEntry(HCMatrixEntry biggerEntry) {
		HCTreeNode xMatrixNode = biggerEntry.getX();
		HCTreeNode yMatrixNode = biggerEntry.getY();
		
		HCTreeNode  xTreeNode = this.tree.findNodeByIdentifier(xMatrixNode.getIdentifier());
		HCTreeNode  yTreeNode = this.tree.findNodeByIdentifier(yMatrixNode.getIdentifier());
		
		if(xTreeNode == null){
			xTreeNode = xMatrixNode;
			this.tree.getNodes().add(xTreeNode);
		}
		
		if(yTreeNode == null){
			yTreeNode = yMatrixNode;
			this.tree.getNodes().add(yMatrixNode);
		}
		
		HCTreeNode joinNode = new HCTreeNode();
		joinNode.setLeftChild(xTreeNode);
		joinNode.setRightChild(yTreeNode);
		joinNode.setIdentifier("(" + xTreeNode.getIdentifier() + "," + yTreeNode.getIdentifier() + ")");
		this.tree.getNodes().add(joinNode);
	}
	
	/**
	 * Updates the HCMatrix with the entry given in the parameter. 
	 * @param biggerEntry
	 */
	public void updateHCMatrix(HCMatrixEntry biggerEntry) {
		// TODO Auto-generated method stub
		
	}
	
	// ----------------------------------------------
	// Getters and setters
	// ----------------------------------------------
	
	public HCTree getTree() {
		return tree;
	}

	public void setTree(HCTree tree) {
		this.tree = tree;
	}
}