package command;

import controller.Controller;
import element.Game;


public class EndTurnCommand implements Command {

	@Override
	public void execute(Controller controller) {
		controller.nextTurn();
	}

}
