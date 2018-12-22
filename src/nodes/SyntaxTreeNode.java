package nodes;

import java.util.ArrayList;

public abstract class SyntaxTreeNode {

	protected ArrayList<SyntaxTreeNode> children = new ArrayList<>();
	
	public void addChild(SyntaxTreeNode child) {
		children.add(child);
	}
	
	public abstract Object execute(Context context);
	
	
	protected abstract String getName();
	
	public void print(String prefix) {
		System.out.println(prefix + getName());
		for(SyntaxTreeNode child : children) {
			child.print(prefix + "---");
		}
	}

	public int getType(Object ob){
		
		if(ob instanceof Integer)return 0;
		if(ob instanceof Double)return 1;
		if(ob instanceof String)return 2;
		if(ob instanceof Boolean)return 3;
		return -1;
	}
}
