package ubordeaux.deptinfo.compilation.project.main.abstractTree;
import ubordeaux.deptinfo.compilation.project.environment.EnvironmentInt;
/**
 * Defines the methods needed to interact with an abstract tree that can be
 * evaluated in an environment
 *
 * @author Lionel CLÉMENT
 */
public interface AbstTreeInt {
	
	// Cette fonction évalue l'arbre en affichant ce qu'il fait
	void eval(EnvironmentInt environment) throws Exception;
	
	// Cette fonction renvoie une valeur associée au noeud de l'arbre
	Double getValue();
}
