package element;
import behaviour.ConstructionAllowance;


public abstract class PropertyLand {
	
	private ConstructionAllowance constructAllowance;
	
	public PropertyLand(ConstructionAllowance allowance) {
		setConstructAllowance(allowance);
	}

	public ConstructionAllowance getConstructAllowance() {
		return constructAllowance;
	}

	public void setConstructAllowance(ConstructionAllowance constructAllowance) {
		this.constructAllowance = constructAllowance;
	}

	
}
