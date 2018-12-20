package nodes;

public class WhileNode extends SyntaxTreeNode {

	@Override
	public Object execute(Context context) {
		while((Boolean)children.get(0).execute(context))
			children.get(1).execute(context);
		return null;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "While";
	}

}
