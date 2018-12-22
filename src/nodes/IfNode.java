package nodes;

public class IfNode extends SyntaxTreeNode {

	@Override
	public Object execute(Context context) {
		Object ob = children.get(0).execute(context);
		int type = getType(ob);
		boolean bo= true;
		if(type==0 && (Integer)ob==0)bo=false;
		if(type==1 && (Double)ob==0)bo=false;
		if(type==3 && (Boolean)ob==false)bo=false;
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





