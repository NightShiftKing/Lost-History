package main.java.models;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class KeyInput extends KeyAdapter {

	Player p;

	public KeyInput(Player p) {
		this.p = p;

	}

	public void keyPressed(KeyEvent e) {
		p.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		p.keyReleased(e);
	}
}
