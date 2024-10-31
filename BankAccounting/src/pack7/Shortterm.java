package pack7;

import javax.swing.*;

public class Shortterm extends Deposit
{
    public Shortterm(double bl){
        setDate(today, thisMonth, (int)thisYear);
        setBalance(bl);
        setType(32);
    }

    public Shortterm(){
        setType(32);
    }

    @Override
    public void setAccountNum(int accountNum1) {
        if(permit){
            setType(32);
            this.accountNum = accountNum1;
        }
    }

    @Override
    public void setBalance(double balance1) {
        if(balance1>=5000){
            this.balance = balance1;
            setBenefit();
        }else{
            JOptionPane.showMessageDialog(null, "Sorry!You Can't Create This Kind Of Account!");
            permit=false;
        }
    }

    @Override
    public void withdrawal(float x) {
        if (x>balance){
            JOptionPane.showMessageDialog(null, "Balance is not Enough !!!");
        }else {
            balance -= x;
            if(balance<5000){
                balance +=x;
                JOptionPane.showMessageDialog(null, "Sorry ! This Request Is Not Acceptable !!!");
            }else{
                JOptionPane.showMessageDialog(null, "Process finished with success!");
//                System.out.println();
            }
        }
    }

    public void setBenefit(){
        if(thisYear>year){
            for(int i=(int)year;i<thisYear;i++){
                balance = 1.1*balance;
//				System.out.println(balance);
            }
        }
    }


}
