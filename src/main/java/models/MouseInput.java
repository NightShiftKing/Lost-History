package main.java.models;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	Player p;

	public MouseInput(Player p) {
		this.p = p;

	}


	
	public void mouseClicked(MouseEvent e) {
		p.mouseClicked(e);
	
	}

	public void mousePressed(MouseEvent e) {
	p.mousePressed(e);
		
	}

	public void mouseReleased(MouseEvent e) {
		p.mouseReleased(e);
	
	}

	public void mouseEntered(MouseEvent e) {
		p.mouseEntered(e);
	}

	public void mouseExited(MouseEvent e) {
		p.mouseExited(e);
	}
}
