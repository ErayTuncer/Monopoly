package command;

import controller.Controller;
import element.Land;
import element.Token;

public abstract class MoveTokenCommand implements Command {

	@Override
	public void execute(Controller controller) {
		int landIndex = getLandIndex(controller);
		Land land = controller.getGame().getBoard().getLands().get(landIndex);

		Token token = controller.getGame().getCurrentPlayer().getToken();
		token.setLocation(landIndex);
		controller.update();
		
		Command command = land.getAssignment();
		command.execute(controller);
	}

	public abstract int getLandIndex(Controller controller);

}
