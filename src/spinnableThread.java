import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Thiloshon on 25-Dec-16.
 */
public class spinnableThread extends Thread {
    JLabel jlabel;
    GridBagConstraints gbc;
    GUInterface.GamePane ts;
    boolean check = true;
    Symbol current;
    private ArrayList<String> paths;
    private ArrayList<Integer> values;

    public spinnableThread(JLabel jlabel, GridBagConstraints gbc, GUInterface.GamePane ts, ArrayList<String> paths, ArrayList<Integer> values) {
        this.gbc = gbc;
        this.jlabel = jlabel;
        this.ts = ts;
        this.values = values;
        this.paths=paths;
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

        System.out.println(check);
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
