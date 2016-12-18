import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by Thiloshon on 17-Dec-16.
 *
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
    private  ArrayList<spinnableThread> threads = new ArrayList<>();
    private int credit = INITIAL_CREDIT;
    private int bet = 0;

    private boolean check1 = true;

    GUInterface guInterface;

    /**
     *
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
    void run(){

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

        //threads.add();
        spinnableThread th = new spinnableThread(c1, guInterface.getGbc(), guInterface.getTestPane());
        c1.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e)

            {
                System.out.println("hi");
                th.check = false;
                int value = th.getCurrent().getValue();

                //System.out.println("Setting False");
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

        spinnableThread th2 = new spinnableThread(c2, guInterface.getGbc2(), guInterface.getTestPane());
        c2.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e)

            {
                //System.out.println("hi");
                th2.check = false;
                // System.out.println("Setting False");
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

        spinnableThread th3 = new spinnableThread(c3, guInterface.getGbc3(), guInterface.getTestPane());
        c3.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e)

            {
                //System.out.println("hi");
                th3.check = false;
                //System.out.println("Setting False");
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
            th.check = true;
            th2.check = true;
            th3.check = true;
            th.start();
            th2.start();
            th3.start();
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


    class IconPack {
        ImageIcon icon;
        Symbol symbol;

        public IconPack(ImageIcon icon, Symbol symbol) {
            this.icon = icon;
            this.symbol = symbol;
        }

        public ImageIcon getIcon() {
            return icon;
        }

        public Symbol getSymbol() {
            return symbol;
        }
    }

    class spinnableThread extends Thread {
        JLabel jlabel;
        GridBagConstraints gbc;
        GUInterface.TestPane ts;
        boolean check = true;
        Symbol current;

        public spinnableThread(JLabel jlabel, GridBagConstraints gbc, GUInterface.TestPane ts) {
            this.gbc = gbc;
            this.jlabel = jlabel;
            this.ts = ts;
        }

        ArrayList<IconPack> iconPack = new ArrayList<>();

        public Symbol getCurrent() {
            return current;
        }

        /**
         *
         */
        public void run() {
            Reel reel = new Reel(paths, values);
            for (Symbol symbol : reel.getSymbols()) {
                iconPack.add(new IconPack(new ImageIcon(symbol.getImage()), symbol));
                //todo simplify this mess
            }

            int no = 0;
            for (int x = 0; check; x++) {
                int sleepno = 10;
                no = x % 6;

                jlabel.setIcon(iconPack.get(no).getIcon());
                jlabel.repaint();
                current = iconPack.get(no).getSymbol();

                ts.setComponentZOrder(jlabel, 0);
                try {
                    Thread.sleep(sleepno);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }


        }
    }


    class spinThread extends Thread {
        JLabel jlabel;
        GridBagConstraints gbc;
        GUInterface.TestPane ts;
        Reel reel;

        public spinThread(JLabel jlabel, Reel reel, GridBagConstraints gbc, GUInterface.TestPane ts) {
            this.gbc = gbc;
            this.jlabel = jlabel;
            this.ts = ts;
            this.reel = reel;
        }

        public void run() {
            ArrayList<ImageIcon> icons = new ArrayList<>();
            for (Symbol symbol : reel.getSymbols()) {
                icons.add(new ImageIcon(symbol.getImage()));
            }

            JLabel label = new JLabel();
            ts.add(label, gbc);

            for (int x = 0; check1; x++) {
                int num = x % 5;
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
}
