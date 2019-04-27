package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.type.TypeBoolean;
import ubordeaux.deptinfo.compilation.project.type.TypeInt;
import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public class NodeRel extends NodeExp {

	protected String name;

	// Relation binaire
	// f : E X F -> {0,1}
	public NodeRel(String name, Node op1, Node op2) {
		super(op1, op2);
		this.name = name;
		this.type = new TypeBoolean();
	}

	@Override
	public boolean checksType() {
		super.checksType();
		if ((!(this.getOp1().getType() instanceof TypeInt)) || (!(this.getOp2().getType() instanceof TypeInt))){
			System.out.println("Erreur de typage dans NodeRel !");
			return false;
		}
		return true;
	}

	private NodeExp getOp1() {
		return (NodeExp) this.get(0);
	};

	private NodeExp getOp2() {
		return (NodeExp) this.get(1);
	}

	@Override
	public NodeRel clone() {
		return new NodeRel(name, (Node) getOp1().clone(), (Node) getOp2().clone());
	};

	@Override
	public void generateIntermediateCode() {
		int value = -1;
		switch (this.name) {
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
		getLhs().generateIntermediateCode();
		getRhs().generateIntermediateCode();

		Binop binop = new Binop(value, getLhs().getExp(), getRhs().getExp());
		super.exp = binop;
	}

}
