import javax.swing.*;
import java.awt.*;

/**
 * Created by Thiloshon on 13-Dec-16.
 * <p>
 * The View of the Application
 * Reusable
 */
public class GUInterface {
    final private int INITIAL_CREDIT = 10;

    private JLabel c1, c2, c3, creditLabel, bettingLabel;
    private GridBagConstraints gbc, gbc2, gbc3;
    private TestPane testPane;
    private CustomButton jButton1, jButton2, jButton3, jButton4, jButton5;

    public GUInterface() {
        testPane = new TestPane();
        Run(testPane);
    }

    /**
     *
     * @param tp
     */
    void Run(TestPane tp) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            JFrame frame = new JFrame("777 Slot Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(tp);
            frame.pack();
            frame.setSize(1000, 700);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }

    /**
     *
     */
    public class TestPane extends JPanel {
        public TestPane() {
            setBackground(Color.DARK_GRAY);
            setLayout(new GridBagLayout());

            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 0.5;
            gbc.weighty = 0.16;
            gbc.gridwidth = 1;
            gbc.insets = new Insets(4, 4, 4, 4);

            ImageIcon card = new ImageIcon("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\bell.png");
            c1 = new JLabel(card);
            add(c1, gbc);

            gbc2 = gbc;
            gbc2.gridx++;
            ImageIcon card2 = new ImageIcon("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\cherry.png");
            c2 = new JLabel(card2);
            add(c2, gbc2);

            gbc3 = gbc2;
            gbc3.gridx++;
            ImageIcon card3 = new ImageIcon("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\lemon.png");
            c3 = new JLabel(card3);
            add(c3, gbc3);

            gbc3.gridx = 0;
            gbc3.gridy++;
            gbc3.fill = GridBagConstraints.NONE;
            gbc3.ipady = 40;
            gbc3.ipadx = 75;

            jButton1 = new CustomButton("Add Coin");
            add(jButton1, gbc3);

            gbc3.gridx++;
            jButton2 = new CustomButton("Bet One");
            add(jButton2, gbc3);

            gbc3.gridx++;
            jButton3 = new CustomButton("Bet Max");
            add(jButton3, gbc3);

            gbc3.gridx = 0;
            gbc3.gridy++;
            gbc3.weightx = 0.5;

            jButton4 = new CustomButton("Spin");
            add(jButton4, gbc3);
            gbc3.gridx++;

            jButton5 = new CustomButton("Reset");
            add(jButton5, gbc3);

            gbc3.gridy++;
            gbc3.gridx = 0;
            creditLabel = new JLabel("Credits Left: " + INITIAL_CREDIT);
            add(creditLabel, gbc3);

            gbc3.gridx++;
            bettingLabel = new JLabel("Betting: 0" );
            add(bettingLabel, gbc3);
        }


    }

    // Getters and Setters of components

    public GridBagConstraints getGbc2() {
        return gbc2;
    }

    public GridBagConstraints getGbc3() {
        return gbc3;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public JLabel getC1() {
        return c1;
    }

    public JLabel getC2() {
        return c2;
    }

    public JLabel getC3() {
        return c3;
    }

    public TestPane getTestPane() {
        return testPane;
    }

    public CustomButton getjButton1() {
        return jButton1;
    }

    public CustomButton getjButton2() {
        return jButton2;
    }

    public CustomButton getjButton3() {
        return jButton3;
    }

    public CustomButton getjButton4() {
        return jButton4;
    }

    public CustomButton getjButton5() {
        return jButton5;
    }

    public JLabel getBettingLabel() {
        return bettingLabel;
    }

    public JLabel getCreditLabel() {
        return creditLabel;
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