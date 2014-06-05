package gui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import element.Game;
import gui.button.CommandButton;
import gui.button.EndTurnButton;
import gui.button.RollDiceButton;

@SuppressWarnings("serial")
public class InfoScreen extends JPanel implements ResetableComponent {
	
	private Game game;
	
	private JLabel playerName;
	private JLabel playerBalance;
	private CommandButton[] buttons;
	
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

		playerName.setAlignmentX(CENTER_ALIGNMENT);
		playerBalance.setAlignmentX(CENTER_ALIGNMENT);
		
		add(playerName);
		add(playerBalance);
	}

	private void initButtons(Controller controller){
		buttons = new CommandButton[2];
		buttons[0] = new RollDiceButton(controller);
		buttons[1] = new EndTurnButton(controller);		
		
		for (CommandButton button : buttons) {
			button.setAlignmentX(CENTER_ALIGNMENT);
			add(button);		
		}
	}

	@Override
	public void reset() {
		playerName.setText("Name : " + game.getCurrentPlayer().getName());
		playerBalance.setText("Balance : " + game.getCurrentPlayer().getBalance());
		for (ResetableComponent button : buttons) {
			button.reset();
		}
	}
	
}
