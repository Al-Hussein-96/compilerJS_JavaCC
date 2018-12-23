package nodes;

public class ConstantNode extends ExpressionNode {

	Object value;

	public ConstantNode(Object value) {
		// TODO Auto-generated constructor stub

		if (value instanceof String) { /// for remove " "
			String temp = (String) value;
			value = temp.substring(1, temp.length() - 1);
		}
		
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
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
