package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Seq extends Stm {
	private Stm left, right;

	public Seq(Stm left, Stm right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		String ret = this.getClass().getSimpleName();
		ret += "(" + this.left + ", " + this.right + ")";
		return ret;
	}

	protected void toDot(StringBuffer stringBuffer) {
		stringBuffer.append("node_" + this.uniqId + " [shape=\"ellipse\", label=\"" + toDotNodeName() + "\"];\n");

		if (left != null) {
			left.toDot(stringBuffer);
			stringBuffer.append("node_" + this.uniqId + " -> node_" + left.uniqId + ";\n");
		}

		if (right != null) {
			right.toDot(stringBuffer);
			stringBuffer.append("node_" + this.uniqId + " -> node_" + right.uniqId + ";\n");
		}
	}
}
