package command;

import controller.Controller;
import element.Board;
import element.Land;

public class MoveLandCommand extends MoveTokenCommand {
	
	private Land land;
	
	public MoveLandCommand(Land land) {
		this.land = land;
	}

	@Override
	public int getLandIndex(Controller controller) {
		Board board = controller.getGame().getBoard();
		return board.getLands().indexOf(land);
	}

}
