package nodes;

public class ForNode extends SyntaxTreeNode {

	String variable;
	
	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	@Override
	public Object execute(Context context) {
		if(children.get(0)!=null)
			children.get(0).execute(context);
		Object ob;
		boolean bo = true;	
		if(children.get(1)!=null){
			ob = children.get(1).execute(context);
		    bo = getSolve(ob);	
		}
		while(bo){
			Object object = children.get(3).execute(context);
			if(object!=null && object instanceof String)
				if(((String)object).equals("Break"))
					break;
			if(children.get(2)!=null)
				children.get(2).execute(context);
			if(children.get(1)!=null){
				ob = children.get(1).execute(context);
			    bo = getSolve(ob);	
			}
		}
		return null;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "For " + variable;
	}


}

