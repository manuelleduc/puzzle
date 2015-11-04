package fr.inria.diverse.puzzle.vmsynthesis.impl;

import java.util.ArrayList;

import vm.PBinaryExpression;
import vm.PBooleanExpression;
import vm.PFeatureRef;
import vm.PUnaryExpression;

public class LeftImplicationsGroup {

	private PBooleanExpression leftSide;
	
	private ArrayList<PBooleanExpression> rightSide;

	public LeftImplicationsGroup(PBooleanExpression leftSide) {
		super();
		this.leftSide = leftSide;
		this.rightSide = new ArrayList<PBooleanExpression>();
	}

	public PBooleanExpression getLeftSide() {
		return leftSide;
	}

	public void setLeftSide(PBooleanExpression leftSide) {
		this.leftSide = leftSide;
	}

	public ArrayList<PBooleanExpression> getRightSide() {
		return rightSide;
	}
	
	public String toString(){
		String rightSide = "";
		boolean first = true;
		for (PBooleanExpression expr : this.rightSide) {
			if(!first)
				rightSide += " and ";
			rightSide += this.stringRepresentation(expr);
			first = false;
		}
		return this.stringRepresentation(leftSide) + " implies " + rightSide;
	}
	
	private String stringRepresentation(PBooleanExpression expr){
		if(expr instanceof PBinaryExpression){
			PBinaryExpression exprBinary = (PBinaryExpression) expr;
			String operator = exprBinary.getOperator().getName();
			String leftSide = this.stringRepresentation(exprBinary.getLeft());
			String rightSide = this.stringRepresentation(exprBinary.getRight());
			return "( " + leftSide + " " + operator + " " + rightSide + " )";
		}
		else if(expr instanceof PUnaryExpression){
			PUnaryExpression exprUnary = (PUnaryExpression)expr;
			String operator = exprUnary.getOperator().getName();
			String expression = this.stringRepresentation(exprUnary.getExpr());
			return "( " + operator + " " + expression + " )";
		}
		else if(expr instanceof PFeatureRef){
			PFeatureRef exprFeatureRef = (PFeatureRef) expr;
			return exprFeatureRef.getRef().getName();
		}
		else{
			return null;
		}
	}

}