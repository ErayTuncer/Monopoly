package element;

public abstract class PropertyLand extends Land {

	private String name;
	private int deedPrice;
	private Rent rent;
	private boolean mortgaged;

	public PropertyLand(String name, int deedPrice, Rent rent) {
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

	public final Rent getRent() {
		return rent;
	}
	
	public void changeMortgageStatus(boolean status){
		this.mortgaged = status;
	}
	
	public boolean isMortgaged(){
		return this.mortgaged;
	}
	
	

}
