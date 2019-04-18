package ubordeaux.deptinfo.compilation.project.environment;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Implementation of an emulated environment with variables
 *
 * @author Lionel CLÉMENT
 */
public class StackEnvironment extends Environment {

    private String name;
    private Stack<Double> stack;

    public StackEnvironment(String name) {
        this.name = name;
        this.stack = new Stack<>();
    }

    public StackEnvironment() {
        this("default");
    }

}
