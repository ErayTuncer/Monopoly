package element;

import behaviour.ConstructionAllowance;

public class CommunityChest extends SpecialLand {
	
	public CommunityChest() {
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
	}

	@Override
	public String getName() {
		return "CommunityChest";
	}

}
