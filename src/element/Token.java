package element;

public class Token {
	private int landIndex;
	private String name;
	
	public void setLocation(int landIndex) {
		this.landIndex = landIndex;
	}
	
	public int getLandIndex() {
		return landIndex;
	}
	
	public void setTokenName(String name) {
		this.name = name;
	}
	
	public String getTokenName() {
		return this.name;
	}
}
