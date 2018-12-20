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
}
