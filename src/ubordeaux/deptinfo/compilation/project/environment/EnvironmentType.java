package ubordeaux.deptinfo.compilation.project.environment;

import java.util.HashMap;
import java.util.Map;
import ubordeaux.deptinfo.compilation.project.type.*;

/**
 * Implementation of an emulated environment to link variables with their type
 *
 * @author Adrien Boitelle
 */
public class EnvironmentType implements EnvironmentInt {

    private String name;
    private Map<String, Type> table;

    public EnvironmentType(String name) {
        this.name = name;
        this.table = new HashMap<>();
    }

    public EnvironmentType() {
        this("default");
    }

    public void putVariable(String variable, Type value) {
        table.put(variable, value);
    }

    public Type getVariableValue(String variable) {
        return table.get(variable);
    }

}
