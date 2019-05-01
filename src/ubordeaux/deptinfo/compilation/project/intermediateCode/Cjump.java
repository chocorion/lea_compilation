package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cjump extends Stm {
	private int relop;
	private Exp left, right;
	private LabelLocation iftrue, iffalse;

	public Cjump(int relop, Exp left, Exp right, LabelLocation iftrue, LabelLocation iffalse) {
		super();
		this.relop = relop;
		this.left = left;
		this.right = right;
		this.iftrue = iftrue;
		this.iffalse = iffalse;
	}

	public final static int EQ = 0, NE = 1, LT = 2, GT = 3, LE = 4, GE = 5, ULT = 6, ULE = 7, UGT = 8, UGE = 9;

	public static int notRel(int relop) {
		switch (relop) {
		case EQ:
			return NE;
		case NE:
			return EQ;
		case LT:
			return GE;
		case GE:
			return LT;
		case GT:
			return LE;
		case LE:
			return GT;
		case ULT:
			return UGE;
		case UGE:
			return ULT;
		case UGT:
			return ULE;
		case ULE:
			return UGT;
		default:
			throw new Error("bad relop in CJUMP.notRel");
		}
	}

	@Override
	public String toString() {
		return "CJump(" + left + " " + relop + " " + right + ", " + iftrue + ", " + iffalse + ")";
	}

	protected void toDot(StringBuffer stringBuffer) {
		stringBuffer.append("node_" + this.uniqId + " [shape=\"ellipse\", label=\"" + toDotNodeName() + "\"];\n");
		
		left.toDot(stringBuffer);
		stringBuffer.append("node_" + this.uniqId + " -> node_" + left.uniqId + ";\n");

		right.toDot(stringBuffer);
		stringBuffer.append("node_" + this.uniqId + " -> node_" + right.uniqId + ";\n");
		
		iftrue.toDot(stringBuffer);
		stringBuffer.append("node_" + this.uniqId + " -> node_" + iftrue.uniqId + ";\n");
		
		if (iffalse != null) {
			iffalse.toDot(stringBuffer);
			stringBuffer.append("node_" + this.uniqId + " -> node_" + iffalse.uniqId + ";\n");
		}

		
	}
}
