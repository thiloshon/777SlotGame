import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Thiloshon on 25-Dec-16.
 * <p>
 * The Thread for managing three Reels at the same time
 */
public class spinnableThread extends Thread {
    JLabel jlabel;
    GridBagConstraints gbc;
    GUInterface.GamePane ts;
    boolean check = true;
    Symbol current;
    private ArrayList<String> paths;
    private ArrayList<Integer> values;

    /**
     * Gets references of view components needed for thread manipulation
     *
     * @param jlabel The JLabel related with the Reel.
     * @param gbc    The GridBagConstraint associated with the reel in GridBagLayout.
     * @param ts     The GamePane that holds all the components.
     * @param paths  The Arraylist with all the image paths
     * @param values The Arraylist with the values of the symbols
     */
    public spinnableThread(JLabel jlabel, GridBagConstraints gbc, GUInterface.GamePane ts, ArrayList<String> paths, ArrayList<Integer> values) {
        this.gbc = gbc;
        this.jlabel = jlabel;
        this.ts = ts;
        this.values = values;
        this.paths = paths;
    }

    ArrayList<IconPack> iconPack = new ArrayList<>();

    /**
     * The method to return the symbol which was stopped by the gamer.
     *
     * @return The symbol Stopped by the gamer.
     */
    public Symbol getCurrent() {
        return current;
    }

    /**
     * The main Thread Logic
     */
    public void run() {
        Reel reel = new Reel(paths, values);
        for (Symbol symbol : reel.getSymbols()) {
            iconPack.add(new IconPack(new ImageIcon(symbol.getImage()), symbol));
        }

        int no = 0; // to iterate through the Arraylist and get the symbol repeatedly.

        for (int x = 0; check; x++) {
            int sleepno = 10; // The duration between consecutive Symbols
            no = x % 6;

            Timer timer = new Timer(0, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(check){
                        int y = jlabel.getY()+1;
                        if (y + jlabel.getHeight() > jlabel.getHeight()*1.3) {
                            y-=jlabel.getHeight()/2;
                        }
                        jlabel.setBounds(jlabel.getX(), y, jlabel.getWidth(), jlabel.getHeight());
                        jlabel.repaint();
                    }
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();

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


    /**
     * Just a data struct to hold imageIcon and Symbol
     */
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
}
