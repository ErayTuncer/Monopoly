package command;

import util.RentCalculator;
import element.Game;
import element.Land;
import element.Player;
import element.PropertyLand;

public class PayRentCommand extends PayCommand {	

	@Override
	protected int getPaymentAmount(Land land, Game game) {
		PropertyLand property = (PropertyLand) land;
		return property.acceptVisitor(new RentCalculator(game));
	}

	@Override
	protected void makeTransaction(Game game, int paymentAmount) {
		Player source = game.getCurrentPlayer();
		Player target = game.getOwner((PropertyLand) getCurrentLand(game));
		source.decreaseBalance(paymentAmount);
		target.increaseBalance(paymentAmount);
	}

}
