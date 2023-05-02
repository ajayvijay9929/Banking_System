package bank_management;

import java.sql.ResultSet;
import java.util.Random;

public class GRNumber {

    static long AccountNumber = 0;
    String stringacNumber;

    public long randomNumberGenerate() {
        Random ran = new Random();
        AccountNumber = Math.abs((long) (ran.nextDouble() % 90000000000L) + 10000000000L);
        System.out.println(AccountNumber);
        long longacNumber;
        Conn conn = new Conn();
        String query = "select * from signupThree where AccountNumber = '" + AccountNumber + "'";
        try {
            ResultSet rs = conn.s.executeQuery(query);
            System.out.println("quary");
            stringacNumber = rs.getString("AccountNumber");
            longacNumber = Long.parseLong(stringacNumber);
            String sacnumber = Long.toString(AccountNumber);
            if (stringacNumber.equals(sacnumber)) {
                randomNumberGenerate();
                System.out.println("if");
            }
            // if (longacNumber == AccountNumber) {
            // randomNumberGenerate();
            // }
            else {
                System.out.println("else");
                return AccountNumber;
            }
        } catch (Exception ee) {
            System.out.println(ee);
        }
        System.out.println(stringacNumber);
        return AccountNumber;
    }

}
