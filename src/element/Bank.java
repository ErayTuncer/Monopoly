package element;

import java.util.ArrayList;

import util.BuildingHolder;

public class Bank {
	private ArrayList<PropertyLand> titleDeeds = new ArrayList<>();
	private ArrayList<Card> cards = new ArrayList<>();
	private final int SALARY = 1500;
	private int houses = 32;
	private int hotels = 12;

	public Bank() {// TODO implement followings
		// titleDeeds.addAll properties
		// cards.addAll cards
		// mortgagedLands
	}

	public void sell(PropertyLand land, Player player) {
		titleDeeds.remove(land);
		player.addProperty(land);
		player.pay(land.getDeedPrice());
	}

	public void mortgage(PropertyLand land, Player player) {
		land.changeMortgageStatus(true);
		player.collect(land.getDeedPrice() / 2);
	}
	
	private ArrayList<PropertyLand> propertyLands = new ArrayList<PropertyLand>();
	//private ArrayList<Card> cards = new ArrayList<>(); //TODO:
	
	public final int INITIAL_PAYMENT = 1500; 
	
	private final int MAX_HOUSE_AMOUNT = 32;
	private final int MAX_HOTEL_AMOUNT = 12;
	
	private ArrayList<House> houses;
	private ArrayList<Hotel> hotels;
	
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

	public void unmortgage(PropertyLand land, Player player) {
		land.changeMortgageStatus(false);
		player.pay(land.getDeedPrice() / 2);
	}

	
	
	
	
	
	
	public void paySalary(Player player) {
		player.changeBalance(SALARY);
	}

	// TODO do price exchange between players
	public void trade(Land land, Player seller, Player buyer) {
		seller.discardProperty(land);
		buyer.addProperty(land);
	}

	// TODO combine into
	// public void sellBuilding(){}
	// reqs: change addBuilding methods in BuildingHolder

	public void sellHouse(Player player, ColoredLand land) {
		if ((--houses) >= 0) {
			land.getBuildingHolder().addBuilding(new House());
			// player.changeBalance(-land.getHousePrice());
		}
	}

	public void sellHotel(Player player, ColoredLand land) {
		if ((--hotels) >= 0) {
			land.getBuildingHolder().addBuilding(new Hotel());
			// player.changeBalance(-land.getHotelPrice());
		}
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
