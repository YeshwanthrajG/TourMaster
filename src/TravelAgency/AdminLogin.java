package TravelAgency;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AdminLogin extends JFrame {
    private JLabel titleLabel, nameLabel, passwordLabel, backgroundLabel;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton exitButton, backButton, loginButton;
    private Font titleFont, labelFont, fieldFont, buttonFont;

    AdminLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Agency - Admin Login");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ImageIcon bgImage = new ImageIcon(getClass().getResource("/Admin.jpg"));
        backgroundLabel = new JLabel(new ImageIcon(bgImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));
        backgroundLabel.setBounds(0, 0, 1536, 864);
        getContentPane().add(backgroundLabel);

        titleFont = new Font("Segoe UI Black", Font.BOLD, 48);
        labelFont = new Font("Segoe UI", Font.BOLD, 30);
        fieldFont = new Font("Segoe UI", Font.PLAIN, 22);
        buttonFont = new Font("Segoe UI Black", Font.PLAIN, 30);

        titleLabel = createLabel("Admin Login", titleFont, 600, 180, 500, 50, Color.WHITE);
        nameLabel = createLabel("User Name", labelFont, 450, 350, 200, 40, Color.WHITE);
        userNameField = createTextField(700, 350, 400, 40);
        passwordLabel = createLabel("Password", labelFont, 450, 450, 200, 40, Color.WHITE);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(700, 450, 400, 40);
        passwordField.setFont(fieldFont);
        backgroundLabel.add(passwordField);

        backButton = createButton("Back", 340, 650);
        backButton.addActionListener(ae -> {
            setVisible(false);
            new UserData().setVisible(true);
        });

        loginButton = createButton("Login", 600, 650);
        loginButton.addActionListener(this::loginAdmin);

        exitButton = createButton("Exit", 860, 650);
        exitButton.setBackground(Color.decode("#C00000"));
        exitButton.addActionListener(ae -> System.exit(0));
    }

    private JLabel createLabel(String text, Font font, int x, int y, int width, int height, Color color) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(font);
        label.setForeground(color);
        backgroundLabel.add(label);
        return label;
    }

    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setFont(fieldFont);
        backgroundLabel.add(textField);
        return textField;
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 250, 60);
        button.setFont(buttonFont);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode("#2E75B6"));
        backgroundLabel.add(button);
        return button;
    }

    private void loginAdmin(ActionEvent ae) {
        String adminName = userNameField.getText().toLowerCase();
        String password = new String(passwordField.getPassword());

        if (adminName.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("./admin_data.txt")))) {
            String line;
            boolean loginSuccessful = false;

            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("Name : " + adminName) && reader.readLine().trim().equals("Password : " + password)) {
                    JOptionPane.showMessageDialog(this, "Admin Login Successful.", "Travel Agency", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    new Admin().setVisible(true);
                    loginSuccessful = true;
                    break;
                }
            }

            if (!loginSuccessful) {
                JOptionPane.showMessageDialog(this, "Invalid Name or Password!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading admin data!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminLogin().setVisible(true));
    }
}
