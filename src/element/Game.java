package element;

public class Game {
	private Bank bank;

	public Game() {
		// TODO initialize Bank
	}

	public void handover(PropertyLand land, Player player) {
		if (player.getBalance() >= land.getDeedPrice()) {
			bank.sell(land, player);
		} else {
			System.out.println("Not have enough money to buy this property!");
		}
	}

	public void mortgage(PropertyLand land, Player player) {
		if (!land.isMortgaged()) { // TODO check house/hotel condition
			bank.mortgage(land, player);
		} else {
			System.out.println("This property's already mortgaged!");
		}
	}

	public void unmortgage(PropertyLand land, Player player) {
		if (land.isMortgaged()) {
			bank.unmortgage(land, player);
		} else {
			System.out.println("This property's already unmortgaged!");
		}
	}

}
