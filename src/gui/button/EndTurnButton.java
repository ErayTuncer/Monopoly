package gui.button;

import command.EndTurnCommand;
import controller.Controller;

public class EndTurnButton extends CommandButton {

	public EndTurnButton(Controller controller) {
		super(new EndTurnCommand(), controller);
	}

	@Override
	public void reset() {
		setText("End Turn");
	}

}
