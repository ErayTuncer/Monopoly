package command;

import controller.Controller;
import element.Token;

public abstract class MoveTokenCommand implements Command {

	@Override
	public void execute(Controller controller) {
		int landIndex = getLandIndex(controller);
		
		Token token = controller.getGame().getCurrentPlayer().getToken();
		token.setLocation(landIndex);
	}

	public abstract int getLandIndex(Controller controller);

}
