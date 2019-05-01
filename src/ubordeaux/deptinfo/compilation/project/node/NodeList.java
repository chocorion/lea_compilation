package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
import java.util.Iterator;
import java.util.ArrayList;

public final class NodeList extends Node {

	public NodeList(Node stm) {
		super(stm);
	}

	public NodeList() {
		super();
	}

	@Override
	public boolean checksType() {
		super.checksType();
		boolean result = true;
		for (Node elt : this.elts) {
			if (elt != null && !elt.checksType()) {
				result = false;
				break;
			}
		}
		return result;
	}

	public Iterator<Node> iterator() {
		return this.elts.iterator();
	}

	public int size() {
		return this.elts.size();
	}

	@Override
	public NodeList clone() {
		NodeList node = new NodeList();
		for (Node elt : this.elts) {
			node.add((Node) elt.clone());
		}
		return node;
	}


	private Stm generateSeqRec(ArrayList<Node> l, int index) {
		Stm current = (Stm)(l.get(index).generateIntermediateCode());
		
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
