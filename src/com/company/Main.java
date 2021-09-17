package com.company;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Main {

    public static void main(String[] args) {
//        XYSeries series = new XYSeries("cos(a)");
//
//        for (float i = 1; i < 10; i+=0.01) {
//            series.add(i, Math.cos(((2*Math.PI*i*2))));
//        }
//
//        XYDataset xyDataset = new XYSeriesCollection(series);
//        JFreeChart chart = ChartFactory
//                .createXYLineChart("y = sin(x)", "x", "y",
//                        xyDataset,
//                        PlotOrientation.VERTICAL,
//                        true, true, true);
//
//        XYDataset xyDataset2 = new XYSeriesCollection(series);
//        JFreeChart chart2 = ChartFactory
//                .createXYLineChart("y = sin(x)", "x", "y",
//                        xyDataset2,
//                        PlotOrientation.VERTICAL,
//                        true, true, true);
//
//        JFrame frame =
//                new JFrame("График гармонического сигнала");
//        // Помещаем график на фрейм
//        frame.getContentPane()
//                .add(new ChartPanel(chart));
//        frame.getContentPane()
//                .add(new ChartPanel(chart2));
//        frame.setSize(800, 600);
//        frame.show();


            FasrFourierTransformation fft = new FasrFourierTransformation();
            fft.func();

        XYSeries series = new XYSeries("cos(a)");

        float[] a = fft.func();
        for (int i = 1; i < 10; i+=1) {
            series.add(i, a[i]);
        }

        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory
                .createXYLineChart("y = sin(x)", "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);


        JFrame frame =
                new JFrame("График гармонического сигнала");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));

        frame.setSize(800, 600);
        frame.show();


    }

}