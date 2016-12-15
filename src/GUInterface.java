import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Thiloshon on 13-Dec-16.
 */
public class GUInterface {

    final int numberOfSymbolsPerReel = 6;
    final int numberOfReels = 3;

    ArrayList<String> paths = new ArrayList<>();
    ArrayList<Integer> values = new ArrayList<>();
    ArrayList<Reel> reels = new ArrayList<>();
    ArrayList<spinThread> threads = new ArrayList<>();

    void Run() {

        addSources();

        for (int x = 0; x < numberOfReels; x++) {
            reels.add(new Reel(paths, values));
        }


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
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

            }
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

            spinnableThread th = new spinnableThread(c1, gbc, this);
            th.start();

            gbc.gridx++;
            ImageIcon card2 = new ImageIcon("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\cherry.png");
            JLabel c2 = new JLabel(card2);
            add(c2, gbc);

            spinnableThread th2 = new spinnableThread(c2, gbc, this);
            th2.start();

            gbc.gridx++;
            ImageIcon card3 = new ImageIcon("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\lemon.png");
            JLabel c3 = new JLabel(card3);
            add(c3, gbc);

            spinnableThread th3 = new spinnableThread(c3, gbc, this);
            th3.start();

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.fill = GridBagConstraints.NONE;
            gbc.ipady = 40;
            gbc.ipadx = 75;



            JButton jButton = new JButton("Add Coin");


            add(jButton,gbc);
            gbc.gridx++;
            JButton jButton2 = new JButton("Bet One");
            add(jButton2,gbc);
            gbc.gridx++;
            JButton jButton3 = new JButton("Bet Max");
            add(jButton3,gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.weightx = 0.5;

            JButton jButton4 = new JButton("Spin");
            add(jButton4,gbc);
            gbc.gridx++;
            JButton jButton5 = new JButton("Reset");
            add(jButton5,gbc);




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

            for (int x = 0; x != -1; x++) {

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

            JLabel label = new JLabel();
            ts.add(label, gbc);
            for (int x = 0; x != -1; x++) {

                int sleepno = 100;

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