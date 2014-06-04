package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import element.Game;

public class GameScreen extends JFrame{
	private final int HEIGHT = 730;
	private final int WIDTH = 706;
	
	public GameScreen() {
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(new BoardScreen());
		repaint();
		revalidate();
		setVisible(true);
		
	}
	
	// Test Purpose
	public static void main(String[] args){
		new GameScreen();
	}
}
