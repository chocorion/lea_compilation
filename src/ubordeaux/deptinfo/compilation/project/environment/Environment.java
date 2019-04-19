package ubordeaux.deptinfo.compilation.project.environment;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of an emulated environment with variables
 *
 * @author Lionel CLÉMENT
 */
public class Environment implements EnvironmentInt {

    private String name;
    private Map<String, String> table;

    public Environment(String name) {
        this.name = name;
        this.table = new HashMap<>();
    }

    public Environment() {
        this("default");
    }

    @Override
    public void putVariable(String variable, String value) {
        table.put(variable, value);
    }

    @Override
    public String getVariableValue(String variable) {
        return table.get(variable);
    }

}
