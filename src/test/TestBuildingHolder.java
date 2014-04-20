package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.BuildingHolder;
import element.ColoredLand;
import element.Hotel;
import element.House;

public class TestBuildingHolder {

	@Test
	public void testAddingOneHouse() {
		BuildingHolder holder = new BuildingHolder();
		holder.addBuilding(new House());
		
		assertEquals(1, holder.getHouseAmount());
	}

	@Test
	public void testAddingFourHouse() {
		BuildingHolder holder = new BuildingHolder();
		
		holder.addBuilding(new House());
		holder.addBuilding(new House());
		holder.addBuilding(new House());
		holder.addBuilding(new House());
		
		assertEquals(BuildingHolder.MAX_HOUSE_AMOUNT, holder.getHouseAmount());
	}

	@Test(expected=RuntimeException.class)
	public void testAddingFiveHouse() {
		BuildingHolder holder = new BuildingHolder();
		
		holder.addBuilding(new House());
		holder.addBuilding(new House());
		holder.addBuilding(new House());
		holder.addBuilding(new House());

		holder.addBuilding(new House()); // illegal house
	}

	@Test
	public void testAddingHotel() {
		BuildingHolder holder = new BuildingHolder();

		holder.addBuilding(new Hotel());
		
		assertEquals(BuildingHolder.MAX_HOTEL_AMOUNT, holder.getHotelAmount());
	}

	@Test(expected=RuntimeException.class)
	public void testAddingTwoHotel() {
		BuildingHolder holder = new BuildingHolder();

		holder.addBuilding(new Hotel());

		holder.addBuilding(new Hotel()); // illegal hotel
	}

	@Test(expected=RuntimeException.class)
	public void testAddingHouseThenHotel() {
		BuildingHolder holder = new BuildingHolder();

		holder.addBuilding(new House());
		holder.addBuilding(new Hotel()); 
	}

	@Test(expected=RuntimeException.class)
	public void testAddingHotelThenHouse() {
		BuildingHolder holder = new BuildingHolder();

		holder.addBuilding(new Hotel());
		holder.addBuilding(new House());
	}

}
