package gui;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import element.Game;
import element.Player;

@SuppressWarnings("serial")
public class BoardScreen extends JPanel {
	private int[][] tileCoordinates;
	private Game game;

	public BoardScreen(Game game) { // TODO
		initialize(game);
		addTiles();
		addTokens();
		addBoardImage();
	}

	private void initialize(Game game) {
		this.game = game;
		setFocusable(true);
		setLayout(null);
		setBounds(0, 0, 700, 700);
	}

	private void addTiles() {
		tileCoordinates = new int[40][2];
		int xPos = 620;
		int yPos = 620;
		for (int i = 0; i < tileCoordinates.length; i++) {
			tileCoordinates[i][0] = xPos;
			tileCoordinates[i][1] = yPos;

			if (0 <= i && i < 10) {
				xPos -= 60;
			} else if (10 <= i && i < 20) {
				yPos -= 60;
			} else if (20 <= i && i < 30) {
				xPos += 60;
			} else if (30 <= i && i < 40) {
				yPos += 60;
			} else {
				throw new RuntimeException("Too many tiles");
			}
		}
	}

	private void addTokens() {
		ArrayList<Player> players = game.getPlayers();

	}

	private void addBoardImage() {
		Image boardImage = new ImageIcon("assets/referenceBoard.jpg").getImage();
		boardImage = boardImage.getScaledInstance(700, 700, Image.SCALE_SMOOTH);
		JLabel board = new JLabel(new ImageIcon(boardImage));
		board.setBounds(0, 0, 700, 700);
		add(board);
	}

	public void update() {
		// TODO
	}

}
