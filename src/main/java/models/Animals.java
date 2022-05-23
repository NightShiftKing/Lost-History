package main.java.models;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Animals extends GameObjects {
	
	static final Logger logger = Logger.getLogger(Animals.class);

	private static final  String BIRD_IMAGE  = "/main/java/images/bird.png";

	int speed = 2;
	int width;
	int height;
	

	public Animals(int x, int y ) {
		super(x, y);
		this.width = x + 10;
		this.height = y + 10;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static String getBirdImage() {
		return BIRD_IMAGE;
	}

	public Image getAnimalsImage() {
		
		
		ImageIcon i = new ImageIcon(getClass().getResource(BIRD_IMAGE));
		return i.getImage();
		
	}
	

	public void draw(Graphics2D g2D) {
		
		g2D.drawImage(getAnimalsImage(), x, y, null);

	}

	public void update() {
		x += speed;

		if (x < -15) {
			speed = 2;
		}

		if (x > 650) {
			speed = -2;
		}

	}
}
