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

	public String getName() {
		return this.name;
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		//Normalement on ne passe jamais par ici, car nodeRel utilisé dans while,
		//Et c'est le code de while qui génère le CJUMP avec les bons labels

		//Sinon c'est qu'il faut rajouter la possibilité de faire des comparaisons dans BinOp
		return null;
	}

}
