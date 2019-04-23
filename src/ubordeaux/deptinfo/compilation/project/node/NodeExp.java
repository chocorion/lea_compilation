package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.type.Type;

public abstract class NodeExp extends Node {

	protected Type type;

	public NodeExp(Node... abstTrees) {
		super(abstTrees);
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type t) {
		this.type = t;
	}

}
