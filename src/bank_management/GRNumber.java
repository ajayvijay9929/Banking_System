package bank_management;

import java.sql.ResultSet;
import java.util.Random;

public class GRNumber {

    static long AccountNumber = 0 ,ATMCardNumber=0,CVV=0;

    public long GRNumber11() {
        Random ran = new Random();
        AccountNumber = 10000000000L + ((long) (ran.nextDouble() * 90000000000L));
        Conn conn = new Conn();
        String query = "select * from signupThree where AccountNumber = '" + AccountNumber + "'";
        try {
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next())
                GRNumber11();
        } catch (Exception ee) {
            System.out.println(ee);
        }
        return AccountNumber;
    }

    public long GRNumber16() {
        Random ran = new Random();
        ATMCardNumber = 1000000000000000L + ((long) (ran.nextDouble() * 9000000000000000L));
        Conn conn = new Conn();
        String query = "select * from ATMCard where ATMCardNumber = '" + ATMCardNumber + "'";
        try {
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next())
             GRNumber16();
        } catch (Exception ee) {
            System.out.println(ee);
        }
        return ATMCardNumber;
    }

    public long GRNumber3() {
        Random ran = new Random();
        CVV = 100L + ((long) (ran.nextDouble() * 900L));
        Conn conn = new Conn();
        String query = "select * from ATMCard where CVV = '" + CVV + "'";
        try {
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next())
             GRNumber3();
        } catch (Exception ee) {
            System.out.println(ee);
        }
        return CVV;
    }

}
