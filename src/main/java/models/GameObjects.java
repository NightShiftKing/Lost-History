package main.java.models;

import java.awt.Rectangle;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class GameObjects   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int x;
	public int y;
	public int height;
	public int width;

	



	public double getX() {
		return x;
	}





	public void setX(int x) {
		this.x = x;
	}





	public double getY() {
		return y;
	}





	public void setY(int y) {
		this.y = y;
	}





	public double getHeight() {
		return height;
	}





	public void setHeight(int height) {
		this.height = height;
	}





	public double getWidth() {
		return width;
	}





	public void setWidth(int width) {
		this.width = width;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	public GameObjects(int x, int y  ) {
		this.x = x;
		this.y = y;
		

	}

}
