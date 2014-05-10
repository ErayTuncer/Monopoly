package element;

import java.awt.Color;

import util.BuildingHolder;
import behaviour.ConstructionAllowance;


public class ColoredLand extends PropertyLand {
	
	private BuildingHolder buildHolder;
	private Color color;
	
	public ColoredLand(String name, Color color, int cost, Rent rent) {
		super(name, cost, rent);
		setColor(color);
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_ALLOWED);
		initilizeBuildingHolder();
	}

	private void setColor(Color color) {
		this.color = color;
	}

	private void initilizeBuildingHolder() {
		buildHolder = new BuildingHolder();		
	}

	public BuildingHolder getBuildingHolder() {
		return buildHolder;
	}
	
	public Color getColor() {
		return color;
	}

}
