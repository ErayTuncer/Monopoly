package gui;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import element.DicePair;
import element.Game;
import element.Player;

@SuppressWarnings("serial")
public class BoardScreen extends JPanel implements ResetableComponent {
	private int[][] tileCoordinates;
	private Game game;
	private ArrayList<JLabel> tokens;
	private JLabel circle;

	public BoardScreen(Controller controller) { // TODO
		initialize(controller);
		addTiles();
		addTokens();
		addCircle();
		addBoardImage();
	}

	private void initialize(Controller controller) {
		this.game = controller.getGame();
		this.tokens = new ArrayList<>();
		setFocusable(true);
		setLayout(null);
		setBounds(0, 0, 700, 700);
	}

	private void addTiles() {
		tileCoordinates = new int[40][2];
		int xPos = 636;
		int yPos = 635;
		int slideAmount = 58;
		for (int i = 0; i < tileCoordinates.length; i++) {
			tileCoordinates[i][0] = xPos;
			tileCoordinates[i][1] = yPos;

			if (i + 1 % 10 == 0 || i % 10 == 0) {
				slideAmount = 72;
			} else {
				slideAmount = 58;
			}

			if (0 <= i && i < 10) {
				xPos -= slideAmount;
			} else if (10 <= i && i < 20) {
				yPos -= slideAmount;
			} else if (20 <= i && i < 30) {
				xPos += slideAmount;
			} else if (30 <= i && i < 40) {
				yPos += slideAmount;
			} else {
				throw new RuntimeException("Too many tiles");
			}
		}
	}

	private void addTokens() {
		ArrayList<Player> players = game.getPlayers();
		for (Player player : players) {
			Image tokenImage = player.getToken().getImage();
			JLabel token = new JLabel(new ImageIcon(tokenImage));
			token.setBounds(tileCoordinates[0][0], tileCoordinates[0][1], 30, 22);
			tokens.add(token);
			add(token);
		}
	}

	private void addCircle() {
		Icon circleIcon = new ImageIcon("assets/circle.gif");
		circle = new JLabel(circleIcon);
		circle.setBounds(900, 900, 50, 50);
		add(circle);
	}

	private void addBoardImage() {
		Image boardImage = new ImageIcon("assets/referenceBoard.jpg").getImage();
		boardImage = boardImage.getScaledInstance(700, 700, Image.SCALE_SMOOTH);
		JLabel board = new JLabel(new ImageIcon(boardImage));
		board.setBounds(0, 0, 700, 700);
		add(board);
	}

	public void update() {
		int tokenID = game.getCurrentPlayer().getPlayerID();
		int tokenTile = game.getCurrentPlayer().getToken().getLandIndex() % game.getBoard().getSize();
		tokens.get(tokenID).setLocation(tileCoordinates[tokenTile][0], tileCoordinates[tokenTile][1]);
		drawCircle(tokenID, tokenTile);
		repaint();
		revalidate();

		// Test Purpose
		System.out.println("Dice : " + DicePair.getDiceValue());
		System.out.println("Player : " + game.getCurrentPlayer().getName() + "  -  index : " + game.getCurrentPlayer().getToken().getLandIndex());
	}

	private void drawCircle(int tokenID, int tokenTile) {
		int circleXPos = tileCoordinates[tokenTile][0] - (circle.getWidth() - tokens.get(tokenID).getWidth()) / 2;
		int circleYPos = tileCoordinates[tokenTile][1] - (circle.getHeight() - tokens.get(tokenID).getHeight())	/ 2;
		circle.setLocation(circleXPos, circleYPos);
	}

	@Override
	public void reset() {
		update();
	}

}
