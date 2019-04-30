package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Jump extends Stm {
	public Exp exp;
	public LabelLocationList targets;

	public Jump(Exp exp, LabelLocationList targets) {
		super();
		this.exp = exp;
		this.targets = targets;
	}

	public Jump(LabelLocation target) {
		this(new Name(target), new LabelLocationList(target, null));
	}

	@Override
	public String toString() {
		return "Jump(" + this.exp + ", "+ this.targets +")";
	}

	protected void toDot(StringBuffer stringBuffer) {
		stringBuffer.append("node_" + this.uniqId + " [shape=\"ellipse\", label=\"" + toDotNodeName() + "\"];\n");

		exp.toDot(stringBuffer);
		stringBuffer.append("node_" + this.uniqId + " -> node_" + exp.uniqId + ";\n");

		targets.toDot(stringBuffer);
		stringBuffer.append("node_" + this.uniqId + " -> node_" + targets.uniqId + ";\n");
	}

}
