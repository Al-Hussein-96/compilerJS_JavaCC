package nodes;

public class CaseNode extends SyntaxTreeNode {
	Object value;
	
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public Object execute(Context context) {
		// TODO Auto-generated method stub
		return "Case";
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "Case";
	}

}
