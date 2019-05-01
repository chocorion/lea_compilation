package ubordeaux.deptinfo.compilation.project.node;

import java.util.ArrayList;
import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

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

	private Stm generateSeqRec(ArrayList<Node> l, int index) {
		Stm current = (Stm) (l.get(index).generateIntermediateCode());

		if (index == l.size() - 1) {
			return current;
		}

		return new Seq(current, generateSeqRec(l, index + 1));
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		if (this.elts.size() == 0) {
			return null;
		}

		return this.generateSeqRec((ArrayList<Node>)this.elts, 0);
	}

}
