package behaviour;

public class ConstructDenied implements ConstructionAllowance {

	@Override
	public boolean isConstructionAllowed() {
		return false;
	}

}
