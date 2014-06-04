package element;

import behaviour.ConstructionAllowance;

public class TransportationLand extends PropertyLand {

	public TransportationLand(String name, int price, Rent rent) {
		super(name, price, rent);
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
	}

}
