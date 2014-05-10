package element;

import behaviour.ConstructionAllowance;

public class Chance extends SpecialLand {
	
	public Chance() {
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
	}

	@Override
	public String getName() {
		return "Chance";
	}

}
