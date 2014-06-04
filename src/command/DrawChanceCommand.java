package command;

import java.util.ArrayList;

import controller.Controller;
import element.Card;

public class DrawChanceCommand implements Command {

	@Override
	public void execute(Controller controller) {
		ArrayList<Card> chanceCards = controller.getGame().getBank().getChanceCards();
		Card drawnCard = chanceCards.remove(0);
		
		displayText(drawnCard.text);
		drawnCard.command.execute(controller);
		
		chanceCards.add(drawnCard);
	}

	private void displayText(String text) {
		// TODO Auto-generated method stub
	}

}
