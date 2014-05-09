package element;

import behaviour.ConstructionAllowance;

public abstract class Land {
	
	public ConstructionAllowance constructionBehavior;
	
	public abstract boolean isConstructionAllowed();

	public final ConstructionAllowance getConstructionBehavior() {
		return constructionBehavior;
	}

	public final void setConstructionBehavior(ConstructionAllowance constructionBehavior) {
		this.constructionBehavior = constructionBehavior;
	}

}
