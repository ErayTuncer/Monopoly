package element;

import behaviour.ConstructionAllowance;

public class TransportationLand extends PropertyLand {

	public TransportationLand(String name, int cost, Rent rent) {
		super(name, cost, rent);
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
	}

}
