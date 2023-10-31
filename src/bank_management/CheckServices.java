package bank_management;

import java.sql.ResultSet;

public class CheckServices {
    public String Atm(String AccountNumber){
        String ans = "";
        String query = "select * from services where AccountNumber = '"+ AccountNumber +"' ";
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                ans = rs.getString("ATM");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(AccountNumber + "   " +ans);
        return ans;
    }
}
