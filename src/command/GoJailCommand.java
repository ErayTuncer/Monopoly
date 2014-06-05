package command;

import controller.Controller;

public class GoJailCommand implements Command {

	@Override
	public void execute(Controller controller) {
		(new MoveBackwardCommand(20)).execute(controller);
		//TODO

	}

}
