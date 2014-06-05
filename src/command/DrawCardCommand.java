package command;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.Controller;
import element.Card;

public abstract class DrawCardCommand implements Command {
	
	@Override
	public void execute(Controller controller) {
		ArrayList<Card> cards = getCards(controller);
		Card drawnCard = cards.remove(0);
		
		displayText(drawnCard.text);
		drawnCard.command.execute(controller);
		
		cards.add(drawnCard);
	}

	private void displayText(String text) {
		JOptionPane.showMessageDialog(null, text);
	}
	
	protected abstract ArrayList<Card> getCards(Controller controller);
	
}
