package bank_management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

  JButton signUp, clear, login, forgatePassWord;
  JTextField userNameField;
  JPasswordField passwordField;
  String AccountNumber;

  Login() {
    setTitle("Login Page");
    getContentPane().setBackground(Color.white);
    setLayout(null); // bezz java consider the default layout so we cannot set the image on org
    // position

    ImageIcon img1 = new ImageIcon(
      ClassLoader.getSystemResource("icons/logo.jpg")
    );
    Image img2 = img1
      .getImage()
      .getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageIcon img3 = new ImageIcon(img2); // conver in image icon bezz we cannnot pass the image in the frame
    JLabel label = new JLabel(img3);
    label.setBounds(70, 10, 100, 100);
    add(label);

    JLabel text = new JLabel("Welcome to login page");
    text.setFont(new Font("Osword", Font.BOLD, 30));
    text.setBounds(250, 40, 350, 50);
    add(text);

    JLabel UserName = new JLabel("UserName");
    UserName.setFont(new Font("Osword", Font.CENTER_BASELINE, 20));
    UserName.setBounds(120, 150, 250, 40);
    add(UserName);

    // user enter box
    userNameField = new JTextField();
    userNameField.setBounds(250, 150, 250, 40);
    userNameField.setFont(new Font("Osword", Font.CENTER_BASELINE, 17));
    add(userNameField);

    JLabel Password = new JLabel("Password");
    Password.setFont(new Font("Osword", Font.CENTER_BASELINE, 20));
    Password.setBounds(120, 220, 250, 40);
    add(Password);

    // user enter box
    passwordField = new JPasswordField();
    passwordField.setBounds(250, 220, 250, 40);
    passwordField.setFont(new Font("Osword", Font.CENTER_BASELINE, 17));
    add(passwordField);

    login = new JButton("Login");
    login.setBounds(250, 300, 100, 30);
    login.setBackground(Color.BLACK); // button back color
    login.setForeground(Color.white); // taxt color
    login.addActionListener(this);
    add(login);

    forgatePassWord = new JButton("Forgate PassWord");
    forgatePassWord.setBounds(350, 270, 170, 15);
    forgatePassWord.setBackground(Color.white); // button back color
    forgatePassWord.setForeground(Color.black); // taxt color
    forgatePassWord.setBorderPainted(false);
    forgatePassWord.setCursor(new Cursor(Cursor.HAND_CURSOR));
    forgatePassWord.addActionListener(this);
    add(forgatePassWord);

    clear = new JButton("Clear");
    clear.setBounds(400, 300, 100, 30);
    clear.setBackground(Color.BLACK); // button back color
    clear.setForeground(Color.white); // taxt color
    clear.addActionListener(this);
    add(clear);

    signUp = new JButton("SignUp");
    signUp.setBounds(250, 350, 250, 30);
    signUp.setBackground(Color.BLACK); // button back color
    signUp.setForeground(Color.white); // taxt color
    signUp.addActionListener(this);
    add(signUp);

    setSize(800, 480);
    setVisible(true);
    setLocation(300, 200);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == clear) {
      userNameField.setText("");
      passwordField.setText("");
    } else if (e.getSource() == login) {
      Conn con = new Conn();
      CustomEncryption enc = new CustomEncryption();
      String username = userNameField.getText();
      String password = passwordField.getText();
      password = enc.customEncrypt(password);
      System.out.println("this " + password + " this ");
      String query =
        "select * from login where userName = '" +
        username +
        "' and password = '" +
        password +
        "' ";

      try {
        ResultSet rs = con.s.executeQuery(query);
        if (rs.next()) {
          AccountNumber = rs.getString("AccountNumber");
          setVisible(false);
          new Transactions(AccountNumber);
        } else {
          JOptionPane.showMessageDialog(
            null,
            "Enter Correct Username And Password"
          );
        }
      } catch (Exception ee) {
        System.out.println(ee);
      }
    } else if (e.getSource() == signUp) {
      setVisible(false);
      new SignupOne();
    }

    throw new UnsupportedOperationException(
      "Unimplemented method 'actionPerformed'"
    );
  }

  public static void main(String[] args) {
    // new DisplayIMG();
    new Login();
  }
}
