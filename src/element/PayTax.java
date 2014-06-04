package element;

import command.PayTaxCommand;

import behaviour.ConstructionAllowance;

public class PayTax extends SpecialLand {
	
	public PayTax() {
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
		setAssignment(new PayTaxCommand());
	}
	
	@Override
	public String getName() {
		return "PayTax";
	}

}
