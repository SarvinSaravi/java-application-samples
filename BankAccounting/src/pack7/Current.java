package pack7;
import javax.swing.*;

public class Current extends Deposit
{
    public int check=10;

    public Current(double b){
        setBalance(b);
        setType(1);
    }

    public Current(){
        setType(1);
    }

    @Override
    public void setAccountNum(int accountNum1) {
        if(permit){
            this.accountNum = accountNum1;
        }
    }

    @Override
    public void setBalance(double balance1) {
        if(balance1>=100000){
            this.balance=balance1;
        }else{
//            System.out.println("Sorry!You Can't Create This Kind Of Account!");
            JOptionPane.showMessageDialog(null,"Sorry!You Can't Create This Kind Of Account!");
            permit=false;
        }
    }

    @Override
    public String gd() {
        return null;
    }

    @Override
    public void sd(int d1, int m1, int y1) {

    }

    @Override
    public void setCh(int ch1) {
        this.check = ch1;
    }

    @Override
    public int getCh() {
        return check;
    }

    @Override
    public void withdrawal(float x) {
        String answer = JOptionPane.showInputDialog("Do You Have Cheque ?");
        if(answer.equalsIgnoreCase("yes")){
            int dch = Integer.parseInt(JOptionPane.showInputDialog("What Day ?"));
            int mch = Integer.parseInt(JOptionPane.showInputDialog("What Month ?"));
            int ych = Integer.parseInt(JOptionPane.showInputDialog("What Year ?"));
            spend(x,dch,mch,ych);
        }else {
            if (x>balance){
                JOptionPane.showMessageDialog(null, "Sorry ! Balance is not Enough !");
            }else {
                balance -= x;
                JOptionPane.showMessageDialog(null, "Process finished with success!");
            }
        }
    }

    public void spend(float x1,int dc,int mc,int yc){
        setDate(dc,mc,yc);
        if (x1>balance){
            JOptionPane.showMessageDialog(null, "Sorry ! Balance is Not Enough!");
            permit = false;
        }else if(today==day&&thisMonth==month&&thisYear==year){
            check--;
            if(check<0){
                JOptionPane.showMessageDialog(null, "Not Enough checkBook!");
            }else{
                balance -= x1;
                JOptionPane.showMessageDialog(null, "Process finished with success!");
            }
        }
    }

}
