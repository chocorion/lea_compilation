package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Call extends Exp {
	private Exp func;
	private ExpList args;

	public Call(Exp func, ExpList args) {
		super();
		this.func = func;
		this.args = args;
	}

	@Override
	public String toString() {
		String ret = this.getClass().getSimpleName();
		ret += "( " + this.func + ", " + this.args + ")";
		return ret;
	}

	protected void toDot(StringBuffer stringBuffer) {
		stringBuffer.append("node_" + this.uniqId + " [shape=\"ellipse\", label=\"" + toDotNodeName() + "\"];\n");

		func.toDot(stringBuffer);
		stringBuffer.append("node_" + this.uniqId + " -> node_" + func.uniqId + ";\n");

		args.toDot(stringBuffer);
		stringBuffer.append("node_" + this.uniqId + " -> node_" + args.uniqId + ";\n");
		
	}
}
