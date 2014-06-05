package element;

import util.RentCalculator;
import command.AskBuyCommand;
import behaviour.ConstructionAllowance;

public class TransportationLand extends PropertyLand {

	public TransportationLand(String name, int price, Rent rent) {
		super(name, price, rent);
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
		setAssignment(new AskBuyCommand());
	}

	@Override
	public int acceptCalculator(RentCalculator calculator) {
		return calculator.calculate(this);
	}

}
