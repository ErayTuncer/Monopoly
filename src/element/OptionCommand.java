package element;

public abstract class OptionCommand {
	
	public Game game;
	
	public OptionCommand(Game game) {
		this.game = game;
	}
	
	public abstract void execute();

}
