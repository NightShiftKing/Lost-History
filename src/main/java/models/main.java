package main.java.models;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class main {

	static final Logger logger = Logger.getLogger(main.class);

	public static void main(String[] args) {
		BasicConfigurator.configure();
		

				logger.info("initalizing game...");

		new Frame(); 

	}

}
