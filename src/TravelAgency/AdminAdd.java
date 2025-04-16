package TravelAgency;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class AdminAdd extends JFrame {
    private JTextField adminNameField, answerField, captchaField;
    private JPasswordField passwordField;
    private JComboBox<String> securityQComboBox;
    private JLabel captchaLabel;
    private int captchaResult;

    public AdminAdd() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Agency - Registration by Admin");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        ImageIcon bgImage = new ImageIcon(getClass().getResource("/Admin.jpg"));
        JLabel backgroundLabel = new JLabel(new ImageIcon(bgImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));
        backgroundLabel.setBounds(0, 0, 1536, 864);
        add(backgroundLabel);

        Font titleFont = new Font("Segoe UI Black", Font.BOLD, 45);
        Font labelFont = new Font("Segoe UI", Font.BOLD, 30);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 22);
        Font buttonFont = new Font("Segoe UI Black", Font.PLAIN, 30);

        JLabel titleLabel = new JLabel("Enter user information");
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(500, 50, 600, 50);
        backgroundLabel.add(titleLabel);

        backgroundLabel.add(createLabel("Enter Name", labelFont, 400, 150));
        adminNameField = createTextField(fieldFont, 700, 150);
        backgroundLabel.add(adminNameField);

        backgroundLabel.add(createLabel("Password", labelFont, 400, 250));
        passwordField = new JPasswordField();
        passwordField.setFont(fieldFont);
        passwordField.setBounds(700, 250, 400, 40);
        backgroundLabel.add(passwordField);

        backgroundLabel.add(createLabel("Security Question", labelFont, 400, 350));
        securityQComboBox = new JComboBox<>(new String[]{"Choose a Security Question...", "Your childhood nickname?", "Your mother's maiden name?", "Your first car?", "Your favorite movie?"});
        securityQComboBox.setFont(fieldFont);
        securityQComboBox.setBounds(700, 350, 400, 40);
        backgroundLabel.add(securityQComboBox);

        backgroundLabel.add(createLabel("Answer", labelFont, 400, 450));
        answerField = createTextField(fieldFont, 700, 450);
        backgroundLabel.add(answerField);

        captchaLabel = new JLabel();
        captchaLabel.setFont(labelFont);
        captchaLabel.setForeground(Color.RED);
        captchaLabel.setBounds(400, 550, 300, 40);
        setCaptcha();
        backgroundLabel.add(captchaLabel);

        captchaField = createTextField(fieldFont, 700, 550);
        backgroundLabel.add(captchaField);

        backgroundLabel.add(createButton("Exit", buttonFont, 340, 750, e -> System.exit(0)));
        backgroundLabel.add(createButton("Back", buttonFont, 540, 750, e -> {
            setVisible(false);
            new AdminLogin().setVisible(true);
        }));
        backgroundLabel.add(createButton("Reset", buttonFont, 740, 750, e -> resetFields()));
        backgroundLabel.add(createButton("Register", buttonFont, 940, 750, e -> registerAdmin()));
    }

    private JLabel createLabel(String text, Font font, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, 200, 40);
        return label;
    }

    private JTextField createTextField(Font font, int x, int y) {
        JTextField field = new JTextField();
        field.setFont(font);
        field.setBounds(x, y, 400, 40);
        return field;
    }

    private JButton createButton(String text, Font font, int x, int y, ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode("#2E75B6"));
        button.setBounds(x, y, 150, 50);
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
        adminNameField.setText("");
        passwordField.setText("");
        answerField.setText("");
        captchaField.setText("");
        securityQComboBox.setSelectedIndex(0);
        setCaptcha();
    }

    private void registerAdmin() {
        if (isFieldsValid()) {
            try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("user_data.txt", true)))) {
                String formattedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy"));
                pw.printf("Admin Name: %s%nPassword: %s%nSecurity Question: %s%nAnswer: %s%nDate & Time: %s%n",
                        adminNameField.getText(), new String(passwordField.getPassword()),
                        securityQComboBox.getSelectedItem(), answerField.getText(), formattedDate);
                pw.println("===============================================");
                JOptionPane.showMessageDialog(this, "Admin Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                resetFields();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving admin data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean isFieldsValid() {
        if (adminNameField.getText().isEmpty() || passwordField.getPassword().length == 0
                || securityQComboBox.getSelectedIndex() == 0 || answerField.getText().isEmpty() || captchaField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!captchaField.getText().equals(String.valueOf(captchaResult))) {
            JOptionPane.showMessageDialog(this, "Incorrect captcha.", "Error", JOptionPane.ERROR_MESSAGE);
            setCaptcha();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminAdd().setVisible(true));
    }
}
