package bank_management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.cj.callback.UsernameCallback;

public class QuickPay extends JFrame implements ActionListener {

    JLabel pageforquickpay, acNo, amount, remark;
    JTextField acnotext, amounttext, remarktext;
    JButton pay, cancel;
    long paybal, sebal;
    String AccountNumber, passwordString, passstr, password, amount1 = null, ureacno, reacbal, seacbal, reacno = null,
            sedatabaseamount,
            redatabaseamount;

    public QuickPay(String AccountNumber, String password) {
        setTitle("Transaction Page");
        setLayout(null);
        this.AccountNumber = "12121212121";
        this.password = password;

        pageforquickpay = new JLabel("Quick Pay");
        pageforquickpay.setFont(new Font("Raleway", Font.BOLD, 20));
        pageforquickpay.setBounds(290, 10, 400, 40);
        add(pageforquickpay);

        acNo = new JLabel("Account Number:");
        acNo.setFont(new Font("Raleway", Font.BOLD, 20));
        acNo.setBounds(70, 80, 200, 40);
        add(acNo);

        amount = new JLabel("Amount:");
        amount.setFont(new Font("Raleway", Font.BOLD, 20));
        amount.setBounds(70, 130, 200, 40);
        add(amount);

        remark = new JLabel("Remark:");
        remark.setFont(new Font("Raleway", Font.BOLD, 20));
        remark.setBounds(70, 180, 200, 40);
        add(remark);

        acnotext = new JTextField();
        acnotext.setFont(new Font("Raleway", Font.BOLD, 14));
        acnotext.setBounds(270, 90, 200, 30);
        add(acnotext);

        amounttext = new JTextField();
        amounttext.setFont(new Font("Raleway", Font.BOLD, 14));
        amounttext.setBounds(270, 140, 200, 30);
        add(amounttext);

        remarktext = new JTextField();
        remarktext.setFont(new Font("Raleway", Font.BOLD, 14));
        remarktext.setBounds(270, 190, 200, 30);
        add(remarktext);

        pay = new JButton("Pay");
        pay.setBackground(Color.black);
        pay.setForeground(Color.white);
        pay.setFont(new Font("Ralway", Font.BOLD, 20));
        pay.setBounds(370, 250, 100, 35);
        pay.addActionListener(this);
        add(pay);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Ralway", Font.BOLD, 20));
        cancel.setBounds(200, 250, 120, 35);
        cancel.addActionListener(this);
        add(cancel);

        setSize(700, 700);
        setLocation(10, 10);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == cancel) {
            setVisible(false);
            new Transactions(AccountNumber, password);
        }

        else if (ae.getSource() == pay) {
            ureacno = acnotext.getText();
            amount1 = amounttext.getText();
            // String amount2 = amount1;
            String remark = remarktext.getText();
            int count = 0;

            if (ureacno.length() != 11) {
                JOptionPane.showMessageDialog(n ull, "Please Enter Valid Account Number");
                return;
            }

            try {
                Conn conn = new Conn();
                ResultSet ars = conn.s.executeQuery("select * from balance where  AccountNumber = '" + ureacno + "'");
                while (ars.next()) {
                    reacbal = ars.getString("Balance");
                    count++;
                }
                if (count == 0) {
                    JOptionPane.showMessageDialog(null, "Wrong Account Number");
                    return;
                }

                if (amount1.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Amount");
                    return;
                }

                Conn connn = new Conn();
                ResultSet arss = connn.s
                        .executeQuery("select * from balance where  AccountNumber = '" + AccountNumber + "'");
                while (arss.next()) {
                    seacbal = arss.getString("Balance");

                }

                setVisible(false);
                {

                    paybal = Long.parseLong(amount1);
                    long rebal = Long.parseLong(reacbal);
                    sebal = Long.parseLong(seacbal);
                    long orrebal = rebal + paybal;
                    long orsebal = sebal - paybal;
                    redatabaseamount = Long.toString(orrebal);
                    sedatabaseamount = Long.toString(orsebal);

                }

                if (sebal < paybal) {
                    JOptionPane.showMessageDialog(null, "Not Enough Amount");
                    // new QuickPay(AccountNumber, password);
                    setVisible(true);
                    return;
                }

                if (paybal <= 0) {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Amount");
                    // new QuickPay(AccountNumber, password);
                    setVisible(true);
                    return;
                }

                JPasswordField passwordField = new JPasswordField();
                int pass = JOptionPane.showConfirmDialog(null, passwordField, "Enter pass",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);

                if (pass == JOptionPane.OK_OPTION) {
                    char[] password = passwordField.getPassword();
                    passwordString = new String(password);
                }

                ResultSet arsss = connn.s
                        .executeQuery("select * from login where  AccountNumber = '" + AccountNumber + "'");
                while (arsss.next()) {
                    passstr = arsss.getString("password");

                }
                if (!passstr.equals(passwordString)) {
                    JOptionPane.showMessageDialog(null, "Incorrect Password");
                    setVisible(true);
                    return;

                }

                String quary1 = "update balance set balance = '" + redatabaseamount + "' ,remark='" + remark
                        + "'  where AccountNumber='" + ureacno + "'";
                String quary2 = "update balance set balance = '" + sedatabaseamount + "' ,remark='" + remark
                        + "' where AccountNumber='" + AccountNumber + "'";

                conn.s.executeUpdate(quary1);
                conn.s.executeUpdate(quary2);

            } catch (Exception e) {
                System.out.println(e);
            }

            JOptionPane.showMessageDialog(null, "Pay Successfully");
            new Transactions(AccountNumber, password);

        }
    }

    public static void main(String[] args) {
        new QuickPay("", "");
    }
