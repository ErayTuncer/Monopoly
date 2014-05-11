package element;


public class EndTurnCommand extends OptionCommand {
	
	public EndTurnCommand(Game game){
		super(game);
	}

	@Override
	public void execute() {
		int newPlayerIndex = (game.getPlayers().indexOf(game.getCurrentPlayer()) + 1) % game.getPlayers().size();
		game.setCurrentPlayer(game.getPlayers().get(newPlayerIndex));
	}

}
