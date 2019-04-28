package ubordeaux.deptinfo.compilation.project.node;
import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public final class NodeReturn extends NodeExp {

	public NodeReturn(Node e) {
		super(e);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeReturn clone() {
		return new NodeReturn((Node) get(0).clone());
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		Exp ret =  (Exp)this.getLhs().generateIntermediateCode();

		//Je ne sais pas quoi mettre comme label,
		//Car return on prend le sommet de la pile et on jump à cette adresse
		return new Jump(ret, null);
	}

}
