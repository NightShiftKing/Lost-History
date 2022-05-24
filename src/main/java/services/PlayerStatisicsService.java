package main.java.services;

import java.awt.Rectangle;
import java.security.PublicKey;

import javax.swing.JFrame;

import org.apache.log4j.Logger;
import org.apache.log4j.jmx.LoggerDynamicMBean;

import main.java.models.Enemy;
import main.java.models.Player;
import main.java.models.Food;
import main.java.models.Frame;
import main.java.models.GameOverPanel;
import main.java.models.MainGamePanel;

public class PlayerStatisicsService {

	public boolean enemyCollison = false;
	static final Logger logger = Logger.getLogger(PlayerStatisicsService.class);

	public int handleHealth(Player player, Enemy enemy, MainGamePanel panel, GameOverPanel gameOver) {
		int totalHealth = player.getHealth();
		int EHealth = enemy.getEnemyHealth();

		if (totalHealth == 0) {

	
			MainGamePanel.playerDeath = true;
		}

		if (player.getBounds().intersects(enemy.getBounds())) {
			totalHealth = totalHealth - 1;
			player.setHealth(totalHealth);

		}

//		if (player.getFoods() != null) {
//			while ((player.getHealth() < 100) && (player.getFoods().size() != 0)) {
//				totalHealth = totalHealth + (player.getFoods().size() / 5);
//			}
//
//		}

		if (player.getBounds().intersects(enemy.getBounds()) && (player.isAttack() == true)) {
			EHealth = EHealth - 5;

			enemy.setEnemyHealth(EHealth);
			return enemy.getEnemyHealth();
		}

		if (EHealth == 0) {

			enemy.x = 1000;

		}
		// player.setHealth(totalHealth);
		logger.info("my total health is " + String.valueOf(player.getHealth()));
		return player.getHealth();

	}

}
