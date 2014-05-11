package element;

public abstract class PropertyLand extends Land {

	private String name;
	private int deedPrice;
	private RentInfo rentInfo;
	private boolean mortgaged;

	public PropertyLand(String name, int deedPrice, RentInfo rent) {
		this.name = name;
		this.deedPrice = deedPrice;
		this.rent = rent;
		this.mortgaged = false;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public int getDeedPrice() {
		return this.deedPrice;
	}

	public void setRent(RentInfo rent) {
		this.rentInfo = rent;
	}
	
	public final RentInfo getRentInfo() {
		return rentInfo;
	}
	
	public void changeMortgageStatus(boolean status){
		this.mortgaged = status;
	}
	
	public boolean isMortgaged(){
		return this.mortgaged;
	}

}
