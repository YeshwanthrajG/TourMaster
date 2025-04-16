package TravelAgency;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;

public class Admin extends JFrame {
    private ImageIcon background;
    private JLabel label1, backgroundLabel;
    private Font titleFont = new Font("Arial Black", Font.BOLD, 50), buttonFont = new Font("Segoe UI Black", Font.PLAIN, 22);
    private Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);

    Admin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Agency");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        URL bgImageUrl = getClass().getResource("/Admin.jpg");
        if (bgImageUrl != null) {
            ImageIcon bgImage = new ImageIcon(bgImageUrl);
            Image scaledBg = bgImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
            background = new ImageIcon(scaledBg);
            backgroundLabel = new JLabel(background);
            backgroundLabel.setBounds(0, 0, 1536, 864);
            getContentPane().add(backgroundLabel);
        }

        label1 = new JLabel("Admin Panel");
        label1.setBounds(600, 85, 433, 50);
        label1.setFont(titleFont);
        label1.setForeground(Color.WHITE);
        backgroundLabel.add(label1);

        JButton btnUserData = createButton("User Data", 260, 250, 287, 88, "#2E75B6", 33);
        JButton btnBack = createButton("Back", 1000, 600, 333, 106, "#2E75B6", 33);
        JButton btnExit = createButton("Exit", 260, 600, 297, 106, "#C00000", 33);
        JButton btnAdminPassword = createButton("Admin Password", 1000, 250, 333, 100, "#2E75B6", 34);

        backgroundLabel.add(btnUserData);
        backgroundLabel.add(btnBack);
        backgroundLabel.add(btnExit);
        backgroundLabel.add(btnAdminPassword);

        btnUserData.addActionListener(e -> {
            setVisible(false);
            new UserData().setVisible(true);
        });

        btnExit.addActionListener(e -> System.exit(0));

        btnBack.addActionListener(e -> {
            setVisible(false);
            new Home().setVisible(true);
        });

        btnAdminPassword.addActionListener(e -> new AdminPassword().setVisible(true));
    }

    private JButton createButton(String text, int x, int y, int width, int height, String color, int fontSize) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Segoe UI Black", Font.PLAIN, fontSize));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode(color));
        button.setCursor(handCursor);
        return button;
    }

    public static void main(String[] args) {
        new Admin().setVisible(true);
    }
}
