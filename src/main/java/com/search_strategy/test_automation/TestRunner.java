package com.search_strategy.test_automation;

import com.search_strategy.strategy.*;
import java.util.logging.*;

public class TestRunner {

    private static final int MAX_SIZE = 5_000_000; // Maximum size for arrays in the test
    private static final int ROUND_SIZE = 100_000; // Incremental size for each round of tests
    private static final int TARGET = -1; // Target value for worst-case testing (not found)

    // Create a Logger instance
    private static final Logger logger = Logger.getLogger(TestRunner.class.getName());

    // Method to run the search with different strategies for an array of a given size
    public void realizeSearch(int[] array, int target) {
        // Instantiate different search strategies
        SearchStrategy[] strategies = new SearchStrategy[]{
                new LinearSearchStrategy(),
                new BinarySearchStrategy(),
                new TernarySearchStrategy(),
                new BinaryRecursiveSearchStrategy()
        };

        // Iterate through the strategies and perform the search
        for (SearchStrategy strategy : strategies) {
            // Log which strategy is being used
            logger.info("Using " + strategy.getClass().getSimpleName() + " for target " + target);
            long startTime = System.currentTimeMillis();
            int result = strategy.search(array, target); // Search for the target
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            // Log the result and time taken
            if (result != -1) {
                logger.info("Result: Found at index " + result + " | Time taken: " + duration + " miliseconds");
            } else {
                logger.warning("Result: Target not found | Time taken: " + duration + " miliseconds");
            }
        }
    }

    // Method to generate and run tests for arrays of varying sizes
    public void generateTest() {
        // Loop through different array sizes in increments of ROUND_SIZE

        for (int i = ROUND_SIZE; i <= MAX_SIZE; i += ROUND_SIZE) {
            logger.info("\nRunning tests for array size: " + i);

            // Generate a sorted array of size 'i'
            int[] codes = TestDataGenerator.generateSortedArray(i);

            realizeSearch(codes, TARGET);
        }
    }


}
