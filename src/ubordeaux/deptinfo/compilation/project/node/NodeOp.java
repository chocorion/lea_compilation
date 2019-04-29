package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Binop;
import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public class NodeOp extends NodeExp {

	protected String name;

	// Opération binaire
	// f : E X F -> F
	public NodeOp(String name, NodeExp op1, NodeExp op2) {
		super(op1, op2);
		this.name = name;
		// le type d'un opérateur 
		NodeExp exprFct = (NodeExp) this.get(1);
		type = exprFct.type;
	}

	public NodeOp(String name, NodeExp op) {
		super(op);
		this.name = name;
		// le type d'un opérateur 
		NodeExp exprFct = (NodeExp) this.get(0);
		type = exprFct.type;
	}
	
	@Override
	public boolean checksType() {
		super.checksType();
		if ((super.size() > 1) && getOp2()!=null && !this.getOp1().getType().equals(this.getOp2().getType()))
			return false;
		return true;
	}

	private NodeExp getOp1() {
		return (NodeExp) this.get(0);
	};
	
	private NodeExp getOp2() {
		return (NodeExp) this.get(1);
	}

	@Override
	public NodeOp clone() {
		if (this.size()==1)
			return new NodeOp(name, (NodeExp) getOp1().clone());
		else if (this.size()==2)
			return new NodeOp(name, (NodeExp) getOp1().clone(), (NodeExp) getOp2().clone());
		return null;
		};
	
	@Override
	public void generateIntermediateCode() {
		int value = -1;
		
		switch(this.name) {
			case "PLUS":
				value = 0;
				break;

			case "MINUS":
				value = 1;
				break;

			case "MUL":
				value = 2;
				break;
			
			case "DIV":
				value = 3;
				break;
			
			default:
				System.err.println("Error in generateIntermediateCode, unknow operator " + this.name);
		}
				
		getOp1().generateIntermediateCode();
		getOp2().generateIntermediateCode();


		super.exp.add(new Binop(value, getOp1().getExp(), getOp2().getExp()));
			
	}
}
