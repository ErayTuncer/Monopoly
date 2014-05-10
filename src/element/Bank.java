package element;

import java.util.ArrayList;

public class Bank {
	private ArrayList<PropertyLand> titleDeeds = new ArrayList<>();
	private ArrayList<Card> cards = new ArrayList<>();
	private final int SALARY = 1500;
	private int balance = Integer.MAX_VALUE; 
	private int houses = 32;
	private int hotels = 12;
	
	
	
	public void sell(PropertyLand land, Player player){
		titleDeeds.remove(land);
		balance += land.getDeedPrice();
		player.addProperty(land);
		player.changeBalance(-land.getDeedPrice());
	}
	
	//TODO do price exchange
	public void trade(Land land, Player seller, Player buyer){
		seller.discardProperty(land);
		buyer.addProperty(land);
	}
	
	public void paySalary(Player player){
		player.changeBalance(SALARY);
		balance -= SALARY;
	}
	
	public void sellHouse(Player player, PropertyLand currentLand){
		player.buyHouse();
		player.changeBalance(-currentLand.getHousePrice());
		houses--;
		balance += currentLand.getHousePrice();
	}
	
	public void sellHotel(Player player, PropertyLand currentLand){
		player.buyHotel();
		player.changeBalance(-currentLand.getHotelPrice());
		hotels--;
		balance += currentLand.getHotelPrice();
	}

}
