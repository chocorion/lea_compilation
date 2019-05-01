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
		Exp exp = (Exp) this.getExpNode().generateIntermediateCode();
		Stm then_stm = (Stm) this.getThenNode().generateIntermediateCode();
		Stm else_stm = null;

		if (this.getElseNode() != null) {
			else_stm = (Stm) this.getElseNode().generateIntermediateCode();
		}

		LabelLocation then_L = new LabelLocation();
		LabelLocation else_L = (else_stm == null)? null : new LabelLocation();
		LabelLocation end_L = new LabelLocation();

		int value = -1;

		NodeRel nodeRel = (NodeRel)getExpNode();

		switch(nodeRel.getName()) {
			case "EQ" :  
				value = 0;
				break;

			case "NE" :  
				value = 1;
				break;

			case "LT" :  
				value = 2;
				break;

			case "GT" :  
				value = 3;
				break;

			case "LE" :  
				value = 4;
				break;

			case "GE" :  
				value = 5;
				break;
		}

		nodeRel.getOp1().generateIntermediateCode();
		nodeRel.getOp2().generateIntermediateCode();
		Cjump cjump = new Cjump(
			value,
			((NodeExp) nodeRel.getOp1()).getExp(),
			((NodeExp) nodeRel.getOp2()).getExp(),
			then_L,
			else_L
		);

		Stm endStm;
		Label end = new Label(end_L);
		if (this.getElseNode() == null) {
			endStm = end;
		} else {
			endStm = new Seq(
				new Label(else_L),
				else_stm
			);
		}

		return 
			new Seq(
				new Seq(
					cjump,
					new Seq(
						new Seq(
							new Seq(
								new Label(then_L),
								then_stm
							),
							new Jump(end_L)
						),
						endStm
					)
				),
				end
			);
	}
}
