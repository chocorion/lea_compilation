package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
import java.util.Iterator;

public final class NodeList extends NodeStm {

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

	@Override
	public void generateIntermediateCode() {
		Iterator<Node> it = this.iterator();
		NodeStm tmp;

		StmList stmList = new StmList(null, null);

		while (it.hasNext()) {
			tmp = (NodeStm)it.next();

			tmp.generateIntermediateCode();
			stmList.add(tmp.getStm());
		}

		//super.stm = stmList

	}

}
