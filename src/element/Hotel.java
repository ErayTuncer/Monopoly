package element;

public class Hotel extends Building {

	@Override
	public boolean isHouse() {
		return false;
	}

	@Override
	public boolean isHotel() {
		return true;
	}

}
