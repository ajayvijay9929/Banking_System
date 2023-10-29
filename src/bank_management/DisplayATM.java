package bank_management;

import javax.swing.*;
import java.awt.*;

public class DisplayATM extends JFrame {
    DisplayATM(String AccountNumber) {
        setTitle("ATM Card");
      //  setUndecorated(true); // Remove the window outline (border and title bar)
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        JLabel label = new JLabel(img1);
        label.setBounds(0, 0, img1.getIconWidth()+50, img1.getIconHeight()+50);

        JLayeredPane layeredPane = getLayeredPane();
        layeredPane.add(label, JLayeredPane.DEFAULT_LAYER);

        String s="Vijay Yadav";
        JLabel textLabel = new JLabel(s);
        textLabel.setHorizontalAlignment(JLabel.CENTER); // Center the text horizontally
        textLabel.setBackground(getForeground());
        textLabel.setBounds(150, 310, 200, 100);
        Font font = new Font("Arial", Font.ITALIC, 30);
        textLabel.setFont(font);
        textLabel.setForeground(Color.white);


        layeredPane.add(textLabel, JLayeredPane.PALETTE_LAYER); // Place text on top of the image

        setSize(img1.getIconWidth()+70, img1.getIconHeight()+100); // Set frame size to match image size
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DisplayATM("");
    }
}
