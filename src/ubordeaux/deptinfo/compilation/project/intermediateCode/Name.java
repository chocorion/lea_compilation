package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Name extends Exp {
	private LabelLocation label;

	public Name(LabelLocation label) {
		super();
		this.label = label;
	}

	@Override
	public String toString() {
		return "Name(" + this.label + ")";
	}

	protected void toDot(StringBuffer stringBuffer) {
		stringBuffer.append("node_" + this.uniqId + " [shape=\"ellipse\", label=\"" + toDotNodeName() + "\"];\n");

		label.toDot(stringBuffer);
		stringBuffer.append("node_" + this.uniqId + " -> node_" + label.uniqId + ";\n");
	}
}
