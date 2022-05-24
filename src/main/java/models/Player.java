package main.java.models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import main.java.services.InventoryService;
import main.java.services.PlayerStatisicsService;

public class Player extends GameObjects {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int health = 100;
	private int stamina = 100;
	private ArrayList<Food> foods;
	private int water = 100;
	private int stealth = 100;
	private boolean sneak = false;
	private ArrayList<Items> bagItems = new ArrayList<>();
	private boolean attack = false;

	private boolean loot = false;

	private boolean playerDeath = false;

	private static final String PLAYER_IMAGE = "/main/java/images/steve.png";
	private static final String HEALTH_BAR = "/main/java/images/health.png";
	private static final String INVENTORY_BAR = "/main/java/images/Inventory_Bar.png";
	PlayerStatisicsService playerService = new PlayerStatisicsService();
	private InventoryService inventoryService;

	// TODO inventory ArrayList<String>

	int velx = 0;
	int vely = 0;
	int width = this.x - 48;
	int height = this.y + 20;

	public Player(int x, int y, ArrayList<Food> foods) {
		super(x, y);
		Food food = new Food("Rations");
		foods.add(food);
		this.foods = foods;

		this.width = this.x - 48;
		this.height = this.y + 20;

		
	}

	public Rectangle getBounds() {
		return new Rectangle(x , y , width - 200 , height - 200);
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isLoot() {
		return loot;
	}

	public void setLoot(boolean loot) {
		this.loot = loot;
	}

	public int getVelx() {
		return velx;
	}

	public void setVelx(int velx) {
		this.velx = velx;
	}

	public int getVely() {
		return vely;
	}

	public void setVely(int vely) {
		this.vely = vely;
	}

	public static String getPlayerImage() {
		return PLAYER_IMAGE;
	}

	public static String getHealthBar() {
		return HEALTH_BAR;
	}

	public static String getInventoryBar() {
		return INVENTORY_BAR;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public ArrayList<Food> getFoods() {
		return foods;
	}

	public void setFoods(ArrayList<Food> foods) {
		this.foods = foods;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}

	public boolean isSneak() {
		return sneak;
	}

	public void setSneak(boolean sneak) {
		this.sneak = sneak;
	}

	public ArrayList<Items> getBagItems() {
		return bagItems;
	}

	public void setBagItems(ArrayList<Items> bagItems) {
		this.bagItems = bagItems;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public boolean isAttack() {
		return attack;
	}

	public void setAttack(boolean attack) {
		this.attack = attack;
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

	public void draw(Graphics2D g2D) {
		g2D.drawImage(getInventoryBarImage(), 600, 850, null);
		g2D.drawImage(getPlayerImages(), x, y, null);
		g2D.drawImage(getHealthBarImage(), -20, -25, null);
		g2D.setColor(Color.RED);
		g2D.fillRect(17, 60, this.health, 20);
		

	}

	public void update() {

		x += velx;
		y += vely;
		if (x < -40) {
			x = -40;
		}
		if (y < 0) {
			y = 0;
		}
		if (x > 1680) {
			x = 1680;
		}
		if (y > 1850) {
			y = 1850;
		}

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_D) {
			velx = 4;
		} else if (key == KeyEvent.VK_A) {
			velx = -4;
		} else if (key == KeyEvent.VK_W) {
			vely = -4;
		} else if (key == KeyEvent.VK_S) {
			vely = 4;
		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_D) {
			velx = 0;
		} else if (key == KeyEvent.VK_A) {
			velx = 0;
		} else if (key == KeyEvent.VK_W) {
			vely = 0;
		} else if (key == KeyEvent.VK_S) {
			vely = 0;
		}
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		loot = true;
		attack = true;

	}

	public void mouseReleased(MouseEvent e) {
		attack = false;
		loot = false;
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public Image getPlayerImages() {
		ImageIcon i = new ImageIcon(getClass().getResource(PLAYER_IMAGE));
		return i.getImage();

	}

	public Image getHealthBarImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(HEALTH_BAR));
		return i.getImage();
	}

	public Image getInventoryBarImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(INVENTORY_BAR));
		return i.getImage();
	}

	public InventoryService getInventoryService() {
		return inventoryService;
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	public boolean isPlayerDeath() {
		return playerDeath;
	}

	public void setPlayerDeath(boolean playerDeath) {
		this.playerDeath = playerDeath;
	}

}
