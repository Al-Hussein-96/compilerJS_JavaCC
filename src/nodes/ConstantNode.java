package nodes;

public class ConstantNode extends ExpressionNode {

	public ConstantNode(Object value, int type) {
		// TODO Auto-generated constructor stub

		if (type == 2) { /// for remove " "
			String temp = (String) value;
			value = temp.substring(1, temp.length() - 1);
		}
		this.value = value;
		this.type = type;
	}

	Object value;
	int type;

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

	public int getType() {
		return type;
	}

}
