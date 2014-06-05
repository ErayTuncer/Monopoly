package gui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import element.DicePair;
import element.Game;
import gui.button.CommandButton;
import gui.button.EndTurnButton;
import gui.button.RollDiceButton;

@SuppressWarnings("serial")
public class InfoScreen extends JPanel implements ResetableComponent {

	private Game game;

	private JLabel playerName;
	private JLabel playerBalance;
	private JLabel dice;
	
	private ButtonDirector director;

	public InfoScreen(Controller controller) {
		game = controller.getGame();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBounds(700, 0, 200, 700);

		initLabels();
		initButtons(controller);

		reset();
	}

	private void initLabels() {
		playerName = new JLabel();
		playerBalance = new JLabel();
		dice = new JLabel();

		playerName.setAlignmentX(CENTER_ALIGNMENT);
		playerBalance.setAlignmentX(CENTER_ALIGNMENT);
		dice.setAlignmentX(CENTER_ALIGNMENT);

		add(playerName);
		add(playerBalance);
		add(dice);
	}

	private void initButtons(Controller controller) {
		director = new ButtonDirector(controller);
		for (CommandButton button : director.getButtons()) {
			button.setAlignmentX(CENTER_ALIGNMENT);
			add(button);
		}
	}

	@Override
	public void reset() {
		playerName.setText("Name : " + game.getCurrentPlayer().getName());
		playerBalance.setText("Balance : " + game.getCurrentPlayer().getBalance());
		setDiceText();
		for (ResetableComponent button : director.getButtons()) {
			button.reset();
		}
	}

	private void setDiceText() {
		try {
			dice.setText(String.format("Dice : %d - %d", DicePair.getCurrent()[0], DicePair.getCurrent()[1]));
		} catch (Exception e) {
			dice.setText("Dice : " + 0 + " - " + 0);
		}

	}

}
