package element;

import behaviour.ConstructionAllowance;

public class FreeParking extends SpecialLand {
	
	public FreeParking() {
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
	}

}
