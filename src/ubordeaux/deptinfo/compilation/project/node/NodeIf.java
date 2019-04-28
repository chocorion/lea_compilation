package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public final class NodeIf extends Node {

	public NodeIf(Node boolExp, Node stm) {
		super(boolExp, stm);
	}

	public NodeIf(Node e, Node stm1, Node stm2) {
		super(e, stm1, stm2);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeIf clone() {
		Node expNode = this.getExpNode();
		Node thenNode = this.getThenNode();
		Node elseNode = this.getElseNode();
		if (elseNode == null)
			return new NodeIf((Node) expNode.clone(), (Node) thenNode.clone());
		else
			return new NodeIf((Node) expNode, (Node) thenNode.clone(), (Node) elseNode.clone());
	}

	private Node getExpNode() {
		return this.get(0);
	}

	private Node getElseNode() {
		if (this.size() == 3)
			return this.get(2);
		else
			return null;
	}

	private Node getThenNode() {
		return this.get(1);
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		IntermediateCode exp = this.getExpNode().generateIntermediateCode();
		IntermediateCode thenCode = this.getThenNode().generateIntermediateCode();
		IntermediateCode elseCode = null;

		if (this.getElseNode() != null) {
			elseCode = this.getElseNode().generateIntermediateCode();
		}

		NodeRel rel = (NodeRel) this.getExpNode();
		Exp left  = (Exp) rel.getLhs().generateIntermediateCode();
		Exp right = (Exp) rel.getRhs().generateIntermediateCode(); 

		int value = -1;
		switch(rel.getName()) {
			case "EQ":
				value = 0;
				break;

			case "NE":
				value = 1;
				break;

			case "LT":
				value = 2;
				break;

			case "GT":
				value = 3;
				break;

			case "LE":
				value = 4;
				break;

			case "GE":
				value = 5;
				break;

			case "ULT":
				value = 6;
				break;

			case "ULE":
				value = 7;
				break;

			case "UGT":
				value = 8;
				break;

			case "UGE":
				value = 9;
				break;

		}

		//Récupérer les label location des if et else
		return new Cjump(value, left, right, new LabelLocation(), new LabelLocation());
	}
}
