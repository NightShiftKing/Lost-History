package main.java.models;

import javax.swing.*;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	public Frame() {
		// this controls the panels

		MainGamePanel panel = new MainGamePanel();
		GameOverPanel gameOverPanel = new GameOverPanel();

		// this controls the frame
		JFrame frame = new JFrame("Lost History");

		frame.setSize(2000, 2000);

		frame.add(panel);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// if player dies GameOverPanel comes on
		if (MainGamePanel.playerDeath == true) {
			frame.add(gameOverPanel);
			panel.setVisable(false);
			gameOverPanel.setVisable(true);

		}

	}

}
