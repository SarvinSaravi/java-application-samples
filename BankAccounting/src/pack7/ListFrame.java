package pack7;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListFrame
{
    ArrayList<Account> list = new ArrayList<Account>();
    int index=0;

    public ListFrame(ArrayList<Account> i){
            this.list = i;
    }

    public void inFrame(){

       JFrame frame = new JFrame("List Of Accounts");
       frame.getContentPane().setBackground(Color.ORANGE);
        frame.setLayout(null);
       frame.setBounds(200,90,390,500);
       frame.setVisible(true);

        DefaultListModel listModel=new DefaultListModel();

        for (Account a : list){
            listModel.addElement("OwnerName Is : " + a.getOwnerName());
            listModel.addElement("AccountNumber Is : " + a.getAccountNum());
            listModel.addElement("Amount Of Balance is : " + a.getBalance());
            int t= a.getType();
            switch(t){
                case 1:
                    listModel.addElement("Current Account");
                    listModel.addElement("ChequeBook: " + a.getCh());
                    break;
                case 2:
                    listModel.addElement("Saving Account");
                    break;
                case 31:
                    listModel.addElement("LongTerm Account");
                    listModel.addElement("DateOfCreate: " + a.gd());
                    break;
                case 32:
                    listModel.addElement("ShortTerm Account");
                    listModel.addElement("DateOfCreate: " + a.gd());
                    break;
            }
            listModel.addElement("*********");
        }

        JList jList = new JList(listModel);
        frame.add(jList);
        jList.setBackground(Color.orange);
        jList.setVisible(true);

        JScrollPane scroll =new JScrollPane(jList);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(10,10,350,430);
        scroll.setBackground(Color.GREEN);
        frame.add(scroll);
        scroll.setVisible(true);
    }


}
