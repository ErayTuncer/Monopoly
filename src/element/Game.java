package element;

import java.util.ArrayList;

public class Game {
	
	private Bank bank;
	private Board board;
	private ArrayList<Player> players;
	
	public final int PAYMENT = 1500; 

	public Game(Board board, ArrayList<Player> players) {
		initBank(board.lands);
		this.board = board;
		this.players = players;
	}

	private void initBank(ArrayList<Land> lands) {
		ArrayList<PropertyLand> propertyLands = new ArrayList<PropertyLand>();
		for (Land land : lands) {
			if (land instanceof PropertyLand) {
				propertyLands.add((PropertyLand) land);
			}
		}
		bank = new Bank(propertyLands);
	}

	public Bank getBank() {
		return bank;
	}

	public Board getBoard() {
		return board;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

}
