import java.awt.*;
import javax.swing.*;

public class Rotate {

    public static JPanel rotatin(Image bi){
        JPanel panel = new JPanel(){

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(bi.getWidth(null), bi.getHeight(null));
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.rotate(Math.PI / 1 , bi.getWidth(null) / 2, bi.getHeight(null) / 2);
                g2.drawImage(bi, 0, 0, null);
            }
        };
        return panel;
    }

    public static JPanel rotatin2(Image bi){
        JPanel panel = new JPanel(){

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(bi.getWidth(null), bi.getHeight(null));
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.rotate(Math.PI * 2 , bi.getWidth(null) / 2, bi.getHeight(null) / 2);
                g2.drawImage(bi, 0, 0, null);
            }
        };
        return panel;
    }
}

   
    
  