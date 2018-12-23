package nodes;

public class WhileNode extends SyntaxTreeNode {

	@Override
	public Object execute(Context context) {
	    Object ob = children.get(0).execute(context);
		boolean bo = getSolve(ob);		
		while(bo){
			Object object = children.get(1).execute(context);;
			if(object!=null && object instanceof String)
				if(((String)object).equals("Break"))
					break;
			ob = children.get(0).execute(context);
		    bo = getSolve(ob);	
		}
		return null;
	}

	
	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "While";
	}

	

}
