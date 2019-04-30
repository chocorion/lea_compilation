package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Move extends Stm {
	private Exp dst, src;

	public Move(Exp dst, Exp src) {
		super();
		this.dst = dst;
		this.src = src;
	}

	@Override
	public String toString() {
		return "Move(" + dst + ", " + src + ")";
	}

	protected void toDot(StringBuffer stringBuffer) {
		stringBuffer.append("node_" + this.uniqId + " [shape=\"ellipse\", label=\"" + toDotNodeName() + "\"];\n");

		dst.toDot(stringBuffer);
		stringBuffer.append("node_" + this.uniqId + " -> node_" + dst.uniqId + ";\n");

		src.toDot(stringBuffer);
		stringBuffer.append("node_" + this.uniqId + " -> node_" + src.uniqId + ";\n");
	}

}
