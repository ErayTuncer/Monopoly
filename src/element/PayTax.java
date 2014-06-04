package element;

import behaviour.ConstructionAllowance;

public class PayTax extends SpecialLand {
	private int taxAmount;
	
	public PayTax(int taxAmount) {
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
		this.taxAmount = taxAmount;
	}
	
	public int getTaxAmount(){
		return taxAmount;
	}
	
	@Override
	public String getName() {
		return "PayTax";
	}

}
