package ubordeaux.deptinfo.compilation.project.node;
import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public final class NodeReturn extends NodeExp {

	public NodeReturn(Node e) {
		super(e);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeReturn clone() {
		return new NodeReturn((Node) get(0).clone());
	}

	@Override
	public IntermediateCode generateIntermediateCode() {

		//Pour le moment car on ne sait pas si on doit utiliser un jump ici
		this.exp = null;
		return this.exp;
	}
}
