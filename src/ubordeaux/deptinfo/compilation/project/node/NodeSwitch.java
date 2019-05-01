package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public final class NodeSwitch extends Node {

	public NodeSwitch(Node e, Node stm) {
		super(e, stm);
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
	public NodeSwitch clone() {
		return new NodeSwitch((Node) this.getExp().clone(), (Node) this.getStm().clone());
	}

	private Node getStm() {
		return this.get(1);
	}

	private Node getExp() {
		return this.get(0);
	}

	private Seq generateRec(Seq seq, LabelLocation endLocation, LabelLocationList labelList) {
		if (seq.getRight() instanceof Seq) {

			labelList.Add(((Label)((Seq)(seq.getLeft())).getLeft()).getLabelLocation());
			return new Seq(
				new Seq(
					seq.getLeft(),
					new Jump(endLocation)
				),
				this.generateRec((Seq)seq.getRight(), endLocation, labelList)
			);
		}

		return new Seq(
			seq,
			new Label(endLocation)
		);
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		this.getExp().generateIntermediateCode();
		Exp exp = ((NodeExp) this.getExp()).getExp();
		Seq caseList = (Seq) this.getStm().generateIntermediateCode();

		LabelLocation endLocation = new LabelLocation();
		LabelLocationList labelList = new LabelLocationList(null, null);

		return new Seq(
			new Jump(exp, labelList),
			this.generateRec(caseList, endLocation, labelList)
		);
	}
}
