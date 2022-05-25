package main.java.services;

import org.apache.log4j.Logger;
import main.java.models.Enemy;
import main.java.models.Player;
import main.java.models.GameOverPanel;
import main.java.models.MainGamePanel;

public class PlayerStatisicsService {

	public boolean enemyCollison = false;
	static final Logger logger = Logger.getLogger(PlayerStatisicsService.class);

	public int handleHealth(Player player, Enemy enemy, MainGamePanel panel, GameOverPanel gameOver) {
		int totalHealth = player.getHealth();
		int EHealth = enemy.getEnemyHealth();

		if (totalHealth <= 0) {

	
			MainGamePanel.playerDeath = true;
		}
		
		if(totalHealth >= 100) {
			player.setHealth(100); 
		}
			
		

		if (player.getBounds().intersects(enemy.getBounds())) {
			totalHealth = totalHealth - 5;
			player.setHealth(totalHealth);

		}

//		if (player.getFoods() != null) {
//			while ((player.getHealth() < 100) && (player.getFoods().size() != 0)) {
//				totalHealth = totalHealth + (player.getFoods().size() / 5);
//			}
//
//		}

		if (player.getBounds().intersects(enemy.getBounds()) && (player.isAttack() == true)) {
			EHealth = EHealth - 10;
			//logger.info("this is enemy health" + String.valueOf(enemy.getEnemyHealth()));
			//logger.info("attemting to kill");
			enemy.setEnemyHealth(EHealth);
			return enemy.getEnemyHealth();
		}

		
		// player.setHealth(totalHealth);
	//	logger.info("https://github.com/NightShiftKing/lost-history.gitmy total health is " + String.valueOf(player.getHealth()));
		return player.getHealth();

	}

}
