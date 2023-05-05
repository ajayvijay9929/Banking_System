
package bank_management;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;
import java.beans.Visibility;

import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {

    JLabel formno, name, page1, fname, dob, gender, email, marital, address, city, state, pincode;
    long random;
    JTextField pincodeTextField, stateTextField, cityTextField, addressTextField, fnameTextField, nameTextField,
            emailTextField;
    JDateChooser dateChooser;
    JRadioButton unMarried, married, feMale, male;
    ButtonGroup marriedGroup, gendergroup;
    JButton next;
    long AccountNumber;
    String acnumber;
    private JLabel label;
    private JButton button;

    SignupOne() {
        setTitle("Application Form");
        setLayout(null);

        GRNumber grn = new GRNumber();
        AccountNumber = grn.randomNumberGenerate();
        System.out.println(AccountNumber);
        acnumber = Long.toString(AccountNumber);

        Random ran = new Random();
        random = 1000L + (long)(ran.nextDouble() *9000L);

        formno = new JLabel("Application No. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 32));
        formno.setBounds(250, 40, 400, 40);
        add(formno);

        page1 = new JLabel("Page 1: Personal Details");
        page1.setFont(new Font("Raleway", Font.BOLD, 20));
        page1.setBounds(290, 80, 400, 40);
        add(page1);

        label = new JLabel();
        button = new JButton("Choose Image");
        button.addActionListener(this);

        add(label);
        add(button);

        name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(130, 170, 400, 40);
        add(name);

        fname = new JLabel("Father's name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(130, 220, 400, 40);
        add(fname);

        dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(130, 270, 400, 40);
        add(dob);

        gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(130, 320, 400, 40);
        add(gender);

        email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(130, 370, 400, 40);
        add(email);

        marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 22));
        marital.setBounds(130, 420, 400, 40);
        add(marital);

        address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(130, 470, 400, 40);
        add(address);

        city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(130, 520, 400, 40);
        add(city);

        state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(130, 570, 400, 40);
        add(state);

        pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(130, 620, 400, 40);
        add(pincode);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(400, 170, 350, 30);
        add(nameTextField);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(400, 220, 350, 30);
        add(fnameTextField);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(400, 270, 350, 30);
        dateChooser.setForeground(new Color(150, 150, 150));
        add(dateChooser);

        male = new JRadioButton("Male");
        male.setBounds(400, 320, 60, 30);
        male.setBackground(Color.white);
        add(male);

        feMale = new JRadioButton("Female");
        feMale.setBounds(500, 320, 100, 30);
        feMale.setBackground(Color.white);
        add(feMale);

        gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(feMale);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(400, 370, 350, 30);
        add(emailTextField);

        married = new JRadioButton("married");
        married.setBounds(400, 420, 100, 30);
        married.setBackground(Color.white);
        add(married);

        unMarried = new JRadioButton("UnMarried");
        unMarried.setBounds(500, 420, 100, 30);
        unMarried.setBackground(Color.white);
        add(unMarried);

        marriedGroup = new ButtonGroup();
        marriedGroup.add(married);
        marriedGroup.add(unMarried);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(400, 470, 350, 30);
        add(addressTextField);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(400, 520, 350, 30);
        add(cityTextField);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(400, 570, 350, 30);
        add(stateTextField);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(400, 620, 350, 30);
        add(pincodeTextField);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(670, 680, 80, 30);
        next.addActionListener(this);
        add(next);

        setSize(850, 800);
        setLocation(10, 10);
        setVisible(true);
        getContentPane().setBackground(Color.white);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (feMale.isSelected()) {
            gender = "Female";
        }

        String email = emailTextField.getText();

        String marital = null;
        if (married.isSelected())
            marital = "Married";
        else if (unMarried.isSelected())
            marital = "Unmarried";

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Name ");
            }

            else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Father Name ");
            }

            else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your D.O.B ");
            }

            else if (!male.isSelected() && !feMale.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please Select Gender");
            }

            else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Email ");
            }

            else if (!married.isSelected() && !unMarried.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please Select Married Status ");
            }

            else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Address ");
            }

            else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your City ");
            }

            else if (pincode.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Pincode ");
            }

            else if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your State ");
            }

            else {
                Conn c = new Conn();
                String query = "insert into signup values('" + formno + "','" + AccountNumber + "','" + name + "','"
                        + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address
                        + "','" + city + "','" + pincode + "','" + state + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno, acnumber);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new SignupOne();
    }
}