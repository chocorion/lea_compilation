package ubordeaux.deptinfo.compilation.project.environment;

import java.util.*;
import ubordeaux.deptinfo.compilation.project.type.*;

/**
 * Implementation of an emulated environment with variables
 *
 * @author Lionel CLÉMENT
 */
public class StackEnvironment {

    private String name;
    private ArrayList<HashMap<String, Type>> stack;
    private int stackSize;

    public StackEnvironment(String name) {
        this.name = name;
        this.stackSize = 0;
        this.stack = new ArrayList<>();
    }

    public StackEnvironment() {
        this("default");
    }

    public void pushLevel() {
        this.stack.add(new HashMap<>());
        this.stackSize++;
    }

    public void popLevel() {
        this.stack.remove(0);
        this.stackSize--;
    }

    public void putVariable(String variable, Type type) {
        stack.get(0).put(variable, type);
    }

    public Type getVariable(String variable) {
        Type ret;
        for (int i = 0; i < stackSize; i++) {
            ret = stack.get(i).get(variable);
            if (ret != null) {
                return ret;
            }
        }

        return null;
    }
}
