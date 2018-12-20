package nodes;

public class AssignNode extends SyntaxTreeNode {

	String variable;
	
	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	@Override
	public Object execute(Context context) {
		// TODO Auto-generated method stub
		context.getVars().put(variable, (Double)children.get(0).execute(context));
		return null;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return variable + "=";
	}

}
