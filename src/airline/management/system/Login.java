package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    private JTextField emailField, passwordField;
    private JLabel emailLabel, passwordLabel;
    private JButton loginButton, exitButton, closeButton;
    
    
    public Login() {
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

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);

        JPanel loginPanel = new JPanel(new GridLayout(3, 2, 10, 20)); 
        loginPanel.setBackground(Color.WHITE); 

        emailLabel = new JLabel("Email:");
        emailLabel.setHorizontalAlignment(JLabel.RIGHT);
        emailField = new JTextField(30); 

        passwordLabel = new JLabel("Password:");
        passwordLabel.setHorizontalAlignment(JLabel.RIGHT); 
        passwordField = new JPasswordField(30);

        closeButton = new JButton("Close");
        closeButton.setPreferredSize(new Dimension(120, 40));
        closeButton.setBackground(Color.LIGHT_GRAY); 
        closeButton.setForeground(Color.BLACK);
        closeButton.setBorderPainted(false);
        closeButton.addActionListener(e -> confirmExit());

        loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(120, 40));
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);

        loginPanel.add(emailLabel);
        loginPanel.add(emailField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(closeButton);
        loginPanel.add(loginButton);

        
        GridBagConstraints gbcCenter = new GridBagConstraints();
        gbcCenter.gridx = 0;
        gbcCenter.gridy = 0;
        gbcCenter.weightx = 1.0;


        centerPanel.add(loginPanel, gbcCenter);

        add(centerPanel, BorderLayout.CENTER);

        setSize(1200, 800);
        setLocationRelativeTo(null); 
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            performLogin();
        } else if (ae.getSource() == closeButton) {
            clearFields();
        }
    }

    private void performLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        try {
            conn c1 = new conn();  
            String str = "select * from login where username = '"+email+"' and password = '"+password+"'";
            ResultSet rs = c1.s.executeQuery(str);  

           if(rs.next()){
                    new Mainframe();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                }

        } catch (SQLException e) {
        }
    }

    private void clearFields() {
        emailField.setText("");
        passwordField.setText("");
    }

    private void confirmExit() {
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
   
    public static void main(String[] args){
            new Login();
    }
}
