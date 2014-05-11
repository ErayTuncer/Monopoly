package element;

import java.util.ArrayList;

public class Game {
	private Bank bank;
	private Board board;
	private ArrayList<Player> players;

	public Game(Bank bank, Board board, ArrayList<Player> players) {
		this.bank = bank;
		this.board = board;
		this.players = players;
	}

}
