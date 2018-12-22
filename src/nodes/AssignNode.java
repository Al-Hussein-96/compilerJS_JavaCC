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
			String ob = null;
			if (children.size() > 0)
				ob = (String) children.get(0).execute(context);

			ConstantNode constantNode = (ConstantNode) children.get(0);

			int Type = constantNode.type;
			context.getVarsType().put(variable, Type);
			context.getVars().put(variable, ob);
			break;
		case "+=":
			String d = (String) context.getVars().get(variable);
			Object res = null;

			ob = (String) children.get(0).execute(context);
			if (context.getVarsType().get(variable) == 0)
				res = Integer.valueOf(d) + Integer.valueOf(ob);
			if (context.getVarsType().get(variable) == 1)
				res = Double.valueOf(d) + Double.valueOf(ob);

			context.getVars().put(variable, res);
			break;
		case "-=":
			res = null;
			d = (String) context.getVars().get(variable);
			ob = (String) children.get(0).execute(context);
			if (context.getVarsType().get(variable) == 0)
				res = Integer.valueOf(d) - Integer.valueOf(ob);

			if (context.getVarsType().get(variable) == 1)
				res = Double.valueOf(d) - Double.valueOf(ob);

			context.getVars().put(variable, res);
			break;
		case "*=":
			res = null;
			d = (String) context.getVars().get(variable);
			ob = (String) children.get(0).execute(context);
			if (context.getVarsType().get(variable) == 0)
				res = Integer.valueOf(d) * Integer.valueOf(ob);
			if (context.getVarsType().get(variable) == 1)
				res = Double.valueOf(d) * Double.valueOf(ob);
			context.getVars().put(variable, res);
			break;
		case "/=":
			res = null;
			d = (String) context.getVars().get(variable);
			ob = (String) children.get(0).execute(context);
			if (context.getVarsType().get(variable) == 0)
				res = Integer.valueOf(d) / Integer.valueOf(ob);
			if (context.getVarsType().get(variable) == 1)
				res = Double.valueOf(d) / Double.valueOf(ob);
			context.getVars().put(variable, res);
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
