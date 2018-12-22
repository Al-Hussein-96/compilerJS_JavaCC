package nodes;

public class IfNode extends SyntaxTreeNode {

	@Override
	public Object execute(Context context) {
		if ((Boolean)children.get(0).execute(context))
			children.get(1).execute(context);
		else if (children.size() > 2)
			children.get(2).execute(context);
		return null;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "If";
	}

	

}
