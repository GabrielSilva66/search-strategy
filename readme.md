# Search Strategy Performance Analysis

## Overview

This program evaluates the performance of different search algorithms in terms of execution time across arrays of varying sizes. It provides insights into the relative efficiency of each algorithm, helping developers choose the right search strategy for specific use cases.

## Features

- Implements and compares the following search algorithms:
    - **Linear Search**
    - **Binary Search**
    - **Recursive Binary Search**
    - **Ternary Search**
- Generates sorted arrays of increasing sizes to simulate real-world scenarios.
- Saves the performance results to a CSV file for further analysis.
- Visualizes the results through a graph generated using the XChart library, with logarithmic scaling for better interpretation of performance trends.

## Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher.
- **Integrated Development Environment (IDE)**: [IntelliJ IDEA](https://www.jetbrains.com/idea/) is highly recommended for optimal development and debugging experience.
- **Dependencies**:
    - XChart for graph generation.
    - SLF4J and Logback for logging.
    - Maven (for dependency management).



## Running the Program

This section explains how to run the program and provides guidance on executing the different components.

### How to Start the Program

1. **Running the SearchStrategyProjectApplication**:  
   To start the program, you need to run the main application class, `SearchStrategyProjectApplication`.

    - Open the project in your IDE (such as IntelliJ IDEA).
    - Locate the `SearchStrategyProjectApplication` class.
    - Right-click on the file and select **Run 'SearchStrategyProjectApplication'** (or use the IDE’s run functionality).

   This will execute the program, which will automatically generate test arrays, run the search strategies for different array sizes, and record the performance results. The results will be saved in the `out` directory in the project root.

### Output Location

The output files will be saved in the `out` directory of your project. These files include:

- **CSV File**: The search performance results, saved in a file called `performance_chart.csv`.
- **PNG Graph**: A graphical representation of the search performance comparison, saved in a file called `performance_chart.png`.

These files will be located in the `out` folder after the program has completed running.

### Arguments or Flags

This program does not require any command-line arguments or flags to run. All configurations (such as the array size and number of test runs) are defined within the source code. You can modify these parameters by editing the constants in the `TestRunner` class to adjust the test conditions:

- `MAX_SIZE`: The maximum size of the array used in tests.
- `ROUND_SIZE`: The incremental size by which the array size increases in each test.
- `NUM_TESTS`: The number of tests to be run for each array size to calculate the average execution time.

If you wish to customize the program, such as changing the test parameters or search algorithms, you can modify the constants and classes directly in the code.

### Example

Once the program is run, you will see the following outputs:
- **CSV File**: The performance results will be saved as `performance_chart.csv` in the `src/main/out/` folder.
- **PNG Graph**: A graphical chart will be saved as `performance_chart.png` in the same folder.


## Author

* Name: Gabriel Victor da Silva
* Email: g.victor.silva01@gmail.com





