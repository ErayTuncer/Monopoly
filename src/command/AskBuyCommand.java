package command;

import javax.swing.JOptionPane;

import controller.Controller;
import element.Game;
import element.Player;
import element.PropertyLand;

public class AskBuyCommand implements Command {

	@Override
	public void execute(Controller controller) {
		Game game = controller.getGame();
		PropertyLand land = (PropertyLand) game.getBoard().getLands().get(game.getCurrentPlayer().getToken().getLandIndex());
		String message = "Do you want to buy " + land.toString() + " for " + land.getPrice() + "K ?";
		String title = controller.getGame().getCurrentPlayer().getName();
		int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
		
		if(reply == JOptionPane.YES_OPTION) {
			makePurchase(controller, land);
		} else {
			display("Player " + game.getCurrentPlayer().getName() + " did not want to purchase " + land.getName(), controller);
		}
		
	}

	private void makePurchase(Controller controller, PropertyLand land) {
		Player player = controller.getGame().getCurrentPlayer();
		if(player.getBalance() > land.getPrice()) {
			player.decreaseBalance(land.getPrice());
			player.addProperty(land);
			land.setAssignment(new PayRentCommand());
			display(player.getName() + "owned " + land.getName(), controller);
		} else {
			display("Purchase of " + land.getName() + "denied", controller);
		}
	}

	private void display(String string, Controller controller) {
		(new LogInfoCommand(string)).execute(controller);
	}

}
