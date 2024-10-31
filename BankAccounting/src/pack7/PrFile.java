package pack7;

import java.io.*;
import java.util.*;

public class PrFile
{
    private String stName;
    private int number;
    private float blnc;
    private int type;
    public ArrayList<Account> account = new ArrayList<Account>();
    private PrintWriter pw;

    public void read() {
        try {
            int d,m,ch;
            long y;
            FileReader fileReader = new FileReader("AccntPrj.txt");
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                type = scanner.nextInt();
                Account a = null ;
                switch(type){
                    case 1:
                        a = new Current();
                        ch = scanner.nextInt();
                        a.setCh(ch);
                        break;
                    case 2:
                        a = new Saving();
                        break;
                    case 31:
                        a = new Longterm();
                        d=scanner.nextInt();
                        m=scanner.nextInt();
                        y=scanner.nextLong();
                        a.sd(d, m, (int)y);
                        break;
                    case 32:
                        a = new Shortterm();
                        d=scanner.nextInt();
                        m=scanner.nextInt();
                        y=scanner.nextLong();
                        a.sd(d, m, (int)y);
                        break;
                }
                stName = scanner.next();
                number = scanner.nextInt();
                blnc = scanner.nextFloat();
                a.setOwnerName(stName);
                a.setBalance(blnc);
                a.setAccountNum(number);
                account.add(a);
                scanner.next();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("not found");;
        }
    }

    public void write() {
        try {                                                           //Start of FileWrite
            pw = new PrintWriter("AccntPrj.txt");
            for(int c=0;c<account.size();c++){
                int type=account.get(c).getType();
                pw.print(type);
                if(type==31||type==32){
                    pw.println();
                    pw.write(account.get(c).gd());
                }else if (type==1){
                    pw.println();
                    pw.print(account.get(c).getCh());
                }
                pw.println();
                pw.write(account.get(c).getOwnerName());
                pw.println();
                pw.print(account.get(c).getAccountNum());
                pw.println();
                pw.print(account.get(c).getBalance());
                pw.println();
                pw.write("*******");
                pw.println();
            }
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry! File Not Found !");
        }
    }
}
