package element;

import behaviour.ConstructionAllowance;

public class TransportationLand extends PropertyLand {

	public TransportationLand() {
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
	}
	
}
