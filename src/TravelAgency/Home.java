package TravelAgency;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
public class Home extends JFrame {

    private JLabel titleLabel1, titleLabel2;
    private Font titleFont, buttonFont;
    private JButton loginButton, registerButton, exitButton, adminLoginButton;
    private JPanel backgroundPanel;

    Home() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Agency");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);

        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                URL backgroundImageUrl = getClass().getResource("/User.jpg");
                if (backgroundImageUrl != null) {
                    ImageIcon backgroundImage = new ImageIcon(backgroundImageUrl);
                    g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        backgroundPanel.setLayout(null);
        getContentPane().add(backgroundPanel);

        titleFont = new Font("Segoe UI Black", Font.BOLD, 48);
        buttonFont = new Font("Segoe UI Black", Font.PLAIN, 25);

        titleLabel1 = new JLabel("Travel Anywhere", SwingConstants.CENTER);
        titleLabel1.setBounds(0, 170, 1536, 65);
        titleLabel1.setFont(titleFont);
        backgroundPanel.add(titleLabel1);

        titleLabel2 = new JLabel("In the World!", SwingConstants.CENTER);
        titleLabel2.setBounds(0, 300, 1536, 65);
        titleLabel2.setFont(titleFont);
        backgroundPanel.add(titleLabel2);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        loginButton = createButton("Login", 400, 450, cursor);
        registerButton = createButton("Register", 1000, 450, cursor);
        exitButton = createButton("Exit", 400, 600, cursor, Color.decode("#C00000"));
        adminLoginButton = createButton("Admin Login", 1000, 600, cursor);

        backgroundPanel.add(loginButton);
        backgroundPanel.add(registerButton);
        backgroundPanel.add(exitButton);
        backgroundPanel.add(adminLoginButton);

        loginButton.addActionListener(e -> openFrame(new Login()));
        registerButton.addActionListener(e -> openFrame(new Registration()));
        exitButton.addActionListener(e -> System.exit(0));
        adminLoginButton.addActionListener(e -> {
            openFrame(new AdminLogin());
            JOptionPane.showMessageDialog(null, "By default, Admin Name and Password is : 'ugesh 041105'", "Information!", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private JButton createButton(String text, int x, int y, Cursor cursor) {
        return createButton(text, x, y, cursor, Color.decode("#2E75B6"));
    }

    private JButton createButton(String text, int x, int y, Cursor cursor, Color bgColor) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 195, 50);
        button.setFont(buttonFont);
        button.setCursor(cursor);
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        return button;
    }

    private void openFrame(JFrame frame) {
        setVisible(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Home().setVisible(true));
    }
}
