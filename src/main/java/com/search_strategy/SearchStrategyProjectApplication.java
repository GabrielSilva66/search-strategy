package com.search_strategy;


import com.search_strategy.test_automation.TestRunner;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchStrategyProjectApplication {

	private static final Logger logger = Logger.getLogger(SearchStrategyProjectApplication.class.getName());

	public static void main(String[] args) {
		// Configure the logger to show INFO level logs
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.ALL); // Set log level to ALL for maximum logging
		logger.addHandler(consoleHandler);
		logger.setLevel(Level.ALL);

		TestRunner runner = new TestRunner();
		runner.generateTest(); // Generate and run tests
	}

}
