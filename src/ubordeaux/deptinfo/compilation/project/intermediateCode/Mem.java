package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mem extends Exp {
	private Exp exp;

	public Mem(Exp exp) {
		super();
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "Mem(" + this.exp + ")";
	}

	protected void toDot(StringBuffer stringBuffer) {
		stringBuffer.append("node_" + this.uniqId + " [shape=\"ellipse\", label=\"" + toDotNodeName() + "\"];\n");

		exp.toDot(stringBuffer);
		stringBuffer.append("node_" + this.uniqId + " -> node_" + exp.uniqId + ";\n");
	}
}
