package nodes;

import java.util.Scanner;

public class ReadNode extends SyntaxTreeNode {

	String variable;
	
	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	@Override
	public Object execute(Context context) {
		Scanner s = new Scanner(System.in);
		context.getVars().put(variable, s.nextDouble());
		return null;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "read " + variable;
	}

}
