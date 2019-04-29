package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.type.TypeBoolean;
import ubordeaux.deptinfo.compilation.project.type.TypeInt;

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

	public String getName() {
		return this.name;
	}

	public NodeExp getOp1() {
		return (NodeExp) this.get(0);
	};

	public NodeExp getOp2() {
		return (NodeExp) this.get(1);
	}

	@Override
	public NodeRel clone() {
		return new NodeRel(name, (Node) getOp1().clone(), (Node) getOp2().clone());
	};

	@Override
	public void generateIntermediateCode() {
		this.getOp1().generateIntermediateCode();
		this.getOp2().generateIntermediateCode();

		this.exp.add(this.getOp1().getExp());
		this.exp.add(this.getOp2().getExp());
	}

}
