package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExpList extends IntermediateCode {
	private Exp head;
	private ExpList tail;

	public ExpList(Exp head, ExpList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}

	public ExpList(Exp head) {
		this(head, null);
	}

	@Override
	public void canonicalTransformation() {
		// TODO Auto-generated method stub
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".canonicalTransformation()()");
	}

	public void Add (Exp elt) {
		this.tail = new ExpList(this.head, this.tail); 
		this.head = elt;
	}

	public Exp getHead() {
		return this.head;
	}

	private Exp getRec(int index, ExpList l) {
		if (index == 0) {
			if (l != null) {
				return l.getHead();
			} else {
				return null;
			}
		}

		return this.getRec(index - 1, this.tail);
	}

	public Exp get(int index) {
		if (index == 0) {
			return this.getHead();
		} else {
			return this.getRec(index - 1, this.tail);
		}
	}


	private String displayRec(ExpList l) {
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

	private ExpList getTail() {
		return this.tail;
	}

	@Override
	public String toString() {
		return "ExpList(" + this.displayRec(this) + ")";
	}

	protected void toDot(StringBuffer stringBuffer) {
		stringBuffer.append("node_" + this.uniqId + " [shape=\"ellipse\", label=\"" + toDotNodeName() + "\"];\n");
		
		if (head == null) {return;}
		head.toDot(stringBuffer);
		stringBuffer.append("node_" + this.uniqId + " -> node_" + head.uniqId + ";\n");
	
		ExpList tailCpy = tail;
		
		while (tailCpy != null) {
			if (tailCpy.getHead() != null) {
				stringBuffer.append("node_" + this.uniqId + " -> node_" + tailCpy.getHead().uniqId + ";\n");
			}

			tailCpy = tailCpy.getTail();
		}
	}

}
