package TravelAgency;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Registration extends JFrame {
    private JLabel titleLabel, userNameLabel, emailLabel, passwordLabel, securityQLabel, answerLabel, captchaLabel;
    private JTextField userNameField, emailField, answerField, captchaField;
    private JPasswordField passwordField;
    private JComboBox<String> securityQComboBox;
    private JButton exitButton, backButton, resetButton, registerButton;
    private int captchaResult;

    public Registration() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Agency - User Registration");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        ImageIcon bgImage = new ImageIcon(getClass().getResource("/Admin.jpg"));
        JLabel backgroundLabel = new JLabel(new ImageIcon(bgImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));
        backgroundLabel.setBounds(0, 0, 1536, 864);
        add(backgroundLabel);

        titleLabel = new JLabel("Enter Your Information");
        titleLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 45));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(500, 50, 600, 50);
        backgroundLabel.add(titleLabel);

        userNameLabel = createLabel("User Name", 400, 150);
        backgroundLabel.add(userNameLabel);
        userNameField = createTextField(700, 150);
        backgroundLabel.add(userNameField);

        emailLabel = createLabel("Email", 400, 250);
        backgroundLabel.add(emailLabel);
        emailField = createTextField(700, 250);
        backgroundLabel.add(emailField);

        passwordLabel = createLabel("Password", 400, 350);
        backgroundLabel.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        passwordField.setBounds(700, 350, 400, 40);
        backgroundLabel.add(passwordField);

        securityQLabel = createLabel("Security Question", 400, 450);
        backgroundLabel.add(securityQLabel);
        securityQComboBox = new JComboBox<>(new String[]{"Choose a Security Question...", "Your dream job?", "Your favorite song?", "First pet's name?", "Your favorite hobby?"});
        securityQComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        securityQComboBox.setBounds(700, 450, 400, 40);
        backgroundLabel.add(securityQComboBox);

        answerLabel = createLabel("Answer", 400, 550);
        backgroundLabel.add(answerLabel);
        answerField = createTextField(700, 550);
        backgroundLabel.add(answerField);

        captchaLabel = createLabel("", 400, 650);
        captchaLabel.setForeground(Color.RED);
        setCaptcha();
        backgroundLabel.add(captchaLabel);
        captchaField = createTextField(700, 650);
        backgroundLabel.add(captchaField);

        exitButton = createButton("Exit", 340, 750, e -> System.exit(0));
        backgroundLabel.add(exitButton);
        backButton = createButton("Back", 540, 750, e -> new Home().setVisible(true));
        backgroundLabel.add(backButton);
        resetButton = createButton("Reset", 740, 750, e -> resetFields());
        backgroundLabel.add(resetButton);
        registerButton = createButton("Register", 940, 750, e -> registerUser());
        backgroundLabel.add(registerButton);
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 30));
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, 300, 40);
        return label;
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        textField.setBounds(x, y, 400, 40);
        return textField;
    }

    private JButton createButton(String text, int x, int y, ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode("#2E75B6"));
        button.setBounds(x, y, 180, 50);
        button.addActionListener(action);
        return button;
    }

    private void setCaptcha() {
        Random rand = new Random();
        int a = rand.nextInt(10), b = rand.nextInt(10);
        captchaResult = a + b;
        captchaLabel.setText("Captcha: " + a + " + " + b + " = ?");
    }

    private void resetFields() {
        userNameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        answerField.setText("");
        captchaField.setText("");
        securityQComboBox.setSelectedIndex(0);
        setCaptcha();
    }

    private void registerUser() {
        try {
            if (isFieldsValid()) {
                try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("user_data.txt", true)))) {
                    String formattedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy"));
                    pw.printf("User Name: %s%nEmail: %s%nPassword: %s%nSecurity Question: %s%nAnswer: %s%nDate & Time: %s%n===============================================%n",
                            userNameField.getText(), emailField.getText(), new String(passwordField.getPassword()),
                            securityQComboBox.getSelectedItem(), answerField.getText(), formattedDate);
                    JOptionPane.showMessageDialog(this, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    resetFields();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error saving data.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (RegistrationException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Validation Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private boolean isFieldsValid() throws RegistrationException {
        if (userNameField.getText().isEmpty() || emailField.getText().isEmpty() || passwordField.getPassword().length == 0
                || securityQComboBox.getSelectedIndex() == 0 || answerField.getText().isEmpty() || captchaField.getText().isEmpty()) {
            throw new RegistrationException("Please fill all fields.");
        }

        if (!emailField.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new RegistrationException("Invalid email format.");
        }

        if (userNameField.getText().length() < 3) {
            throw new RegistrationException("Username must be at least 3 characters long.");
        }

        if (!captchaField.getText().equals(String.valueOf(captchaResult))) {
            setCaptcha();
            throw new RegistrationException("Incorrect captcha.");
        }

        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Registration().setVisible(true));
    }
}

class RegistrationException extends Exception {
    public RegistrationException(String message) {
        super(message);
    }
}
