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
	public void generateIntermediateCode() {
		Exp exp = (Exp) this.getExpNode().generateIntermediateCode();
		Stm then_stm = (Stm) this.getThenNode().generateIntermediateCode();
		Stm else_stm = null;

		if (this.getElseNode != null) {
			else_stm = (Stm) elseNode.generateIntermediateCode();
		}

		Label then_L = new Label(new LabelLocation());
		Label else_L = (else_stm == null)? null : new Label(new LabelLocation());
		Label end_L = new Label(new LabelLocation());

		int value = -1;

		NodeRel nodeRel = (NodeRel)getExpNode();
		nodeRel.generateIntermediateCode();

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

		
		Cjump cjump = new Cjump(value, nodeRel.getOp1().getExp(), nodeRel.getOp2().getExp(), then_L, else_L);

		Stm endStm;
		if (elseNode == null) {
			endStm = end_L;
		} else {
			endStm = new Seq(
				new Seq(
					else_L,
					else_stm
				),
				end_L
			);
		}

		return 
			new Seq(
				new Seq(
					cjump,
					new Seq(
						new Seq(
							then_L,
							then_stm
						),
							endStm
					),
					end_L
				)
			);
	}
}
