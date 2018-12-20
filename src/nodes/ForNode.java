package nodes;

public class ForNode extends SyntaxTreeNode {

	String variable;
	
	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	@Override
	public Object execute(Context context) {
		double v = (Double)children.get(0).execute(context);
		context.getVars().put(variable, v);
		while(true) {
			if ((Double)children.get(2).execute(context) > 0)
			{
				if (v > (Double)children.get(1).execute(context))
					break;
			}else {
				if (v < (Double)children.get(1).execute(context))
					break;
			}
			children.get(3).execute(context);
			v += (Double)children.get(2).execute(context);
			context.getVars().put(variable, v);
		}
		return null;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "For " + variable;
	}

}
