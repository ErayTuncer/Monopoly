package command;

import controller.Controller;

public class GoJailCommand implements Command {

	@Override
	public void execute(Controller controller) {
		(new MoveLandCommand("Jail")).execute(controller);
		//TODO

	}

}
