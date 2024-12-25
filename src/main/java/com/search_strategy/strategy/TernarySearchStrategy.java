package com.search_strategy.strategy;

/**
 * This class implements the Ternary Search strategy.
 * It divides the array into three parts and compares the target value with two middle elements
 * to determine where to search next.
 * If the target is found, it returns the index. If not found, it returns -1.
 */
public class TernarySearchStrategy implements SearchStrategy {

    /**
     * Searches for a target value in the given array using ternary search.
     * It calls the helper method that performs the search recursively.
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

        // Call the recursive ternary search helper method
        return ternarySearch(array, target, 0, array.length - 1);
    }

    /**
     * Helper method for performing a recursive ternary search on the array.
     * It divides the array into three parts and compares the target with the middle elements.
     * It continues recursively until the target is found or the search space is exhausted.
     *
     * @param array  The array of integers where the search will be performed.
     * @param target The value to search for in the array.
     * @param left   The left index of the current search space.
     * @param right  The right index of the current search space.
     * @return The index of the target if found, otherwise -1.
     */
    private int ternarySearch(int[] array, int target, int left, int right) {
        // If the left pointer exceeds the right, the element is not in the array
        if (left > right) {
            return -1; // Element not found
        }

        // Calculate the indices that divide the array into three parts
        int mid1 = left + (right - left) / 3;
        int mid2 = right - (right - left) / 3;

        // Check if the target is at either of the middle indices
        if (array[mid1] == target) {
            return mid1;
        }
        if (array[mid2] == target) {
            return mid2;
        }

        // If the target is smaller than mid1, search in the leftmost part
        if (target < array[mid1]) {
            return ternarySearch(array, target, left, mid1 - 1);
        }

        // If the target is larger than mid2, search in the rightmost part
        if (target > array[mid2]) {
            return ternarySearch(array, target, mid2 + 1, right);
        }

        // Otherwise, search between mid1 and mid2
        return ternarySearch(array, target, mid1 + 1, mid2 - 1);
    }
}
