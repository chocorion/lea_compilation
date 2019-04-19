package ubordeaux.deptinfo.compilation.project.environment;

/**
 * Defines the methods needed to interact with an emulated environment with variables
 *
 * @author Lionel CLÉMENT
 */
public interface EnvironmentInt {

	void putVariable(String var, String value);
	String getVariableValue(String variable);
}
