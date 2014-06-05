package element;

import command.GetPaidCommand;
import behaviour.ConstructionAllowance;

public class Start extends SpecialLand {
	
	public Start() {
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_DENIED);
		setAssignment(new GetPaidCommand());
	}

	@Override
	public String getName() {
		return "Start";
	}

}
