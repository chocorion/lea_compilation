package ubordeaux.deptinfo.compilation.project.environment;

import java.util.HashMap;
import java.util.Map;
import ubordeaux.deptinfo.compilation.project.type.*;

/**
 * Implementation of an emulated environment with variables
 *
 * @author Lionel CLÉMENT
 */
public class Environment implements EnvironmentInt {

    private String name;
    private Map<String, Type> table;

    public Environment(String name) {
        this.name = name;
        this.table = new HashMap<>();
    }

    public Environment() {
        this("default");
    }

    @Override
    public void putVariable(String variable, Type value) {
        table.put(variable, value);
    }

    @Override
    public Type getVariableValue(String variable) {
        return table.get(variable);
    }

}
