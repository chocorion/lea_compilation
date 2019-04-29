package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class StmList implements IntermediateCode{
	private Stm head;
	private StmList tail;

	public StmList(Stm head, StmList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}

	public StmList (Stm head) {
		this(head, null);
	}

	public void add(Stm stm) {
		this.tail = new StmList(this.head, this.tail);
		this.head = stm;
	}

	@Override
	public void canonicalTransformation() {
		// TODO Auto-generated method stub
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".canonicalTransformation()()");
	}

	public Stm getHead() {
		return this.head;
	}

	private Stm getRec(int index, StmList l) {
		if (index == 0) {
			if (l != null) {
				return l.getHead();
			} else {
				return null;
			}
		}

		return this.getRec(index - 1, this.tail);
	}

	public Stm get(int index) {
		if (index == 0) {
			return this.getHead();
		} else {
			return this.getRec(index - 1, this.tail);
		}
	}
}
