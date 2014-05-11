package element;

public class TransportationRent extends RentInfo {

	public TransportationRent(int baseRent) {
		super(baseRent);
	}
	
	public int getRent(int transportationAmount) {
		return getBaseRent() * transportationAmount;
	}

}
