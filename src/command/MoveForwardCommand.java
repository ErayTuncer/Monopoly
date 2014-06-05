package command;

import controller.Controller;
import element.Game;

public class MoveForwardCommand extends MoveTokenCommand {
	
	private int stepForward;
	
	public MoveForwardCommand(int stepForward) {
		this.stepForward = stepForward;
	}

	@Override
	public int getLandIndex(Controller controller) {
		Game game = controller.getGame();
		int currentIndex = game.getCurrentPlayer().getToken().getLandIndex();
		int movedIndex = (currentIndex + stepForward) % game.getBoard().getSize();
		return movedIndex;
	}

	@Override
	public boolean isForward() {
		return true;
	}

}
