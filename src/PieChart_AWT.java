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

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PieChart_AWT extends ApplicationFrame {
    static int wins = 0;
    static int loses = 0;
    static int draws = 0;
    static int credit = 0;
    JButton jButton1 = new CustomButton("Save Statistics");
    JLabel txt = new JLabel();
    int nettedPerGame;

    public PieChart_AWT(String title, int wins, int loses, int draws, int credit) {
        super(title);
        this.draws = draws;
        this.wins = wins;
        this.loses = loses;
        this.credit = credit;
        setContentPane(createDemoPanel());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(jButton1);
        try {
            nettedPerGame = (credit - 10) / (wins + loses);
        } catch (ArithmeticException e) {
            System.out.println("Dividing By Zero Phew");
        }
        txt.setText("     Netted per Game: " + nettedPerGame);
        this.add(txt);

        /**
         * Event Listener of "Save Statistics" Button. Increases credit value. Decreases bet value.
         */
        jButton1.addActionListener(e -> {
            saveDataToFile();
        });


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

    /**
     * This method saves the statistics in text format to the file.
     */
    public static void saveDataToFile() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd, HH mm");
        Date date = new Date();
        String fileName= dateFormat.format(date)+".txt";

        try {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.print("Wins: ");
            writer.println(wins);
            writer.print("Draws: ");
            writer.println(draws);
            writer.print("Losses: ");
            writer.println(loses);
            writer.close();
            System.out.println("File Write Successful");
        } catch (IOException e) {

        }


    }


}