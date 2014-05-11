package element;

import java.util.Scanner;

public abstract class UserIO {
	
	public static void displayCurrentStatusOf(Game game){
		displayCurrentPlayer(game.getCurrentPlayer());
		displayCurrentDice();
		displayCurrentLand(game.getBoard(), game.getCurrentPlayer().getToken());
		
	}

	private static void displayCurrentPlayer(Player player) {
		System.out.printf("%s is now playing\n", player.getName());
	}

	private static void displayCurrentDice() {
		System.out.printf("Rolled dice %d-%d\n", DicePair.getCurrent()[0], DicePair.getCurrent()[1]);
	}

	private static void displayCurrentLand(Board board, Token token) {
		System.out.printf("Token is now on %s\n", board.getLands().get(token.getLandIndex()).getName());
	}
	
	public static void displayOptionsOf(Game game){
		System.out.println("Options are below : ");
		System.out.println("[0] End Turn ");
		System.out.print("Type Option : ");
	}

	public static OptionCommand getOptionCommand(Game game) {
		Scanner scanner = new Scanner(System.in);
		int choice = Integer.parseInt(scanner.nextLine()); 
		if( choice == 0) return new EndTurnCommand(game);	
		throw new RuntimeException("Illegal Option");
	}
	
}
