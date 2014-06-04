package gui;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import element.Game;

@SuppressWarnings("serial")
public class InfoScreen extends JPanel {
	private Game game;
	private String[] buttons = { "Buy", "Sell" };
	private ActionListener[] listeners = { null, null/*new BuyButtonListener(), new SellButtonListener() */ };

	public InfoScreen(Game game) {
		initialize(game);

		addLabels();
		addButtons();
	}

	private void initialize(Game game) {
		this.game = game;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBounds(700, 0, 200, 700);
	}

	private void addLabels() {
		String name = "Player: " + game.getCurrentPlayer().getName();
		add(createLabel(name));

		String balance = "Balance: " + game.getCurrentPlayer().getBalance();
		add(createLabel(balance));
	}

	private JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		label.setAlignmentX(CENTER_ALIGNMENT);
		return label;
	}

	private void addButtons(){
		for (int i = 0; i < listeners.length; i++) {
			JButton button = new JButton(buttons[i]);
			button.addActionListener(listeners[i]);
			button.setAlignmentX(CENTER_ALIGNMENT);
			add(button);		
		}
	}
	
	
}
