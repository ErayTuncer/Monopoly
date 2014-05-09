package element;

import behaviour.ConstructionAllowance;

public class Start extends SpecialLand {
	
	public Start() {
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
	}

}
