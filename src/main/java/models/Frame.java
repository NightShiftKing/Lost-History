package main.java.models;

import javax.swing.*;

public class Frame extends JFrame  {

	private static final long serialVersionUID = 1L;

	public Frame() {
		// this controls the panel

		MyPanel panel;

	

		panel = new MyPanel();
	GameOverPanel gameOverPanel = new GameOverPanel(); 

		

		// this controls the frame
		JFrame frame = new JFrame("Lost History");
	
		frame.setSize(2000, 2000);

		frame.add(panel);
		
		//frame.add(gameOverPanel);
	
	if(MyPanel.playerDeath == true) {
		panel.setVisable(false);
		gameOverPanel.setVisable(true);
		frame.add(gameOverPanel);
	}
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		
		
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	



	

}
