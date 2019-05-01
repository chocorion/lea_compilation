package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public final class NodeWhile extends Node {

	public NodeWhile(Node boolExpr, Node stm) {
		super(boolExpr, stm);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		if (!get(0).checksType())
			return false;
		if (!get(1).checksType())
			return false;
		return true;
	}

	@Override
	public NodeWhile clone() {
		return new NodeWhile((Node) this.getExp().clone(), (Node) this.getStm().clone());
	}

	private Node getStm() {
		return this.get(1);
	}

	private Node getExp() {
		return this.get(0);
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		

		LabelLocation endLocation = new LabelLocation();
		LabelLocation beginLocation = new LabelLocation();
		LabelLocation whileTestLocation = new LabelLocation();

		Label end = new Label(endLocation);
		Label begin = new Label(beginLocation);
		Label whileTest = new Label(whileTestLocation);

		NodeRel nodeRel = (NodeRel) this.getExp();
		Stm whileStm = (Stm) this.getStm().generateIntermediateCode();

		int value = -1;

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
			nodeRel.getOp1().getExp(),
			nodeRel.getOp2().getExp(),
			beginLocation,
			endLocation
		);

		Jump jump = new Jump(whileTestLocation);
		
		return new Seq(
			new Seq(
				new Seq(
					whileTest,
					cjump
				),
				new Seq(
					begin,
					new Seq(
						whileStm,
						jump
					)
				)
			),
			end
		);
	}

}
