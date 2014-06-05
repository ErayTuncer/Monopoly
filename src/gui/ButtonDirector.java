package gui;

import controller.Controller;
import gui.button.CommandButton;
import gui.button.EndTurnButton;
import gui.button.RollDiceButton;

public class ButtonDirector {
	
	private RollDiceButton rollDiceButton;
	private EndTurnButton endTurnButton;
	
	public ButtonDirector(Controller controller) {
		rollDiceButton = new RollDiceButton(controller, this);
		endTurnButton = new EndTurnButton(controller, this);
	}
	
	public CommandButton[] getButtons() {
		CommandButton[] buttons = {	
									rollDiceButton,
									endTurnButton	
								  };
		return buttons;
	}
	
	public void buttonChanged() {
		checkRollDiceButton();
	}

	private void checkRollDiceButton() {
		if (!rollDiceButton.isEnabled()) {
			endTurnButton.setEnabled(true);
		}
	}
	
}
