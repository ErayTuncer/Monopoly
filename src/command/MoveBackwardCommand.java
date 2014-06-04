package command;

import controller.Controller;
import element.Game;

public class MoveBackwardCommand extends MoveTokenCommand {
	
	private int stepBackward;
	
	public MoveBackwardCommand(int stepBackward) {
		this.stepBackward = stepBackward;
	}

	@Override
	public int getLandIndex(Controller controller) {
		Game game = controller.getGame();
		int currentIndex = game.getCurrentPlayer().getToken().getLandIndex();
		int movedIndex = ((currentIndex - stepBackward) + game.getBoard().getLands().size()) % game.getBoard().getLands().size();
		return movedIndex;
	}
	
}
