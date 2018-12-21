package nodes;

public class ConstantNode extends ExpressionNode {

	public ConstantNode() {
		// TODO Auto-generated constructor stub
	}
	public ConstantNode(String operator, SyntaxTreeNode child1, SyntaxTreeNode child2) {
		super(operator, child1, child2);
		// TODO Auto-generated constructor stub
	}

	double value;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return value + "";
	}
	
	public Object execute(Context context) {
		return value;
	}
	
}
