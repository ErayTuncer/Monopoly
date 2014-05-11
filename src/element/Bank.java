package element;

import java.util.ArrayList;

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

}
