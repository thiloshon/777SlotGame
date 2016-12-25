/**
 * Created by Thiloshon on 25-Dec-16.
 */

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

public class PieChart_AWT extends ApplicationFrame {
    static int wins = 0;
    static int loses = 0;
    static int draws = 0;
    JButton jButton1 = new CustomButton("Save Statistics");

    public PieChart_AWT(String title, int wins, int loses, int draws) {
        super(title);
        this.draws = draws;
        this.wins = wins;
        this.loses = loses;
        setContentPane(createDemoPanel());
        this.add(jButton1);
    }

    private static PieDataset createDataset(int wins, int loses, int draws) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Wins: " + wins + "", new Double(wins));
        dataset.setValue("Looses: " + loses + "", new Double(loses));
        dataset.setValue("Draws: " + draws + "", new Double(draws));

        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {

        JFreeChart chart = ChartFactory.createPieChart(
                "",  // chart title
                dataset,        // data
                true,           // include legend
                true,
                false);

        return chart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset(wins, loses, draws));
        return new ChartPanel(chart);
    }



    /*public static void main( String[ ] args )
    {

    }*/
}