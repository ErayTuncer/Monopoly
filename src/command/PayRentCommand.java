package command;

import javax.swing.JOptionPane;

import controller.Controller;
import util.RentCalculator;
import element.Game;
import element.Land;
import element.Player;
import element.PropertyLand;

public class PayRentCommand implements Command {	

	@Override
	public void execute(Controller controller) {
		Game game = controller.getGame();
		PropertyLand property = (PropertyLand) getCurrentLand(game);
		int payment = property.acceptVisitor(new RentCalculator(game));
		makeTransaction(game, payment);
	}

	protected Land getCurrentLand(Game game) {
		return game.getBoard().getLands().get(game.getCurrentPlayer().getToken().getLandIndex());
	}

	private void makeTransaction(Game game, int payment) {
		Player source = game.getCurrentPlayer();
		Player target = game.getOwner((PropertyLand) getCurrentLand(game));
		if(!source.equals(target)) {
			source.decreaseBalance(payment);
			target.increaseBalance(payment);
			JOptionPane.showMessageDialog(null, source.getName() + " paid " + payment + "K to " + target.getName());
		}
	}



}
