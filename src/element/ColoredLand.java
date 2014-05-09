package element;

import util.BuildingHolder;
import behaviour.ConstructAllowed;


public class ColoredLand extends PropertyLand {
	
	private BuildingHolder buildHolder;

	public ColoredLand() {
		buildHolder = new BuildingHolder();
	}
	

	public BuildingHolder getBuildingHolder() {
		return buildHolder;
	}
	
}
