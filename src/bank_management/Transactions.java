package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Transactions extends JFrame implements ActionListener {

    String AccountNumber, facility, name, fname, dob, gender, email, marritalstatus, city, state, pincode, pan, aadhar;
    JButton changePin, accountdetails, pay;
    String password, username;

    Transactions(String username, String password) {
        this.password = password;
        this.username = username;
        setTitle("Transaction Page");
        setLayout(null);

        accountdetails = new JButton("Account Details");
        accountdetails.setBackground(Color.black);
        accountdetails.setForeground(Color.white);
        accountdetails.setFont(new Font("Ralway", Font.BOLD, 22));
        accountdetails.setBounds(300, 150, 300, 40);
        accountdetails.addActionListener(this);
        add(accountdetails);

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

        JButton history = new JButton("History");
        history.setBackground(Color.black);
        history.setForeground(Color.white);
        history.setFont(new Font("Ralway", Font.BOLD, 22));
        history.setBounds(100, 300, 160, 40);
        add(history);

        pay = new JButton("Quick Pay");
        pay.setBackground(Color.black);
        pay.setForeground(Color.white);
        pay.setFont(new Font("Ralway", Font.BOLD, 20));
        pay.setBounds(100, 350, 160, 35);
        pay.addActionListener(this);
        add(pay);

        setSize(1300, 820);
        setLocation(130, 0);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == changePin) {
            setVisible(false);
            new PinChange(username, password);
        } else if (ae.getSource() == pay) {
            setVisible(false);
            new QuickPay(AccountNumber, password);
        } else if (ae.getSource() == accountdetails) {
            try {
                Conn conn = new Conn();
                ResultSet ars = conn.s.executeQuery("select * from signupThree where  UserName = '" + username + "'");
                while (ars.next()) {
                    AccountNumber = ars.getString("AccountNumber");
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
                    String input = JOptionPane.showInputDialog(null, "Please Enter The Password:");
                    if (password.equals(input)) {
                        new accountDetails(AccountNumber, name, fname, dob, gender, email, marritalstatus, city, state,
                                pincode, pan, aadhar, facility);

                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Password");

                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new Transactions("", "");
    }
}