package nodes;

public class AssignNode extends SyntaxTreeNode {

	String variable;
	String op;

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}
	
	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}
	
	@Override
	public Object execute(Context context) {
		// TODO Auto-generated method stub
		switch (op) {
		case "=":
			Object ob=null;
			if(children.size()>0)
				ob = children.get(0).execute(context);
			context.getVars().put(variable, (Double)ob);
			break;
		case "+=":
			double d = context.getVars().get(variable);
		    ob = children.get(0).execute(context);
			context.getVars().put(variable, d+(double)ob );
			break;
		case "-=":
			d = context.getVars().get(variable);
		    ob = children.get(0).execute(context);
			context.getVars().put(variable, d-(double)ob );
			break;
		case "*=":
			d = context.getVars().get(variable);
		    ob = children.get(0).execute(context);
			context.getVars().put(variable, d*(double)ob );
			break;
		case "/=":
		    d = context.getVars().get(variable);
		    ob = children.get(0).execute(context);
			context.getVars().put(variable, d/(double)ob );
			break;
		default:
			break;
		}
		return null;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return variable + op;
	}

}
