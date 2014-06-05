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
import gui.GameScreen;
import ui.UserIO;
import util.BoardFactory;

public class Controller {

	public static void main(String[] args) {
		Controller gameController = new Controller();
		gameController.start();
	}
	
	private Game game;
	private GameScreen gameFrame;
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
		gameFrame = new GameScreen(this);
		gameFrame.setVisible(true);
	}

	 public void update() {
		gameFrame.reset();
	}
	
	public void execute(Command command) {
		command.execute(this);
	}

	public Game getGame() {
		return game;
	}

}
