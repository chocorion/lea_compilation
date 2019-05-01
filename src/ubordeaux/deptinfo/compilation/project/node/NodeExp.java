package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.type.Type;
import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public abstract class NodeExp extends Node {

	protected Type type;
	protected Exp exp;

	public NodeExp(Node... abstTrees) {
		super(abstTrees);
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type t) {
		this.type = t;
	}

	public Exp getExp() {
		return this.exp;
	}


}
