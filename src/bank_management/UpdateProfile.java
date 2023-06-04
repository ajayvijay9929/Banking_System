package bank_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.*;

public class UpdateProfile extends JFrame implements ActionListener {
    JComboBox update;
    TextField updatetext;
    String AccountNumber;
    JButton close, submit;

    UpdateProfile(String AccountNumber) {
        this.AccountNumber = AccountNumber;
        setTitle("Update Profile");
        setLayout(null);

        String[] uparray = { "Name", "Father Name", "DOB", "Gender", "Email", "Pan Card No.", "Aadhar Card No.", "City",
                "State", "Pincode", "Marital Status" };
        update = new JComboBox(uparray);
        update.setBounds(100, 50, 300, 30);
        update.setBackground(Color.white);
        add(update);

        updatetext = new TextField();
        updatetext.setBounds(100, 100, 300, 30);
        updatetext.setBackground(Color.white);
        updatetext.setFont(new Font("railway", Font.BOLD, 17));
        add(updatetext);

        close = new JButton("Close");
        close.setBackground(Color.black);
        close.setForeground(Color.white);
        close.setFont(new Font("Ralway", Font.BOLD, 22));
        close.setBounds(100, 170, 150, 40);
        close.addActionListener(this);
        add(close);

        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Ralway", Font.BOLD, 22));
        submit.setBounds(250, 170, 150, 40);
        // submit.addActionListener(this);
        add(submit);

        setSize(500, 500);
        setLocation(450, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == close) {
            setVisible(false);
            // new Transactions(AccountNumber);
        }
    }

    public static void main(String[] args) {
        new UpdateProfile("");
    }
}
