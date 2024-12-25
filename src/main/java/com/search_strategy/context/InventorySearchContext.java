package com.search_strategy.context;

import com.search_strategy.strategy.SearchStrategy;
/**
 * The InventorySearchContext class is responsible for managing and using a search strategy.
 * It allows the strategy to be swapped dynamically at runtime.
 */
public class InventorySearchContext {
    private SearchStrategy strategy;

    public SearchStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }


    /**
     * Delegates the search operation to the current strategy.
     *
     * @param productCodes The array of product codes to search in.
     * @param target The target product code to search for.
     * @return The index of the target if found, otherwise -1.
     */
    public int search(int[] productCodes, int target) {
        return strategy.search(productCodes, target);
    }
}
