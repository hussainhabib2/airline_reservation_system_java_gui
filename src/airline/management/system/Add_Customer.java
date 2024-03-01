package airline.management.system;

import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Add_Customer extends JFrame{ //Third Frame

    
	JTextField textField_2,textField_6;
        JFormattedTextField cnicTextField, phoneNumberTextField, passportTextField, nationalityTextField, nameTextField;

        public Add_Customer() {
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel headerPanel = new JPanel(new GridBagLayout());
        headerPanel.setBackground(Color.BLUE);
        headerPanel.setPreferredSize(new Dimension(1200, 100));

        JLabel headerLabel = new JLabel("Add New Customer Booking");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));

        GridBagConstraints gbcHeader = new GridBagConstraints();
        gbcHeader.gridx = 0;
        gbcHeader.gridy = 0;
        headerPanel.add(headerLabel, gbcHeader);

        add(headerPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(null);
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBounds(0, 70, 900, 580);
        add(contentPanel);

        JLabel Passportno = new JLabel("Passport No:");
        Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Passportno.setBounds(50, 100, 200, 30);
        contentPanel.add(Passportno);

        try {
            MaskFormatter cnicFormatter = new MaskFormatter("LL-#######");
            passportTextField = new JFormattedTextField(cnicFormatter);
            passportTextField.setBounds(220, 100, 200, 30);
            contentPanel.add(passportTextField);

            passportTextField.setInputVerifier(new InputVerifier() {
                @Override
                public boolean verify(JComponent input) {
                    JFormattedTextField textField = (JFormattedTextField) input;
                    String passport = textField.getText().replaceAll("-", "");

                    if (passport.length() == 9) {
                        return true;
                    } else {
                        return false;
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel Pnrno = new JLabel("CNIC Number:");
        Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Pnrno.setBounds(50, 150, 200, 30);
        contentPanel.add(Pnrno);

        try {
            MaskFormatter cnicFormatter = new MaskFormatter("#####-#######-#");
            cnicTextField = new JFormattedTextField(cnicFormatter);
            cnicTextField.setBounds(220, 150, 200, 30);
            contentPanel.add(cnicTextField);


        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel Address = new JLabel("Complete Address:");
        Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Address.setBounds(50, 200, 200, 30);
        contentPanel.add(Address);

        textField_2 = new JTextField();
        textField_2.setBounds(220, 200, 200, 30);
        contentPanel.add(textField_2);

        JLabel Nationality = new JLabel("Nationality:");
        Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Nationality.setBounds(50, 250, 200, 30);
        contentPanel.add(Nationality);

         try {
            MaskFormatter nationalityFormatter = new MaskFormatter("***********************");
            nationalityTextField = new JFormattedTextField(nationalityFormatter);
            nationalityTextField.setBounds(220, 250, 200, 30);
            contentPanel.add(nationalityTextField);


        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel Name = new JLabel("Full Name:");
        Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Name.setBounds(50, 300, 200, 30);
        contentPanel.add(Name);
        try {
            MaskFormatter nationalityFormatter = new MaskFormatter("**************************");
            nameTextField = new JFormattedTextField(nationalityFormatter);
            nameTextField.setBounds(220, 300, 200, 30);
            contentPanel.add(nameTextField);

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel Gender = new JLabel("Gender:");
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Gender.setBounds(50, 350, 200, 30);
        contentPanel.add(Gender);

        JRadioButton NewRadioButton = new JRadioButton("Male");
        NewRadioButton.setBackground(Color.WHITE);
        NewRadioButton.setBounds(220, 350, 70, 30);
        contentPanel.add(NewRadioButton);

        JRadioButton Female = new JRadioButton("Female");
        Female.setBackground(Color.WHITE);
        Female.setBounds(300, 350, 80, 30);
        contentPanel.add(Female);

        JLabel Phno = new JLabel("Phone Number:");
        Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Phno.setBounds(50, 400, 200, 30);
        contentPanel.add(Phno);
        
        try {
            MaskFormatter cnicFormatter = new MaskFormatter("####-#######");
            phoneNumberTextField = new JFormattedTextField(cnicFormatter);
            phoneNumberTextField.setBounds(220, 400, 200, 30);
            contentPanel.add(phoneNumberTextField);


        } catch (Exception e) {
            e.printStackTrace();
        }
        

        JLabel Flightcode = new JLabel("Flight Code:");
        Flightcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Flightcode.setBounds(50, 50, 200, 30);
        contentPanel.add(Flightcode);

        textField_6 = new JTextField();
        textField_6.setBounds(220, 50, 200, 30);
        contentPanel.add(textField_6);
        
        
        JButton Next = new JButton("SAVE");
        Next.setBounds(220, 520, 120, 40);
        Next.setBackground(Color.BLUE);
        Next.setForeground(Color.WHITE);
        contentPanel.add(Next);


        Next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                   String passport_No = passportTextField.getText();
                    String pnr_no = cnicTextField.getText();
                    String address =  textField_2.getText();
                    String nationality = nationalityTextField.getText();
                    String name = nameTextField.getText();
                    String fl_code = textField_6.getText();
                   
                    String gender = null;
                    String ph_no = phoneNumberTextField.getText();
                    
                    if(NewRadioButton.isSelected()){
                        gender = "male";
                    
                    }else if(Female.isSelected()){
                        gender = "female";
                    }
                    
                    if (passport_No.isEmpty() || pnr_no.isEmpty() || address.isEmpty() || nationality.isEmpty()
                              || name.isEmpty() || fl_code.isEmpty() || gender == null || ph_no.isEmpty()) {
                          JOptionPane.showMessageDialog(null, "Please fill in all mandatory fields.", "Error", JOptionPane.ERROR_MESSAGE);
                          return; // Exit the method if any mandatory field is empty
                    }

                    
                   try {
                        conn c = new conn();
                        String str = "INSERT INTO passenger values( '"+pnr_no+"', '"+address+"', '"+nationality+"','"+name+"', '"+gender+"', '"+ph_no+"','"+passport_No+"', '"+fl_code+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Customer Added");
                        setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
            }
        });

        setVisible(true);
    }

        
    public static void main(String[] args){
        new Add_Customer();
    }   
}