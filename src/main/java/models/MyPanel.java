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

public class MyPanel extends JPanel implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Need to fix timer

	public Enemy En;
	

	

	


	Player p;

	Animals a;

	Plants Pl;

	ITEM_Stick IStick;

	InventoryService Inv;

	public Timer gamelooptimer;
	
	public boolean visable = true; 
	public static boolean playerDeath = false; 

	PlayerStatisicsService playerService = new PlayerStatisicsService();
	InventoryService inventoryService = new InventoryService();
	EnemyService enemyService = new EnemyService();
	GameOverPanel gameOver = new GameOverPanel();
	static final Logger logger = Logger.getLogger(MyPanel.class);

	private static final String BACKGROUND_IMAGE = "/main/java/images/Floor.png";

	public MyPanel() {
		
		JPanel MyPanel = new JPanel();
		MyPanel.setSize(1000, 1000);
		ArrayList<Food> starterFoods = new ArrayList<>();
		Food food = new Food("Rations");
		starterFoods.add(food);
		p = new Player(300, 300, starterFoods);
		if(p.isPlayerDeath()) {
			playerDeath = true;
			}
		En = new Enemy(100, 100);
		a = new Animals(150, 250);
		Pl = new Plants(250, 300);
		IStick = new ITEM_Stick(300, 300);
		
		addKeyListener(new KeyInput(p));
		addMouseListener(new MouseInput(p));
		// Create a event handler that when a click happends in a item class call the
		// inventory service and add to the inventory
		setFocusable(true);
		setVisible(visable);

		gamelooptimer = new Timer(10, this);
		gamelooptimer.start();

		
			
	}
	

	


	public boolean isVisable() {
		return visable;
	}


	public void setVisable(boolean visable) {
		this.visable = visable;
	}


	public InventoryService getInventoryService() {
		return inventoryService;
	}


	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}


	public EnemyService getEnemyService() {
		return enemyService;
	}


	public void setEnemyService(EnemyService enemyService) {
		this.enemyService = enemyService;
	}


	public GameOverPanel getGameOver() {
		return gameOver;
	}


	public void setGameOver(GameOverPanel gameOver) {
		this.gameOver = gameOver;
	}


	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public Enemy getEn() {
		return En;
	}

	public void setEn(Enemy en) {
		En = en;
	}

	public Animals getA() {
		return a;
	}

	public void setA(Animals a) {
		this.a = a;
	}

	public Plants getPl() {
		return Pl;
	}

	public void setPl(Plants pl) {
		Pl = pl;
	}

	public ITEM_Stick getIStick() {
		return IStick;
	}

	public void setIStick(ITEM_Stick iStick) {
		IStick = iStick;
	}

	public InventoryService getInv() {
		return Inv;
	}

	public void setInv(InventoryService inv) {
		Inv = inv;
	}

	public Timer getGamelooptimer() {
		return gamelooptimer;
	}

	public void setGamelooptimer(Timer gamelooptimer) {
		this.gamelooptimer = gamelooptimer;
	}

	public PlayerStatisicsService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerStatisicsService playerService) {
		this.playerService = playerService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return logger;
	}

	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(getBackgroundImage(), 0, 0, null);

		p.draw(g2D);
		En.draw(g2D);

		// logger.info("PlayerHealth = " + String.valueOf(p.getHealth()));
		a.draw(g2D);
		Pl.draw(g2D);
		IStick.draw(g2D);
		
		if(playerDeath == true) {
			logger.info("trying to put the death screen here " + String.valueOf(MyPanel.playerDeath) );
			g2D.drawImage(gameOver.getDeathScreenImage(), 0,0,null);
				
			
		}
		
	}

	public Image getBackgroundImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(BACKGROUND_IMAGE));
		return i.getImage();

	}

	public void actionPerformed(ActionEvent e) {

		repaint();
		En.update();
		p.update();
		a.update();
		Pl.update();
		
		playerService.handleHealth(p, En,  this, gameOver);
		/*
		 * if(p.getHealth() == 0) { MyPanel.playerDeath = true; }
		 */
		inventoryService.addToInventory(IStick, p, IStick);
		enemyService.Pathfinding(p, En);
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
