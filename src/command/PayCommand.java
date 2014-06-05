package command;

import controller.Controller;
import element.Game;
import element.Land;

public abstract class PayCommand implements Command {
	
	@Override
	public void execute(Controller controller) {
		Game game = controller.getGame();
		
		Land land = getCurrentLand(game);
		
		int paymentAmount = getPaymentAmount(land, game);
		
		makeTransaction(game, paymentAmount);
	}

	protected abstract int getPaymentAmount(Land land, Game game);

	protected Land getCurrentLand(Game game) {
		return game.getBoard().getLands().get(game.getCurrentPlayer().getToken().getLandIndex());
	}

	protected abstract void makeTransaction(Game game, int paymentAmount);
}
