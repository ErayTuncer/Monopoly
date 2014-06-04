package element;

import behaviour.ConstructionAllowance;

public abstract class Land {

	private ConstructionAllowance constructionBehavior;
	
	public abstract String getName();

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
