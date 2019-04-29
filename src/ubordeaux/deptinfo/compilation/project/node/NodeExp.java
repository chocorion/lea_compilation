package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.type.Type;
import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public abstract class NodeExp extends Node {

	protected Type type;
	protected ExpList exp;

	public NodeExp(Node... abstTrees) {
		super(abstTrees);

		this.exp = new ExpList(null);
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type t) {
		this.type = t;
	}

	public ExpList getExp() {
		return this.exp;
	}


}
