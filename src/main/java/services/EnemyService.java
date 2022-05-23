package main.java.services;

import main.java.models.Enemy;
import main.java.models.Player;

public class EnemyService {

	public void Pathfinding(Player player , Enemy enemy) {
		if(player.getX() > enemy.getX() ) {
			enemy.x += enemy.getSpeed(); 
		}
		if(player.getY() > enemy.getY()) {
			enemy.y += enemy.getSpeed(); 
		}
		if(player.getX() < enemy.getX()) {
			enemy.x -= enemy.getSpeed(); 
		}
		if(player.getY() < enemy.getY()) {
			enemy.y -= enemy.getSpeed(); 
		}
	}
}
