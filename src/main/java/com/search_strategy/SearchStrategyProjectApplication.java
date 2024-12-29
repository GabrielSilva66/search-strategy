package com.search_strategy;

import com.search_strategy.test_automation.TestRunner;
import com.search_strategy.test_automation.XChartCSVGenerator;

/**
 * The main entry point for the Search Strategy project.
 * <p>
 * This class orchestrates the execution of the search strategy performance tests and the generation of a performance chart.
 * It runs the search tests, collects the data in a CSV format, and then generates a graphical representation of the performance.
 * </p>
 */
public class SearchStrategyProjectApplication {

	// Path to save the CSV file containing performance data
	private static final String csvFilePath = "src/main/out/performance_chart.csv";

	// Path to save the generated performance chart image
	private static final String outputImagePath = "src/main/out/performance_chart";

	/**
	 * The main method that drives the execution of the project.
	 * <p>
	 * This method first generates test data by running multiple search strategies (e.g., Linear Search, Binary Search),
	 * then it generates a performance chart based on the results stored in a CSV file.
	 * </p>
	 *
	 * @param args Command-line arguments (not used in this case).
	 */
	public static void main(String[] args) {
		// Initialize the TestRunner to generate and execute search strategy performance tests
		TestRunner runner = new TestRunner();

		// Run the test generation process
		runner.generateTest(); // This generates the test data and saves it in the CSV file

		// Generate the performance chart from the CSV file and save it as an image
		new XChartCSVGenerator().generateChartFromCSV(csvFilePath, outputImagePath); // Generate the chart and save it as a PNG image

	}
}
