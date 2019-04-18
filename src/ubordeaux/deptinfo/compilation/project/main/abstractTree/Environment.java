package abstractTree;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of an emulated environment with variables
 *
 * @author Lionel CLÉMENT
 */
public class Environment implements EnvironmentInt {

	private Map<String, Double> table;

	public Environment() {
		this.table = new HashMap<String, Double>();
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
