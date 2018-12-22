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
			Object ob = null;
			if (children.size() > 0)
				ob = children.get(0).execute(context);
			context.getVars().put(variable, ob);
			break;
		case "+=":
			Object d = context.getVars().get(variable);
			Object res = null;
			ob = children.get(0).execute(context);
			int type1 = getType(d);
			int type2 = getType(ob);
			if ( type1 == 0){
				if(type2==0)res = (Integer)d + (Integer)ob;
				if(type2==1)res = (Integer)d + (Double)ob;
				if(type2==2)res = String.valueOf((Integer)d) + (String)ob;
				if(type2==3)res = (Integer)d + ((Boolean)ob== true?1:0);
			}
			if (type1 == 1){
				if(type2==0)res = (Double)d + (Integer)ob;
				if(type2==1)res = (Double)d + (Double)ob;
				if(type2==2)res = String.valueOf((Double)d) + (String)ob;
				if(type2==3)res = (Double)d + ((Boolean)ob== true?1:0);
			}
			if(type1 == 2){
				if(type2==0)res = (String)d + String.valueOf((Integer)ob);
				if(type2==1)res = (String)d + String.valueOf((Double)ob);
				if(type2==2)res = (String)d + (String)ob;
				if(type2==3)res = (String)d + String.valueOf((Boolean)ob);
			}
			if(type1 == 3){
				if(type2==0)res = ((Boolean)d== true?1:0) + (Integer)ob;
				if(type2==1)res = ((Boolean)d== true?1:0) + (Double)ob;
				if(type2==2)res = String.valueOf((Boolean)d) + (String)ob;
				if(type2==3)res = ((Boolean)d== true?1:0) + ((Boolean)ob== true?1:0);
			}
			
			context.getVars().put(variable, res);
			break;
		case "-=":
		    d = context.getVars().get(variable);
		    res = null;
			ob = children.get(0).execute(context);
			type1 = getType(d);
			type2 = getType(ob);
			if ( type1 == 0){
				if(type2==0)res = (Integer)d - (Integer)ob;
				if(type2==1)res = (Integer)d - (Double)ob;
				if(type2==2)res = null;
				if(type2==3)res = (Integer)d - ((Boolean)ob== true?1:0);
			}
			if (type1 == 1){
				if(type2==0)res = (Double)d - (Integer)ob;
				if(type2==1)res = (Double)d - (Double)ob;
				if(type2==2)res = null;
				if(type2==3)res = (Double)d - ((Boolean)ob== true?1:0);
			}
			if(type1 == 2){
				res = null;
			}
			if(type1 == 3){
				if(type2==0)res = ((Boolean)d== true?1:0) - (Integer)ob;
				if(type2==1)res = ((Boolean)d== true?1:0) - (Double)ob;
				if(type2==2)res = null;
				if(type2==3)res = ((Boolean)d== true?1:0) - ((Boolean)ob== true?1:0);
			}
			
			context.getVars().put(variable, res);
			break;
		case "*=":
		    d = context.getVars().get(variable);
			res = null;
			ob = children.get(0).execute(context);
			type1 = getType(d);
			type2 = getType(ob);
			if ( type1 == 0){
				if(type2==0)res = (Integer)d * (Integer)ob;
				if(type2==1)res = (Integer)d * (Double)ob;
				if(type2==2)res = null;
				if(type2==3)res = (Integer)d * ((Boolean)ob== true?1:0);
			}
			if (type1 == 1){
				if(type2==0)res = (Double)d * (Integer)ob;
				if(type2==1)res = (Double)d * (Double)ob;
				if(type2==2)res = null;
				if(type2==3)res = (Double)d * ((Boolean)ob== true?1:0);
			}
			if(type1 == 2){
				res = null;
			}
			if(type1 == 3){
				if(type2==0)res = ((Boolean)d== true?1:0) * (Integer)ob;
				if(type2==1)res = ((Boolean)d== true?1:0) * (Double)ob;
				if(type2==2)res = null;
				if(type2==3)res = ((Boolean)d== true?1:0) * ((Boolean)ob== true?1:0);
			}
			context.getVars().put(variable, res);
			break;
		case "/=":
			d = context.getVars().get(variable);
			res = null;
			ob = children.get(0).execute(context);
			type1 = getType(d);
			type2 = getType(ob);
			if ( type1 == 0){
				if(type2==0)res = (Integer)d / (Integer)ob;
				if(type2==1)res = (Integer)d / (Double)ob;
				if(type2==2)res = null;
				if(type2==3)res = (Integer)d / ((Boolean)ob== true?1:0);
			}
			if (type1 == 1){
				if(type2==0)res = (Double)d / (Integer)ob;
				if(type2==1)res = (Double)d / (Double)ob;
				if(type2==2)res = null;
				if(type2==3)res = (Double)d / ((Boolean)ob== true?1:0);
			}
			if(type1 == 2){
				res = null;
			}
			if(type1 == 3){
				if(type2==0)res = ((Boolean)d== true?1:0) / (Integer)ob;
				if(type2==1)res = ((Boolean)d== true?1:0) / (Double)ob;
				if(type2==2)res = null;
				if(type2==3)res = ((Boolean)d== true?1:0) / ((Boolean)ob== true?1:0);
			}
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
