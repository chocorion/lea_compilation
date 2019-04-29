package ubordeaux.deptinfo.compilation.project.node;

public final class NodeCaseList extends NodeStm {

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

	@Override
	public void generateIntermediateCode() {
		for (NodeStm n : (ArrayList<NodeStm>)this.elts) {
			n.generateIntermediateCode();

			this.stm.add(n.getStm());
		}
	}

}
