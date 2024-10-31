package pack7;
import javax.swing.*;

public abstract class Account
{
    protected String ownerName;
    protected int accountNum;
    protected double balance;
    public boolean permit = true;
    private int type;

    protected void setType(int t){
        this.type = t;
    }

    //Setters & Getters
    public void setOwnerName(String ownerName1){
        this.ownerName = ownerName1;
    }
    public String getOwnerName() {
        return ownerName;
    }

    public abstract void setAccountNum(int accountNum1) ;

    public int getAccountNum() {
        return accountNum;
    }

    public abstract void setBalance(double balance1) ;

    public double getBalance() {
        return balance;
    }

    public int getType(){
        return type;
    }

    public abstract String gd();

    public abstract void sd(int d1,int m1,int y1);

    public abstract void setCh(int ch1);

    public abstract int getCh();


    //Methods
    public void deposit(float m){
        balance += m;
//        System.out.println("Process finished with success!");
        JOptionPane.showMessageDialog(null,"Process finished with success!");
    }

    public abstract void withdrawal(float x);


}
