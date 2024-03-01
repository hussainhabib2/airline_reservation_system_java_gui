package airline.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.MaskFormatter;


public class Add_Flight extends JFrame {

    private JTextField idField, fCodeField, flightDateField, departureTimeField, sourceField, destinationField,
            arrivalDateField, arrivalTimeField;

    public Add_Flight() {
        setTitle("Add new Flight");
        setLayout(null);
        
        JLabel fCodeLabel = new JLabel("Flight Code:");
        fCodeLabel.setBounds(50, 70, 100, 25);
        add(fCodeLabel);

        JLabel flightDateLabel = new JLabel("Flight Date (yyyy-MM-dd):");
        flightDateLabel.setBounds(50, 110, 150, 25);
        add(flightDateLabel);

        JLabel departureTimeLabel = new JLabel("Departure Time (HH:mm:ss):");
        departureTimeLabel.setBounds(50, 150, 150, 25);
        add(departureTimeLabel);

        JLabel sourceLabel = new JLabel("Source:");
        sourceLabel.setBounds(50, 190, 100, 25);
        add(sourceLabel);

        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setBounds(50, 230, 100, 25);
        add(destinationLabel);

        JLabel arrivalDateLabel = new JLabel("Arrival Date (yyyy-MM-dd):");
        arrivalDateLabel.setBounds(50, 270, 150, 25);
        add(arrivalDateLabel);

        JLabel arrivalTimeLabel = new JLabel("Arrival Time (HH:mm:ss):");
        arrivalTimeLabel.setBounds(50, 310, 150, 25);
        add(arrivalTimeLabel);

 

        fCodeField = new JTextField();
        fCodeField.setBounds(200, 70, 150, 25);
        add(fCodeField);

        try {
            MaskFormatter dateFormatter = new MaskFormatter("####-##-##");
            flightDateField = new JFormattedTextField(dateFormatter);
        flightDateField.setBounds(200, 110, 150, 25);
            add(flightDateField);


        } catch (Exception e) {
            e.printStackTrace();
        }

          try {
            MaskFormatter timeFormatter = new MaskFormatter("##:##");
            departureTimeField = new JFormattedTextField(timeFormatter);
            departureTimeField.setBounds(200, 150, 150, 25);
            add(departureTimeField);


        } catch (Exception e) {
            e.printStackTrace();
        }


        sourceField = new JTextField();
        sourceField.setBounds(200, 190, 150, 25);
        add(sourceField);
        

        destinationField = new JTextField();
        destinationField.setBounds(200, 230, 150, 25);
        add(destinationField);

    
        try {
            MaskFormatter dateFormatter = new MaskFormatter("####-##-##");
            arrivalDateField = new JFormattedTextField(dateFormatter);
        arrivalDateField.setBounds(200, 270, 150, 25);
            add(arrivalDateField);


        } catch (Exception e) {
            e.printStackTrace();
        }

    
        try {
            MaskFormatter timeFormatter = new MaskFormatter("##:##");
            arrivalTimeField = new JFormattedTextField(timeFormatter);
            arrivalTimeField.setBounds(200, 310, 150, 25);
            add(arrivalTimeField);


        } catch (Exception e) {
            e.printStackTrace();
        }

        // Button
        JButton addFlightButton = new JButton("Add Flight");
        addFlightButton.setBounds(150, 360, 120, 30);
        add(addFlightButton);

        // Action Listener for the button
        addFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFlightToDatabase();
            }
        });

        // Frame settings
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addFlightToDatabase() {
        conn c = new conn();

// Assuming you have JTextField variables named fCodeField, flightDateField, departureTimeField, sourceField,
// destinationField, arrivalDateField, arrivalTimeField
        String f_code = fCodeField.getText();
        String flight_date = flightDateField.getText();
        String departure_time = departureTimeField.getText();
        String source = sourceField.getText();
        String destination = destinationField.getText();
        String arrival_date = arrivalDateField.getText();
        String arrival_time = arrivalTimeField.getText();
        
         if (f_code.isEmpty() || flight_date.isEmpty() || departure_time.isEmpty() || source.isEmpty()
                || destination.isEmpty() || arrival_date.isEmpty() || arrival_time.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all mandatory fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if any mandatory field is empty
        }

        try {
            // SQL query to insert a new flight
            String str = "INSERT INTO reservation VALUES('" + f_code + "', '" + flight_date + "', '" + departure_time + "', '"
                    + source + "', '" + destination + "', '" + arrival_date + "', '" + arrival_time + "')";

            c.s.executeUpdate(str);

            JOptionPane.showMessageDialog(null, "Flight Added");
            setVisible(false); // Assuming this is a JFrame method

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       new Add_Flight();
    }
    
 
}
