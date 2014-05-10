package element;

import behaviour.ConstructionAllowance;


public class InfrastructureLand extends PropertyLand {
	
	public InfrastructureLand(String name, int cost, Rent rent) {
		super(name, cost, rent);
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
