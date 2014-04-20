package util;

import java.util.ArrayList;

import element.Building;

public class BuildingHolder extends ArrayList<Building> {
	
	public static final int MAX_HOUSE_AMOUNT = 4;
	public static final int MAX_HOTEL_AMOUNT = 1;

	public void addBuilding(Building building) {
		if (building.isHotel()) {
			addHotel(building);
		} else {
			addHouse(building);
		}
	}

	private void addHotel(Building hotel) {
		if (getHotelAmount() < MAX_HOTEL_AMOUNT && getHouseAmount() == 0) {
			add(hotel);
		} else {
			throw new RuntimeException("MAX HOTEL REACHED OR HOLDER HAS HOUSE.");
		}
	}

	private void addHouse(Building house) {
		if (getHouseAmount() < MAX_HOUSE_AMOUNT && getHotelAmount() == 0) {
			add(house);
		} else {
			throw new RuntimeException("MAX HOUSE REACHED OR HOLDER HAS HOTEL.");
		}					
	}

	public int getHouseAmount() {
		int numberHouse = 0;
		
		for (Building building : this) {
			numberHouse += (building.isHouse())? 1 : 0;
		}
		
		return numberHouse;
	}

	public int getHotelAmount() {
		int numberHotel = 0;
		
		for (Building building : this) {
			numberHotel += (building.isHotel())? 1 : 0;
		}
		
		return numberHotel;	
	}

}
