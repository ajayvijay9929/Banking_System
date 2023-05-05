package bank_management;

import java.sql.ResultSet;
import java.util.Random;

public class GRNumber {

    static long AccountNumber = 0;
    String stringacNumber;

    public long randomNumberGenerate() {
        Random ran = new Random();
        AccountNumber = 10000000000L + ((long) (ran.nextDouble() * 90000000000L));
        long longacNumber;
        Conn conn = new Conn();
        String query = "select * from signupThree where AccountNumber = '" + AccountNumber + "'";
        try {
            ResultSet rs = conn.s.executeQuery(query);
            stringacNumber = rs.getString("AccountNumber");
            longacNumber = Long.parseLong(stringacNumber);
            // String sacnumber = Long.toString(AccountNumber);
        } catch (Exception ee) {
            System.out.println(ee);
        }

        // if (stringacNumber.equals(sacnumber)) {
        // randomNumberGenerate();
        // System.out.println("if");
        // }
        // else {
        // System.out.println("else");
        // return AccountNumber;
        // }
        // System.out.println(stringacNumber);

        return AccountNumber;
    }

}
