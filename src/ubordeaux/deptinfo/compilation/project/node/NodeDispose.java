package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;

public final class NodeDispose extends Node {

	public NodeDispose(Node e) {
		super(e);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeDispose clone() {
		return new NodeDispose((Node) this.get(0).clone());
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		//Never use this
		return null;
	}

}
