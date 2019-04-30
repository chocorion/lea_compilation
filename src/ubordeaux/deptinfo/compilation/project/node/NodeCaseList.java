package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;

public final class NodeCaseList extends Node {

	public NodeCaseList() {
		super();
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeCaseList clone() {
		return new NodeCaseList();
	}

	private Stm generateCodeRec(int index, ArrayList<NodeStm> l, int size) {
		if (index == size - 1) {
			return (Stm) l.get(size - 1).generateIntermediateCode();
		}

		return new Seq(
			(Stm)l.get(index).generateIntermediateCode(),
			generateCodeRec(index - 1, l, size);
		)
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		int size = this.elts.size();

		if (size == 0) {
			return null;
		}
		
		return generateCodeRec(0, (ArrayList<NodeStm>)this.elts, size);
	}

}
