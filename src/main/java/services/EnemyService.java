package main.java.services;

import org.apache.log4j.Logger;

import main.java.models.Enemy;
import main.java.models.Player;

public class EnemyService {
	static final Logger logger = Logger.getLogger(EnemyService.class);

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
		
		
		if(enemy.getEnemyHealth() == 0) {
			enemy.x = 1900;
			
			enemy.setEnemyHealth(10); 
 		}
	//	logger.info("enemy position = " + String.valueOf(enemy.x));
		
		
	}
	
	
}