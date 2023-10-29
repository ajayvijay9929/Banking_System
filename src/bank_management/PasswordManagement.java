package bank_management;

import java.sql.ResultSet;

public class PasswordManagement {

    public boolean checkPassword(String AccountNumber, String password) {
        Conn connn = new Conn();
        CustomEncryption enc = new CustomEncryption();

        String pass = "";
        try {
            ResultSet arss = connn.s.executeQuery("select * from login where  AccountNumber = '" + AccountNumber + "'");
            while (arss.next()) {
                pass = arss.getString("Password");

            }
        } catch (Exception e) {

        }

        password = enc.customEncrypt(password);
        if (pass.equals(password))
            return true;
        else
            return false;
    }
}
