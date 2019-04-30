package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class IntermediateCode {
	public int uniqId;
	private static int staticUniqId;

	public IntermediateCode() {
		this.uniqId = IntermediateCode.staticUniqId++;
	}

	// Transforme l'arbre pour éliminer les ESEQ locaux
	public void canonicalTransformation() {
		//We need that to use intermediate code for labelLocation
		return;
	}

	protected abstract void toDot(StringBuffer stringBuffer);

	protected String toDotNodeName() {
		return getClass().getSimpleName();
	}

	public final void toDot(String file) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write("digraph Stree {\n");
			StringBuffer str = new StringBuffer();
			toDot(str);
			out.write(str.toString());
			out.write("}\n");
			out.close();
		} catch (IOException e) {
			System.err.println("ERROR: build dot");
		}
	}
}
