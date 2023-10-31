package bank_management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class DisplayATM extends JFrame implements ActionListener {

  String AtmNumber, Name, CVV, date;
  JButton Close;

  DisplayATM(String AccountNumber) {
    setTitle("ATM Card");
    // AccountNumber="79298288867";
    setUndecorated(true);
    getContentPane().setBackground(Color.white);
    setLayout(null);

    ImageIcon img1 = new ImageIcon(
        ClassLoader.getSystemResource("icons/ATM.jpg"));
    JLabel label = new JLabel(img1);
    label.setBounds(0, 0, img1.getIconWidth() + 50, img1.getIconHeight() + 50);

    JLayeredPane layeredPane = getLayeredPane();
    layeredPane.add(label, JLayeredPane.DEFAULT_LAYER);

    Conn con = new Conn();
    String query = "select * from atmcard where AccountNumber = '" + AccountNumber + "'";
    String query1 = "select * from signup where AccountNumber = '" + AccountNumber + "'";

    try {
      ResultSet rs = con.s.executeQuery(query);
      if (rs.next()) {
        AtmNumber = rs.getString("ATMCardNumber");
        CVV = rs.getString("CVV");
        date = rs.getString("validdate");
      }
      ResultSet rs1 = con.s.executeQuery(query1);
      if (rs1.next())
        Name = rs1.getString("Name");
    } catch (Exception ee) {
      System.out.println(ee);
    }

    JLabel textLabel = new JLabel(Name);
    textLabel.setBackground(getForeground());
    textLabel.setBounds(150, 310, 500, 100);
    Font font = new Font("Arial", Font.ITALIC, 30);
    textLabel.setFont(font);
    textLabel.setForeground(Color.white);

    JLabel textLabel1 = new JLabel(AtmNumber);
    textLabel1.setBackground(getForeground());
    textLabel1.setBounds(150, 230, 500, 100);
    Font font1 = new Font("Arial", Font.BOLD, 40);
    textLabel1.setFont(font1);
    textLabel1.setForeground(Color.white);

    JLabel textLabel2 = new JLabel(CVV);
    textLabel2.setBackground(getForeground());
    textLabel2.setBounds(750, 360, 500, 100);
    Font font2 = new Font("Arial", Font.ITALIC, 30);
    textLabel2.setFont(font2);
    textLabel2.setForeground(Color.GREEN);

    JLabel textLabel3 = new JLabel(date);
    textLabel3.setBackground(getForeground());
    textLabel3.setBounds(280, 395, 500, 100);
    Font font3 = new Font("Arial", Font.ITALIC, 30);
    textLabel3.setFont(font3);
    textLabel3.setForeground(Color.GREEN);

    Close = new JButton("Close ATM ");
    Close.setBounds(750, 470, 160, 40);
    Close.setLayout(null);
    Close.setBorderPainted(false);
    Close.setBackground(Color.lightGray);
    Close.setForeground(Color.black);
    Close.setFont(new Font("Ralway", Font.BOLD, 22));
    Close.setFocusPainted(false);
    Close.addActionListener(this);

    layeredPane.add(textLabel, JLayeredPane.PALETTE_LAYER); // Place text on top of the image
    layeredPane.add(textLabel1, JLayeredPane.PALETTE_LAYER); // Place text on top of the image
    layeredPane.add(textLabel2, JLayeredPane.PALETTE_LAYER); // Place text on top of the image
    layeredPane.add(textLabel3, JLayeredPane.PALETTE_LAYER); // Place text on top of the image
    layeredPane.add(Close, JLayeredPane.PALETTE_LAYER); // Place text on top of the image
    setSize(img1.getIconWidth() + 50, img1.getIconHeight() + 50); // Set frame size to match image size
    setLocationRelativeTo(null); // Center the frame on the screen
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == Close) {
      System.out.println("it's working");
      setVisible(false);
    }
  }

  public static void main(String[] args) {
    new DisplayATM("");
  }
}
