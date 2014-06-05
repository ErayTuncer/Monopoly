package gui.button;

import gui.ButtonDirector;
import command.EndTurnCommand;
import controller.Controller;

public class EndTurnButton extends CommandButton {

	public EndTurnButton(Controller controller, ButtonDirector director) {
		super(new EndTurnCommand(), controller, director);
		reset();
	}

	@Override
	public void reset() {
		setText("End Turn");
		setEnabled(false);
	}

}
