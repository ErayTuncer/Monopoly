package command;

import controller.Controller;
import element.Player;

public class GetPaidCommand implements Command {

	@Override
	public void execute(Controller controller) {
		Player player = controller.getGame().getCurrentPlayer();
		player.increaseBalance(controller.getGame().PAYMENT);
	}

}
