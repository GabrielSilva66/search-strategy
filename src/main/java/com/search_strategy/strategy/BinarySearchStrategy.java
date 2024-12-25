package com.search_strategy.strategy;

/**
 * This class implements the Binary Search strategy.
 * It searches for a target value in a sorted array and returns its index.
 * If the target is not found, it returns -1.
 */
public class BinarySearchStrategy implements SearchStrategy {

    /**
     * Searches for a target value in the given array using binary search.
     * This method calls the helper method for the binary search.
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
        return binarySearch(array, target, 0, array.length - 1);
    }

    /**
     * Helper method for performing binary search in a sorted array.
     * This method is used to recursively divide the array and search for the target.
     *
     * @param array  The sorted array of integers where the search will be performed.
     * @param target The value to search for in the array.
     * @param left   The left index of the current search range.
     * @param right  The right index of the current search range.
     * @return The index of the target if found, otherwise -1.
     */
    private int binarySearch(int[] array, int target, int left, int right) {

        // Loop until the left pointer exceeds the right pointer
        while (left <= right) {
            // Calculate the middle index
            int mid = left + (right - left) / 2;

            // If the element at mid is the target, return the index
            if (array[mid] == target) {
                return mid;
            }

            // If the target is greater than the element at mid, search in the right half
            if (array[mid] < target) {
                left = mid + 1;
            }
            // If the target is smaller than the element at mid, search in the left half
            else {
                right = mid - 1;
            }
        }

        // If the target was not found, return -1
        return -1;
    }
}
