package gui.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.RollDiceCommand;
import controller.Controller;

public class RollDiceButton extends CommandButton {

	public RollDiceButton(Controller controller) {
		super(new RollDiceCommand(), controller);	
		setText("Roll Dice");
	}

	@Override
	protected ActionListener getListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				command.execute(controller);
				setEnabled(false);
			}
		};
	}

	@Override
	public void reset() {
		setEnabled(true);
	}

}
