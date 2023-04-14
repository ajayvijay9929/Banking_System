package bank_management;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try {
           // Class.forName(com.mysql.cj.jdbc.Driver);
            c=DriverManager.getConnection("jdbc:mysql:///bsys","root","9521175482");
            s=c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
