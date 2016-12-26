/**
 * Created by Thiloshon on 15-Dec-16.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 * A custom Button which is more stylish than the native
 */
public class CustomButton extends JButton implements MouseListener {
    Color backgroundColor = Color.LIGHT_GRAY;
    Font defaultFont = new Font("Open Sans Light", Font.PLAIN, 14);
    Color hoverColor = Color.decode("#00aced");
    Color textColor = Color.black;

    public CustomButton(String s) {
        s = s.toUpperCase();
        this.setBorder(null);
        this.setForeground(textColor);
        this.setOpaque(true);
        this.setFocusPainted(false);
        this.setBackground(backgroundColor);
        this.setFont(defaultFont);
        this.setText(s);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this) {
            this.setBackground(this.hoverColor);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this) {
            this.setBackground(this.backgroundColor);
        }
    }
}