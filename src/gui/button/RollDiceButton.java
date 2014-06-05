package gui.button;

import gui.ButtonDirector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.RollDiceCommand;
import controller.Controller;

public class RollDiceButton extends CommandButton {

	public RollDiceButton(Controller controller, ButtonDirector director) {
		super(new RollDiceCommand(), controller, director);	
	}

	@Override
	protected ActionListener getListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				command.execute(controller);
				setEnabled(false);
				director.buttonChanged();
			}
		};
	}

	@Override
	public void reset() {
		setEnabled(true);
		setText("Roll Dice");
	}

}
