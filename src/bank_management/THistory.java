package bank_management;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class THistory implements ActionListener {
    JButton Close;
    JFrame frame;
    String AccountNumber, password;

    THistory(String AccountNumber,String password){
        this.AccountNumber=AccountNumber;
        this.password=password;
         frame = new JFrame("Transactions History");
        
         Close= new JButton("Close");
        Close.setBounds(900, 500, 70, 30);
        Close.setLayout(null);
        Close.setBackground(Color.black);
        Close.setForeground(Color.white);
        Close.addActionListener(this);
        frame.add(Close);
        // Create a JTable object using the DefaultTableModel
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        table.setEnabled(false);
        frame.add(new JScrollPane(table));
        
        
        // Create a JFrame and add the JTable to it
        try {

            Conn con=new Conn();
           // ResultSet rs = con.s.executeQuery("SELECT * FROM trhistory JOIN signupthree ON trhistory.Self_AcNo = signupthree.AccountNumber where Self_AcNo='"+AccountNumber+"'");
            ResultSet rs = con.s.executeQuery("SELECT * FROM trhistory where Self_AcNo='"+AccountNumber+"'");
            
            // Get the metadata for the result set
            ResultSetMetaData rsmd = rs.getMetaData();
            
            // Get the number of columns in the result set
            int numColumns = rsmd.getColumnCount();
            
            // Create a DefaultTableModel object with the column names
            for (int i = 1; i <= numColumns; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }
            
            // Add the rows to the model
            while (rs.next()) {
                Object[] row = new Object[numColumns];
                for (int i = 1; i <= numColumns; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }
            

            frame.setSize(1000, 600);
            frame.setLocation(50, 50);
            frame.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Close) {
            frame.setVisible(false); 
            new Transactions(AccountNumber);
        }
    }

    public static void main(String[] args) {
        new THistory("", "");
    }
}
