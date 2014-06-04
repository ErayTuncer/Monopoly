package element;

import command.GoJailCommand;

import behaviour.ConstructionAllowance;

public class GoJail extends SpecialLand {
	
	public GoJail() {
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
		setAssignment(new GoJailCommand());
	}

	@Override
	public String getName() {
		return "GoJail";
	}

}
