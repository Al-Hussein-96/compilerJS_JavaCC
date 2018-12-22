package nodes;

public class WhileNode extends SyntaxTreeNode {

	@Override
	public Object execute(Context context) {
	    Object ob = children.get(0).execute(context);
		boolean bo = getSolve(context, ob);		
		while(bo){
			children.get(1).execute(context);
			ob = children.get(0).execute(context);
		    bo = getSolve(context, ob);	
		}
		return null;
	}

	private boolean getSolve(Context context, Object ob){
	    ob = children.get(0).execute(context);
		int type = getType(ob);
		boolean bo= true;
		if(type==0 && (Integer)ob==0)bo=false;
		if(type==1 && (Double)ob==0)bo=false;
		if(type==3 && (Boolean)ob==false)bo=false;
		return bo;
	}
	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "While";
	}

	

}
