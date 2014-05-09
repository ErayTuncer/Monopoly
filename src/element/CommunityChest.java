package element;

import behaviour.ConstructionAllowance;

public class CommunityChest extends SpecialLand {
	
	public CommunityChest() {
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
	}

}
