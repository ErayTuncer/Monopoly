package element;

import command.PayFeeCommand;

import behaviour.ConstructionAllowance;

public class PayTax extends SpecialLand {
	private int taxAmount;
	
	public PayTax(int taxAmount) {
		this.taxAmount = taxAmount;
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
		setAssignment(new PayFeeCommand(taxAmount));
	}
	
	public int getTaxAmount(){
		return taxAmount;
	}
	
	@Override
	public String getName() {
		return "PayTax";
	}

}
