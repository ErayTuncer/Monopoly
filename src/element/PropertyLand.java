package element;


public abstract class PropertyLand extends Land {

	private String name;
	private int price;
	private RentInfo rentInfo;

	public PropertyLand(String name, int price, RentInfo rent) {
		setName(name);
		setPrice(price);
		setRent(rent);
	}

	private final void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	private final void setPrice(int price) {
		this.price = price;
	}

	public void setRent(RentInfo rent) {
		this.rentInfo = rent;
	}

	public final int getPrice() {
		return price;
	}
	
	public final RentInfo getRentInfo() {
		return rentInfo;
	}
	
}
