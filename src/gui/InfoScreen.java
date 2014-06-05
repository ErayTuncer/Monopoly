package gui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.Controller;
import element.DicePair;
import gui.button.CommandButton;

@SuppressWarnings("serial")
public class InfoScreen extends JPanel implements ResetableComponent {

	private Controller controller;
	private ButtonDirector director;

	private JLabel playerName;
	private JLabel playerBalance;
	private JLabel dice;

	private PropertyListPanel propertyList;

	public InfoScreen(Controller controller) {
		initialize(controller);
		initButtons();
		initLabels();
		initListPanel();
		reset();
	}

	private void initialize(Controller controller) {
		this.controller = controller;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBounds(700, 0, 200, 700);
	}

	private void initButtons() {
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

	private void initListPanel() {
		propertyList = new PropertyListPanel();
		add(propertyList);
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

	private void update() {
		playerName.setText("Name : " + controller.getGame().getCurrentPlayer().getName());
		playerBalance.setText("Balance : " + controller.getGame().getCurrentPlayer().getBalance());
		setDiceText();
		propertyList.setProperties(controller);
		for (ResetableComponent button : director.getButtons()) {
			button.reset();
		}
		repaint();
		revalidate();
	}

	private void setDiceText() {
		try {dice.setText(String.format("Dice : %d - %d",
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
