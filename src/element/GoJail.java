package element;

import behaviour.ConstructionAllowance;

public class GoJail extends SpecialLand {
	
	public GoJail() {
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
	}


}
