package element;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import util.BoardFactory;

public class Controller {
	
	public static void main(String[] args) {
		new Controller();
	}
	
	private Game game;
	private String boardFilePath = "!!!!!!!!!!!!!!!!!!";
	
	public Controller() {
		ArrayList<Player> players = getPlayers();
		Board board = BoardFactory.readBoard(new File(boardFilePath));
		this.game = new Game(board, players);
		start();
	}

	private ArrayList<Player> getPlayers() {
		ArrayList<Player> players = new ArrayList<Player>();
		Scanner scanner =  new Scanner(System.in);
		System.out.println("Player amount: ");
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter player name: ");
			players.add(new Player(i, scanner.nextLine()));
		}
		scanner.close();
		return players;
	}
	
	private void start() {
		while(!game.hasWinner()) {
			
			
		}

	}
	

}
