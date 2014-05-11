package element;

import java.util.ArrayList;

import util.BuildingHolder;

public class Bank {
	private ArrayList<PropertyLand> propertyLands = new ArrayList<PropertyLand>();
	private ArrayList<Card> cards = new ArrayList<>(); //TODO:
	
	public final int INITIAL_PAYMENT = 1500; 
	
	private final int MAX_HOUSE_AMOUNT = 32;
	private final int MAX_HOTEL_AMOUNT = 12;
	
	private ArrayList<House> houses;
	private  ArrayList<Hotel> hotels;
	
	public Bank(ArrayList<PropertyLand> propertyLands){
		this.propertyLands = propertyLands;
		initBuildings();
	}
	
	private void initBuildings() {
		initHouses();
		initHotels();		
	}

	private void initHouses() {
		houses = new ArrayList<House>();
		for (int i = 0; i < MAX_HOUSE_AMOUNT; i++)
			houses.add(new House());
	}

	private void initHotels() {
		hotels = new ArrayList<Hotel>();
		for (int i = 0; i < MAX_HOTEL_AMOUNT; i++)
			hotels.add(new Hotel());
	}

	public void sell(PropertyLand land, Player player){
		propertyLands.remove(land);
		player.addProperty(land);
		player.decreaseBalance(land.getPrice());
	}
	
	public void pay(Player player, int amount){
		player.increaseBalance(amount);
	}
	
	public void sellHouse(Player player, ColoredLand currentLand){
		player.decreaseBalance(currentLand.getHousePrice());
		BuildingHolder holder = currentLand.getBuildingHolder();
		holder.add(houses.remove(0));
	}
	
	public void sellHotel(Player player, ColoredLand currentLand){
		player.decreaseBalance(currentLand.getHousePrice());
		BuildingHolder holder = currentLand.getBuildingHolder();
		holder.add(hotels.remove(0));
	}
	
	//TODO do price exchange
	public void trade(Land land, Player seller, Player buyer){
		seller.discardProperty(land);
		buyer.addProperty(land);
	}

}
