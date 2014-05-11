package element;

import java.awt.Color;

import util.BuildingHolder;
import behaviour.ConstructionAllowance;


public class ColoredLand extends PropertyLand {
	
	private BuildingHolder buildingHolder;
	private Color color;
	
	public ColoredLand(String name, Color color, int price, RentInfo rent) {
		super(name, price, rent);
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

}
