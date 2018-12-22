package nodes;

import java.util.HashMap;

public class Context {
	
	HashMap<String, Object> vars = new HashMap<>();
	HashMap<String, Integer> varsType = new HashMap<>();

	public HashMap<String, Object> getVars() {
		return vars;
	}
	
	public HashMap<String, Integer> getVarsType(){
		return varsType;
	}

}
