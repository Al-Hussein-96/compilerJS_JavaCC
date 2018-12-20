package nodes;

public class ConstantNode extends ExpressionNode {

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
