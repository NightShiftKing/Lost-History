package main.java.models;

import javax.swing.*;

import org.apache.log4j.Logger;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(Frame.class);

	public Frame() {
		// this controls the panels

		MainGamePanel panel = new MainGamePanel();
		GameOverPanel gameOverPanel = new GameOverPanel();

		// this controls the frame
		JFrame frame = new JFrame("Lost History");

		frame.setSize(2000, 2000);

		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logger.info("The player is dead? " + String.valueOf(MainGamePanel.playerDeath));

		// if player dies GameOverPanel comes on
		if (MainGamePanel.playerDeath == true) {
			logger.info("The player is dead? " + String.valueOf(MainGamePanel.playerDeath));
			frame.getContentPane().removeAll();
			frame.getContentPane().add(gameOverPanel);
			
		}

	}

}
