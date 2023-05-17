package bank_management;

import java.sql.*;
import javax.swing.*;

public class Passwordcheck {
    String password,passwordString;
    boolean passwordinputbox(String AccountNumber) {
        
        try {
            Conn connnn = new Conn();
            ResultSet aprs = connnn.s
                    .executeQuery("select * from login where AccountNumber = '" + AccountNumber + "'");
            while (aprs.next()) {
                password = aprs.getString("Password");
                System.out.println(password);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JPasswordField passwordField = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Enter password:",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            // Get the password as a char array
            char[] password1 = passwordField.getPassword();
            // Convert the password to a String
            passwordString = new String(password1);
            if (password.equals(passwordString)) {
                return true;
            }
            if (!password.equals(passwordString)) {
                JOptionPane.showMessageDialog(null, "Incorrect Password");
            }
        }
        return false;
    }
}
