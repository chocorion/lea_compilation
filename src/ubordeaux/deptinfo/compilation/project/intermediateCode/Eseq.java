package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Eseq extends Exp {
	private Stm stm;
	private Exp exp;

	public Eseq(Stm stm, Exp exp) {
		super();
		this.stm = stm;
		this.exp = exp;
	}

	protected void toDot(StringBuffer stringBuffer) {
		System.out.println("TODO TODOT");
		stringBuffer.append("node_" + this.uniqId + " [shape=\"ellipse\", label=\"" + toDotNodeName() + "\"];\n");
		//Pas utilisé
	}

}
