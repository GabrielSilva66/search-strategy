package com.search_strategy;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.util.Arrays;

public class XChartExample {
    public static void main(String[] args) {
        // Create data
        double[] xData = {1, 2, 3, 4, 5};
        double[] yData = {1, 4, 9, 16, 25};

        // Create chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title("Performance Graph").xAxisTitle("X Axis").yAxisTitle("Y Axis").build();

        // Customize chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.addSeries("Data Series", xData, yData);

        // Show the chart in a window
        new SwingWrapper<>(chart).displayChart();
    }
}
