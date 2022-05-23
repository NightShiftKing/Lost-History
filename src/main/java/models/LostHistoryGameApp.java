package main.java.models;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LostHistoryGameApp {

	static final Logger logger = Logger.getLogger(LostHistoryGameApp.class);

	public static void main(String[] args) {
		BasicConfigurator.configure();

		logger.info("initalizing game...");

		new Frame();

	}

}
