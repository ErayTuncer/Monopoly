package gui;

import java.awt.Component;

import javax.swing.JFrame;

import controller.Controller;
import element.Game;

public class GameScreen extends JFrame implements ResetableComponent {
	
	private final int HEIGHT = 730;
	private final int WIDTH = 906;
	private Game game;
	
	private ResetableComponent[] components;
	
	public GameScreen(Controller controller) {
		initialize(controller);

		addContentPanel(controller);
		repaint();
		revalidate();
		setVisible(true);
	}

	private void initialize(Controller controller) {
		this.game = controller.getGame();
		setTitle("Monopoly");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addContentPanel(Controller controller) {
		BoardScreen boardScreen = new BoardScreen(controller);
		add(boardScreen);

		InfoScreen infoScreen = new InfoScreen(controller);
		add(infoScreen);
		
		components = new ResetableComponent[2];	
		components[0] = boardScreen;
		components[1] = infoScreen;
	}
	
	@Override
	public void reset() {
		for (ResetableComponent component : components) {
			component.reset();
		}
	}
	
}
