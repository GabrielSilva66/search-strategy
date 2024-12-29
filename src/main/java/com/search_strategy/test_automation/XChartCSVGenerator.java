package com.search_strategy.test_automation;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.XYSeries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * A utility class for generating charts from CSV data using the XChart library.
 */
public class XChartCSVGenerator {

    private static final Logger logger = LoggerFactory.getLogger(XChartCSVGenerator.class);

    /**
     * Generates a line chart based on data from a CSV file and saves it as an image.
     *
     * @param csvFilePath    the path to the input CSV file containing the data.
     *                       The CSV must have the following format:
     *                       Algorithm,ArraySize,TimeTaken
     *                       LinearSearch,200000,754333
     *                       BinarySearch,200000,4883
     *                       ...
     * @param outputImagePath the path where the generated chart image will be saved.
     *                        The image will be saved as a PNG file.
     */
    public void generateChartFromCSV(String csvFilePath, String outputImagePath) {
        // Maps to store the data for each algorithm
        Map<String, List<Integer>> xDataMap = new HashMap<>();
        Map<String, List<Long>> yDataMap = new HashMap<>();

        // Read data from the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line = br.readLine(); // Skip the header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String algorithm = values[0];
                int arraySize = Integer.parseInt(values[1]);
                long timeTaken = Long.parseLong(values[2]);

                // Add data to the respective maps
                xDataMap.putIfAbsent(algorithm, new ArrayList<>());
                yDataMap.putIfAbsent(algorithm, new ArrayList<>());

                xDataMap.get(algorithm).add(arraySize);
                yDataMap.get(algorithm).add(timeTaken);
            }
            logger.info("Data successfully read from CSV file: {}", csvFilePath);
        } catch (IOException e) {
            logger.error("Error reading the CSV file: {}", csvFilePath, e);
            return;
        }

        // Create the chart
        XYChart chart = new XYChartBuilder()
                .width(800).height(600)
                .title("Search Algorithm Performance Comparison")
                .xAxisTitle("Array Size")
                .yAxisTitle("Execution Time (ns)")
                .build();

        // Customize the chart style
        chart.getStyler().setChartTitleVisible(true);
        chart.getStyler().setLegendVisible(true);
        chart.getStyler().setYAxisLogarithmic(true); // Use a logarithmic Y-axis
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add data series to the chart
        for (String algorithm : xDataMap.keySet()) {
            chart.addSeries(algorithm, xDataMap.get(algorithm), yDataMap.get(algorithm));
            logger.info("Added data series for algorithm: {}", algorithm);
        }

        // Save the chart as a PNG file
        try {
            BitmapEncoder.saveBitmap(chart, outputImagePath, BitmapEncoder.BitmapFormat.PNG);
            logger.info("Chart successfully saved at: {}", outputImagePath);
        } catch (IOException e) {
            logger.error("Error saving the chart to file: {}", outputImagePath, e);
        }
    }
}
