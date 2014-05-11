package element;

public class Game {
	private Bank bank;

	public Game() {
		// TODO initialize Bank
	}

	public void handover(PropertyLand land, Player player) {
		if (player.getBalance() >= land.getPrice()) {
			bank.sell(land, player);
		} else {
			System.out.println("Not have enough money to buy this property!");
		}
	}

}
