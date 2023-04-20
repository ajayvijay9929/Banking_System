package bank_management;

import javax.swing.*;
import java.awt.*;

public class accountDetails extends JFrame  {

    accountDetails(String AccountNumber,String name ,String fname,String dob,String gender,String email,String marritalstatus,String city,String state,String pincode,String pan,String aadhar) {
        setTitle("Account Details");
        setLayout(null);

        JLabel text = new JLabel("Account Deatils");
        text.setFont(new Font("Osword", Font.BOLD, 25)); 
        text.setBounds(150, 20, 200, 50);
        add(text);

        JLabel accountNo = new JLabel("AccountNumber:   " + AccountNumber);
        accountNo.setFont(new Font("Osword", Font.BOLD, 15));
        accountNo.setBounds(30, 100, 400, 50);
        add(accountNo);

        JLabel dname = new JLabel("Name:                       " + name);
        dname.setFont(new Font("Osword", Font.BOLD, 15));
        dname.setBounds(30, 120, 400, 50);
        add(dname);

        JLabel dfname = new JLabel("Father Name:          " + fname);
        dfname.setFont(new Font("Osword", Font.BOLD, 15));
        dfname.setBounds(30, 140, 400, 50);
        add(dfname);

        JLabel ddob = new JLabel("DOB:                         " + dob);
        ddob.setFont(new Font("Osword", Font.BOLD, 15));
        ddob.setBounds(30, 160, 400, 50);
        add(ddob);

        JLabel dgender = new JLabel("Gender:                    " + gender);
        dgender.setFont(new Font("Osword", Font.BOLD, 15));
        dgender.setBounds(30, 180, 400, 50);
        add(dgender);

        JLabel demail = new JLabel("Email:                        " + email);
        demail.setFont(new Font("Osword", Font.BOLD, 15));
        demail.setBounds(30, 200, 400, 50);
        add(demail);

        JLabel dmarritalstatus = new JLabel("Marrital Status:       " + marritalstatus);
        dmarritalstatus.setFont(new Font("Osword", Font.BOLD, 15));
        dmarritalstatus.setBounds(30, 220, 400, 50);
        add(dmarritalstatus);

        JLabel dpan = new JLabel("PAN Number:           " + pan);
        dpan.setFont(new Font("Osword", Font.BOLD, 15));
        dpan.setBounds(30, 240, 400, 50);
        add(dpan);
        
        
        JLabel daadhar = new JLabel("Aadhar Number:     " + aadhar);
        daadhar.setFont(new Font("Osword", Font.BOLD, 15));
        daadhar.setBounds(30, 260, 400, 50);
        add(daadhar);
        
        JLabel dpincode = new JLabel("PinCode:                  " + pincode);
        dpincode.setFont(new Font("Osword", Font.BOLD, 15));
        dpincode.setBounds(30, 280, 400, 50);
        add(dpincode);
        
        JLabel dcity = new JLabel("City:                           " + city);
        dcity.setFont(new Font("Osword", Font.BOLD, 15));
        dcity.setBounds(30, 300, 400, 50);
        add(dcity);
        
        JLabel dstate = new JLabel("State:                         " + state);
        dstate.setFont(new Font("Osword", Font.BOLD, 15));
        dstate.setBounds(30, 320, 400, 50);
        add(dstate);


        setSize(500, 500);
        setVisible(true);
        setLocation(500, 150);
        getContentPane().setBackground(Color.white);
    }



    public static void main(String[] args) {
        new accountDetails("","","","","","","","","","","","");
    }

}
