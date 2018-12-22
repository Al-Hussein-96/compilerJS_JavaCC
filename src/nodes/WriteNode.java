package nodes;

public class WriteNode extends SyntaxTreeNode {

	@Override
	public Object execute(Context context) {
		// TODO Auto-generated method stub
		System.out.println(children.get(0).execute(context));
		return null;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "Print";
	}

	

}
