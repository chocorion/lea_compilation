package ubordeaux.deptinfo.compilation.project.node;

import java.util.Iterator;
import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
import ubordeaux.deptinfo.compilation.project.type.TypeFeature;
import ubordeaux.deptinfo.compilation.project.type.TypeFunct;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Call;
import ubordeaux.deptinfo.compilation.project.intermediateCode.ExpList;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;
import ubordeaux.deptinfo.compilation.project.type.Type;

public final class NodeCallFct extends NodeExp {

	protected String name;

	// Application
	// (f : E1 x E2 ... x Ek -> F), (arg1, arg2, ..., argk)
	public NodeCallFct(String name, TypeFunct type, NodeList args) {
		super(args);
		this.name = name;
		this.type = type;
	}

	// Application
	// (f : E1 x E2 ... x Ek -> F), (arg1, arg2, ..., argk)
	public NodeCallFct(String name, TypeFunct type) {
		super();
		this.name = name;
		this.type = type;
	}

	public Type getType() {
		return ((TypeFunct) this.type).getRet();
	}

	public String toString() {
		return name + '_' + super.toString();
	}

	// On parcourt les arguments et on vérifie qu'ils sont bien typés
	// On parcourt aussi les paramètres de la fonction
	// et on regarde que les types sont égaux
	public boolean checksType() {
		super.checksType();
		boolean result = true;
		Iterator<Node> itArgs = this.getArgs().iterator();
		Iterator<Type> itParams = ((TypeFunct) type).getParams().iterator();
		while (itArgs.hasNext() && itParams.hasNext()) {
			NodeExp arg = (NodeExp) itArgs.next();
			if (!arg.checksType()) {
				result = false;
				break;
			}
			Type argType = arg.getType();
			// chaque paramètre est une feature nom : type
			Type paramType = ((TypeFeature) itParams.next()).getType();

			
			if (!paramType.equals(argType)) {
				//System.out.println("IN NODE CALL FUNCTION -> " + (TypeFeature) argType.getType());
				//System.err.println("*** Erreur de typage " + argType + " != " + paramType);
				result = false;
				break;
			}
			//System.out.println("GRAMMAR ArgType -> " + argType);
			//System.out.println("GRAMMAR paramType -> " + paramType);
		}
		// Plus ou moins d'arguments que de paramètres
		if (result && (itArgs.hasNext() || itParams.hasNext())) {
			System.err.println("*** Erreur de typage: pas le même nombre de paramètres ");
			return false;
		}
		return result;
	}

	private NodeList getArgs() {
		return (NodeList) elts.get(0);
	}

	@Override
	public NodeCallFct clone() {
		NodeCallFct node = new NodeCallFct(name, (TypeFunct) type);
		for (Node elt : this.elts) {
			node.add((Node) elt.clone());
		}
		return node;
	}
	
	@Override
	protected String toDotNodeName() {
		return "NodeCallFct " + name + "()";
	}

	@Override
	public void generateIntermediateCode() {
		Name func_name = new Name(new LabelLocation(this.name));
		ExpList args = new ExpList(null, null);

		for (int i = this.size(); i > 0; i--) {
			NodeExp fils = (NodeExp) this.get(i-1);
			fils.generateIntermediateCode();			
			args.Add(fils.getExp());
		}
		Call call = new Call(func_name, args);
		
		super.exp.add(call);
	}

}


