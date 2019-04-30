package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;
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
	public IntermediateCode generateIntermediateCode() {
		Exp left =  (Exp) this.getOp1().generateIntermediateCode();
		Exp right = (Exp) this.getOp2().generateIntermediateCode();

		//Null pour le moment, car on ne sait pas trop si on doit utiliser Binop avec MINUS
		return null;
	}

}
