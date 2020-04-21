package dopfunction;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.List;

public class Print {
    public static void print4 (ArrayList<Double> array, ArrayList<Double> array1, ArrayList<Double> array2, ArrayList<Double> array3, String name, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i <= k;i++)
        {
            list.add(i);
        }

        XYChart chart = new XYChartBuilder().width(800).height(600).title(name).xAxisTitle("x").yAxisTitle("y").build();

        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(false);
        chart.getStyler().setPlotGridLinesVisible(false);

        chart.addSeries("State0", list, array);
        chart.addSeries("State0_Teor", list,array1);
        chart.addSeries("State1", list, array2);
        chart.addSeries("State1_Teor", list,array3);
        List<XYChart> charts = new ArrayList<XYChart>();
        charts.add(chart);
        new SwingWrapper<XYChart>(charts).displayChartMatrix();

    }
    public static void print (ArrayList<Double> array, ArrayList<Double> array1,String name, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i <= k;i++)
        {
            list.add(i);
        }

        XYChart chart = new XYChartBuilder().width(800).height(600).title(name).xAxisTitle("x").yAxisTitle("y").build();

        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(false);
        chart.getStyler().setPlotGridLinesVisible(false);

        chart.addSeries("теоретическая", list, array);
        chart.addSeries("Практическая", list,array1);
        List<XYChart> charts = new ArrayList<XYChart>();
        charts.add(chart);
        new SwingWrapper<XYChart>(charts).displayChartMatrix();

    }
    public static void print6 (ArrayList<Double> array, ArrayList<Double> array1, ArrayList<Double> array2, ArrayList<Double> array3,ArrayList<Double> array4,ArrayList<Double> array5, String name, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i <= k;i++)
        {
            list.add(i);
        }

        XYChart chart = new XYChartBuilder().width(800).height(600).title(name).xAxisTitle("x").yAxisTitle("y").build();

        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(false);
        chart.getStyler().setPlotGridLinesVisible(false);

        chart.addSeries("State0", list, array);
        chart.addSeries("State0_Teor", list,array1);
        chart.addSeries("State1", list, array2);
        chart.addSeries("State1_Teor", list,array3);
        chart.addSeries("State2", list, array4);
        chart.addSeries("State2_Teor", list,array5);
        List<XYChart> charts = new ArrayList<XYChart>();
        charts.add(chart);
        new SwingWrapper<XYChart>(charts).displayChartMatrix();

    }
}
