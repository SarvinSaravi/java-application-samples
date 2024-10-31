package pack7;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class Execution extends Run
{
    public Execution(int op){
        this.operation = op;
    }

    public void view(){
        PrFile f1 = new PrFile();
        f1.read();
        f1.write();
        int j = f1.account.get(f1.account.size()-1).getAccountNum();
        if (operation==1){
            String userName=JOptionPane.showInputDialog("Please Enter Your Name : ");
            String userFamily=JOptionPane.showInputDialog("Please Enter Your Family : ");
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(5,1));
            panel.add(new JLabel("Please Enter Number of Your Account Type :"));
            panel.add(new JLabel("1-Current"));
            panel.add(new JLabel("2-Saving"));
            panel.add(new JLabel("31-LongTerm"));
            panel.add(new JLabel("32-ShortTerm"));
            int tp = Integer.parseInt(JOptionPane.showInputDialog(panel));
            float userBalance = Float.parseFloat(JOptionPane.showInputDialog("Please Enter The Amount Of Your Balance : "));
            Account a = null;
            if(tp==1){
                a= new Current(userBalance);
            }else if(tp==2){
                a = new Saving(userBalance);
            }else if(tp==31){
                a = new Longterm(userBalance);
            }else if(tp==32){
                a = new Shortterm(userBalance);
            }
            try {
                a.setOwnerName(userName + "_" + userFamily);
                a.setAccountNum(j+1);
                if (a.getAccountNum()!=0) {
                    JOptionPane.showMessageDialog(null, "Your Account Number Is : " + a.getAccountNum());
                    f1.account.add(a);
                    j++;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Unknown Type");
            }
        }else if (operation==2){
            int rNum = Integer.parseInt(JOptionPane.showInputDialog("Please Enter The AccountNumber : "));
            boolean flg=false;
            for (int p = 0; p < f1.account.size(); p++) {
                if (f1.account.get(p).getAccountNum() == rNum) {
                    f1.account.remove(p);
                    flg=true;
                }
            }
            if(flg==true){
                JOptionPane.showMessageDialog(null, "Removed!");
            }else{
                JOptionPane.showMessageDialog(null, "Sorry ! This Request Is Not Acceptable !");
            }
        }else if (operation==3){
            ListFrame list = new ListFrame(f1.account);
            list.inFrame();
        }else if (operation==4){
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2,1));
            panel.add(new JLabel("1-Search By AccountNumber"));
            panel.add(new JLabel("2-Search By OwnerName"));
            int x = Integer.parseInt(JOptionPane.showInputDialog(panel));
            boolean flg=false;
            if(x==1){
                int aNum = Integer.parseInt(JOptionPane.showInputDialog("Please Enter The AccountNumber : "));
                for(Account a:f1.account){
                    if(a.getAccountNum()==aNum){
                        JPanel p = new JPanel(new GridLayout(5,1));
                        p.add(new JLabel("OwnerName Is : " + a.getOwnerName()));
                        p.add(new JLabel("AccountNumber Is : " + a.getAccountNum()));
                        p.add(new JLabel("Amount Of Balance is : " + a.getBalance()));
                        int t= a.getType();
                        switch(t){
                            case 1:
                                p.add(new JLabel("Current Account"));
                                p.add(new JLabel("ChequeBook: " + a.getCh()));
                                break;
                            case 2:
                                p.add(new JLabel("Saving Account"));
                                break;
                            case 31:
                                p.add(new JLabel("LongTerm Account"));
                                p.add(new JLabel("DateOfCreate: " + a.gd()));
                                break;
                            case 32:
                                p.add(new JLabel("ShortTerm Account"));
                                p.add(new JLabel("DateOfCreate: " + a.gd()));
                                break;
                        }
                        JOptionPane.showMessageDialog(null,p);
                        flg=true;
                        break;
                    }
                }
                if(!flg){
                    JOptionPane.showMessageDialog(null, "Not found !");
                }
            }else if (x == 2) {
                String user1 = JOptionPane.showInputDialog("Enter Your Name : ");
                String user2 = JOptionPane.showInputDialog("Enter Your Family : ");
                String user = user1+"_"+user2;
                for(Account a:f1.account){
                    if(a.getOwnerName().equals(user)){
                        JPanel p = new JPanel(new GridLayout(5,1));
                        p.add(new JLabel("OwnerName Is : " + a.getOwnerName()));
                        p.add(new JLabel("AccountNumber Is : " + a.getAccountNum()));
                        p.add(new JLabel("Amount Of Balance is : " + a.getBalance()));
                        int t= a.getType();
                        switch(t){
                            case 1:
                                p.add(new JLabel("Current Account"));
                                p.add(new JLabel("ChequeBook: " + a.getCh()));
                                break;
                            case 2:
                                p.add(new JLabel("Saving Account"));
                                break;
                            case 31:
                                p.add(new JLabel("LongTerm Account"));
                                p.add(new JLabel("DateOfCreate: " + a.gd()));
                                break;
                            case 32:
                                p.add(new JLabel("ShortTerm Account"));
                                p.add(new JLabel("DateOfCreate: " + a.gd()));
                                break;
                        }
                        JOptionPane.showMessageDialog(null,p);
                        flg=true;
                        break;
                    }
                }
                if(!flg){
                    JOptionPane.showMessageDialog(null, "Not found !");
                }
            }else {
                JOptionPane.showMessageDialog(null,"Unkown Request!");
            }
        }else if (operation==5){
            int id = Integer.parseInt(JOptionPane.showInputDialog("Please Enter Your AccountNumber : "));
            float m1 = Float.parseFloat(JOptionPane.showInputDialog("Please Enter Amount : "));
            boolean flg=false;
            for(Account a:f1.account){
                if(a.getAccountNum()==id){
                    a.deposit(m1);
                    JOptionPane.showMessageDialog(null,"Your New Balance Is : " + a.getBalance());
                    flg=true;
                }
            }
            if(!flg){
                JOptionPane.showMessageDialog(null, "Not Found.");
            }
        }else if (operation==6){
            int id2 = Integer.parseInt(JOptionPane.showInputDialog("Please Enter Your AccountNumber : "));
            float m2 = Float.parseFloat(JOptionPane.showInputDialog("Please Enter Amount : "));
            boolean flg=false;
            int x = 0;
            for(Account a:f1.account){
                if(a.getAccountNum()==id2){
                    a.withdrawal(m2);
                    JOptionPane.showMessageDialog(null,"Your Balance Is : " + a.getBalance());
                    boolean letout = a.permit;
                    if (!letout){
                        JOptionPane.showMessageDialog(null, "Sorry! We Have to Delete Your Account!");
                        x = a.getAccountNum();
                    }
                    flg=true;
                }
            }
            for (int i=0;i<f1.account.size();i++){
                if (f1.account.get(i).getAccountNum()== x){
                    f1.account.remove(i);
                }
            }
            if(!flg){
                JOptionPane.showMessageDialog(null, "Not Found.");
            }
        }else if(operation==7){
            int a1 = Integer.parseInt(JOptionPane.showInputDialog("Enter First Account Number :"));
            int a2 = Integer.parseInt(JOptionPane.showInputDialog("Enter Seccond Account Number : "));
            int y=0,x=0;
            float am=0;
            for (Account ac:f1.account){
                if (ac.getAccountNum()==a1)
                    y++;
                if (ac.getAccountNum()==a1)
                    y++;
            }
            if (y==2){
                 am = Float.parseFloat(JOptionPane.showInputDialog("Please Enter Amount : "));
                for(Account a:f1.account){
                    if(a.getAccountNum()==a1){
                        a.withdrawal(am);
                        JOptionPane.showMessageDialog(null, "First Account Balance Is : " + a.getBalance());
                        x++;
                    }
                    if(a.getAccountNum()==a2){
                        a.deposit(am);
                        JOptionPane.showMessageDialog(null, "Seccond Account Balance Is : " + a.getBalance());
                        x++;
                    }
                }
                if(x<2){
                    JOptionPane.showMessageDialog(null, "Not Acceptable");
                }
            }else {
                JOptionPane.showMessageDialog(null,"No Response");
            }

        }else if(operation==8){
            int id = Integer.parseInt(JOptionPane.showInputDialog("Please Enter Your AccountNumber : "));
            boolean flg=false;
            for(Account a:f1.account){
                if(a.getAccountNum()==id){
                    a.setCh(10);
                    JOptionPane.showMessageDialog(null, "You Have 10 Cheque!");
                    flg=true;
                }
            }
            if(!flg){
                JOptionPane.showMessageDialog(null, "Not found");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Unknown Request !");
        }
        f1.write();
    }

}
