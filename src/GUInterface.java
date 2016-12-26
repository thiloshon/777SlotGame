import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Thiloshon on 13-Dec-16.
 * <p>
 * The View of the Application
 * All the Visual Representation of the application comes here.
 * Contains an innerclass which is a custom container
 */
public class GUInterface {
    final private int INITIAL_CREDIT = 10; // The number of credits given at the beginning of the game

    private JLabel c1, c2, c3, creditLabel, bettingLabel, messageLabel;
    private GridBagConstraints gbc, gbc2, gbc3;
    private GamePane gamePane;
    private CustomButton jButton1, jButton2, jButton3, jButton4, jButton5, jButton6;

    public GUInterface() {
        gamePane = new GamePane();
        Run(gamePane);
    }

    /**
     * The method initiates the GUI and sets size and views it.
     *
     * @param gamePane: An instance of the GamePane
     */
    void Run(GamePane gamePane) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            JFrame frame = new JFrame("777 Slot Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(gamePane);
            frame.pack();
            frame.setSize(1000, 700);
            Dimension dm = new Dimension(); // The minimum frame size dimension
            dm.setSize(500, 370);
            frame.setMinimumSize(dm);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }

    /**
     * The Custom Container to hold Reel and similar components
     * Uses GridBagLayout
     */
    public class GamePane extends JPanel {

        public GamePane() {
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

            ImageIcon card = new ImageIcon("src\\sources\\images\\bell.png");
            c1 = new JLabel(card);
            add(c1, gbc);

            gbc2 = gbc;
            gbc2.gridx++;
            ImageIcon card2 = new ImageIcon("src\\sources\\images\\cherry.png");
            c2 = new JLabel(card2);
            add(c2, gbc2);

            gbc3 = gbc2;
            gbc3.gridx++;
            ImageIcon card3 = new ImageIcon("src\\sources\\images\\lemon.png");
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

            gbc3.gridx++;
            jButton6 = new CustomButton("Statistics");
            add(jButton6, gbc3);

            Font defaultFont = new Font("Open Sans Light", Font.PLAIN, 17);


            gbc3.gridy++;
            gbc3.gridx = 0;
            creditLabel = new JLabel("Credits Left: " + INITIAL_CREDIT);
            creditLabel.setForeground(Color.GRAY);
            creditLabel.setFont(defaultFont);
            creditLabel.setPreferredSize(new Dimension(110, 24));
            add(creditLabel, gbc3);

            gbc3.gridx++;
            bettingLabel = new JLabel("Betting: 0");
            bettingLabel.setForeground(Color.GRAY);
            bettingLabel.setFont(defaultFont);
            add(bettingLabel, gbc3);

            gbc3.gridx++;
            messageLabel = new JLabel("Status: Playing");
            messageLabel.setForeground(Color.WHITE);
            messageLabel.setFont(defaultFont);
            messageLabel.setPreferredSize(new Dimension(110, 24));
            add(messageLabel, gbc3);


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

    public GamePane getGamePane() {
        return gamePane;
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

    public CustomButton getjButton6() {
        return jButton6;
    }

    public JLabel getBettingLabel() {
        return bettingLabel;
    }

    public JLabel getCreditLabel() {
        return creditLabel;
    }

    public JLabel getMessageLabel() {
        return messageLabel;
    }
}