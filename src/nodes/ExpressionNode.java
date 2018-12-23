package nodes;

import java.text.ParseException;

import org.omg.CORBA.OMGVMCID;

public class ExpressionNode extends SyntaxTreeNode {

	String operator;
	boolean isUnary = false;

	public ExpressionNode() {
		// TODO Auto-generated constructor stub
	}

	public ExpressionNode(String operator, SyntaxTreeNode child1, SyntaxTreeNode child2) {
		this.operator = operator;
		children.add(child1);
		children.add(child2);
	}
	
	public ExpressionNode(String operator, SyntaxTreeNode child1) {
		this.operator = operator;
		children.add(child1);
		isUnary = true;
	}

	public ExpressionNode(String operator, SyntaxTreeNode child1, SyntaxTreeNode child2, SyntaxTreeNode child3) {
		this.operator = operator;
		children.add(child1);
		children.add(child2);
		children.add(child3);
	}
	public Object UnaryExpression(String operator ,Context context) {
        Object res = children.get(0).execute(context);
        if(operator == null) return res;
        int type1 = getType(res);
		switch (operator) {
		case "++":
		    if ( type1 == 0)
				res = (Integer)res + 1;
			else if (type1 == 1)
				res = (Double)res + 1;
            else
               res = null; 
		    if((children.get(0) != null) && (children.get(0) instanceof VariableNode)){
				VariableNode v = (VariableNode)children.get(0);
				if(res!=null)
					context.getVars().put(v.name, res);
			}
		    break;
        case "--":
            if ( type1 == 0)
				res = (Integer)res - 1;
			else if (type1 == 1)
				res = (Double)res - 1;
            else
               res = null; 
            if((children.get(0) != null) && (children.get(0) instanceof VariableNode)){
				VariableNode v = (VariableNode)children.get(0);
				if(res!=null)
					context.getVars().put(v.name, res);
			}
		    break;
        case "!":
            res = getSolve(res);
            res = !((Boolean)res);
		    break;
        case "~":
            if ( type1 == 0)
				res = ~ ((Integer)res );
            else
               res = null; 
		    break;
		}
		return res;
	}
	
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}


	@Override
	public Object execute(Context context) {
		if(isUnary){
			return UnaryExpression(operator, context);
		}
		Object d1 =  children.get(0).execute(context);
		Object d2 =  children.get(1).execute(context);
		
		int type1 = getType(d1);
		int type2 = getType(d2);
		
		switch (operator) {
		case "+":
			Object res = null;
			if ( type1 == 0){
				if(type2==0)res = (Integer)d1 + (Integer)d2;
				if(type2==1)res = (Integer)d1 + (Double)d2;
				if(type2==2)res = String.valueOf((Integer)d1) + (String)d2;
				if(type2==3)res = (Integer)d1 + ((Boolean)d2== true?1:0);
			}
			if (type1 == 1){
				if(type2==0)res = (Double)d1 + (Integer)d2;
				if(type2==1)res = (Double)d1 + (Double)d2;
				if(type2==2)res = String.valueOf((Double)d1) + (String)d2;
				if(type2==3)res = (Double)d1 + ((Boolean)d2== true?1:0);
			}
			if(type1 == 2){
				if(type2==0)res = (String)d1 + String.valueOf((Integer)d2);
				if(type2==1)res = (String)d1 + String.valueOf((Double)d2);
				if(type2==2)res = (String)d1 + (String)d2;
				if(type2==3)res = (String)d1 + String.valueOf((Boolean)d2);
			}
			if(type1 == 3){
				if(type2==0)res = ((Boolean)d1== true?1:0) + (Integer)d2;
				if(type2==1)res = ((Boolean)d1== true?1:0) + (Double)d2;
				if(type2==2)res = String.valueOf((Boolean)d1) + (String)d2;
				if(type2==3)res = ((Boolean)d1== true?1:0) + ((Boolean)d2== true?1:0);
			}
			return res;
		case "-":
		    res = null;
			if ( type1 == 0){
				if(type2==0)res = (Integer)d1 - (Integer)d2;
				if(type2==1)res = (Integer)d1 - (Double)d2;
				if(type2==3)res = (Integer)d1 - ((Boolean)d2== true?1:0);
			}
			if (type1 == 1){
				if(type2==0)res = (Double)d1 - (Integer)d2;
				if(type2==1)res = (Double)d1 - (Double)d2;
				if(type2==3)res = (Double)d1 - ((Boolean)d2== true?1:0);
			}
			if(type1 == 3){
				if(type2==0)res = ((Boolean)d1== true?1:0) - (Integer)d2;
				if(type2==1)res = ((Boolean)d1== true?1:0) - (Double)d2;
				if(type2==3)res = ((Boolean)d1== true?1:0) - ((Boolean)d2== true?1:0);
			}
			return res;

		case "*":
		    res = null;
			if ( type1 == 0){
				if(type2==0)res = (Integer)d1 * (Integer)d2;
				if(type2==1)res = (Integer)d1 * (Double)d2;
				if(type2==3)res = (Integer)d1 * ((Boolean)d2== true?1:0);
			}
			if (type1 == 1){
				if(type2==0)res = (Double)d1 * (Integer)d2;
				if(type2==1)res = (Double)d1 * (Double)d2;
				if(type2==3)res = (Double)d1 * ((Boolean)d2== true?1:0);
			}
			if(type1 == 3){
				if(type2==0)res = ((Boolean)d1== true?1:0) * (Integer)d2;
				if(type2==1)res = ((Boolean)d1== true?1:0) * (Double)d2;
				if(type2==3)res = ((Boolean)d1== true?1:0) * ((Boolean)d2== true?1:0);
			}
			return res;

		case "/":
			res = null;
			if ( type1 == 0){
				if(type2==0)res = (Integer)d1 / (Integer)d2;
				if(type2==1)res = (Integer)d1 / (Double)d2;
				if(type2==3)res = (Integer)d1 / ((Boolean)d2== true?1:0);
			}
			if (type1 == 1){
				if(type2==0)res = (Double)d1 / (Integer)d2;
				if(type2==1)res = (Double)d1 / (Double)d2;
				if(type2==3)res = (Double)d1 / ((Boolean)d2== true?1:0);
			}
			if(type1 == 3){
				if(type2==0)res = ((Boolean)d1== true?1:0) / (Integer)d2;
				if(type2==1)res = ((Boolean)d1== true?1:0) / (Double)d2;
				if(type2==3)res = ((Boolean)d1== true?1:0) / ((Boolean)d2== true?1:0);
			}
			return res;

		case "%":
			res = null;
			if ( type1 == 0){
				if(type2==0)res = (Integer)d1 % (Integer)d2;
			}
			return res;
		case "<<":
			res = null;
			if ( type1 == 0){
				if(type2==0)res = ( (Integer)d1 << (Integer)d2 );
			}
			return res;
		case ">>":
			res = null;
			if ( type1 == 0){
				if(type2==0)res = ( (Integer)d1 >> (Integer)d2 );
			}
			return res;
		case ">>>":
			res = null;
			if ( type1 == 0){
				if(type2==0)res = ( (Integer)d1 >>> (Integer)d2 );
			}
			return res;
		case "<":
			res = null;
			if ( type1 == 0){
				if(type2==0)res = (Integer)d1 < (Integer)d2;
				if(type2==1)res = (Integer)d1 < (Double)d2;
				if(type2==3)res = (Integer)d1 < ((Boolean)d2== true?1:0);
			}
			if (type1 == 1){
				if(type2==0)res = (Double)d1 < (Integer)d2;
				if(type2==1)res = (Double)d1 < (Double)d2;
				if(type2==3)res = (Double)d1 < ((Boolean)d2== true?1:0);
			}
			if(type1 == 2){
				if(type2==2)res = null;
			}
			if(type1 == 3){
				if(type2==0)res = ((Boolean)d1== true?1:0) < (Integer)d2;
				if(type2==1)res = ((Boolean)d1== true?1:0) < (Double)d2;
				if(type2==3)res = ((Boolean)d1== true?1:0) < ((Boolean)d2== true?1:0);
			}
			return res;

		case ">":
			res = null;
			if ( type1 == 0){
				if(type2==0)res = (Integer)d1 > (Integer)d2;
				if(type2==1)res = (Integer)d1 > (Double)d2;
				if(type2==3)res = (Integer)d1 > ((Boolean)d2== true?1:0);
			}
			if (type1 == 1){
				if(type2==0)res = (Double)d1 > (Integer)d2;
				if(type2==1)res = (Double)d1 > (Double)d2;
				if(type2==3)res = (Double)d1 > ((Boolean)d2== true?1:0);
			}
			if(type1 == 2){
				if(type2==2)res = null;
			}
			if(type1 == 3){
				if(type2==0)res = ((Boolean)d1== true?1:0) > (Integer)d2;
				if(type2==1)res = ((Boolean)d1== true?1:0) > (Double)d2;
				if(type2==3)res = ((Boolean)d1== true?1:0) > ((Boolean)d2== true?1:0);
			}
			return res;
		case "<=":
			res = null;
			if ( type1 == 0){
				if(type2==0)res = (Integer)d1 <= (Integer)d2;
				if(type2==1)res = (Integer)d1 <= (Double)d2;
				if(type2==3)res = (Integer)d1 < ((Boolean)d2== true?1:0);
			}
			if (type1 == 1){
				if(type2==0)res = (Double)d1 <= (Integer)d2;
				if(type2==1)res = (Double)d1 <= (Double)d2;
				if(type2==3)res = (Double)d1 <= ((Boolean)d2== true?1:0);
			}
			if(type1 == 2){
				if(type2==2)res = null;
			}
			if(type1 == 3){
				if(type2==0)res = ((Boolean)d1== true?1:0) <= (Integer)d2;
				if(type2==1)res = ((Boolean)d1== true?1:0) <= (Double)d2;
				if(type2==3)res = ((Boolean)d1== true?1:0) <= ((Boolean)d2== true?1:0);
			}
			return res;
		case ">=":
			res = null;
			if ( type1 == 0){
				if(type2==0)res = (Integer)d1 >= (Integer)d2;
				if(type2==1)res = (Integer)d1 >= (Double)d2;
				if(type2==3)res = (Integer)d1 >= ((Boolean)d2== true?1:0);
			}
			if (type1 == 1){
				if(type2==0)res = (Double)d1 >= (Integer)d2;
				if(type2==1)res = (Double)d1 >= (Double)d2;
				if(type2==3)res = (Double)d1 >= ((Boolean)d2== true?1:0);
			}
			if(type1 == 2){
				if(type2==2)res = null;
			}
			if(type1 == 3){
				if(type2==0)res = ((Boolean)d1== true?1:0) >= (Integer)d2;
				if(type2==1)res = ((Boolean)d1== true?1:0) >= (Double)d2;
				if(type2==3)res = ((Boolean)d1== true?1:0) >= ((Boolean)d2== true?1:0);
			}
			return res;
		case "==":
			res = null;
			if ( type1 == 0){
				if(type2==0)res = (Integer)d1 == (Integer)d2;
				if(type2==1)res = ((Integer)d1).equals((Double)d2);
				if(type2==2)res = String.valueOf((Integer)d1) == (String)d2;
				if(type2==3)res = (Integer)d1 == ((Boolean)d2== true?1:0);
			}
			if (type1 == 1){
				if(type2==0)res = ((Double)d1).equals((Integer)d2);
				if(type2==1)res = (Double)d1 == (Double)d2;
				if(type2==2)res = String.valueOf((Double)d1) == (String)d2;
				if(type2==3)res = (Double)d1 == ((Boolean)d2== true?1:0);
			}
			if(type1 == 2){
				if(type2==0)res = (String)d1 == String.valueOf((Integer)d2);
				if(type2==1)res = (String)d1 == String.valueOf((Double)d2);
				if(type2==2)res = (String)d1 == (String)d2;
				if(type2==3)res = (String)d1 == String.valueOf((Boolean)d2);
			}
			if(type1 == 3){
				if(type2==0)res = ((Boolean)d1== true?1:0) == (Integer)d2;
				if(type2==1)res = ((Boolean)d1== true?1:0) == (Double)d2;
				if(type2==2)res = String.valueOf((Boolean)d1) == (String)d2;
				if(type2==3)res = ((Boolean)d1== true?1:0) == ((Boolean)d2== true?1:0);
			}
			return res;
		case "!=":
			res = null;
			if ( type1 == 0){
				if(type2==0)res = (Integer)d1 != (Integer)d2;
				if(type2==1)res = !((Integer)d1).equals((Double)d2);;
				if(type2==2)res = String.valueOf((Integer)d1) != (String)d2;
				if(type2==3)res = (Integer)d1 != ((Boolean)d2== true?1:0);
			}
			if (type1 == 1){
				if(type2==0)res = !((Double)d1).equals((Integer)d2);;
				if(type2==1)res = (Double)d1 != (Double)d2;
				if(type2==2)res = String.valueOf((Double)d1) != (String)d2;
				if(type2==3)res = (Double)d1 != ((Boolean)d2== true?1:0);
			}
			if(type1 == 2){
				if(type2==0)res = (String)d1 != String.valueOf((Integer)d2);
				if(type2==1)res = (String)d1 != String.valueOf((Double)d2);
				if(type2==2)res = (String)d1 != (String)d2;
				if(type2==3)res = (String)d1 != String.valueOf((Boolean)d2);
			}
			if(type1 == 3){
				if(type2==0)res = ((Boolean)d1== true?1:0) != (Integer)d2;
				if(type2==1)res = ((Boolean)d1== true?1:0) != (Double)d2;
				if(type2==2)res = String.valueOf((Boolean)d1) != (String)d2;
				if(type2==3)res = ((Boolean)d1== true?1:0) != ((Boolean)d2== true?1:0);
			}
			return res;
		case "&":
			res = null;
			if ( type1 == 0){
				if(type2==0)res = ( (Integer)d1 & (Integer)d2 );
			}
			return res;
		case "^":
			res = null;
			if ( type1 == 0){
				if(type2==0)res = ( (Integer)d1 ^ (Integer)d2 );
			}
			return res;
		case "|":
			res = null;
			if ( type1 == 0){
				if(type2==0)res = ( (Integer)d1 | (Integer)d2 );
			}
			return res;
		case "&&":
			res = null;
			boolean bo1 = getSolve(d1);
			boolean bo2 = getSolve(d2);
			res = bo1 && bo2;
			return res;
		case "||":
			res = null;
			bo1 = getSolve(d1);
		    bo2 = getSolve(d2);
			res = bo1 || bo2;
			return res;
		}
		
		return null;
	}
	

	
	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "Exp " + operator;
	}

}
