package element;

import java.awt.Color;

import util.BuildingHolder;
import behaviour.ConstructionAllowance;


public class ColoredLand extends PropertyLand {
	
	private BuildingHolder buildingHolder;
	private Color color;
	private int housePrice;
	
	public ColoredLand(String name, Color color, int price, int housePrice, RentInfo rent) {
		super(name, price, rent);
		this.housePrice = housePrice;
		setColor(color);
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_ALLOWED);
		initilizeBuildingHolder();
	}

	private void setColor(Color color) {
		this.color = color;
	}

	private void initilizeBuildingHolder() {
		buildingHolder = new BuildingHolder();		
	}

	public BuildingHolder getBuildingHolder() {
		return buildingHolder;
	}
	
	public Color getColor() {
		return color;
	}

	public int getHousePrice() {
		return housePrice;
	}

	public int getHotelPrice() {
		return housePrice * 5;
	}

}
