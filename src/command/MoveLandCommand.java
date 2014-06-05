package command;

import controller.Controller;
import element.Board;
import element.Land;

public class MoveLandCommand extends MoveTokenCommand {
	
	private String landName;
	
	public MoveLandCommand(String landName) {
		this.landName = landName;
	}

	@Override
	public int getLandIndex(Controller controller) {
		Board board = controller.getGame().getBoard();
		for (Land land : board.getLands()) {
			if (land.getName().equals(landName)) {
				return board.getLands().indexOf(land);
			}
		}
		throw new RuntimeException("Land Name NOT found.");
	}

}
