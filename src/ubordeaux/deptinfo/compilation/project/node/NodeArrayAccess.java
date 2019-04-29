package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.type.TypeRange;
import ubordeaux.deptinfo.compilation.project.type.TypeItemEnum;
import ubordeaux.deptinfo.compilation.project.type.Type;
import ubordeaux.deptinfo.compilation.project.type.TypeArray;
import ubordeaux.deptinfo.compilation.project.type.TypeComplex;
import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public final class NodeArrayAccess extends NodeExp {

	// t [i]
	public NodeArrayAccess(NodeExp t, Node i) {
		super(t, i);
		if ((t!=null) && (((TypeComplex) t.type).size() == 2))
			type = ((TypeComplex) t.type).get(1);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		TypeArray typeArray = (TypeArray)((NodeExp)this.get(0)).getType();
		TypeRange typeRangeOREnum = typeArray.getRangeOREnum();
		Type typeArg = ((NodeExp)get(1)).getType();

				// Si l'index n'est pas du type attendu 
		if (typeArg.getClass() != typeRangeOREnum.getFirst().getClass()) {
			System.err.println("type de l'index incorrect, n'est pas du type attentdu !");
			System.err.println("Trouvé : " + typeArg.getClass());
			System.err.println("Attendu : " + typeRangeOREnum.getFirst().getClass());
			return false;
		}
		// Si l'index est un enum, mais pas le bon
		if ((typeArg instanceof TypeItemEnum)
				&& ((TypeItemEnum) typeArg).getRefEnumRange()  != ((TypeItemEnum) typeRangeOREnum.getFirst()).getRefEnumRange()) {
			System.err.println("type de l'index incorrect, enum mais pas le bon !");
			System.out.println(((TypeItemEnum) typeArg).getRefEnumRange());
			System.out.println(((TypeItemEnum) typeRangeOREnum.getFirst()).getRefEnumRange());
			return false;
		}		
		// Si la valeur constante de l'index depasse
		if ((typeArg.compareTo(typeRangeOREnum.getFirst()) < 0) 
			|| (typeArg.compareTo(((TypeRange) typeRangeOREnum).getLast()) > 0)) {
			System.err.println("index constant hors tableau");
			return false;
		}			
		return true;
	}

	@Override
	public NodeArrayAccess clone() {
		return new NodeArrayAccess((NodeExp) get(0).clone(), (Node) get(1).clone());
	}

	@Override
	public void generateIntermediateCode() {
		this.getLhs().generateIntermediateCode();;
		this.getRhs().generateIntermediateCode();;
		
		Exp left  = this.getLhs().getExp();
		Exp right = this.getRhs().getExp();

		//Peut-être qu'il faut multiplier ça par la taille des éléments du tableaux
		this.exp.add(new Mem(new Binop(0, left, right)));
	}

}
