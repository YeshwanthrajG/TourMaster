package TravelAgency;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;

public class AdminPassword extends JFrame {

    private JLabel titleLabel1, titleLabel2, nameLabel, passwordLabel, backgroundLabel;
    private Font titleFont, fieldFont, buttonFont;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton closeButton, changeButton;
    private Cursor handCursor;

    AdminPassword() {
        setTitle("Travel Agency - Change Admin Credentials");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        URL bgImageUrl = getClass().getResource("/Admin.jpg");
        if (bgImageUrl != null) {
            ImageIcon bgImage = new ImageIcon(bgImageUrl);
            Image bg = bgImage.getImage();
            Image scaledBg = bg.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
            backgroundLabel = new JLabel(new ImageIcon(scaledBg));
            backgroundLabel.setBounds(0, 0, 1536, 864);
            getContentPane().add(backgroundLabel);
            backgroundLabel.setLayout(null);
        }

        titleFont = new Font("Segoe UI Black", Font.BOLD, 48);
        fieldFont = new Font("Segoe UI", Font.PLAIN, 25);
        buttonFont = new Font("Segoe UI Black", Font.PLAIN, 25);

        titleLabel1 = createLabel("Change Admin Name", 0, 50, 1536, 60, titleFont, Color.WHITE, backgroundLabel);
        titleLabel2 = createLabel("And Password", 0, 130, 1536, 60, titleFont, Color.WHITE, backgroundLabel);

        nameLabel = createLabel("Name:", 450, 280, 200, 50, new Font("Segoe UI", Font.BOLD, 28), Color.WHITE, backgroundLabel);
        nameField = createTextField(660, 280, 350, 50, fieldFont, backgroundLabel);

        passwordLabel = createLabel("Password:", 450, 500, 200, 50, new Font("Segoe UI", Font.BOLD, 28), Color.WHITE, backgroundLabel);
        passwordField = createPasswordField(660, 500, 350, 50, fieldFont, backgroundLabel);

        handCursor = new Cursor(Cursor.HAND_CURSOR);

        closeButton = createButton("Close", 400, 700, 220, 60, "#C00000", handCursor, buttonFont, backgroundLabel);
        changeButton = createButton("Change", 850, 700, 220, 60, "#2E75B6", handCursor, buttonFont, backgroundLabel);

        closeButton.addActionListener(ae -> setVisible(false));
        changeButton.addActionListener(ae -> changeAdminCredentials());
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, Font font, Color color, Container container) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setBounds(x, y, width, height);
        label.setFont(font);
        label.setForeground(color);
        container.add(label);
        return label;
    }

    private JTextField createTextField(int x, int y, int width, int height, Font font, Container container) {
        JTextField field = new JTextField();
        field.setBounds(x, y, width, height);
        field.setFont(font);
        container.add(field);
        return field;
    }

    private JPasswordField createPasswordField(int x, int y, int width, int height, Font font, Container container) {
        JPasswordField field = new JPasswordField();
        field.setBounds(x, y, width, height);
        field.setFont(font);
        field.setEchoChar('*');
        container.add(field);
        return field;
    }

    private JButton createButton(String text, int x, int y, int width, int height, String colorHex, Cursor cursor, Font font, Container container) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(font);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode(colorHex));
        button.setCursor(cursor);
        container.add(button);
        return button;
    }

    private void changeAdminCredentials() {
        String adminName = nameField.getText().toLowerCase();
        String adminPassword = new String(passwordField.getPassword());

        if (adminName.isEmpty() || adminPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String adminFile = "./admin_data.txt";
        File oldFile = new File(adminFile);
        oldFile.delete();
        
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(adminFile, true)))) {
            pw.println("==========================================");
            pw.println("=== ###  Travel Agency Admin Data  ### ===");
            pw.println("==========================================");
            pw.println("Name : " + adminName);
            pw.println("Password : " + adminPassword);
            pw.println("==========================================");

            JOptionPane.showMessageDialog(null, "Admin Name and Password have been changed.", "Success!", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AdminPassword frame = new AdminPassword();
        frame.setVisible(true);
    }
}
