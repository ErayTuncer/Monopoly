package element;

public abstract class PropertyLand extends Land {

	int deedPrice, housePrice, hotelPrice;

	/*public PropertyLand(int deedPrice, int housePrice, int hotelPrice) {
		this.deedPrice = deedPrice;
		this.housePrice = housePrice;
		this.hotelPrice = hotelPrice;
	}
*/
	public int getHousePrice() {
		return this.housePrice;
	}

	public int getDeedPrice() {
		return this.deedPrice;
	}

	public int getHotelPrice() {
		return this.hotelPrice;
	}

}
