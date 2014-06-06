package command;

import javax.swing.JOptionPane;

import controller.Controller;
import element.Player;
import element.PropertyLand;

public class MortgageCommand implements Command {

	private PropertyLand property;

	public MortgageCommand(PropertyLand property) {
		this.property = property;
	}

	@Override
	public void execute(Controller controller) {
		Player player = controller.getGame().getCurrentPlayer();
		if (player.getProperties().contains(property)) {
			askMortgage(player);
		} else if (player.getMortgagedProperties().contains(property)) {
			askUnmortgage(player);
		}
	}

	private void askMortgage(Player player) {
		int reply = ask(player, "mortgage");
		doCommand(player, reply, "mortgage");
	}

	private void askUnmortgage(Player player) {
		int reply = ask(player, "unmortgage");
		doCommand(player, reply, "unmortgage");
	}

	private void doCommand(Player player, int reply, String command) {
		if (reply == JOptionPane.YES_OPTION) {
			if (command.equals("mortgage")) {
				player.getProperties().remove(property);
				player.getMortgagedProperties().add(property);
				player.increaseBalance(property.getMortgage());
			} else if (command.equals("unmortgage")) {
				player.getProperties().add(property);
				player.getMortgagedProperties().remove(property);
				player.decreaseBalance(property.getMortgage());
			}
			JOptionPane.showMessageDialog(null, String.format(
					"%s is %s for %dK.", property.getName(), command, property.getMortgage()));
		} else {
			JOptionPane.showMessageDialog(null, command + " canceled.");
		}
	}

	private int ask(Player player, String command) {
		String title = player.getName();
		String message = String.format("Do you want to %s %s for %dK?",
				command, property.getName(), property.getMortgage());
		return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
	}

}
