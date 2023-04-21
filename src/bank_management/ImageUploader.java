package bank_management;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageUploader extends JFrame implements ActionListener {

    private JLabel label;
    private JButton button;

    public ImageUploader() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Image Uploader");
        setLayout(new FlowLayout());

        label = new JLabel();
        button = new JButton("Choose Image");
        button.addActionListener(this);

        add(label);
        add(button);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif");
        chooser.setFileFilter(filter);
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            // label.setIcon(new ImageIcon(selectedFile.getAbsolutePath()));
        }
    }

    public static void main(String[] args) {
        new ImageUploader();
    }
}
