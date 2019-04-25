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
        System.out.println("STACK pushing level...");
        
        this.stack.add(0, new HashMap<>());
        this.stackSize++;

        System.out.println("STACK\t\tSize : " + this.stackSize);
    }
    
    public void popLevel() {
        System.out.println("STACK poping level...");
        
        this.stack.remove(0);
        this.stackSize--;
        System.out.println("STACK\t\tSize : " + this.stackSize);
    }
    
    public void putVariable(String variable, Type type) {
        System.out.println("STACK Pushing variable " + variable + " on level " + this.stackSize);
        stack.get(0).put(variable, type);
    }
    
    
    public Type getVariableType(String variable, int index) {
        if (index > stackSize) {
            return null;
        }
        
        return stack.get(index).get(variable);
    }
    public Type getVariableType(String variable) {
        Type ret;
        System.out.println("STACK Stack search : " + variable + " on level " + this.stackSize);
        for (int i = 0; i < stackSize; i++) {
            ret = stack.get(i).get(variable);
            if (ret != null) {
                System.out.println("STACK Find ! " + ret);
                return ret;
            }
        }
        
        System.out.println("STACK Not Find...");
        return null;
    }
}
