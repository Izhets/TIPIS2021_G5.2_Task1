package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

public class HarmonicSignalGraph {

    public ChartPanel drawGraph(int frequency) {

        XYSeries series = new XYSeries("A*cos(2*pi*t*frequency)");

        for (float i = 1; i < 3; i += 0.01) {
            series.add(i, Math.cos(((2 * Math.PI * i * frequency))));
        }

        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory
                .createXYLineChart("График гармонического сигнала" + "\n Частота: " + frequency + " Гц", "t", "A",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);
        ChartPanel frame =
                new ChartPanel(chart);
        frame.setPreferredSize(new Dimension(850,500));

        return frame;
    }
}
