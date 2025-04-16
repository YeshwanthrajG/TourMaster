//
//package TravelAgency;
//import java.awt.*;
//import javax.swing.*;
//import java.awt.event.*;
//
//public class SelfChoosenPacks extends JFrame {
//
//    private JLabel label0, label1, totalCostLabel, backgroundLabel;
//    private Font f1, f2, f3, f4, f5, f6;
//    private JComboBox<String> cb1, cb2, cb3, cb4, cb5, cb6, cb7;
//    private JButton btn1, btn2, btn3, btn4;
//    private Cursor cursor;
//    private double totalCost = 0;
//
//    SelfChoosenPacks() {
//        // Frame setup
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setTitle("Travel Agency - Registration by admin");
//        setSize(1536, 864);
//        setLocationRelativeTo(null);
//        setResizable(false);
//        setLayout(null);
//
//        // Background setup
//        ImageIcon bgImage = new ImageIcon(getClass().getResource("/Admin.jpg"));
//        backgroundLabel = new JLabel(new ImageIcon(bgImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));
//        backgroundLabel.setBounds(0, 0, 1536, 864);
//        add(backgroundLabel);
//
//        // Fonts
//        f1 = new Font("Segoe UI Black", Font.PLAIN, 35);
//        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
//        f3 = new Font("Segoe UI Semibold", Font.PLAIN, 35);
//        f4 = new Font("Segoe UI", Font.PLAIN, 25);
//        f5 = new Font("Segoe UI", Font.PLAIN, 19);
//
//        // Cursor for JButtons
//        cursor = new Cursor(Cursor.HAND_CURSOR);
//
//        // Title
//        label1 = createLabel("Select Tour Details", 482, 24, f1);
//        backgroundLabel.add(label1);
//
//        // Tour Type
//        JLabel tourTypeLabel = createLabel("Tour Type", 430, 75, f4);
//        backgroundLabel.add(tourTypeLabel);
//
//        String[] cb1Str = { "Choose tour type...", "Domestic", "International" };
//        cb1 = createComboBox(cb1Str, 580, 84);
//        backgroundLabel.add(cb1);
//
//        // Destination
//        label0 = createLabel("Destination", 430, 140, f4);
//        backgroundLabel.add(label0);
//
//        String[] cb2Str = { "Choose tour type first!" };
//        cb2 = createComboBox(cb2Str, 580, 150);
//        cb2.setEnabled(false);
//        backgroundLabel.add(cb2);
//
//        // Person
//        JLabel personLabel = createLabel("Person", 430, 200, f4);
//        backgroundLabel.add(personLabel);
//
//        String[] cb3Str = { "Total person number...", "1", "2", "3", "4", "5" };
//        cb3 = createComboBox(cb3Str, 580, 210);
//        backgroundLabel.add(cb3);
//
//        // Days
//        JLabel daysLabel = createLabel("Total Days", 430, 300, f4);
//        backgroundLabel.add(daysLabel);
//
//        String[] cb4Str = { "Number of days...", "1", "2", "3", "4", "5", "6", "7" };
//        cb4 = createComboBox(cb4Str, 580, 310);
//        backgroundLabel.add(cb4);
//
//        // Hotel
//        JLabel hotelLabel = createLabel("Hotel Type", 430, 400, f4);
//        backgroundLabel.add(hotelLabel);
//
//        String[] cb5Str = { "Select tour type first!" };
//        cb5 = createComboBox(cb5Str, 580, 410);
//        cb5.setEnabled(false);
//        backgroundLabel.add(cb5);
//
//        // Travel By
//        JLabel travelByLabel = createLabel("Travel By", 430, 500, f4);
//        backgroundLabel.add(travelByLabel);
//
//        String[] cb6Str = { "Select tour type first!" };
//        cb6 = createComboBox(cb6Str, 580, 510);
//        cb6.setEnabled(false);
//        backgroundLabel.add(cb6);
//
//        // Vehicle Type
//        JLabel vehicleLabel = createLabel("Vehicle Type", 430, 600, f4);
//        backgroundLabel.add(vehicleLabel);
//
//        String[] cb7Str = { "Select vehicle first!" };
//        cb7 = createComboBox(cb7Str, 580, 610);
//        cb7.setEnabled(false);
//        backgroundLabel.add(cb7);
//
//        // Total Cost Label
//        totalCostLabel = createLabel("Total Cost: $0", 450, 650, f3);
//        backgroundLabel.add(totalCostLabel);
//
//        // JButtons
//        btn1 = createButton("Exit", 58, 740, "#C00000", e -> System.exit(0));
//        backgroundLabel.add(btn1);
//
//        btn2 = createButton("Back", 387, 740, "#2E75B6", e -> {
//            Packs frame = new Packs();
//            frame.setVisible(true);
//            setVisible(false);
//        });
//        backgroundLabel.add(btn2);
//
//        btn3 = createButton("Next", 1226, 740, "#2E75B6", e -> {
//            totalCost = calculateCost(); // Calculate and update the total cost
//            
//            // Update the label to display the total cost
//            totalCostLabel.setText("Total Cost: $" + totalCost);
//            
//            // Display a dialog box showing the total cost
//            JOptionPane.showMessageDialog(this, "Total Cost is: $" + totalCost, "Total Cost", JOptionPane.INFORMATION_MESSAGE);
//            
//            // Check if total cost is non-zero before proceeding
//            if (totalCost != 0) { 
//                setVisible(false);
//                Payment frame = new Payment();
//                frame.setVisible(true);
//            } else {
//                // Warn if no package is selected
//                JOptionPane.showMessageDialog(this, "Please select a package before proceeding!", "Warning!", JOptionPane.WARNING_MESSAGE);
//            }
//        });
//        backgroundLabel.add(btn3);
//
//
//
//        btn4 = createButton("Reset", 784, 740, "#2E75B6", e -> resetForm());
//        backgroundLabel.add(btn4);
//
//        cb1.addActionListener(ae -> handleTourTypeSelection());
//
//        // Populate cb2 based on initial selection
//        
//        cb2.addActionListener(ae -> {
//            if (cb1.getSelectedIndex() == 1 || cb1.getSelectedIndex() == 2) {
//                cb5.setEnabled(true);
//                cb6.setEnabled(true);
//            }
//        });
//
//        // Populate cb7 based on initial selection
//        cb6.addActionListener(ae -> cb7.setEnabled(cb6.getSelectedIndex() != 0));
//    }
//
//    private JLabel createLabel(String text, int x, int y, Font font) {
//        JLabel label = new JLabel(text);
//        label.setBounds(x, y, 500, 50);
//        label.setFont(font);
//        label.setForeground(Color.WHITE);
//        return label;
//    }
//
//    private JComboBox<String> createComboBox(String[] items, int x, int y) {
//        JComboBox<String> comboBox = new JComboBox<>(items);
//        comboBox.setBounds(x, y, 250, 30);
//        comboBox.setFont(f5);
//        comboBox.setBackground(Color.WHITE);
//        return comboBox;
//    }
//
//    private JButton createButton(String text, int x, int y, String colorHex, ActionListener action) {
//        JButton button = new JButton(text);
//        button.setBounds(x, y, 183, 50);
//        button.setFont(f2);
//        button.setCursor(cursor);
//        button.setForeground(Color.WHITE);
//        button.setBackground(Color.decode(colorHex));
//        button.addActionListener(action);
//        return button;
//    }
//
//    private void handleTourTypeSelection() {
//        int s = cb1.getSelectedIndex();
//        cb2.removeAllItems();
//        if (s == 1) {
//            label0.setText("State");
//            cb2.addItem("Select State...");
//            cb2.addItem("Tamil Nadu");
//            cb2.addItem("Goa");
//            cb2.addItem("Shillong");
//            cb2.addItem("Andaman & Nicobar");
//            cb2.addItem("Kerala");
//            cb2.setEnabled(true);
//            configureForDomestic();
//        } else if (s == 2) {
//            label0.setText("Country");
//            cb2.addItem("Select Country...");
//            cb2.addItem("United States");
//            cb2.addItem("United Kingdom");
//            cb2.addItem("Thailand");
//            cb2.addItem("Japan");
//            cb2.addItem("South Korea");
//            cb2.setEnabled(true);
//            configureForInternational();
//        }
//    }
//
//    private void configureForDomestic() {
//        cb5.removeAllItems();
//        cb5.addItem("Hotel Type...");
//        cb5.addItem("Luxury");
//        cb5.addItem("Budget");
//        cb5.addItem("Standard");
//        cb5.setEnabled(true);
//
//        cb6.removeAllItems();
//        cb6.addItem("Travel By...");
//        cb6.addItem("Train");
//        cb6.addItem("Bus");
//        cb6.addItem("Flight");
//        cb6.setEnabled(true);
//
//        cb7.removeAllItems();
//        cb7.addItem("Vehicle Type...");
//        cb7.addItem("Car");
//        cb7.addItem("Bike");
//        cb7.setEnabled(true);
//    }
//
//    private void configureForInternational() {
//        cb5.removeAllItems();
//        cb5.addItem("Hotel Type...");
//        cb5.addItem("Luxury");
//        cb5.addItem("Budget");
//        cb5.addItem("Standard");
//        cb5.setEnabled(true);
//
//        cb6.removeAllItems();
//        cb6.addItem("Travel By...");
//        cb6.addItem("Flight");
//        cb6.addItem("Cruise");
//        cb6.addItem("Bus");
//        cb6.setEnabled(true);
//
//        cb7.removeAllItems();
//        cb7.addItem("Vehicle Type...");
//        cb7.addItem("Luxury Car");
//        cb7.addItem("Economy Car");
//        cb7.setEnabled(true);
//    }
//
//    private void resetForm() {
//        cb1.setSelectedIndex(0);
//        cb2.setSelectedIndex(0);
//        cb3.setSelectedIndex(0);
//        cb4.setSelectedIndex(0);
//        cb5.setSelectedIndex(0);
//        cb6.setSelectedIndex(0);
//        cb7.setSelectedIndex(0);
//        totalCostLabel.setText("Total Cost: $0");
//        cb2.setEnabled(false);
//        cb5.setEnabled(false);
//        cb6.setEnabled(false);
//        cb7.setEnabled(false);
//    }
//
//    private double calculateCost() {
//        // Placeholder cost calculation logic; replace with actual logic
//        int persons = cb3.getSelectedIndex(); // Assuming the index correlates to the person count
//        int days = cb4.getSelectedIndex(); // Assuming the index correlates to the number of days
//
//        // Simple cost calculation example
//        double costPerPerson = 100; // Example cost
//        double costPerDay = 50; // Example cost per day
//        double hotelCost = 0;
//        double transportCost = 0;
//
//        // Assign costs based on selections (adjust logic as needed)
//        if (cb5.getSelectedIndex() == 1) hotelCost = 200; // Luxury
//        else if (cb5.getSelectedIndex() == 2) hotelCost = 100; // Budget
//        else if (cb5.getSelectedIndex() == 3) hotelCost = 150; // Standard
//
//        if (cb6.getSelectedIndex() == 1) transportCost = 300; // Flight
//        else if (cb6.getSelectedIndex() == 2) transportCost = 150; // Cruise
//        else if (cb6.getSelectedIndex() == 3) transportCost = 100; // Bus
//        
//        return (costPerPerson * persons) + (costPerDay * days) + hotelCost + transportCost;
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            new SelfChoosenPacks().setVisible(true);
//        });
//    }
//}
package TravelAgency;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SelfChoosenPacks extends JFrame {

    private JLabel label0, label1, totalCostLabel, backgroundLabel;
    private Font f1, f2, f3, f4, f5;
    private JComboBox<String> cb1, cb2, cb3, cb4, cb5, cb6, cb7;
    private JButton btn1, btn2, btn3, btn4;
    private Cursor cursor;
    private double totalCost = 0;

    SelfChoosenPacks() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Agency - Registration by admin");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        ImageIcon bgImage = new ImageIcon(getClass().getResource("/Admin.jpg"));
        backgroundLabel = new JLabel(new ImageIcon(bgImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));
        backgroundLabel.setBounds(0, 0, 1536, 864);
        add(backgroundLabel);

        f1 = new Font("Segoe UI Black", Font.PLAIN, 35);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI Semibold", Font.PLAIN, 35);
        f4 = new Font("Segoe UI", Font.PLAIN, 25);
        f5 = new Font("Segoe UI", Font.PLAIN, 19);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        label1 = createLabel("Select Tour Details", 482, 24, f1);
        backgroundLabel.add(label1);

        JLabel tourTypeLabel = createLabel("Tour Type", 430, 75, f4);
        backgroundLabel.add(tourTypeLabel);

        String[] cb1Str = { "Choose tour type...", "Domestic", "International" };
        cb1 = createComboBox(cb1Str, 580, 84);
        backgroundLabel.add(cb1);

        label0 = createLabel("Destination", 430, 140, f4);
        backgroundLabel.add(label0);

        String[] cb2Str = { "Choose tour type first!" };
        cb2 = createComboBox(cb2Str, 580, 150);
        cb2.setEnabled(false);
        backgroundLabel.add(cb2);

        JLabel personLabel = createLabel("Person", 430, 200, f4);
        backgroundLabel.add(personLabel);

        String[] cb3Str = { "Total person number...", "1", "2", "3", "4", "5" };
        cb3 = createComboBox(cb3Str, 580, 210);
        backgroundLabel.add(cb3);

        JLabel daysLabel = createLabel("Total Days", 430, 300, f4);
        backgroundLabel.add(daysLabel);

        String[] cb4Str = { "Number of days...", "1", "2", "3", "4", "5", "6", "7" };
        cb4 = createComboBox(cb4Str, 580, 310);
        backgroundLabel.add(cb4);

        JLabel hotelLabel = createLabel("Hotel Type", 430, 400, f4);
        backgroundLabel.add(hotelLabel);

        String[] cb5Str = { "Select tour type first!" };
        cb5 = createComboBox(cb5Str, 580, 410);
        cb5.setEnabled(false);
        backgroundLabel.add(cb5);

        JLabel travelByLabel = createLabel("Travel By", 430, 500, f4);
        backgroundLabel.add(travelByLabel);

        String[] cb6Str = { "Select tour type first!" };
        cb6 = createComboBox(cb6Str, 580, 510);
        cb6.setEnabled(false);
        backgroundLabel.add(cb6);

        JLabel vehicleLabel = createLabel("Vehicle Type", 430, 600, f4);
        backgroundLabel.add(vehicleLabel);

        String[] cb7Str = { "Select vehicle first!" };
        cb7 = createComboBox(cb7Str, 580, 610);
        cb7.setEnabled(false);
        backgroundLabel.add(cb7);

        totalCostLabel = createLabel("Total Cost: $0", 450, 650, f3);
        backgroundLabel.add(totalCostLabel);

        btn1 = createButton("Exit", 58, 740, "#C00000", e -> System.exit(0));
        backgroundLabel.add(btn1);

        btn2 = createButton("Back", 387, 740, "#2E75B6", e -> {
            Packs frame = new Packs();
            frame.setVisible(true);
            setVisible(false);
        });
        backgroundLabel.add(btn2);

        btn3 = createButton("Next", 1226, 740, "#2E75B6", e -> {
            totalCost = calculateCost();
            totalCostLabel.setText("Total Cost: $" + totalCost);
            JOptionPane.showMessageDialog(this, "Total Cost is: $" + totalCost, "Total Cost", JOptionPane.INFORMATION_MESSAGE);

            if (totalCost != 0) {
                setVisible(false);
                Payment frame = new Payment();
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a package before proceeding!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        });
        backgroundLabel.add(btn3);

        btn4 = createButton("Reset", 784, 740, "#2E75B6", e -> resetForm());
        backgroundLabel.add(btn4);

        cb1.addActionListener(ae -> handleTourTypeSelection());

        cb2.addActionListener(ae -> {
            if (cb1.getSelectedIndex() == 1 || cb1.getSelectedIndex() == 2) {
                cb5.setEnabled(true);
                cb6.setEnabled(true);
            }
        });

        cb6.addActionListener(ae -> cb7.setEnabled(cb6.getSelectedIndex() != 0));
    }

    private JLabel createLabel(String text, int x, int y, Font font) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 500, 50);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        return label;
    }

    private JComboBox<String> createComboBox(String[] items, int x, int y) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBounds(x, y, 250, 30);
        comboBox.setFont(f5);
        comboBox.setBackground(Color.WHITE);
        return comboBox;
    }

    private JButton createButton(String text, int x, int y, String colorHex, ActionListener action) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 183, 50);
        button.setFont(f2);
        button.setCursor(cursor);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode(colorHex));
        button.addActionListener(action);
        return button;
    }

    private void handleTourTypeSelection() {
        int s = cb1.getSelectedIndex();
        cb2.removeAllItems();
        if (s == 1) {
            label0.setText("State");
            cb2.addItem("Select State...");
            cb2.addItem("Tamil Nadu");
            cb2.addItem("Goa");
            cb2.addItem("Shillong");
            cb2.addItem("Andaman & Nicobar");
            cb2.addItem("Kerala");
            cb2.setEnabled(true);
            configureForDomestic();
        } else if (s == 2) {
            label0.setText("Country");
            cb2.addItem("Select Country...");
            cb2.addItem("United States");
            cb2.addItem("United Kingdom");
            cb2.addItem("Thailand");
            cb2.addItem("Japan");
            cb2.addItem("South Korea");
            cb2.setEnabled(true);
            configureForInternational();
        }
    }

    private void configureForDomestic() {
        cb5.removeAllItems();
        cb5.addItem("Hotel Type...");
        cb5.addItem("Luxury");
        cb5.addItem("Budget");
        cb5.addItem("Standard");
        cb5.setEnabled(true);

        cb6.removeAllItems();
        cb6.addItem("Travel By...");
        cb6.addItem("Train");
        cb6.addItem("Bus");
        cb6.addItem("Flight");
        cb6.setEnabled(true);

        cb7.removeAllItems();
        cb7.addItem("Vehicle Type...");
        cb7.addItem("Car");
        cb7.addItem("Bike");
        cb7.setEnabled(true);
    }

    private void configureForInternational() {
        cb5.removeAllItems();
        cb5.addItem("Hotel Type...");
        cb5.addItem("Luxury");
        cb5.addItem("Budget");
        cb5.addItem("Standard");
        cb5.setEnabled(true);

        cb6.removeAllItems();
        cb6.addItem("Travel By...");
        cb6.addItem("Flight");
        cb6.addItem("Cruise");
        cb6.addItem("Bus");
        cb6.setEnabled(true);

        cb7.removeAllItems();
        cb7.addItem("Vehicle Type...");
        cb7.addItem("Luxury Car");
        cb7.addItem("Economy Car");
        cb7.setEnabled(true);
    }

    private void resetForm() {
        cb1.setSelectedIndex(0);
        cb2.setSelectedIndex(0);
        cb3.setSelectedIndex(0);
        cb4.setSelectedIndex(0);
        cb5.setSelectedIndex(0);
        cb6.setSelectedIndex(0);
        cb7.setSelectedIndex(0);
        totalCost = 0;
        totalCostLabel.setText("Total Cost: $" + totalCost);
    }

    private double calculateCost() {
        int tourType = cb1.getSelectedIndex();
        int destination = cb2.getSelectedIndex();
        int person = cb3.getSelectedIndex();
        int days = cb4.getSelectedIndex();
        int hotel = cb5.getSelectedIndex();
        int travelBy = cb6.getSelectedIndex();
        int vehicle = cb7.getSelectedIndex();

        if (tourType > 0 && destination > 0 && person > 0 && days > 0 && hotel > 0 && travelBy > 0 && vehicle > 0) {
            totalCost = (person * days * 5000) + (hotel * 10000) + (travelBy * 8000) + (vehicle * 2000);
        } else {
            totalCost = 0;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SelfChoosenPacks().setVisible(true));
    }
}