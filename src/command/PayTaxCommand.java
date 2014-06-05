package command;

import element.Game;
import element.Land;
import element.PayTax;
import element.Player;

public class PayTaxCommand extends PayCommand {

	@Override
	protected int getPaymentAmount(Land land, Game game) {
		PayTax payTax = (PayTax) land;
		return payTax.getTaxAmount();
	}

	@Override
	protected void makeTransaction(Game game, int paymentAmount) {
		Player source = game.getCurrentPlayer();
		source.decreaseBalance(paymentAmount);
	}

}
