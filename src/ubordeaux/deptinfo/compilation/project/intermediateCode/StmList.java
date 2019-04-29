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
}
