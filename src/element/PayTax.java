package element;

import behaviour.ConstructionAllowance;

public class PayTax extends SpecialLand {
	
	public PayTax() {
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
	}

}
