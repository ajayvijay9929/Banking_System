package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DisplayIMG extends JFrame {
    DisplayIMG() {
        setTitle("ATM Card");
        setUndecorated(true); // Remove the window outline (border and title bar)
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        JLabel label = new JLabel(img1);
        label.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());

        JLayeredPane layeredPane = getLayeredPane();
        layeredPane.add(label, JLayeredPane.DEFAULT_LAYER);

        String s="fd";
        JLabel textLabel = new JLabel(s);
        textLabel.setHorizontalAlignment(JLabel.CENTER); // Center the text horizontally
        textLabel.setBounds(100, 100, 200, 50);

        layeredPane.add(textLabel, JLayeredPane.PALETTE_LAYER); // Place text on top of the image

        setSize(img1.getIconWidth(), img1.getIconHeight()); // Set frame size to match image size
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DisplayIMG();
    }
}
