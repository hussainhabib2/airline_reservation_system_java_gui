package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Journey_Details extends JFrame{  //Forth

    JTable table;
    JLabel ReservationDetails,Pnrno,Ticketid,Fcode,Jnydate,Jnytime,Source,Destination,label,label1;
    JButton Show;

    public static void main(String[] args){
        new Journey_Details();
    }
    
       public Journey_Details() {
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        // Header
        JPanel headerPanel = new JPanel(new GridBagLayout());
        headerPanel.setBackground(Color.BLUE);
        headerPanel.setPreferredSize(new Dimension(1200, 100));

        JLabel headerLabel = new JLabel("Find Flights");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));

        GridBagConstraints gbcHeader = new GridBagConstraints();
        gbcHeader.gridx = 0;
        gbcHeader.gridy = 0;
        headerPanel.add(headerLabel, gbcHeader);

        add(headerPanel, BorderLayout.NORTH);

        // Other components
        Source = new JLabel("SOURCE");
        Source.setFont(new Font("Tahoma", Font.PLAIN, 19));
        Source.setBounds(60, 150, 150, 27);
        add(Source);

        Destination = new JLabel("DESTINATION");
        Destination.setFont(new Font("Tahoma", Font.PLAIN, 19));
        Destination.setBounds(350, 150, 150, 27);
        add(Destination);

        Show = new JButton("SHOW");
        Show.setBounds(680, 150, 100, 30);
        Show.setPreferredSize(new Dimension(120, 40));
        Show.setBackground(Color.BLUE);
        Show.setForeground(Color.WHITE);
        add(Show);

        String[] items1 = {"Karachi", "Lahore", "Islamabad", "Faislabad", "Skardu"};
        JComboBox comboBox = new JComboBox(items1);
        comboBox.setBounds(150, 150, 150, 27);
        add(comboBox);

        String[] items2 = {"Karachi", "Lahore", "Islamabad", "Faislabad", "Skardu"};
        JComboBox comboBox_1 = new JComboBox(items2);
        comboBox_1.setBounds(500, 150, 150, 27);
        add(comboBox_1);

        table = new JTable();
        table.setBackground(Color.WHITE);

        // Set preferred width of the table to cover the full width
        table.setPreferredScrollableViewportSize(new Dimension(1200, 300));

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(23, 250, 1150, 300); // Changed the width to 1150        
        
        JPanel contentPanel = new JPanel(null);
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBounds(0, 70, 900, 580);
        add(contentPanel);// Changed the width to 1150
        contentPanel.add(pane);

        Show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String src = (String) comboBox.getSelectedItem();
                    String dst = (String) comboBox_1.getSelectedItem();

                    conn c = new conn();

                    String str = "select * from reservation where source = '" + src + "' and destination = '" + dst + "'";
                    ResultSet rs = c.s.executeQuery(str);
                    
               
                    
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                   
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
