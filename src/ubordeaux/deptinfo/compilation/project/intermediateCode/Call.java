package ubordeaux.deptinfo.compilation.project.intermediateCode;

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

}
