package element;

import java.util.ArrayList;

public class Player {
	private ArrayList<Card> cardsOwned;
	private ArrayList<Land> propertiesOwned;
	private int playerID, playerBalance, houseAmount, hotelAmount;
	private String playerName;
	
	public Player(int playerID, String playerName, int playerBalance){ //TODO token will be added
																	   //TODO maybe predefined balance
		this.playerID = playerID;
		this.playerName = playerName;
		this.playerBalance = playerBalance;
	}
	
	public void addProperty(Land land){
		this.propertiesOwned.add(land);
	}
	
	public void discardProperty(Land land){
		this.propertiesOwned.remove(land);
	}
	
	public void changeBalance(int amount){
		this.playerBalance += amount;
	}
	
	public int getBalance(){
		return this.playerBalance;
	}
	
	public ArrayList<Card> getCardsOwned(){
		return this.cardsOwned;
	}
	
	public int getPlayerID(){
		return this.playerID;
	}
	
	public String getPlayerName(){
		return this.playerName;
	}
	
	public ArrayList<Land> getProperties(){
		return this.propertiesOwned;
	}

	public void addCard(Card card){
		this.cardsOwned.add(card);
	}
	
	public void useCard(Card card){
		this.cardsOwned.remove(card);
	}
	
	public void buyHouse(){
		houseAmount++;
	}
	
	public void sellHouse(){
		houseAmount--;
	}
	
	public void buyHotel() {
		hotelAmount++;
	}
	
	public void sellHotel(){
		hotelAmount--;
	}
	
	public void useCard(){
		
	}
	
}
