package element;

import behaviour.ConstructionAllowance;


public class InfrastructureLand extends PropertyLand {
	
	public InfrastructureLand() {
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
	}

}
