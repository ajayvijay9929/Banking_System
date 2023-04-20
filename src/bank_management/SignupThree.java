package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.EventListener;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton b1, b2, b3, b4;
    JTextField passwordTextField, userTextField;
    String formNo,AccountNumber;
    JCheckBox tac, c1, c2, c4, c3, c5, c6;

    SignupThree(String fno,String AccountNumber) {
        formNo = fno;
        this.AccountNumber = AccountNumber;
        setTitle("Account Opening Application Form");
        setLayout(null);


        JLabel title = new JLabel("Page 3: Account Details ");
        title.setFont(new Font("Raleway", Font.BOLD, 22));
        title.setBounds(300, 50, 300, 30);
        title.setBackground(Color.black);
        add(title);

        JLabel AcType = new JLabel("Account Type ");
        AcType.setFont(new Font("Raleway", Font.BOLD, 22));
        AcType.setBounds(150, 150, 300, 30);
        AcType.setBackground(Color.black);
        add(AcType);

        b1 = new JRadioButton("Saving Account");
        b1.setBounds(160, 200, 200, 30);
        b1.setFont(new Font("Raleway", Font.BOLD, 15));
        b1.setBackground(Color.white);
        add(b1);

        b2 = new JRadioButton("Current Account");
        b2.setBounds(400, 200, 200, 30);
        b2.setFont(new Font("Raleway", Font.BOLD, 15));
        b2.setBackground(Color.white);
        add(b2);

        b3 = new JRadioButton("Fixed Deposit Account");
        b3.setBounds(160, 230, 200, 30);
        b3.setFont(new Font("Raleway", Font.BOLD, 15));
        b3.setBackground(Color.white);
        add(b3);

        b4 = new JRadioButton("Recurring Deposit Account");
        b4.setBounds(400, 230, 250, 30);
        b4.setFont(new Font("Raleway", Font.BOLD, 15));
        b4.setBackground(Color.white);
        add(b4);

        ButtonGroup acTypebtn = new ButtonGroup();
        acTypebtn.add(b4);
        acTypebtn.add(b3);
        acTypebtn.add(b2);
        acTypebtn.add(b1);

        JLabel userName = new JLabel("UserName:");
        userName.setFont(new Font("Raleway", Font.BOLD, 22));
        userName.setBounds(150, 300, 300, 30);
        userName.setBackground(Color.black);
        add(userName);

        userTextField = new JTextField();
        userTextField.setBounds(400, 300, 200, 30);
        userTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        userTextField.setBackground(Color.white);
        add(userTextField);

        JLabel passWord = new JLabel("Password:");
        passWord.setFont(new Font("Raleway", Font.BOLD, 22));
        passWord.setBounds(150, 340, 300, 30);
        passWord.setBackground(Color.black);
        add(passWord);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(400, 340, 200, 30);
        passwordTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        passwordTextField.setForeground(Color.black);
        passwordTextField.setBackground(Color.white);
        add(passwordTextField);

        JLabel servicesRequired = new JLabel("Services Required:");
        servicesRequired.setFont(new Font("Raleway", Font.BOLD, 22));
        servicesRequired.setBounds(150, 400, 300, 30);
        servicesRequired.setBackground(Color.black);
        add(servicesRequired);

        c1 = new JCheckBox("ATM Card");
        c1.setBounds(160, 450, 200, 30);
        c1.setBackground(Color.white);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(160, 480, 200, 30);
        c2.setBackground(Color.white);
        add(c2);

        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(160, 510, 200, 30);
        c5.setBackground(Color.white);
        add(c5);

        c3 = new JCheckBox("Mobial Banking");
        c3.setBounds(400, 450, 300, 30);
        c3.setBackground(Color.white);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBounds(400, 480, 300, 30);
        c4.setBackground(Color.white);
        add(c4);

        c6 = new JCheckBox("E-Statement");
        c6.setBounds(400, 510, 300, 30);
        c6.setBackground(Color.white);
        add(c6);

        tac = new JCheckBox("Term And Conditions Apply");
        tac.setBounds(150, 560, 300, 30);
        tac.setBackground(Color.white);
        add(tac);

        JButton submit = new JButton("Submit");
        submit.setBounds(550, 650, 130, 35);
        submit.setFont(new Font("Ralway", Font.BOLD, 22));
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        setSize(850, 820);
        setVisible(true);
        setLocation(30, 30);
        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ea) {



        String accountType = null;
        if (b1.isSelected()) {
            accountType = "Saving Account";
        } else if (b2.isSelected()) {
            accountType = "Current Account";
        } else if (b3.isSelected()) {
            accountType = "Fixed Deposit Account";
        } else if (b4.isSelected()) {
            accountType = "Recurring Deposit Account";
        }

        String username = userTextField.getText();
        String password = passwordTextField.getText();
        int ulen = username.length();
        int plen = password.length();
        String facility = "";
        if (c1.isSelected()) {
            facility = facility + " ATM Card ,";
        }
        if (c2.isSelected()) {
            facility = facility + " Internet Banking ,";
        }
        if (c3.isSelected()) {
            facility = facility + " Cheque Book ,";
        }
        if (c4.isSelected()) {
            facility = facility + " Mobial Banking ,";
        }
        if (c5.isSelected()) {
            facility = facility + " Email & SMS Alerts ,";
        }
        if (c6.isSelected()) {
            facility = facility + " E-Statement ,";
        }

        try {
            if (!b1.isSelected() && !b2.isSelected() && !b3.isSelected() && !b4.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please Select Account Type");
            } else if (username.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your UserName");
            } else if (password.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Password");
            } else if (ulen < 7 || ulen > 14) {
                JOptionPane.showMessageDialog(null, "Please Enter Min 7 And Max 14 Character UserName ");
            } else if (plen < 5) {
                JOptionPane.showMessageDialog(null, "Please Enter Min 5 Character Password ");
            } else if (!tac.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please Check Term And Conditions");
            } else {
                
                Conn conn = new Conn();
                String quary1 = "insert into signupThree values('" + formNo + "','"+AccountNumber+"','" + username + "','" + password + "','" + accountType + "','" + facility + "')";
                conn.s.executeUpdate(quary1);
                String quary2 = "insert into login values('" + formNo + "','"+AccountNumber+"','" + username + "','" + password + "')";
                conn.s.executeUpdate(quary2);
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Your Application Submited");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "UserName Not Available");
            System.out.println(e);
        }

    }

    

    public static void main(String[] args) {
        new SignupThree("","");
    }
}
