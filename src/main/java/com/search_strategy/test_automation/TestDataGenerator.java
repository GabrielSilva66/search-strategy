package com.search_strategy.test_automation;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestDataGenerator {

    // Set up the Logger
    private static final Logger logger = Logger.getLogger(TestDataGenerator.class.getName());

    /**
     * Generates an array of integers with random numbers.
     *
     * @param size The size of the array to be generated
     * @return An array of integers with random numbers
     */
    public static int[] generateRandomArray(int size) {
        logger.log(Level.INFO, "Starting the generation of a random array with size: " + size);

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = getRandomTarget();
        }

        logger.log(Level.INFO, "Random array generated successfully.");
        return array;
    }

    /**
     * Generates an array of integers with random numbers and sorts it.
     *
     * @param size The size of the array to be generated
     * @return A sorted array of integers with random numbers
     */
    public static int[] generateSortedArray(int size) {
        logger.log(Level.INFO, "Starting the generation of a sorted array with size: " + size);

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = getRandomTarget();
        }

        Arrays.sort(array); // Sorts the array

        logger.log(Level.INFO, "Sorted array generated successfully.");
        return array;
    }

    /**
     * Generates a random number within a specified range.
     *
     * @return A random number
     */
    public static int getRandomTarget() {
        return ThreadLocalRandom.current().nextInt(1_000_000, 10_000_000);
    }
}
