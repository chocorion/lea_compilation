package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class ExpList implements IntermediateCode {
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

}
