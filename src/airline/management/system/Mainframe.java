package airline.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Mainframe extends JFrame{

    public static void main(String[] args) {
        new Mainframe().setVisible(true);
    }
    
    public Mainframe() {
        super("AIRLINE RESERVATION MANAGEMENT SYSTEM");
        initialize();
    }

    
   
    private void initialize() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setTitle("Cloud Wings Airline Management System");

    // Header
    JPanel headerPanel = new JPanel(new GridBagLayout());
    headerPanel.setBackground(Color.BLUE);
    headerPanel.setPreferredSize(new Dimension(1200, 100));

    JLabel headerLabel = new JLabel("Cloud Wings Airline Reservation System");
    headerLabel.setForeground(Color.WHITE);
    headerLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));

    GridBagConstraints gbcHeader = new GridBagConstraints();
    gbcHeader.gridx = 0;
    gbcHeader.gridy = 0;
    headerPanel.add(headerLabel, gbcHeader);

    add(headerPanel, BorderLayout.NORTH);

    // Centered buttons panel
    JPanel centerPanel = new JPanel(new GridBagLayout());
    centerPanel.setBackground(Color.WHITE);

    JPanel buttonPanel = new JPanel(new GridLayout(0, 3, 10, 10));
    buttonPanel.setBackground(Color.WHITE);

    addButton(buttonPanel, "Flight Info", ae -> new Flight_Info());
    addButton(buttonPanel, "Add Customer", ae -> {
        try {
            new Add_Customer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
    addButton(buttonPanel, "Flight Details", ae -> {
        try {
            new Journey_Details();
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
    addButton(buttonPanel, "Payment Details", ae -> {
        try {
            new Payment_Details();
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
    addButton(buttonPanel, "Cancellation", ae -> new Cancel());

    GridBagConstraints gbcCenter = new GridBagConstraints();
    gbcCenter.gridx = 0;
    gbcCenter.gridy = 0;
    centerPanel.add(new JPanel(), gbcCenter);
    gbcCenter.gridx = 1;
    centerPanel.add(buttonPanel, gbcCenter);
    gbcCenter.gridx = 2;
    centerPanel.add(new JPanel(), gbcCenter);

    add(centerPanel, BorderLayout.CENTER);
    

    setSize(1200, 800);
    setVisible(true);
}


   private void addButton(JPanel panel, String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.addActionListener(actionListener);

        button.setPreferredSize(new Dimension(300, 100)); 
        panel.add(button);
    }
}
