package airline.management.system;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Flight_Info extends JFrame{  //Second Frame

    private JTable table;
    private JTextField textField;
    
    public static void main(String[] args){		 
	new Flight_Info().setVisible(true);    
    }
    
     public Flight_Info() {
        setSize(1200, 800);
        setLocationRelativeTo(null); 
        setVisible(true);

           // Header
        JPanel headerPanel = new JPanel(new GridBagLayout());
        headerPanel.setBackground(Color.BLUE);
        headerPanel.setPreferredSize(new Dimension(1200, 100));

        JLabel headerLabel = new JLabel("Search Flight Information");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));

        GridBagConstraints gbcHeader = new GridBagConstraints();
        gbcHeader.gridx = 0;
        gbcHeader.gridy = 0;
        headerPanel.add(headerLabel, gbcHeader);

        add(headerPanel, BorderLayout.NORTH);

        // Main Content Panel
        JPanel contentPanel = new JPanel(null);
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBounds(0, 70, 900, 580);
        add(contentPanel);

        JLabel Fcode = new JLabel("Enter flight code");
        Fcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Fcode.setBounds(50, 100, 200, 30);
        contentPanel.add(Fcode);

        JButton btnShow = new JButton("SHOW");
        btnShow.setPreferredSize(new Dimension(120, 40));
        btnShow.setBackground(Color.BLUE);
        btnShow.setForeground(Color.WHITE);
        btnShow.setBounds(220, 150, 120, 30);
        contentPanel.add(btnShow);

        table = new JTable();
        table.setBackground(Color.WHITE);

        // Set preferred width of the table to cover the full width
        table.setPreferredScrollableViewportSize(new Dimension(1200, 300));

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(23, 250, 1150, 300); // Changed the width to 1150
        contentPanel.add(pane);
        textField = new JTextField();
        textField.setBounds(220, 100, 200, 30);
        contentPanel.add(textField);

        // ... (Other components)

        // Action listener for the SHOW button
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String code = textField.getText();

                try {
                    // Assuming 'conn' is your database connection class
                    conn c = new conn();
                    String str = "select * from reservation, sector where f_code = '" + code + "'";

                    ResultSet rs = c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        setVisible(true);
    }
}