package element;

import java.util.ArrayList;

public class Player {
	private ArrayList<Card> cardsOwned;
	private ArrayList<Land> propertiesOwned;
	private int playerID, playerBalance;
	private String playerName;
	private Game game;

	public Player(Game game, int playerID, String playerName, int playerBalance) {
		// TODO token will be added
		this.game = game;
		this.playerID = playerID;
		this.playerName = playerName;
		this.playerBalance = playerBalance; // TODO maybe predefined balance
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public int getPlayerID() {
		return this.playerID;
	}

	public int getBalance() {
		return this.playerBalance;
	}

	public ArrayList<Land> getProperties() {
		return this.propertiesOwned;
	}

	public ArrayList<Card> getCardsOwned() {
		return this.cardsOwned;
	}

	public void pay(int amount) {
		this.playerBalance -= amount;
	}
	
	public void collect(int amount) {
		this.playerBalance += amount;
	}
	
	public void buy(PropertyLand land) {
		game.handover(land, this);
	}

	public void addProperty(Land land) {
		this.propertiesOwned.add(land);
	}
	
	public void mortgage(PropertyLand land){
		game.mortgage(land, this);
	}
	
	public void unmortgage(PropertyLand land){
		game.unmortgage(land, this);
	}
	






	public void discardProperty(Land land) {
		this.propertiesOwned.remove(land);
	}

	public void changeBalance(int amount) {
		this.playerBalance += amount;
	}

	public void addCard(Card card) {
		this.cardsOwned.add(card);
	}

	public void useCard(Card card) {// TODO implement
		this.cardsOwned.remove(card);
	}


	public void useCard() {

	}

}
