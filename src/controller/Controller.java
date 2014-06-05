package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import command.Command;
import element.Bank;
import element.Board;
import element.DicePair;
import element.Game;
import element.Player;
import element.Token;
import gui.GameScreen;
import ui.UserIO;
import util.BoardFactory;
import util.CardFactory;

public class Controller {

	public static void main(String[] args) {
		Controller gameController = new Controller();
		gameController.start();
	}
	
	private Game game;
	private GameScreen gameFrame;
	
	private String boardFilePath = "assets/gameBoard.txt";
	private String cardFilePath = "assets/cards.txt";
	
	public Controller() {
		ArrayList<Player> players = getPlayers();
		initGame(players);
		initCards();
	}

	private void initGame(ArrayList<Player> players) {
		Board board = BoardFactory.readBoard(new File(boardFilePath));
		this.game = new Game(board, players);		
	}

	private ArrayList<Player> getPlayers() {
		ArrayList<Player> players = new ArrayList<Player>();
		int n = Integer.parseInt(JOptionPane.showInputDialog("Enter Player Amount"));
		for (int i = 0; i < n; i++) {
			players.add(new Player(i, JOptionPane.showInputDialog(String.format("#%d Player Name : ", i + 1))));
		}
		return players;
	}
	
	private void initCards() {
		Bank bank = game.getBank();
		bank.chanceCards = CardFactory.readChanceCards(new File(cardFilePath));
		bank.communityCards = CardFactory.readCommunityCards(new File(cardFilePath));		
	}

	private void start() {
		gameFrame = new GameScreen(this);
		gameFrame.setVisible(true);
	}

	 public void update() {
		gameFrame.reset();
	}
	
	public void execute(Command command) {
		command.execute(this);
	}

	public Game getGame() {
		return game;
	}

}
