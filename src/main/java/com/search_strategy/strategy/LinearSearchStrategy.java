package com.search_strategy.strategy;

/**
 * This class implements the Linear Search strategy.
 * It searches for a target value in an array by checking each element one by one.
 * If the target is found, it returns the index. If not found, it returns -1.
 */
public class LinearSearchStrategy implements SearchStrategy {

    /**
     * Searches for a target value in the given array using linear search.
     * It calls the helper method that performs the search.
     *
     * @param array  The array of integers where the search will be performed.
     * @param target The value to search for in the array.
     * @return The index of the target if found, otherwise -1.
     */
    @Override
    public int search(int[] array, int target) {

        // If the array is null or empty, return -1 (not found)
        if (array == null || array.length == 0) {
            return -1;
        }

        // Call the linearSearch helper method to perform the search
        return linearSearch(array, target);
    }

    /**
     * Helper method for performing a linear search in the array.
     * It iterates through each element and compares it with the target.
     *
     * @param array  The array of integers where the search will be performed.
     * @param target The value to search for in the array.
     * @return The index of the target if found, otherwise -1.
     */
    private int linearSearch(int[] array, int target) {
        // Iterate through each element in the array
        for (int i = 0; i < array.length; i++) {
            // If the current element matches the target, return the index
            if (array[i] == target) {
                return i;
            }
        }

        // If the target is not found, return -1
        return -1;
    }
}
