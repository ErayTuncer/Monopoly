package element;

import command.DrawChanceCommand;

import behaviour.ConstructionAllowance;

public class Chance extends SpecialLand {
	
	public Chance() {
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
		setAssignment(new DrawChanceCommand());
	}

	@Override
	public String getName() {
		return "Chance";
	}

}
