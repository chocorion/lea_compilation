package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Binop extends Exp {
	private int binop;
	private Exp left, right;

	public Binop(int b, Exp l, Exp r) {
		super();
		binop = b;
		left = l;
		right = r;
	}

	public final static int PLUS = 0, MINUS = 1, MUL = 2, DIV = 3, AND = 4, OR = 5, LSHIFT = 6, RSHIFT = 7, ARSHIFT = 8,
			XOR = 9;

	@Override
	public String toString() {
		String ret = this.getClass().getSimpleName();
		
		ret += "(" + this.left;
		ret += " " + this.binop;
		ret += " " + this.right;
		ret += ")";

		return ret;
	}

	protected void toDot(StringBuffer stringBuffer) {
		stringBuffer.append("node_" + this.uniqId + " [shape=\"ellipse\", label=\"" + toDotNodeName() + "\"];\n");
		

		left.toDot(stringBuffer);
		stringBuffer.append("node_" + this.uniqId + " -> node_" + left.uniqId + ";\n");
			
		right.toDot(stringBuffer);
		stringBuffer.append("node_" + this.uniqId + " -> node_" + right.uniqId + ";\n");
	}

}
