
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by Thiloshon on 13-Dec-16.
 */
public class GUInterface {

    final int numberOfSymbolsPerReel = 6;
    final int numberOfReels = 3;
    final int initialCredit = 10;


    ArrayList<String> paths = new ArrayList<>();
    ArrayList<Integer> values = new ArrayList<>();
    ArrayList<Reel> reels = new ArrayList<>();
    ArrayList<spinThread> threads = new ArrayList<>();
    int credit = initialCredit;
    int bet = 0;

    boolean check1 = true;

    void Run() {

        addSources();

        for (int x = 0; x < numberOfReels; x++) {
            reels.add(new Reel(paths, values));
        }


        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            JFrame frame = new JFrame("Testing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new TestPane());
            frame.pack();
            frame.setSize(1000, 700);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });


    }

    public class TestPane extends JPanel {
        public TestPane() {
            setBackground(Color.DARK_GRAY);
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 0.5;
            gbc.weighty = 0.16;
            gbc.gridwidth = 1;
            gbc.insets = new Insets(4, 4, 4, 4);

            ImageIcon card = new ImageIcon("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\bell.png");
            JLabel c1 = new JLabel(card);
            add(c1, gbc);
            //setComponentZOrder(c1, 0);

            spinnableThread th = new spinnableThread(c1, gbc, this);
            //th.start();


            c1.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e)

                {
                    System.out.println("hi");
                    th.check = false;
                    System.out.println("Setting False");
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    System.out.println("hi");
                    try {
                        th.wait();

                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    } catch (IllegalMonitorStateException r) {

                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    System.out.println("hi");
                    try {
                        th.wait();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    } catch (IllegalMonitorStateException r) {

                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });

            gbc.gridx++;
            ImageIcon card2 = new ImageIcon("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\cherry.png");
            JLabel c2 = new JLabel(card2);
            add(c2, gbc);

            spinnableThread th2 = new spinnableThread(c2, gbc, this);

            c2.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e)

                {
                    System.out.println("hi");
                    th2.check = false;
                    System.out.println("Setting False");
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
            //th2.start();

            gbc.gridx++;
            ImageIcon card3 = new ImageIcon("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\lemon.png");
            JLabel c3 = new JLabel(card3);
            add(c3, gbc);

            spinnableThread th3 = new spinnableThread(c3, gbc, this);
            //th3.start();
            c3.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e)

                {
                    System.out.println("hi");
                    th3.check = false;
                    System.out.println("Setting False");
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


            gbc.gridx = 0;
            gbc.gridy++;
            gbc.fill = GridBagConstraints.NONE;
            gbc.ipady = 40;
            gbc.ipadx = 75;


            DregerButton bu1 = new DregerButton("Add Coin");
            add(bu1, gbc);



            gbc.gridx++;
            DregerButton jButton2 = new DregerButton("Bet One");
            add(jButton2, gbc);

            gbc.gridx++;
            DregerButton jButton3 = new DregerButton("Bet Max");
            add(jButton3, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.weightx = 0.5;

            DregerButton jButton4 = new DregerButton("Spin   ");
            add(jButton4, gbc);
            gbc.gridx++;

            jButton4.addActionListener(e -> {
                th.check = true;
                th2.check = true;
                th3.check = true;
                th.start();
                th2.start();
                th3.start();
            });

            DregerButton jButton5 = new DregerButton("Reset   ");
            add(jButton5, gbc);

            gbc.gridy++;
            gbc.gridx= 0;
            JLabel creditLabel = new JLabel("Credits Left: " + initialCredit);
            add(creditLabel, gbc);

            gbc.gridx++;
            JLabel bettingLabel = new JLabel("Betting: " + bet);
            add(bettingLabel, gbc);

            bu1.addActionListener(e -> {
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


        }
    }


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


    }

    class spinThread extends Thread {
        JLabel jlabel;
        GridBagConstraints gbc;
        TestPane ts;
        Reel reel;

        public spinThread(JLabel jlabel, Reel reel, GridBagConstraints gbc, TestPane ts) {
            this.gbc = gbc;
            this.jlabel = jlabel;
            this.ts = ts;
            this.reel = reel;
        }

        public void run() {


            ArrayList<ImageIcon> icons = new ArrayList<>();
            for (Symbol symbol : reel.symbols) {
                icons.add(new ImageIcon(symbol.path));
            }

            JLabel label = new JLabel();
            ts.add(label, gbc);


            for (int x = 0; check1; x++) {

                System.out.println("hi");
                int num = x % 5;

                System.out.println(num);

                label.setIcon(icons.get(num));
                label.repaint();

                ts.setComponentZOrder(label, 0);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }
    }

    class spinnableThread extends Thread {
        JLabel jlabel;
        GridBagConstraints gbc;
        ArrayList<Symbol> reel;
        TestPane ts;
        boolean check = true;

        public spinnableThread(JLabel jlabel, GridBagConstraints gbc, TestPane ts) {
            this.gbc = gbc;
            this.jlabel = jlabel;
            this.reel = reel;
            this.ts = ts;
        }

        ArrayList<ImageIcon> icon = new ArrayList<>();


        public void run() {

            Reel reel = new Reel(paths, values);
            for (Symbol symbol : reel.symbols) {
                icon.add(new ImageIcon(symbol.path));
            }

            int no = 0;

            //JLabel label = new JLabel();
            //ts.add(label, gbc);
            for (int x = 0; check; x++) {

                int sleepno = 10;

                System.out.println(check);
                no = x % 6;


                jlabel.setIcon(icon.get(no));
                jlabel.repaint();

                ts.setComponentZOrder(jlabel, 0);
                try {
                    Thread.sleep(sleepno);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }


        }
    }
}




    /*JFrame f = new JFrame();//creating instance of JFrame

    JButton b = new JButton("click");//creating instance of JButton
b.setBounds(130, 100, 100, 40);//x axis, y axis, width, height
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //f.add(b);//adding button in JFrame




        try {
        BufferedImage img = ImageIO.read(new File("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\bell.png"));
        ImageIcon icon = new ImageIcon(img);
        JLabel label = new JLabel(icon);
        f.add(label);
        //JOptionPane.showMessageDialog(null, label);
        } catch (IOException e) {
        e.printStackTrace();
        }

        f.setSize(400, 500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible*/

/*gbc.gridwidth = 3;
            gbc.fill = GridBagConstraints.NONE;
            ImageIcon cardsdf = new ImageIcon("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\bg.png");
            JLabel cfg1 = new JLabel(cardsdf);
            add(cfg1, gbc);
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridwidth = 1;*/