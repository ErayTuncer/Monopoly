package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import element.Game;

public class GameScreen extends JFrame {
	private final int HEIGHT = 730;
	private final int WIDTH = 906;
	private Game game;

	public GameScreen(Game game) {
		initialize(game);

		add(addContentPanel());
		repaint();
		revalidate();
		setVisible(true);
	}

	private void initialize(Game game) {
		this.game = game;
		setTitle("Monopoly");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JPanel addContentPanel() {
		JPanel contentPanel = createContentPanel();

		BoardScreen boardScreen = new BoardScreen(game);
		contentPanel.add(boardScreen, BorderLayout.WEST);

		InfoScreen infoScreen = new InfoScreen(game);
		contentPanel.add(infoScreen, BorderLayout.EAST);

		return contentPanel;
	}

	private JPanel createContentPanel() {
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 730, 906);
		contentPanel.setLayout(null);
		contentPanel.setVisible(true);
		return contentPanel;
	}

	// Test Purpose
	public static void main(String[] args) {
		new GameScreen(new Controller().getGame());
	}
}
