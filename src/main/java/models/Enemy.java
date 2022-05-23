package main.java.models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Enemy extends GameObjects {
	private static final String ENEMY_IMAGE = "/main/java/images/Enemy.png";

	int speed = 2;
	int enemyHealth = 10;

	public Enemy(int x, int y) {
		super(x, y);

		width = x - 38;
		height = y + 15;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x , y , width  , height );
	}
	

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getEnemyHealth() {
		return enemyHealth;
	}

	public void setEnemyHealth(int enemyHealth) {
		this.enemyHealth = enemyHealth;
	}

	public void draw(Graphics2D g2D) {
		g2D.drawImage(getEnemyImage(), x, y, null);
		
	}

	public Image getEnemyImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(ENEMY_IMAGE));
		return i.getImage();
	}

	public void update() {

		if (y < -15) {
			speed = 2;
		}

		if (y > 850) {
			speed = -2;
		}

	}
}
