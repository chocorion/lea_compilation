package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.type.Type;
import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public abstract class NodeStm extends Node {

	protected Type type;
	protected StmList stm;

	public NodeStm(Node... abstTrees) {
		super(abstTrees);
		this.stm = new StmList(null);
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type t) {
		this.type = t;
	}

	public StmList getStm() {
		return this.stm;
	}

	

}