package pack7;
import javax.swing.*;

public class Saving extends Account
{
    public Saving(double g){
        setType(2);
        setBalance(g);
    }

    public Saving(){
        setType(2);
    }

    @Override
    public void setAccountNum(int accountNum1) {
        if(permit){
            setType(2);
            this.accountNum = accountNum1;
        }
    }

    @Override
    public void setBalance(double balance1) {
        if(balance1>=50000){
            this.balance = balance1;
        }else{
           JOptionPane.showMessageDialog(null,"Sorry!You Can't Create This Kind Of Account!");
            permit=false;
        }
    }

    @Override
    public void withdrawal(float x) {
        if (x>balance){
            JOptionPane.showMessageDialog(null, "Sorry ! This Request Is Not Acceptable !");
        }else {
            balance -= x;
            JOptionPane.showMessageDialog(null, "Process finished with success!");
        }
    }

    @Override
    public String gd() {return null;}

    @Override
    public void sd(int d1,int m1,int y1) {}

    @Override
    public void setCh(int ch1) {
    }

    @Override
    public int getCh() {
        return 0;
    }
}
