package nodes;

public class BlockNode extends SyntaxTreeNode {

	@Override
	public Object execute(Context context) {
		for(SyntaxTreeNode child : children)
			child.execute(context);
		return null;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "Block";
	}

	

}
