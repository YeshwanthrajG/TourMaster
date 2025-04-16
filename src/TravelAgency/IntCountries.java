package TravelAgency;
import javax.swing.*;
import java.awt.*;

public class IntCountries extends JFrame {
    private JLabel label1, backgroundLabel;
    private Font f1, f3;
    private JButton btnExit, btnBack, btnNext;
    private Cursor cursor;
    private JRadioButton country1, country2, country3, country4, country5;
    private ButtonGroup buttonGroup;
    private int country = 0;

    IntCountries() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Agency");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        backgroundLabel = new JLabel(new ImageIcon(getScaledBackground()));
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);

        f1 = new Font("Segoe UI Black", Font.PLAIN, 45);
        f3 = new Font("Segoe UI Black", Font.PLAIN, 25);
        cursor = new Cursor(Cursor.HAND_CURSOR);

        label1 = new JLabel("Which Country Would You Like To Visit?", SwingConstants.CENTER);
        label1.setForeground(Color.WHITE);
        label1.setBounds(150, 29, 1166, 50);
        label1.setFont(f1);
        backgroundLabel.add(label1);

        country1 = createRadioButton("United States", 100, 1);
        country2 = createRadioButton("Thailand", 200, 2);
        country3 = createRadioButton("United Kingdom", 300, 3);
        country4 = createRadioButton("Japan", 400, 4);
        country5 = createRadioButton("South Korea", 500, 5);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(country1);
        buttonGroup.add(country2);
        buttonGroup.add(country3);
        buttonGroup.add(country4);
        buttonGroup.add(country5);

        btnExit = createButton("Exit", 80, 700, Color.decode("#C00000"));
        btnBack = createButton("Back", 650, 700, Color.decode("#2E75B6"));
        btnNext = createButton("Next", 1250, 700, Color.decode("#2E75B6"));

        btnExit.addActionListener(e -> System.exit(0));
        btnBack.addActionListener(e -> openFrame(new DefPackTypes()));
        btnNext.addActionListener(e -> handleNextAction());

        backgroundLabel.add(country1);
        backgroundLabel.add(country2);
        backgroundLabel.add(country3);
        backgroundLabel.add(country4);
        backgroundLabel.add(country5);
        backgroundLabel.add(btnExit);
        backgroundLabel.add(btnBack);
        backgroundLabel.add(btnNext);
    }

    private Image getScaledBackground() {
        ImageIcon bgImage = new ImageIcon(getClass().getResource("/DefPacks.jpg"));
        return bgImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
    }

    private JRadioButton createRadioButton(String text, int yPosition, int countryIndex) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setForeground(Color.WHITE);
        radioButton.setBounds(460, yPosition, 400, 50);
        radioButton.setFont(new Font("Segoe UI", Font.BOLD, 45));
        radioButton.setOpaque(false);
        radioButton.setCursor(cursor);
        radioButton.addActionListener(e -> country = countryIndex);
        return radioButton;
    }

    private JButton createButton(String text, int xPosition, int yPosition, Color bgColor) {
        JButton button = new JButton(text);
        button.setBounds(xPosition, yPosition, 215, 50);
        button.setFont(f3);
        button.setCursor(cursor);
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        return button;
    }

    private void handleNextAction() {
        switch (country) {
            case 1: openFrame(new InternationalUnitedStates()); break;
            case 2: openFrame(new InternationalThailand()); break;
            case 3: openFrame(new InternationalUnitedKingdom()); break;
            case 4: openFrame(new InternationalJapan()); break;
            case 5: openFrame(new InternationalSouthKorea()); break;
            default: JOptionPane.showMessageDialog(null, "Please select a country.", "Warning!!!", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void openFrame(JFrame frame) {
        setVisible(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new IntCountries().setVisible(true));
    }
}
