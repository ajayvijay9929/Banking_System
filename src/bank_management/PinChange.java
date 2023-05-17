package bank_management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {

    JButton back, change;
    JPasswordField repintextfield, pintextfield,oldpasswordtextfield;
    String oldpassword,AccountNumber;
    PinChange(String AccountNumber) { // you deleted the old password

       // this.oldpassword=oldpassword;
        this.AccountNumber=AccountNumber;
        setTitle("Password Change Page");
        setLayout(null);

        JLabel oldpintext = new JLabel("Enter Old Password");
        oldpintext.setBounds(165, 240, 300, 25);
        oldpintext.setFont(new Font("System", Font.BOLD, 25));
        add(oldpintext);

        oldpasswordtextfield = new JPasswordField();
        oldpasswordtextfield.setBounds(470, 240, 200, 25);
        oldpasswordtextfield.setFont(new Font("System", Font.BOLD, 20));
        add(oldpasswordtextfield);

        JLabel pintext = new JLabel("New Password");
        pintext.setBounds(165, 320, 300, 25);
        pintext.setFont(new Font("System", Font.BOLD, 25));
        add(pintext);

        pintextfield = new JPasswordField();
        pintextfield.setBounds(470, 320, 200, 25);
        pintextfield.setFont(new Font("System", Font.BOLD, 20));
        add(pintextfield);

        JLabel repintext = new JLabel("Re-Enter New Password");
        repintext.setBounds(165, 400, 300, 25);
        repintext.setFont(new Font("System", Font.BOLD, 25));
        add(repintext);

        repintextfield = new JPasswordField();
        repintextfield.setBounds(470, 400, 200, 25);
        repintextfield.setFont(new Font("System", Font.BOLD, 20));
        add(repintextfield);

        change = new JButton("CHANGE");
        change.setBounds(470, 470, 100, 30);
        change.setForeground(Color.white);
        change.setBackground(Color.black);
        change.addActionListener(this);
        add(change);

        back = new JButton("BACK");
        back.setBounds(570, 470, 100, 30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        add(back);

        setSize(1000, 700);
        setLocation(130, 0);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {

                String uoldpassword = oldpasswordtextfield.getText();
                String newpassword = pintextfield.getText();
                String rnewpassword = repintextfield.getText();
                int plen = newpassword.length();
                if(!uoldpassword.equals(oldpassword)){
                    JOptionPane.showMessageDialog(null, "Please Enter Correct Old Password");
                    return;
                }
                else if (!newpassword.equals(rnewpassword)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                } else if (plen < 5) {
                    JOptionPane.showMessageDialog(null, "Please Enter Min 5 Character Password ");
                    return;
                }
                Conn conn =new Conn();
                String quary1="update login set password = '"+newpassword+"'  where AccountNumber='"+AccountNumber+"'" ;
                //String quary2="update signupThree set password = '"+newpassword+"'  where AccountNumber='"+AccountNumber+"'";

                conn.s.executeUpdate(quary1);
              //  conn.s.executeUpdate(quary2);
                JOptionPane.showMessageDialog(null, "PIN Successfully Changed");
                setVisible(false);
                new Transactions(AccountNumber);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(AccountNumber);
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
