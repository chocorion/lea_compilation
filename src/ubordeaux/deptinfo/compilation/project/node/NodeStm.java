package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.type.Type;
import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public abstract class NodeStm extends Node {

	protected Type type;
	protected Stm stm;

	public NodeStm(Node... abstTrees) {
		super(abstTrees);
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type t) {
		this.type = t;
	}

	public Stm getStm() {
		return this.stm;
	}

	public NodeExp getLhs() {
		return (NodeExp) this.get(0);
	};

	public NodeExp getRhs() {
		return (NodeExp) this.get(1);
	}

}