import javax.imageio.ImageIO;
import javax.swing.*;
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


    void Run() {
        paths.add("sources/images/bell.png");
        paths.add("sources/images/cherry.png");
        paths.add("sources/images/lemon.png");
        paths.add("sources/images/plum.png");
        paths.add("sources/images/redseven.png");
        paths.add("sources/images/watermelon.png");

        values.add(6);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(7);
        values.add(1);



        for (int x = 0; x < numberOfReels; x++) {
            //reels.add(new Reel(paths, values));

            System.out.println("done");
        }


        JFrame f = new JFrame();//creating instance of JFrame

        JButton b = new JButton("click");//creating instance of JButton
        b.setBounds(130, 100, 100, 40);//x axis, y axis, width, height

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
        f.setVisible(true);//making the frame visible
    }


}
