package nodes;

public class VariableNode extends ExpressionNode {

	public VariableNode() {
		// TODO Auto-generated constructor stub
	}
	public VariableNode(String operator, SyntaxTreeNode child1, SyntaxTreeNode child2) {
		super(operator, child1, child2);
		// TODO Auto-generated constructor stub
	}

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
