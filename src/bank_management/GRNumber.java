package bank_management;

import java.sql.ResultSet;
import java.util.Random;

public class GRNumber {
    
     static long AccountNumber = 0;
     String stringacNumber;

    public long randomNumberGenerate(){
        Random ran =new Random();
        AccountNumber = Math.abs((ran.nextLong() % 12854856873L) + 10000000000L);
        System.out.println(AccountNumber);
        long longacNumber;
        Conn conn = new Conn();
        String query = "select * from signupThree where AccountNumber = '"+AccountNumber+"'";

        try {
           ResultSet rs= conn.s.executeQuery(query);
           stringacNumber=rs.getString("AccountNumber");
           longacNumber=Long.parseLong(stringacNumber);

           if(longacNumber==AccountNumber){
            randomNumberGenerate();
           } else{
           // return stringacNumber;
           }
        } catch (Exception ee) {
            System.out.println(ee);
        }
        System.out.println(stringacNumber);
        return AccountNumber;
    }

}
