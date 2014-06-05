package command;

import java.util.ArrayList;

import controller.Controller;
import element.Card;

public class DrawCommunityCommand extends DrawCardCommand {

	@Override
	protected ArrayList<Card> getCards(Controller controller) {
		return controller.getGame().getBank().getCommunityCards();
	}

}
