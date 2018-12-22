package nodes;

import java.text.ParseException;

import org.omg.CORBA.OMGVMCID;

public class ExpressionNode extends SyntaxTreeNode {

	String operator;

	public ExpressionNode() {
		// TODO Auto-generated constructor stub
	}

	public ExpressionNode(String operator, SyntaxTreeNode child1, SyntaxTreeNode child2) {
		this.operator = operator;
		children.add(child1);
		children.add(child2);
	}

	public ExpressionNode(String operator, SyntaxTreeNode child1, SyntaxTreeNode child2, SyntaxTreeNode child3) {
		this.operator = operator;
		children.add(child1);
		children.add(child2);
		children.add(child3);
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public Object execute(Context context) {

		String d1 = (String) children.get(0).execute(context);
		String d2 = (String) children.get(1).execute(context);
//		
		int type1 = -1;
		int type2 = -1;

		if (children.get(0) instanceof VariableNode)
			type1 = context.getVarsType().get(((VariableNode) children.get(0)).getName());
		else
			type1 = ((ConstantNode) children.get(0)).getType();

		if (children.get(1) instanceof VariableNode)
			type2 = context.getVarsType().get(((VariableNode) children.get(1)).getName());
		else
			type2 = ((ConstantNode) children.get(1)).getType();

		switch (operator) {
		case "+":
			if (type1 == 0 && type2 == 0)
				return Integer.valueOf(d1) + Integer.valueOf(d2);
			if (type1 == 1 && type2 == 1)
				return Double.valueOf(d1) + Double.valueOf(d2);
			if (type1 == 2 && type2 == 2)
				return (String) d1 + (String) d2;

		case "-":
			if (type1 == 0 && type2 == 0)
				return Integer.valueOf(d1) - Integer.valueOf(d2);
			if (type1 == 1 && type2 == 1)
				return Double.valueOf(d1) - Double.valueOf(d2);

		case "*":
			if (type1 == 0 && type2 == 0)
				return Integer.valueOf(d1) * Integer.valueOf(d2);
			if (type1 == 1 && type2 == 1)
				return Double.valueOf(d1) * Double.valueOf(d2);

		case "/":
			if (type1 == 0 && type2 == 0)
				return Integer.valueOf(d1) / Integer.valueOf(d2);
			if (type1 == 1 && type2 == 1)
				return Double.valueOf(d1) / Double.valueOf(d2);

		case "%":
			if (type1 == 0 && type2 == 0)
				return Integer.valueOf(d1) % Integer.valueOf(d2);
			if (type1 == 1 && type2 == 1)
				return Double.valueOf(d1) % Double.valueOf(d2);

		case "<<":
			if (type1 == 0 && type2 == 0)
				return (Integer.valueOf(d1) << Integer.valueOf(d2));
		case ">>":
			if (type1 == 0 && type2 == 0)
				return (Integer.valueOf(d1) >> Integer.valueOf(d2));
		case ">>>":
			if (type1 == 0 && type2 == 0)
				return (Integer.valueOf(d1) >>> Integer.valueOf(d2));
		case "<":
			if (type1 == 0 && type2 == 0)
				return Integer.valueOf(d1) < Integer.valueOf(d2);

			if (type1 == 1 && type2 == 1)
				return Double.valueOf(d1) < Double.valueOf(d2);

		case ">":
			if (type1 == 0 && type2 == 0)
				return Integer.valueOf(d1) > Integer.valueOf(d2);

			if (type1 == 1 && type2 == 1)
				return Double.valueOf(d1) > Double.valueOf(d2);
		case "<=":
			if (type1 == 0 && type2 == 0)
				return Integer.valueOf(d1) <= Integer.valueOf(d2);

			if (type1 == 1 && type2 == 1)
				return Double.valueOf(d1) <= Double.valueOf(d2);

		case ">=":
			if (type1 == 0 && type2 == 0)
				return Integer.valueOf(d1) >= Integer.valueOf(d2);

			if (type1 == 1 && type2 == 1)
				return Double.valueOf(d1) >= Double.valueOf(d2);

		case "==":
			if (type1 == 0 && type2 == 0)
				return Integer.valueOf(d1) == Integer.valueOf(d2);
			if (type1 == 1 && type2 == 1)
				return Double.valueOf(d1) == Double.valueOf(d2);
			if (type1 == 2 && type2 == 2)
				return String.valueOf(d1) == String.valueOf(d2);
		case "!=":
			if (type1 == 0 && type2 == 0)
				return Integer.valueOf(d1) != Integer.valueOf(d2);
			if (type1 == 1 && type2 == 1)
				return Double.valueOf(d1) != Double.valueOf(d2);
			if (type1 == 2 && type2 == 2)
				return String.valueOf(d1) != String.valueOf(d2);
		case "&":
			if (type1 == 0 && type2 == 0)
				return (Integer.valueOf(d1) & Integer.valueOf(d2));
		case "^":
			if (type1 == 0 && type2 == 0)
				return (Integer.valueOf(d1) ^ Integer.valueOf(d2));
		case "|":
			if (type1 == 0 && type2 == 0)
				return (Integer.valueOf(d1) | Integer.valueOf(d2));
		}
		return null;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "Exp " + operator;
	}

}
