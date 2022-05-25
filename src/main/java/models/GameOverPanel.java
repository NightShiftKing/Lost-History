package main.java.models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DEATH_IMAGE = "/main/java/images/DeathScreen.png";
	private boolean visable = true;
	private boolean respawn = false;

	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(getDeathScreenImage(), 0, 0, null);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Image getDeathScreenImage() {

		ImageIcon i = new ImageIcon(getClass().getResource(DEATH_IMAGE));
		return i.getImage();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("Button pressed");
	}

	public static String getDeathImage() {
		return DEATH_IMAGE;
	}

	public boolean isVisable() {
		return visable;
	}

	public void setVisable(boolean visable) {
		this.visable = visable;
	}

	public boolean isRespawn() {
		return respawn;
	}

	public void setRespawn(boolean respawn) {
		this.respawn = respawn;
	}

}