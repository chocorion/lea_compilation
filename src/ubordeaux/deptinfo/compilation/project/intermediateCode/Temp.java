package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Temp extends Exp {
	private TempValue temp;

	public Temp(TempValue temp) {
		super();
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "Temp(" + this.temp + ")";
	}

	protected void toDot(StringBuffer stringBuffer) {
		stringBuffer.append("node_" + this.uniqId + " [shape=\"ellipse\", label=\"" + toDotNodeName() + "\"];\n");

		temp.toDot(stringBuffer);
		stringBuffer.append("node_" + this.uniqId + " -> node_" + temp.uniqId + ";\n");

	}

}
