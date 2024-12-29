package com.search_strategy.test_automation;

import com.search_strategy.strategy.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * The TestRunner class is responsible for executing search strategy tests
 * on arrays of various sizes and recording the performance results.
 * It runs tests using multiple search strategies and writes the results to a file.
 */
public class TestRunner {

    private static final int MAX_SIZE = 5_000_000;
    private static final int ROUND_SIZE = 200_000;

    // The target value used for worst-case testing (not found).
    private static final int TARGET = -1;
    private static final int NUM_TESTS = 10; // Run multiple tests for better accuracy

    private static final Logger logger = LoggerFactory.getLogger(TestRunner.class);
    private static final Path OUTPUT_PATH = Paths.get("src", "main", "out", "performance_chart.csv");


    /**
     * Generates test arrays of varying sizes and runs the search tests.
     * It generates arrays from ROUND_SIZE up to MAX_SIZE, running the tests for each array size.
     */
    public void generateTest() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_PATH.toFile(), false))) {
            // Write the header to the file only once
            writer.write("Algorithm,Array Size,Time Taken (nanoseconds)");
            writer.newLine();

            // Loop through different array sizes in increments of ROUND_SIZE
            for (int i = ROUND_SIZE; i <= MAX_SIZE; i += ROUND_SIZE) {
                logger.info("Running tests for array size: {}", i);

                // Generate a sorted array of size 'i'
                int[] codes = TestDataGenerator.generateSortedArray(i);

                // Run the search tests and write results to file
                realizeSearch(codes, TARGET, writer);
            }

            logger.info("All tests completed. Results saved to {}", OUTPUT_PATH);
        } catch (IOException e) {
            logger.error("Failed to write output to file {}: {}", OUTPUT_PATH, e.getMessage(), e);
        }
    }

    /**
     * Executes the search strategies on an array and records the results to a file.
     *
     * @param array  The array to search in.
     * @param target The target value to search for (typically -1 for worst-case testing).
     * @param writer The BufferedWriter to write results to.
     */
    public void realizeSearch(int[] array, int target, BufferedWriter writer) {
        // Instantiate different search strategies
        SearchStrategy[] strategies = new SearchStrategy[]{
                new LinearSearchStrategy(),
                new BinarySearchStrategy(),
                new BinaryRecursiveSearchStrategy(),
                new TernarySearchStrategy()
        };

        // Iterate through the strategies and perform the search
        for (SearchStrategy strategy : strategies) {
            String nameStrategy = strategy.getClass().getSimpleName();

            // Measure execution time for the current strategy
            long averageDuration = measureExecutionTime(array, target, strategy);

            // Log and write results
            logAndWriteResults(nameStrategy, array, averageDuration, writer);
        }
    }

    /**
     * Measures the execution time of a search strategy by running multiple tests and calculating the average time.
     *
     * @param array    The array to search in.
     * @param target   The target value to search for.
     * @param strategy The search strategy to be tested.
     * @return The average execution time in nanoseconds.
     */
    private long measureExecutionTime(int[] array, int target, SearchStrategy strategy) {
        long[] durations = new long[NUM_TESTS];

        // Run multiple tests and accumulate total time
        for (int i = 0; i < NUM_TESTS; i++) {
            long startTime = System.nanoTime();
            strategy.search(array, target);
            long endTime = System.nanoTime();

            durations[i] = endTime - startTime; // Record the time
        }

        // Sort and trim the durations to remove outliers
        Arrays.sort(durations);
        long[] trimmedDurations = Arrays.copyOfRange(durations, NUM_TESTS / 4, NUM_TESTS - NUM_TESTS / 4);

        // Calculate the average duration
        long totalDuration = 0;
        for (long duration : trimmedDurations) {
            totalDuration += duration;
        }

        return totalDuration / trimmedDurations.length;
    }

    /**
     * Logs the result and writes it to the output file.
     *
     * @param strategyName   The name of the search strategy.
     * @param array          The array being searched.
     * @param averageDuration The average duration for the search.
     * @param writer         The BufferedWriter to write the results to.
     */
    private void logAndWriteResults(String strategyName, int[] array, long averageDuration, BufferedWriter writer) {
        // Log the results
        logger.info("Average Time for {}: {} nanoseconds", strategyName, averageDuration);

        // Write the results to the output file
        try {
            writer.write(strategyName + "," + array.length + "," + averageDuration);
            writer.newLine();
        } catch (IOException e) {
            logger.error("Failed to write results to file: {}", e.getMessage(), e);
        }
    }


}
