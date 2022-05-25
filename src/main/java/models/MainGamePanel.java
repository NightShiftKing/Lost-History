package main.java.models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import main.java.services.EnemyService;
import main.java.services.InventoryService;
import main.java.services.PlayerStatisicsService;

public class MainGamePanel extends JPanel implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Need to fix timer

	public Enemy enemy;

	Player player;

	ITEM_Stick stick;

	Animals animal;

	Plants plant;

	public Timer gamelooptimer;

	public boolean visable = true;
	public static boolean playerDeath = false;

	PlayerStatisicsService playerService = new PlayerStatisicsService();
	InventoryService inventoryService = new InventoryService();
	EnemyService enemyService = new EnemyService();
	GameOverPanel gameOver = new GameOverPanel();
	static final Logger logger = Logger.getLogger(MainGamePanel.class);

	private static final String BACKGROUND_IMAGE = "/main/java/images/Floor.png";

	public MainGamePanel() {

		JPanel mainGamePanel = new JPanel();
		mainGamePanel.setSize(1000, 1000);
		ArrayList<Food> starterFoods = new ArrayList<>();
		Food food = new Food("Rations");
		starterFoods.add(food);
		player = new Player(300, 300, starterFoods);
		//logger.info("The player is dead?" + String.valueOf(MainGamePanel.playerDeath));

		if (player.isPlayerDeath()) {
			//logger.info("The player is dead?" + String.valueOf(MainGamePanel.playerDeath));

			playerDeath = true;
		}
		enemy = new Enemy(100, 100);
		animal = new Animals(150, 250);
		plant = new Plants(250, 300);
		stick = new ITEM_Stick(300, 300);

		addKeyListener(new KeyInput(player));
		addMouseListener(new MouseInput(player));
		setFocusable(true);
		setVisible(visable);

		gamelooptimer = new Timer(10, this);
		gamelooptimer.start();

	}

	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(getBackgroundImage(), 0, 0, null);

		player.draw(g2D);
		enemy.draw(g2D);

		// logger.info("PlayerHealth = " + String.valueOf(p.getHealth()));
		animal.draw(g2D);
		plant.draw(g2D);
		stick.draw(g2D);

		if (playerDeath == true) {
			//logger.info("trying to put the death screen here " + String.valueOf(MainGamePanel.playerDeath));
			g2D.drawImage(gameOver.getDeathScreenImage(), 0, 0, null);

		}

	}

	public Image getBackgroundImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(BACKGROUND_IMAGE));
		return i.getImage();

	}

	public void actionPerformed(ActionEvent e) {

		repaint();
		enemy.update();
		player.update();
		animal.update();
		plant.update();

		playerService.handleHealth(player, enemy, this, gameOver);
		/*
		 * if(p.getHealth() == 0) { MyPanel.playerDeath = true; }
		 */
		inventoryService.addToInventory(stick, player, stick);
		enemyService.Pathfinding(player, enemy);
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ITEM_Stick getStick() {
		return stick;
	}

	public void setStick(ITEM_Stick stick) {
		this.stick = stick;
	}

	public Animals getAnimal() {
		return animal;
	}

	public void setAnimal(Animals animal) {
		this.animal = animal;
	}

	public Plants getPlant() {
		return plant;
	}

	public void setPlant(Plants plant) {
		this.plant = plant;
	}

	public static boolean isPlayerDeath() {
		return playerDeath;
	}

	public static void setPlayerDeath(boolean playerDeath) {
		MainGamePanel.playerDeath = playerDeath;
	}

	public boolean isVisable() {
		return visable;
	}

	public void setVisable(boolean visable) {
		this.visable = visable;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
