package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Label extends Stm {
	private LabelLocation label;

	public Label(LabelLocation label) {
		super();
		this.label = label;
	}

	@Override
	public String toString() {
		return "Label(" + this.label + ")";
	}

	protected void toDot(StringBuffer stringBuffer) {
		stringBuffer.append("node_" + this.uniqId + " [shape=\"ellipse\", label=\"" + toDotNodeName() + "\"];\n");

		if (label != null) {
			label.toDot(stringBuffer);
			stringBuffer.append("node_" + this.uniqId + " -> node_" + label.uniqId + ";\n");
		}
	}
}
