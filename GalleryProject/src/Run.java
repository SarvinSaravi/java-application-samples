import javax.swing.*;
import java.awt.*;

public class Run
{
    public static void main(String[] args) {
        Gallery g = new Gallery();
        g.frame.getContentPane().setBackground(Color.blue);
        g.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.frame.setVisible(true);
        g.frame.setBounds(350,0,800,700);
        g.view();
        JOptionPane.showMessageDialog(g.frame,"Welcome To Gallery !","Welcome Message",JOptionPane.OK_OPTION,new ImageIcon("D:\\JAVA\\minipic\\pic.png"));
        g.action();
        g.frame.validate();
    }
}
