package ubordeaux.deptinfo.compilation.project.main.abstractTree;
import beaver.Symbol;
import ubordeaux.deptinfo.compilation.project.environment.EnvironmentInt;

/**
 * Implementation of an abstract tree capable of evaluating itself
 *
 * @author Lionel CLÉMENT
 */
public abstract class AbstTree extends Symbol implements AbstTreeInt {

	protected AbstTree left;
	protected AbstTree right;
	protected Double value;

	public AbstTree(AbstTree left, AbstTree right) {
		super();
		this.left = left;
		this.right = right;
	}

	public AbstTree(AbstTree left) {
		super();
		this.left = left;
	}

	public AbstTree() {
		super();
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double val) {
		value = val;
	}

	public String toString() {
		if (left != null)
			if (right != null)
				return this.getClass().getSimpleName() + "(" + left.toString() + "," + right.toString() + ")";
			else
				return this.getClass().getSimpleName() + "(" + left.toString() + ")";
		else
			return this.getClass().getSimpleName();
	}

	public void eval(EnvironmentInt environment) throws Exception {System.out.println("Eval:" + toString()); this.peval(environment);};
	
	abstract public void peval(EnvironmentInt environment) throws Exception;
}
