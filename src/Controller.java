import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by Thiloshon on 17-Dec-16.
 * <p>
 * Controller Class
 */
public class Controller {
    final private int NUMBER_OF_SYMBOLS_PER_REEL = 6;
    final private int NUMBER_OF_REELS = 3;
    final private int INITIAL_CREDIT = 10;
    final private int MAX_VALUE = 3;

    private ArrayList<String> paths = new ArrayList<>();
    private ArrayList<Integer> values = new ArrayList<>();
    private ArrayList<Reel> reels = new ArrayList<>();
    private ArrayList<spinnableThread> threads = new ArrayList<>();
    private int credit = INITIAL_CREDIT;
    private int bet = 0;
    private int numberOfGames = 0;
    private int numberOfWins = 0;
    private int numberOfDraws = 0;
    private int numberOfLosses = 0;
    private ArrayList<Integer> reelValues = new ArrayList<>();

    private boolean check1 = true;

    GUInterface guInterface;

    /**
     * @param guInterface
     */
    public Controller(GUInterface guInterface) {
        this.guInterface = guInterface;
        addSources();
        //run();
    }


    /**
     *
     */
    void run() {

        JLabel messageLabel = guInterface.getMessageLabel();
        final spinnableThread[] th = {null};
        final spinnableThread[] th2 = {null};
        final spinnableThread[] th3 = {null};
        JLabel c1 = guInterface.getC1();
        JLabel c2 = guInterface.getC2();
        JLabel c3 = guInterface.getC3();

        JLabel creditLabel = guInterface.getCreditLabel();
        JLabel bettingLabel = guInterface.getBettingLabel();

        JButton jButton1 = guInterface.getjButton1();
        JButton jButton2 = guInterface.getjButton2();
        JButton jButton3 = guInterface.getjButton3();
        JButton jButton4 = guInterface.getjButton4();
        JButton jButton5 = guInterface.getjButton5();
        JButton jButton6 = guInterface.getjButton6();

        //threads.add();


        c1.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e)

            {
                th[0].check = false;
                reelValues.add(th[0].getCurrent().getValue());

                if (th2[0].getState().toString().equalsIgnoreCase("TERMINATED") && th3[0].getState().toString().equalsIgnoreCase("TERMINATED")) {
                    if (reelValues.get(0) == reelValues.get(1) && reelValues.get(1) == reelValues.get(2)) {
                        messageLabel.setText("You Won");
                        numberOfWins++;
                        int number = th[0].getCurrent().getValue();
                        credit+=number*bet;
                        bet=0;
                        messageLabel.setText("You Won "+ number);
                        bettingLabel.setText("Betting: " + bet);
                        creditLabel.setText("Credits Left: " + credit);
                    } else if (reelValues.get(0) == reelValues.get(1) || reelValues.get(0) == reelValues.get(2) || reelValues.get(2) == reelValues.get(1)) {

                        messageLabel.setText("Same values");
                        numberOfDraws++;


                    } else {
                        messageLabel.setText("You Lost");
                        numberOfLosses++;
                        bet = 0;
                        bettingLabel.setText("Betting: " + bet);
                    }
                    reelValues.clear();
                    numberOfGames++;
                }


                int value = th[0].getCurrent().getValue();

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });


        c2.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e)

            {
                th2[0].check = false;
                reelValues.add(th2[0].getCurrent().getValue());

                if (th[0].getState().toString().equalsIgnoreCase("TERMINATED") && th3[0].getState().toString().equalsIgnoreCase("TERMINATED")) {

                    if (reelValues.get(0) == reelValues.get(1) && reelValues.get(1) == reelValues.get(2)) {
                        numberOfWins++;
                        int number = th2[0].getCurrent().getValue();
                        credit+=number*bet;
                        bet=0;
                        messageLabel.setText("You Won "+ number);
                        bettingLabel.setText("Betting: " + bet);
                        creditLabel.setText("Credits Left: " + credit);
                    } else if (reelValues.get(0) == reelValues.get(1) || reelValues.get(0) == reelValues.get(2) || reelValues.get(2) == reelValues.get(1)) {
                        numberOfDraws++;
                        messageLabel.setText("Same values");

                    } else {
                        messageLabel.setText("You Lost");
                        numberOfLosses++;
                        bet = 0;
                        bettingLabel.setText("Betting: " + bet);
                    }
                    numberOfGames++;
                    reelValues.clear();
                }


            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });


        c3.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e)

            {
                th3[0].check = false;
                reelValues.add(th3[0].getCurrent().getValue());

                if (th2[0].getState().toString().equalsIgnoreCase("TERMINATED") && th[0].getState().toString().equalsIgnoreCase("TERMINATED")) {
                    if (reelValues.get(0) == reelValues.get(1) && reelValues.get(1) == reelValues.get(2)) {
                        numberOfWins++;
                        int number = th3[0].getCurrent().getValue();
                        credit+=number*bet;
                        bet=0;
                        messageLabel.setText("You Won "+ number);
                        bettingLabel.setText("Betting: " + bet);
                        creditLabel.setText("Credits Left: " + credit);
                    } else if (reelValues.get(0) == reelValues.get(1) || reelValues.get(0) == reelValues.get(2) || reelValues.get(2) == reelValues.get(1)) {
                        numberOfDraws++;
                        messageLabel.setText("Same values");

                    } else {
                        numberOfLosses++;
                        messageLabel.setText("You Lost");
                        bet = 0;
                        bettingLabel.setText("Betting: " + bet);
                    }
                    reelValues.clear();
                    numberOfGames++;
                }


            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });


        jButton4.addActionListener(e -> {

            messageLabel.setText("Status: Playing");
            th[0] = new spinnableThread(c1, guInterface.getGbc(), guInterface.getGamePane(), paths, values);
            th[0].start();
            th2[0] = new spinnableThread(c2, guInterface.getGbc2(), guInterface.getGamePane(), paths, values);
            th2[0].start();
            th3[0] = new spinnableThread(c3, guInterface.getGbc3(), guInterface.getGamePane(), paths, values);
            th3[0].start();
        });


        jButton1.addActionListener(e -> {
            credit++;
            creditLabel.setText("Credits Left: " + credit);
        });

        jButton2.addActionListener(e -> {
            bet++;
            bettingLabel.setText("Betting: " + bet);
            credit--;
            creditLabel.setText("Credits Left: " + credit);
        });

        jButton3.addActionListener(e -> {
            bet += credit;
            credit = 0;
            creditLabel.setText("Credits Left: " + credit);
            bettingLabel.setText("Betting: " + bet);
        });

        jButton5.addActionListener(e -> {
            credit += bet;
            bet = 0;
            creditLabel.setText("Credits Left: " + credit);
            bettingLabel.setText("Betting: " + bet);
        });

        jButton6.addActionListener(e -> {
            PieChart_AWT demo = new PieChart_AWT( "Game Statistics" , numberOfWins, numberOfLosses, numberOfDraws);
            demo.setSize( 560 , 367 );
            RefineryUtilities.centerFrameOnScreen( demo );
            demo.setVisible( true );
        });
    }

    void reelSpinning() {

    }

    /**
     *
     */
    void addSources() {
        paths.add("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\bell.png");
        paths.add("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\cherry.png");
        paths.add("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\lemon.png");
        paths.add("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\plum.png");
        paths.add("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\redseven.png");
        paths.add("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\watermelon.png");

        values.add(6);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(7);
        values.add(1);

        for (int x = 0; x < NUMBER_OF_REELS; x++) {
            reels.add(new Reel(paths, values));
        }

    }


}