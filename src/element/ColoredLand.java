package element;

import util.BuildingHolder;
import behaviour.ConstructAllowed;
import behaviour.ConstructionAllowance;


public class ColoredLand extends PropertyLand {
	
	private BuildingHolder buildHolder;

	public ColoredLand() {
		buildHolder = new BuildingHolder();
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_ALLOWED);
	}
	

	public BuildingHolder getBuildingHolder() {
		return buildHolder;
	}
	
}
