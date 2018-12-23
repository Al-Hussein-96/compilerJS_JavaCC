package nodes;

public class IfNode extends SyntaxTreeNode {

	@Override
	public Object execute(Context context) {
		Object ob = children.get(0).execute(context);
		boolean bo = getSolve(ob);
		Object res =null;
		if (bo)
			res = children.get(1).execute(context);
		else if (children.size() > 2)
			res = children.get(2).execute(context);
		return res;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "If";
	}

	

}





