package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class LabelLocationList {
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
}
