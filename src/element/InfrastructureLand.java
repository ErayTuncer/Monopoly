package element;

import behaviour.ConstructionAllowance;


public class InfrastructureLand extends PropertyLand {
	
	public InfrastructureLand(String name, int price, Rent rent) {
		super(name, price, rent);
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
	}

}
