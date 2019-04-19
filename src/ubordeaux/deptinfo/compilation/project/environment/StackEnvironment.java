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

    @Override
    public void putVariable(String variable, String value) {
    }

    public void putVariable(String variable, Double value) {
        stack.push(value);
    }

    public Double getValueAt(int index) throws IndexOutOfBoundsException {
        // Allows to get a value in the stack (without popping, at a distance
        // relative to the head)
        int target = stack.size()-index-1;
        if(target <0) throw new IndexOutOfBoundsException("Reached end of stack");
        return stack.get(target);
    }

}
