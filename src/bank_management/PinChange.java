package bank_management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {

    JButton back, change;
    JTextField repintextfield, pintextfield,oldpasswordtextfield;
    String oldpassword,username;
    PinChange(String username,String oldpassword) {

        this.oldpassword=oldpassword;
        this.username=username;
        setTitle("Password Change Page");
        setLayout(null);

        JLabel oldpintext = new JLabel("Enter Old Password");
        oldpintext.setBounds(165, 240, 200, 25);
        oldpintext.setFont(new Font("System", Font.BOLD, 25));
        add(oldpintext);

        oldpasswordtextfield = new JTextField();
        oldpasswordtextfield.setBounds(455, 240, 100, 25);
        oldpasswordtextfield.setFont(new Font("System", Font.BOLD, 25));
        add(oldpasswordtextfield);

        JLabel pintext = new JLabel("New Password");
        pintext.setBounds(165, 320, 100, 25);
        pintext.setFont(new Font("System", Font.BOLD, 25));
        add(pintext);

        pintextfield = new JTextField();
        pintextfield.setBounds(455, 320, 150, 25);
        pintextfield.setFont(new Font("System", Font.BOLD, 25));
        add(pintextfield);

        JLabel repintext = new JLabel("Re-Enter New Password");
        repintext.setBounds(165, 400, 250, 25);
        repintext.setFont(new Font("System", Font.BOLD, 25));
        add(repintext);

        repintextfield = new JTextField();
        repintextfield.setBounds(455, 400, 150, 25);
        repintextfield.setFont(new Font("System", Font.BOLD, 25));
        add(repintextfield);

        change = new JButton("CHANGE");
        change.setBounds(400, 450, 100, 30);
        change.setForeground(Color.white);
        change.setBackground(Color.black);
        change.addActionListener(this);
        add(change);

        back = new JButton("BACK");
        back.setBounds(510, 450, 100, 30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        add(back);

        setSize(1300, 820);
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
                System.out.println(uoldpassword + " " + oldpassword);
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
                String quary1="update login set password = '"+newpassword+"'  where userName='"+username+"'" ;
                String quary2="update signupThree set password = '"+newpassword+"'  where userName='"+username+"'";

                conn.s.executeUpdate(quary1);
                conn.s.executeUpdate(quary2);
                JOptionPane.showMessageDialog(null, "PIN Successfully Changed");
                setVisible(false);
                new Transactions(username,newpassword);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(username,oldpassword);
        }
    }

    public static void main(String[] args) {
        new PinChange("","");
    }
}