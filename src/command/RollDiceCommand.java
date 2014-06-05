package command;

import controller.Controller;
import element.DicePair;

public class RollDiceCommand implements Command {

	@Override
	public void execute(Controller controller) {
		DicePair.roll();
		controller.update();
		movePlayer(controller);
		controller.update();
	}
	
	private void movePlayer(Controller controller) {
		int stepForward = DicePair.getDiceValue();
		MoveForwardCommand moveCommand = new MoveForwardCommand(stepForward);
		moveCommand.execute(controller);
	}

}
