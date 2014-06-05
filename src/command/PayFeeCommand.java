package command;

import javax.swing.JOptionPane;

import controller.Controller;
import element.Player;

public class PayFeeCommand implements Command {
	
	private int fee;
	
	public PayFeeCommand(int fee) {
		this.fee = fee;
	}

	@Override
	public void execute(Controller controller) {
		Player player = controller.getGame().getCurrentPlayer();
		player.decreaseBalance(fee);
		JOptionPane.showMessageDialog(null, String.format("%s paid : %dK", player.getName(), fee));
	}

}
