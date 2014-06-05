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
		if(player.getProperties().contains(property)) {
			askMortgage(player, property);
		} else if (player.getMortgagedProperties().contains(property)) {
			askUnmortgage(player, property);
		}
		
	}

	private void askMortgage(Player player, PropertyLand property) {
		String title = player.getName();
		String message = "Do you want to mortgage " + property + " for " + property.getMortgage() + "K ?";
		int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
		
		if(reply == JOptionPane.YES_OPTION) {
			player.getMortgagedProperties().add(property);
			player.getProperties().remove(property);
			player.increaseBalance(property.getMortgage());
			JOptionPane.showMessageDialog(null, property.getName() + " is mortgaged for " + property.getMortgage() + "K");
		} else {
			JOptionPane.showMessageDialog(null, "Mortgage canceled.");
		}
		
	}

	private void askUnmortgage(Player player, PropertyLand property2) {
		String title = player.getName();
		String message = "Do you want to UNmortgage " + property + " for " + property.getMortgage() + "K ?";
		int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
		
		if(reply == JOptionPane.YES_OPTION) {
			player.getProperties().add(property);
			player.getMortgagedProperties().remove(property);
			player.decreaseBalance(property.getMortgage());
			JOptionPane.showMessageDialog(null, property.getName() + " is UNmortgaged for " + property.getMortgage() + "K");
		} else {
			JOptionPane.showMessageDialog(null, "UNmortgage canceled.");
		}
	}

}
