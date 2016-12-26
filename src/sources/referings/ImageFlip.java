package sources.referings; /**
 * Created by Thiloshon on 26-Dec-16.
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageFlip extends JPanel {

    public void paint(Graphics g) {
        Image myImage = new ImageIcon("C:\\Users\\Thiloshon\\IdeaProjects\\777 Slot Game\\src\\sources\\images\\cherry.png").getImage();
        BufferedImage bufferedImage = new BufferedImage(myImage.getWidth(null), myImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) g;

        Graphics gb = bufferedImage.getGraphics();
        gb.drawImage(myImage, 0, 0, null);
        gb.dispose();

        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-myImage.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        bufferedImage = op.filter(bufferedImage, null);

        g2d.drawImage(myImage, 10, 10, null);
        g2d.drawImage(bufferedImage, null, 300, 10);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flip image");
        frame.add(new ImageFlip());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(570, 230);
        frame.setVisible(true);
    }
}