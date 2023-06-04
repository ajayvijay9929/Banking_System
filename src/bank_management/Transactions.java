package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Transactions extends JFrame implements ActionListener {

    String AccountNumber, facility, name, fname, dob, gender, email, marritalstatus, city, state, pincode, pan, aadhar;
  public  JButton changePin, accountdetails, pay,logout,history,upprofile,ATMButton;
    String password, passwordString;;

    Transactions(String AccountNumber) {
        this.AccountNumber = AccountNumber;
        setTitle("Transaction Page");
        setLayout(null);

       // Passwordcheck ps=new Passwordcheck();
       //System.out.println( ps.passwordinputbox(AccountNumber));

        accountdetails = new JButton("Account Details");
        accountdetails.setBackground(Color.black);
        accountdetails.setForeground(Color.white);
        accountdetails.setFont(new Font("Ralway", Font.BOLD, 22));
        accountdetails.setBounds(300, 150, 300, 40);
        accountdetails.addActionListener(this);
        add(accountdetails);

        upprofile = new JButton("Update Profile");
        upprofile.setBackground(Color.black);
        upprofile.setForeground(Color.white);
        upprofile.setFont(new Font("Ralway", Font.BOLD, 22));
        upprofile.setBounds(300, 200, 300, 40);
        upprofile.addActionListener(this);
        add(upprofile);

        logout = new JButton("Logout");
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.setFont(new Font("Ralway", Font.BOLD, 22));
        logout.setBounds(300, 250, 300, 40);
        logout.addActionListener(this);
        add(logout);

        JButton withDrawl = new JButton("Withdrawl");
        withDrawl.setBackground(Color.black);
        withDrawl.setForeground(Color.white);
        withDrawl.setFont(new Font("Ralway", Font.BOLD, 22));
        withDrawl.setBounds(100, 150, 160, 40);
        add(withDrawl);

        JButton deposit = new JButton("Deposit");
        deposit.setBackground(Color.black);
        deposit.setForeground(Color.white);
        deposit.setFont(new Font("Ralway", Font.BOLD, 22));
        deposit.setBounds(100, 200, 160, 40);
        add(deposit);

        changePin = new JButton("PIN Change");
        changePin.setBackground(Color.black);
        changePin.setForeground(Color.white);
        changePin.setFont(new Font("Ralway", Font.BOLD, 22));
        changePin.setBounds(100, 250, 160, 40);
        changePin.addActionListener(this);
        add(changePin);

         history = new JButton("History");
        history.setBackground(Color.black);
        history.setForeground(Color.white);
        history.setFont(new Font("Ralway", Font.BOLD, 22));
        history.setBounds(100, 300, 160, 40);
        history.addActionListener(this);
        add(history);

        pay = new JButton("Quick Pay");
        pay.setBackground(Color.black);
        pay.setForeground(Color.white);
        pay.setFont(new Font("Ralway", Font.BOLD, 20));
        pay.setBounds(100, 350, 160, 35);
        pay.addActionListener(this);
        add(pay);

        ATMButton = new JButton("ATM Services");
        ATMButton.setBackground(Color.black);
        ATMButton.setForeground(Color.white);
        ATMButton.setFont(new Font("Ralway", Font.BOLD, 20));
        ATMButton.setBounds(300, 300, 300, 40);
        ATMButton.addActionListener(this);
        add(ATMButton);

        setSize(750, 600);
        setLocation(350, 70);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == changePin) {
            setVisible(false);
            new PinChange(AccountNumber);}
        if (ae.getSource() == history) {
            setVisible(false);
            new THistory(AccountNumber,password);}
        if (ae.getSource() == logout) {
            setVisible(false);
            new Login();
        } else if (ae.getSource() == pay) {
                setVisible(false);
                new QuickPay(AccountNumber, password);
        } else if(ae.getSource()==upprofile){
                    if(passwordinputbox()){
                         new UpdateProfile(AccountNumber);    
                    }
                   
        } 
        else if (ae.getSource() == accountdetails) {
            try {
                Conn conn = new Conn();
                ResultSet ars = conn.s.executeQuery("select * from signupThree where  AccountNumber = '" + AccountNumber + "'");
                while (ars.next()) {
                    facility = ars.getString("Facility");
                }

                Conn connn = new Conn();
                ResultSet rs = connn.s
                        .executeQuery("select * from signup where AccountNumber = '" + AccountNumber + "'");
                while (rs.next()) {
                    name = rs.getString("Name");
                    fname = rs.getString("Father_name");
                    dob = rs.getString("DOB");
                    gender = rs.getString("Gender");
                    email = rs.getString("Email");
                    marritalstatus = rs.getString("Married_Status");
                    city = rs.getString("City");
                    state = rs.getString("Pincode");
                    pincode = rs.getString("State");
                }

                Conn connnn = new Conn();
                ResultSet aprs = connnn.s
                        .executeQuery("select * from signupTwo where AccountNumber = '" + AccountNumber + "'");
                while (aprs.next()) {
                    pan = aprs.getString("panNo");
                    aadhar = aprs.getString("aadharNo");

                }
                    if (passwordinputbox()) {
                        new accountDetails(AccountNumber, name, fname, dob, gender, email, marritalstatus, city,
                                state,
                                pincode, pan, aadhar, facility);
                    }


            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    boolean passwordinputbox() {
        
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

    public static void main(String[] args) {
        new Transactions("");
    }
}