package TravelAgency;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class Login extends JFrame {
    private JLabel titleLabel, backgroundLabel, userLabel, passLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton exitButton, backButton, loginButton;
    private Font titleFont, buttonFont, labelFont, fieldFont;

    public Login() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency - Login");
        this.setSize(1536, 864);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);

        titleFont = new Font("Segoe UI Black", Font.BOLD, 60);
        buttonFont = new Font("Segoe UI Black", Font.PLAIN, 25);
        labelFont = new Font("Segoe UI", Font.BOLD, 33);
        fieldFont = new Font("Segoe UI", Font.PLAIN, 22);

        ImageIcon bgImage = new ImageIcon(getClass().getResource("/User.jpg"));
        Image scaledBg = bgImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon background = new ImageIcon(scaledBg);
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        getContentPane().add(backgroundLabel);

        titleLabel = new JLabel("User Login");
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(549, 160, 500, 90);
        backgroundLabel.add(titleLabel);

        userLabel = new JLabel("User Name");
        userLabel.setFont(labelFont);
        userLabel.setBounds(450, 302, 246, 50);
        backgroundLabel.add(userLabel);

        usernameField = new JTextField();
        usernameField.setFont(fieldFont);
        usernameField.setBounds(761, 314, 200, 35);
        backgroundLabel.add(usernameField);

        passLabel = new JLabel("Password");
        passLabel.setFont(labelFont);
        passLabel.setBounds(450, 444, 293, 50);
        backgroundLabel.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(fieldFont);
        passwordField.setBounds(761, 456, 200, 35);
        backgroundLabel.add(passwordField);

        exitButton = createButton("Exit", 30, 650, "#C00000", e -> System.exit(0));
        backgroundLabel.add(exitButton);

        backButton = createButton("Back", 630, 650, "#2E75B6", e -> {
            setVisible(false);
            new Home().setVisible(true);
        });
        backgroundLabel.add(backButton);

        loginButton = createButton("Login", 1150, 650, "#2E75B6", e -> loginUser());
        backgroundLabel.add(loginButton);
    }

    private JButton createButton(String text, int x, int y, String colorHex, ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(buttonFont);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode(colorHex));
        button.setBounds(x, y, 300, 70);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(action);
        return button;
    }

    private void loginUser() {
        String usernameInput = usernameField.getText().toLowerCase();
        String passwordInput = new String(passwordField.getPassword());

        if (usernameInput.isEmpty() || passwordInput.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all of the fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"))) {
            String line;
            boolean isAuthenticated = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("User Name: ")) {
                    String fileUsername = line.substring(11).trim();
                    String passwordLine = reader.readLine();
                    passwordLine = reader.readLine();

                    if (passwordLine != null && passwordLine.startsWith("Password: ")) {
                        String filePassword = passwordLine.substring(10).trim();

                        if (fileUsername.equalsIgnoreCase(usernameInput) && filePassword.equals(passwordInput)) {
                            isAuthenticated = true;
                            break;
                        }
                    }
                }
            }

            if (isAuthenticated) {
                JOptionPane.showMessageDialog(this, "Login Successful.", "Travel Agency", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                new Packs().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error accessing user data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
