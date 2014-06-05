package command;

import java.util.ArrayList;

import controller.Controller;
import element.Card;

public class DrawChanceCommand extends DrawCardCommand {

	@Override
	protected ArrayList<Card> getCards(Controller controller) {
		return controller.getGame().getBank().getChanceCards();
	}

}
