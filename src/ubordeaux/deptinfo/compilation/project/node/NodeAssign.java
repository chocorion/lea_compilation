package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Move;
import ubordeaux.deptinfo.compilation.project.type.Type;
import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public final class NodeAssign extends Node {

	public NodeAssign(NodeExp lhs, NodeExp rhs) {
		super(lhs, rhs);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		if (!get(0).checksType())
			return false;
		if (!get(1).checksType())
			return false;
		Type lhsType = this.getLhs().getType();
		Type rhsType = this.getRhs().getType();
		if (lhsType == null || rhsType == null || !lhsType.equals(rhsType))
			return false;
		else
			return true;
	}

	@Override
	public NodeAssign clone() {
		return new NodeAssign((NodeExp) getLhs().clone(), (NodeExp) getRhs().clone());
	}

	public NodeExp getLhs() {
		return (NodeExp) this.get(0);
	}

	public NodeExp getRhs() {
		return (NodeExp) this.get(1);
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		getLhs().generateIntermediateCode();
		getRhs().generateIntermediateCode();
		Exp right = getRhs().getExp();
		Exp left = getLhs().getExp();

		return new Move(new Mem(left), right);
		

	}

}
