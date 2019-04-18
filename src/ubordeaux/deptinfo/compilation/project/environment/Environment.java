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
    private Map<String, Double> table;

    public Environment(String name) {
        this.name = name;
        this.table = new HashMap<String, Double>();
    }

    public Environment() {
        this("default");
    }

    @Override
    public void putVariable(String variable, Double value) {
        table.put(variable, value);
    }

    @Override
    public Double getVariableValue(String variable) {
        return table.get(variable);
    }

}
