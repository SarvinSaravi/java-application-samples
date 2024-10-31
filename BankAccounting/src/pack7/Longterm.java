package pack7;

import javax.swing.*;

public class Longterm extends Deposit
{
    public Longterm(double blnc){
        setDate(today, thisMonth, (int)thisYear);
        setBalance(blnc);
        setType(31);
    }

    public Longterm(){
        setType(31);
    }

    @Override
    public void setAccountNum(int accountNum1) {
        if(permit){
            setType(31);
            this.accountNum= accountNum1;
        }
    }

    @Override
    public void setBalance(double balance1) {
        if(balance1>=10000){
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
            JOptionPane.showMessageDialog(null, "Sorry ! Balance is not Enough !!!");
        }else if(thisYear>year){
            balance -= x;
            if(balance<10000){
                balance +=x;
                JOptionPane.showMessageDialog(null, "Sorry ! This Request Is Not Acceptable !!!");
            }else{
                JOptionPane.showMessageDialog(null, "Process finished with success!");
//                System.out.println();
            }
        }else {
            JOptionPane.showMessageDialog(null, "Sorry ! This Request Is Not Acceptable !");
        }
    }

    public void setBenefit(){
        if(thisYear==year && thisMonth>month){
            for(int i=month;i<thisMonth;i++){
                balance = 1.3*balance;
//				System.out.println(balance);
            }
        }else if(thisYear>year){
            for(int j=(int)year;j<thisYear;j++){
                balance = Math.pow(1.3, 12)*balance;
//				System.out.println(balance);
            }
            if(thisMonth>month){
                for(int i=month;i<thisMonth;i++){
                    balance = 1.3*balance;
//					System.out.println(balance);
                }
            }else {
                for(int i=thisMonth;i<month;i++){
                    balance = balance/1.3;
//					System.out.println(balance);
                }
            }
        }
    }
}
