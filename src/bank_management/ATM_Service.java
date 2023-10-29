package bank_management;

import javax.swing.JFrame;

public class ATM_Service {
    String ATMCardNumber,CVV;
    long ATMCNumber,CVVN;

    ATM_Service(String AccountNumber) {
        GRNumber grn = new GRNumber();

        ATMCNumber = grn.GRNumber16();
        ATMCardNumber = Long.toString(ATMCNumber);
        System.out.println(ATMCNumber);
        
        CVVN = grn.GRNumber3();
        CVV = Long.toString(CVVN);
        System.out.println(CVV);
        try {
            Conn con=new Conn();
            String quary="insert into ATMCard values('"+AccountNumber+"','"+ATMCardNumber+"','"+CVV+"')";
            con.s.executeUpdate(quary);
        } catch (Exception e) {
           System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new DisplayIMG();
        new ATM_Service("");
    }

}
