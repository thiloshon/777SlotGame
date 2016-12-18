package sources.referings; /**
 * Created by Thiloshon on 14-Dec-16.
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CardLayoutExample extends JFrame implements ActionListener {
    CardLayout card;
    JButton b1, b2, b3;
    Container c;


        CardLayoutExample() {

        c = getContentPane();
        card = new CardLayout(40, 30);
        //create CardLayout object with 40 hor space and 30 ver space
        c.setLayout(card);

        b1 = new JButton("Apple");
        b2 = new JButton("Boy");
        b3 = new JButton("Cat");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        c.add("a", b1);
        c.add("b", b2);
        c.add("c", b3);

    }

    public void actionPerformed(ActionEvent e) {
        card.next(c);
    }



    //TODO main method
    /*public static void main(String[] args) {
        *//*CardLayoutExample cl = new CardLayoutExample();
        cl.setSize(400, 400);
        cl.setVisible(true);
        cl.setDefaultCloseOperation(EXIT_ON_CLOSE);*//*

        new MyGridLayout();
    }*/

    static class MyGridLayout {
        JFrame f;

        MyGridLayout() {
            f = new JFrame();

            JButton b1 = new JButton("1");
            JButton b2 = new JButton("2");
            JButton b3 = new JButton("3");
            JButton b4 = new JButton("4");
            JButton b5 = new JButton("5");
            JButton b6 = new JButton("6");
            JButton b7 = new JButton("7");
            JButton b8 = new JButton("8");
            JButton b9 = new JButton("9");

            f.add(b1);
            f.add(b2);
            f.add(b3);
            f.add(b4);
            f.add(b5);
            f.add(b6);
            f.add(b7);
            f.add(b8);
            f.add(b9);

            f.setLayout(new GridLayout(3, 3));
            //setting grid layout of 3 rows and 3 columns

            f.setSize(300, 600);
            f.setVisible(true);
        }
    }
}


