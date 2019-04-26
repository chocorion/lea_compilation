package ubordeaux.deptinfo.compilation.project.environment;

import ubordeaux.deptinfo.compilation.project.type.Type;

/**
 * Defines the methods needed to interact with an emulated environment with
 * variables
 */
public interface EnvironmentInt {

	void putVariable(String variable, Type type);
	Type getVariableValue(String variable);
}
