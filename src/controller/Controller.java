package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import command.Command;
import element.Board;
import element.DicePair;
import element.Game;
import element.Player;
import element.Token;
import ui.UserIO;
import util.BoardFactory;

public class Controller {

	public static void main(String[] args) {
		Controller gameController = new Controller();
		gameController.start();
	}
	
	private Game game;
	private String boardFilePath = "assets/gameBoard.txt";
	
	public Controller() {
		ArrayList<Player> players = getPlayers();
		Board board = BoardFactory.readBoard(new File(boardFilePath));
		this.game = new Game(board, players);
	}

	private ArrayList<Player> getPlayers() {
		ArrayList<Player> players = new ArrayList<Player>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Player amount: ");
		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			System.out.println("Enter player name: ");
			players.add(new Player(i, scanner.nextLine()));
		}
		return players;
	}

	private void start() {
		update();
	}
	
	public void update() {
		if(!game.hasWinner()) {
			UserIO.displayCurrentStatusOf(game);
			
			UserIO.displayOptionsOf(game);
		}
	}

	public void nextTurn() {
		int newPlayerIndex = (game.getPlayers().indexOf(game.getCurrentPlayer()) + 1) % game.getPlayers().size();
		game.setCurrentPlayer(game.getPlayers().get(newPlayerIndex));
		
		DicePair.roll();
		movePlayer(game.getCurrentPlayer(), DicePair.getDiceValue());
	}
	
	public void execute(Command command) {
		command.execute(this);
	}

	private void movePlayer(Player player, int diceValue) {
		Token token = player.getToken();
		int newLocation = (token.getLandIndex() + diceValue)
									% game.getBoard().getSize();
		token.setLocation(newLocation);
	}

	public Game getGame() {
		return game;
	}

}
