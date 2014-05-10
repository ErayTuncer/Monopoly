package element;


public abstract class PropertyLand extends Land {

	private String name;
	private int cost;
	private Rent rent;

	public PropertyLand(String name, int cost, Rent rent) {
		setName(name);
		setCost(cost);
		setRent(rent);
	}

	private final void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	private final void setCost(int cost) {
		this.cost = cost;
	}

	private final void setRent(Rent rent) {
		this.rent = rent;
	}

	public final int getCost() {
		return cost;
	}

	public final Rent getRent() {
		return rent;
	}
	
}
