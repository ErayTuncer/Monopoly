package element;

import behaviour.ConstructionAllowance;

public abstract class Land {
	
	public ConstructionAllowance constructionBehavior;
	
	public final boolean isConstructionAllowed() {
		return constructionBehavior.isConstructionAllowed();
	}

	public final ConstructionAllowance getConstructionBehavior() {
		return constructionBehavior;
	}

	public final void setConstructionBehavior(ConstructionAllowance constructionBehavior) {
		this.constructionBehavior = constructionBehavior;
	}

}
