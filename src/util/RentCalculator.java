 package util;

import element.ColoredLand;
import element.Game;
import element.InfrastructureLand;
import element.TransportationLand;

public class RentCalculator {

	private Game game;
	
	public RentCalculator(Game game) {
		this.game = game;
	}
	public int calculate(ColoredLand land){
		return land.getRentInfo().getBaseRent();
		
	}
	
	public int calculate(InfrastructureLand land){
		return land.getRentInfo().getBaseRent();
		
	}
	
	public int calculate(TransportationLand land){
		return land.getRentInfo().getBaseRent();
		
	}
}
