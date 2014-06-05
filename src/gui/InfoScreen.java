package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.Controller;
import element.DicePair;
import element.Game;
import element.PropertyLand;
import gui.button.CommandButton;
import gui.button.EndTurnButton;
import gui.button.RollDiceButton;

@SuppressWarnings("serial")
public class InfoScreen extends JPanel implements ResetableComponent {

	private Game game;
	private ButtonDirector director;

	private JLabel playerName;
	private JLabel playerBalance;
	private JLabel dice;

	private JPanel propertyPanel;

	public InfoScreen(Controller controller) {
		initialize(controller);
		initButtons(controller);
		initLabels();
		showPlayerProperties();
		reset();
	}

	private void initialize(Controller controller) {
		game = controller.getGame();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBounds(700, 0, 200, 700);
	}

	private void initButtons(Controller controller) {
		director = new ButtonDirector(controller);
		for (CommandButton button : director.getButtons()) {
			button.setAlignmentX(CENTER_ALIGNMENT);
			add(button);
		}
	}

	private void initLabels() {
		createLabels();
		setLabelsAlignmentX();
		addLabels();
	}

	private void createLabels() {
		playerName = new JLabel();
		playerBalance = new JLabel();
		dice = new JLabel();
	}

	private void setLabelsAlignmentX() {
		playerName.setAlignmentX(CENTER_ALIGNMENT);
		playerBalance.setAlignmentX(CENTER_ALIGNMENT);
		dice.setAlignmentX(CENTER_ALIGNMENT);
	}

	private void addLabels() {
		add(playerName);
		add(playerBalance);
		add(dice);
	}

	private void showPlayerProperties() {
		propertyPanel = new JPanel();
		propertyPanel.setLayout(new BoxLayout(propertyPanel, BoxLayout.Y_AXIS));
		propertyPanel.setBorder(new TitledBorder("Properties Owned"));
		for (PropertyLand property : game.getCurrentPlayer().getProperties()) {
			JButton land = new JButton(property.getName());
			land.setContentAreaFilled(false);
			land.setCursor(new Cursor(Cursor.HAND_CURSOR));
			propertyPanel.add(land);
		}
		propertyPanel.setAlignmentX(CENTER_ALIGNMENT);
		propertyPanel.setVisible(true);
		add(propertyPanel);
	}

	

	private void update() {
		playerName.setText("Name : " + game.getCurrentPlayer().getName());
		playerBalance.setText("Balance : "
				+ game.getCurrentPlayer().getBalance());
		setDiceText();
		updatePlayerProperties();
		for (ResetableComponent button : director.getButtons()) {
			button.reset();
		}
		repaint();
		revalidate();
	}

	private void updatePlayerProperties() {
		remove(propertyPanel);
		showPlayerProperties();
	}

	private void setDiceText() {
		try {
			dice.setText(String.format("Dice : %d - %d",
					DicePair.getCurrent()[0], DicePair.getCurrent()[1]));
		} catch (Exception e) {
			dice.setText("Dice : " + 0 + " - " + 0);
		}
	}
	
	@Override
	public void reset() {
		update();
	}

}
