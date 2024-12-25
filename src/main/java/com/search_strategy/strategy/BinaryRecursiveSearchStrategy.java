package com.search_strategy.strategy;

/**
 * This class implements the Binary Search strategy using recursion.
 * It searches for a target value in a sorted array and returns its index.
 * If the target is not found, it returns -1.
 */
public class BinaryRecursiveSearchStrategy implements SearchStrategy {

    /**
     * Searches for a target value in the given array using binary search.
     * This method calls the recursive helper method to perform the search.
     *
     * @param array  The sorted array of integers where the search will be performed.
     * @param target The value to search for in the array.
     * @return The index of the target if found, otherwise -1.
     */
    @Override
    public int search(int[] array, int target) {
        // If the array is null or empty, return -1 (not found)
        if (array == null || array.length == 0) {
            return -1;
        }

        // Call the binary search helper method with the initial full range
        return binaryRecursiveSearch(array, target, 0, array.length - 1);
    }

    /**
     * Performs a recursive binary search to find the target value in the array.
     *
     * @param array  The sorted array of integers where the search will be performed.
     * @param target The value to search for in the array.
     * @param left   The left index of the current search range.
     * @param right  The right index of the current search range.
     * @return The index of the target if found, otherwise -1.
     */
    private int binaryRecursiveSearch(int[] array, int target, int left, int right) {

        // Base case: If the search range is invalid (left > right), return -1
        if (left > right) {
            return -1;
        }

        // Calculate the middle index to divide the search range
        int mid = left + (right - left) / 2;

        // If the element at mid is the target, return the index
        if (array[mid] == target) {
            return mid;
        }

        // If the target is greater than the middle element, search in the right half
        if (array[mid] < target) {
            return binaryRecursiveSearch(array, target, mid + 1, right);
        }

        // If the target is smaller than the middle element, search in the left half
        return binaryRecursiveSearch(array, target, left, mid - 1);
    }
}
