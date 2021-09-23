package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

public class SignalSpectrum {

    public ChartPanel drawSignalSpectrum (int frequency) {

        FastFourierTransformation fastFourierTransformation = new FastFourierTransformation(frequency);
        fastFourierTransformation.func();

        XYSeries series = new XYSeries("");

        float[] a = fastFourierTransformation.func();
        for (int i = 1; i < 10; i+=1) {
            series.add(i, a[i]);
        }

        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory
                .createXYLineChart("График спектра гармонического сигнала" + "\n Частота: " + frequency + " Гц", "t", "A",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);

        ChartPanel frame =
                new ChartPanel(chart);
        frame.setPreferredSize(new Dimension(850,500));

        return frame;
    }

}
