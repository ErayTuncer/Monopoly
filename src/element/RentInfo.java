package element;

public abstract class RentInfo {
	
	private int baseRent;
	
	public RentInfo(int baseRent) {
		setBaseRent(baseRent);
	}

	public final void setBaseRent(int rent) {
		this.baseRent = rent;
	}

	public final int getBaseRent() {
		return baseRent;
	}

}
