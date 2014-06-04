package command;

import controller.Controller;
import element.Game;
import element.PayTax;
import element.Player;

public class PayTaxCommand implements Command {

	@Override
	public void execute(Controller controller) {
		Game game = controller.getGame();
		Player debtor = game.getCurrentPlayer();
		PayTax payTax = (PayTax) game.getBoard().getLands().get(debtor.getToken().getLandIndex());
		int taxAmount = payTax.getTaxAmount();
		debtor.decreaseBalance(taxAmount);
	}

}
