package nodes;

public class BlockNode extends SyntaxTreeNode {

	@Override
	public Object execute(Context context) {
		for(SyntaxTreeNode child : children){
			Object ob = child.execute(context);
			if(ob!=null && ob instanceof String)
				if(((String)ob).equals("Break") || ((String)ob).equals("Continue") )
					return ob;
		}
		return null;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "Block";
	}

	

}
