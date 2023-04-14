package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener{
    JButton signUp,clear,login;
    JTextField userNameField;
    JPasswordField passwordField;


    Login(){

        setTitle("Login Page");
        getContentPane().setBackground(Color.white);
        setLayout(null); // bezz java consider the default layout so we cannot set the image on org position

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image img2= img1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2); // conver in image icon bezz we cannnot pass the image in the frame  
        JLabel label= new JLabel(img3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text=new JLabel("Welcome to login page");
         text.setFont(new Font("Osword", Font.BOLD, 30));
        text.setBounds(250, 40, 350, 50);
        add(text);

        JLabel UserName=new JLabel("UserName");
         UserName.setFont(new Font("Osword", Font.CENTER_BASELINE, 20));
        UserName.setBounds(120, 150, 250, 40);
        add(UserName);

        // user enter box
        userNameField = new JTextField();
        userNameField.setBounds(250, 150, 250, 40);
        userNameField.setFont(new Font("Osword", Font.CENTER_BASELINE, 17));
        add(userNameField);
       
       JLabel Password=new JLabel("Password");
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
       login.setBackground(Color.BLACK);  // button back color
       login.setForeground(Color.white); // taxt color
       login.addActionListener(this);
       add(login);

       clear = new JButton("Clear");
       clear.setBounds(400, 300, 100, 30);
       clear.setBackground(Color.BLACK);  // button back color
       clear.setForeground(Color.white); // taxt color
       clear.addActionListener(this);
       add(clear);

       signUp = new JButton("SignUp");
       signUp.setBounds(250, 350, 250, 30);
       signUp.setBackground(Color.BLACK);  // button back color
       signUp.setForeground(Color.white); // taxt color
       signUp.addActionListener(this);
       add(signUp);

       

        setSize(800,480);
        setVisible(true);
        setLocation(300,200);
    }


    public static void main(String[] args) {
        new Login();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear) {
            userNameField.setText("");
            passwordField.setText("");
        }

        else if(e.getSource() == login){

        }
        else if(e.getSource() == signUp){
                    setVisible(false);
                    new SignupOne();
        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}