package main.java.services;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import org.apache.log4j.Logger;

import main.java.models.ITEM_Stick;
import main.java.models.Items;
import main.java.models.Player;

public class InventoryService implements MouseListener {
	static final Logger logger = Logger.getLogger(InventoryService.class);

	public void addToInventory(Items item, Player player, ITEM_Stick stick) {
		if (null != item) {

			if (stick.getBounds().intersects(player.getBounds()) && (player.isLoot() == true)
					&& (stick.isAllowpickup() == true)) {

				if (player.getBagItems() != null) {
					player.getBagItems().add(item);
					stick.setX(10000);
					player.getBagItems().stream().forEach((i) -> {
					//	logger.info("My inventory " + i.getName());
					});
				}
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

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
