package element;

import behaviour.ConstructionAllowance;

public class Jail extends SpecialLand {
	
	public Jail() {
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
	}

}
