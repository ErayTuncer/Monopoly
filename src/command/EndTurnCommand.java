package command;

import controller.Controller;

public class EndTurnCommand implements Command {

	@Override
	public void execute(Controller controller) {
		controller.nextTurn();
	}

}
