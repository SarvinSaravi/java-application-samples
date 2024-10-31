package pack7;

import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Deposit extends Account
{
    public float benefit;
    public Date date=new Date();
    public SimpleDateFormat dfd = new SimpleDateFormat ("dd");
    public SimpleDateFormat dfm = new SimpleDateFormat ("MM");
    public SimpleDateFormat dfy = new SimpleDateFormat ("yyyy");
    public int today= Integer.parseInt(dfd.format(date));
    public int thisMonth=Integer.parseInt(dfm.format(date));;
    public long thisYear=Integer.parseInt(dfy.format(date));;
    public int day=7;  //day of create
    public int month=5;   //month of create
    public long year=2016;   //year of create

    public void setDate(int d,int m,int y){
        if((d>0&&d<31)&&(m>0&&m<13)){
            this.day=d;
            this.month=m;
            this.year=y;
        }
    }

    public String getDate(){
        String date=day+" "+month+" "+year;
        return date;
    }

    @Override
    public String gd() {
        return getDate();
    }

    @Override
    public void sd(int d1,int m1,int y1) {
        setDate(d1,m1,y1);
    }

    @Override
    public void setCh(int ch1) {}

    @Override
    public int getCh() {
        return 0;
    }

}
