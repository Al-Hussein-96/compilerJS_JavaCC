package nodes;

public class ExpressionNode extends SyntaxTreeNode {

	String operator;
	
	public ExpressionNode() {
		// TODO Auto-generated constructor stub
	}
	
	public ExpressionNode(String operator ,SyntaxTreeNode child1 , SyntaxTreeNode child2 )
	{
		this.operator = operator;
		children.add(child1);
		children.add(child2);
	}
	
	public ExpressionNode(String operator ,SyntaxTreeNode child1 , SyntaxTreeNode child2  , SyntaxTreeNode child3)
	{
		this.operator = operator;
		children.add(child1);
		children.add(child2);
		children.add(child3);
	}
	public String getOperator() {
		return operator;
	}


	public void setOperator(String operator) {
		this.operator = operator;
	}


	@Override
	public Object execute(Context context) {
		double d1 = (Double)children.get(0).execute(context);
		double d2 = (Double)children.get(1).execute(context);
		switch(operator) {
		case "+":
			return d1 + d2;
		case "-":
			return d1 - d2;
		case "*":
			return d1 * d2;
		case "/":
			return d1 / d2;
		case "%" : 
			return d1%d2;
		case "<<":
			return ((int)d1<<(int)d2);
		case ">>":
			return ((int)d1>>(int)d2);
		case ">>>":
			return ((int)d1>>>(int)d2);
		case "<":
			return (d1<d2);
		case ">":
			return (d1>d2);
		case "<=":
			return (d1<=d2);
		case ">=":
			return (d1>=d2);
		case "==":
			return (d1==d2);
		case "!=":
			return (d1!=d2);
		case "&":
			return ((int)d1&(int)d2);
		case "^":
			return ((int)d1^(int)d2);
		case "|":
			return ((int)d1|(int)d2);
		case "&&":
	//		return (d1&&d2);
		case "||":
	//		return (d1||d2);
		case "?":
			double d3 = (Double)children.get(2).execute(context);
	//		return (d1 ? d2 : d3);
		}
		return null;
	}


	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "Exp " + operator;
	}

}
