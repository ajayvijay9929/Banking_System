
package bank_management;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener {

    JLabel page2, formno, religion, category, income, eQualification, occupation, panNumber, aadharNumber,
            seniorCitizen, exisitingAccount;
    long random;
    JTextField panTextField, aadharTextField, cityTextField, addressTextField, fnameTextField, nameTextField,
            emailTextField;
    JDateChooser dateChooser;
    JRadioButton eaYes, eaNo, scNo, scYes;
    ButtonGroup eagroup, scgroup;
    JButton next;
    JComboBox religionBox, categoryBox, incomeBox, eqBox, occupationBox;
    String fno;

    SignupTwo(String fno) {
        this.fno = fno;
        // this.random=random;
        setTitle("Account Opening Application Form");
        setLayout(null);

        formno = new JLabel("Application No. " + fno);
        formno.setFont(new Font("Raleway", Font.BOLD, 32));
        formno.setBounds(270, 40, 400, 40);
        add(formno);

        page2 = new JLabel("Page 2: Additional Details");
        page2.setFont(new Font("Raleway", Font.BOLD, 20));
        page2.setBounds(290, 80, 400, 40);
        add(page2);

        religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 22));
        religion.setBounds(130, 170, 400, 40);
        add(religion);

        category = new JLabel("Category");
        category.setFont(new Font("Raleway", Font.BOLD, 22));
        category.setBounds(130, 220, 400, 40);
        add(category);

        income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 22));
        income.setBounds(130, 270, 400, 40);
        add(income);

        eQualification = new JLabel("Edu. Qualification:");
        eQualification.setFont(new Font("Raleway", Font.BOLD, 22));
        eQualification.setBounds(130, 320, 400, 40);
        add(eQualification);

        occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 22));
        occupation.setBounds(130, 370, 400, 40);
        add(occupation);

        panNumber = new JLabel("PAN Number:");
        panNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        panNumber.setBounds(130, 420, 400, 40);
        add(panNumber);

        aadharNumber = new JLabel("Aadhar Number:");
        aadharNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        aadharNumber.setBounds(130, 470, 400, 40);
        add(aadharNumber);

        seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 22));
        seniorCitizen.setBounds(130, 520, 400, 40);
        add(seniorCitizen);

        exisitingAccount = new JLabel("Exisiting Account:");
        exisitingAccount.setFont(new Font("Raleway", Font.BOLD, 22));
        exisitingAccount.setBounds(130, 570, 400, 40);
        add(exisitingAccount);

        String[] rbarray = { "Hindu", "Muslim", "Sikh", "Christian", "Others" };
        religionBox = new JComboBox(rbarray);
        religionBox.setBounds(400, 170, 350, 30);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);

        String[] cbarray = { "General", "OBC", "SC", "ST", "Others" };
        categoryBox = new JComboBox(cbarray);
        categoryBox.setBounds(400, 220, 350, 30);
        categoryBox.setForeground(Color.black);
        categoryBox.setBackground(Color.white);
        add(categoryBox);

        String[] ibarray = { "Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000" };
        incomeBox = new JComboBox(ibarray);
        incomeBox.setBounds(400, 270, 350, 30);
        incomeBox.setForeground(Color.black);
        incomeBox.setBackground(Color.white);
        add(incomeBox);

        String[] eqarray = { "Non Graduation", "Graduate", "Post Graduation", "Dr", "Eng.", "Other" };
        eqBox = new JComboBox(eqarray);
        eqBox.setBounds(400, 320, 350, 30);
        eqBox.setForeground(Color.black);
        eqBox.setBackground(Color.white);
        add(eqBox);

        String[] obarray = { "Salaried", "Self_Employed", "Bussiness", "Student", "Retired", "Other" };
        occupationBox = new JComboBox(obarray);
        occupationBox.setBounds(400, 370, 350, 30);
        occupationBox.setForeground(Color.black);
        occupationBox.setBackground(Color.white);
        add(occupationBox);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(400, 420, 350, 30);
        add(panTextField);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(400, 470, 350, 30);
        add(aadharTextField);

        scYes = new JRadioButton("Yes");
        scYes.setBounds(400, 520, 70, 50);
        scYes.setBackground(Color.white);
        add(scYes);

        scNo = new JRadioButton("No");
        scNo.setBounds(500, 520, 70, 50);
        scNo.setBackground(Color.white);
        add(scNo);

        scgroup = new ButtonGroup();
        scgroup.add(scYes);
        scgroup.add(scNo);

        eaYes = new JRadioButton("Yes");
        eaYes.setBounds(400, 570, 70, 50);
        eaYes.setBackground(Color.white);
        add(eaYes);

        eaNo = new JRadioButton("No");
        eaNo.setBounds(500, 570, 70, 50);
        eaNo.setBackground(Color.white);
        add(eaNo);

        eagroup = new ButtonGroup();
        eagroup.add(eaYes);
        eagroup.add(eaNo);

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

    public static void main(String[] args) {
        new SignupTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String religion = (String) religionBox.getSelectedItem();
        String category = (String) categoryBox.getSelectedItem();
        String income = (String) incomeBox.getSelectedItem();
        String eQualification = (String) eqBox.getSelectedItem();
        String occupation = (String) occupationBox.getSelectedItem();
        String panNo = panTextField.getText();
        String aadharNo = aadharTextField.getText();
        String sc = null;
        String ea = null;

        if (scYes.isSelected()) {
            sc = "Yes";
        } else if (scNo.isSelected()) {
            sc = "No";
        }

        if (eaYes.isSelected()) {
            ea = "Yes";
        } else if (eaNo.isSelected()) {
            ea = "No";
        }

        try {
            if (panNo.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Pan Number ");
            }

            else if (aadharNo.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Aadhar Number ");
            }

            else if (!eaYes.isSelected() && !eaNo.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please Select Exisiting Account ");
            }

            else {
            Conn c=new Conn();
            String query = "insert into signupTwo values('"+fno+"','"+religion+"','"+category+"','"+income+"','"+eQualification+"','"+occupation+"','"+panNo+"','"+aadharNo+"','"+sc+"','"+ea+"')";
            c.s.executeUpdate(query);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}