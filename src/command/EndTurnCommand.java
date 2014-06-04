package command;

import controller.Controller;
import element.Game;


public class EndTurnCommand implements Command {

	@Override
	public void execute(Controller controller) {
		Game game = controller.getGame();
		int newPlayerIndex = (game.getPlayers().indexOf(game.getCurrentPlayer()) + 1) % game.getPlayers().size();
		game.setCurrentPlayer(game.getPlayers().get(newPlayerIndex));
	}

}
