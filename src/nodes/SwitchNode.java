package nodes;

public class SwitchNode extends SyntaxTreeNode {
	String nameVar;
	
	

	public String getNameVar() {
		return nameVar;
	}

	public void setNameVar(String nameVar) {
		this.nameVar = nameVar;
	}

	@Override
	public Object execute(Context context) {
		// TODO Auto-generated method stub
		
		if(!context.getVars().containsKey(nameVar))
		   return null;
		
		Object first = context.getVars().get(nameVar);
		for (int i = 0; i < children.size(); i++) {
			String NodeSwitch = (String) children.get(i).execute(context);

			if (NodeSwitch == "Case") {
				CaseNode caseNode = (CaseNode) children.get(i);
				Object object1 = caseNode.children.get(0).execute(context);
				
				 if(first.equals(object1)) {
					 Object object = caseNode.children.get(1).execute(context);
					 if(object!=null && object instanceof String)
							if(((String)object).equals("Break"))
								break;
				 }

			} else if (NodeSwitch == "Default") {
				DefaultNode defaultNode = (DefaultNode) children.get(i);
				 Object object = defaultNode.children.get(0).execute(context);
				 if(object!=null && object instanceof String)
						if(((String)object).equals("Break"))
							break;
			}
		}

		return null;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub

		return null;
	}

}
