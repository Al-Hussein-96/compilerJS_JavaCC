package nodes;

public class VariableNode extends ExpressionNode {

	String name;

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Object execute(Context context) {
		if (context.getVars().containsKey(name))
			return context.getVars().get(name);
		else
		{
			System.out.println("Use of undefined " + name + " assuming 0");
			context.getVars().put(name, 0.0);
			return 0.0;
		}
		
	}
	
}
