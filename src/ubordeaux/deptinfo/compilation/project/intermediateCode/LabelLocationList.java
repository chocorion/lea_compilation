package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LabelLocationList extends IntermediateCode {
	private LabelLocation head;
	private LabelLocationList tail;

	public LabelLocationList(LabelLocation head, LabelLocationList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}

	private String displayRec(LabelLocationList l) {
		if (l == null) {
			return "";
		}

		if (l.getHead() != null && l.getTail() != null) {
			return head + ", " + this.displayRec(l.getTail());
		} else if (l.getHead() != null) {
			return head.toString();
		}

		return "";

	}

	private LabelLocation getHead() {
		return this.head;
	}
	
	private LabelLocationList getTail() {
		return this.tail;
	}

	@Override
	public String toString() {
		return "LabelLocationList(" + this.displayRec(this) + ")";
	}

	protected void toDot(StringBuffer stringBuffer) {
		stringBuffer.append("node_" + this.uniqId + " [shape=\"ellipse\", label=\"" + toDotNodeName() + "\"];\n");

		if (head == null) {
			return;
		}
		head.toDot(stringBuffer);
		stringBuffer.append("node_" + this.uniqId + " -> node_" + head.uniqId + ";\n");

		LabelLocationList tailCpy = tail;

		while (tailCpy != null) {
			if (tailCpy.getHead() != null) {
				stringBuffer.append("node_" + this.uniqId + " -> node_" + tailCpy.getHead().uniqId + ";\n");
			}

			tailCpy = tailCpy.getTail();
		}
	}
}
