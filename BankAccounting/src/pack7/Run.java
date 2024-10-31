package pack7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Run
{
    public int operation=10;
    public JComboBox box;

    public void initview(){
        JFrame mainFrame = new JFrame("Account");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setBackground(Color.cyan);
        mainFrame.setSize(650,650);
        mainFrame.setLayout(null);

        JPanel panel1= new JPanel();
        JLabel welcome = new JLabel("Hello ! Welcome To Bank System !");
        JLabel choose = new JLabel("Please Choose Your Request From List . Then Click On OK Button !");
        panel1.setBounds(80,100,500,100);

        panel1.setBackground(Color.CYAN);
        panel1.setLayout(new GridLayout(2,1));
        panel1.add(welcome);
        panel1.add(choose);
        mainFrame.add(panel1);

        JPanel panel2 = new JPanel();
        DefaultComboBoxModel boxModel=new DefaultComboBoxModel();
        boxModel.addElement("1-New Account");
        boxModel.addElement("2-Remove Account");
        boxModel.addElement("3-Show The List Of Accounts");
        boxModel.addElement("4-Search");
        boxModel.addElement("5-Deposit");
        boxModel.addElement("6-Withdrawal");
        boxModel.addElement("7-Card To Card");
        boxModel.addElement("8-Set Cheque");
        box = new JComboBox(boxModel);
        box.setBackground(Color.PINK);
        panel2.add(box);
        JButton button = new JButton("OK");
        button.setBackground(Color.PINK);
        panel2.add(button);
        panel2.setBounds(80,250,300,120);
        panel2.setBackground(Color.CYAN);
        mainFrame.add(panel2);

        welcome.setVisible(true);
        choose.setVisible(true);
        panel1.setVisible(true);
        mainFrame.setVisible(true);
        box.setVisible(true);
        panel2.setVisible(true);
        button.setVisible(true);

        //+++++++++++++++++++++++++++++++++++++++++++++
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation = box.getSelectedIndex();
//                JOptionPane.showMessageDialog(null,"item is : "+operation);
                Execution execution = new Execution(operation+1);
                execution.view();
            }
        });
    }

    public static void main(String[] args) {
        Run run = new Run();
        run.initview();

    }
}
