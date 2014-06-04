package element;

import command.DrawCommunityCommand;

import behaviour.ConstructionAllowance;

public class CommunityChest extends SpecialLand {
	
	public CommunityChest() {
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
		setAssignment(new DrawCommunityCommand());
	}

	@Override
	public String getName() {
		return "CommunityChest";
	}

}
