package command;

import controller.Controller;
import element.DicePair;

public class RollDiceCommand implements Command {

	@Override
	public void execute(Controller controller) {
		DicePair.roll();
		movePlayer(controller);
	}
	
	private void movePlayer(Controller controller) {
		int stepForward = DicePair.getDiceValue();
		MoveForwardCommand moveCommand = new MoveForwardCommand(stepForward);
		moveCommand.execute(controller);
	}

}
