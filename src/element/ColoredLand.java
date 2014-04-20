package element;

import util.BuildingHolder;
import behaviour.ConstructAllowed;


public class ColoredLand extends PropertyLand {
	
	private BuildingHolder buildHolder;

	public ColoredLand() {
		super(new ConstructAllowed());
		buildHolder = new BuildingHolder();
	}
	

	public BuildingHolder getBuildingHolder() {
		return buildHolder;
	}
	
}
