package TravelAgency;
import javax.swing.*;
import java.awt.*;

public class InternationalJapan extends JFrame {

    private ImageIcon background;
    private JLabel label1, backgroundLabel, label3, label3_1, label3_2;
    private JButton exitButton, backButton, payButton;
    private Cursor cursor;
    private JRadioButton pack1, pack2, pack3;
    private ButtonGroup radioButtonGroup;
    private int selected = 0;

    InternationalJapan() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Agency - Japan");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        ImageIcon bgImage = new ImageIcon(getClass().getResource("/Japan.jpg"));
        Image img = bgImage.getImage();
        Image scaledImg = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        background = new ImageIcon(scaledImg);

        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);

        Font f1 = new Font("Segoe UI Black", Font.PLAIN, 50);
        Font f2 = new Font("Segoe UI", Font.BOLD, 30);
        Font f3 = new Font("Segoe UI", Font.BOLD, 42);
        Font f4 = new Font("Segoe UI", Font.BOLD, 40);
        Font f5 = new Font("Segoe UI Black", Font.PLAIN, 28);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        label1 = new JLabel("3 Packs Available for Japan Tour!");
        label1.setBounds(100, 34, 1324, 70);
        label1.setFont(f1);
        label1.setHorizontalAlignment(JLabel.CENTER);
        backgroundLabel.add(label1);

        JLabel label2 = new JLabel("Select One:");
        label2.setBounds(671, 97, 500, 50);
        label2.setFont(f2);
        backgroundLabel.add(label2);

        pack1 = createPackRadioButton("Pack 1", 115, 200, "<html>* First Class<br>* 5 Star Hotel<br>* By Airplane<br>* 6 Persons<br>* 10 Days<br>* Cost: ¥600,000</html>", f3, f4);
        pack2 = createPackRadioButton("Pack 2", 674, 200, "<html>* Second Class<br>* 4 Star Hotel<br>* By Airplane<br>* 4 Persons<br>* 7 Days<br>* Cost: ¥450,000</html>", f3, f4);
        pack3 = createPackRadioButton("Pack 3", 1145, 200, "<html>* Third Class<br>* 3 Star Hotel<br>* By Airplane<br>* 3 Persons<br>* 5 Days<br>* Cost: ¥300,000</html>", f3, f4);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(pack1);
        radioButtonGroup.add(pack2);
        radioButtonGroup.add(pack3);

        exitButton = createButton("Exit", 30, 650, f5, Color.decode("#C00000"));
        backButton = createButton("Back", 1150, 650, f5, Color.decode("#2E75B6"));
        payButton = createButton("Pay", 630, 650, f5, Color.decode("#2E75B6"));

        exitButton.addActionListener(e -> System.exit(0));
        backButton.addActionListener(e -> {
            setVisible(false);
            IntCountries frame = new IntCountries();
            frame.setVisible(true);
        });

        payButton.addActionListener(e -> {
            if (pack1.isSelected()) selected = 1;
            else if (pack2.isSelected()) selected = 2;
            else if (pack3.isSelected()) selected = 3;

            if (selected != 0) {
                setVisible(false);
                Payment frame = new Payment();
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a package before proceeding!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    private JRadioButton createPackRadioButton(String text, int x, int y, String description, Font font1, Font font2) {
        JRadioButton pack = new JRadioButton(text);
        pack.setBounds(x, y, 168, 50);
        pack.setFont(font1);
        pack.setBackground(Color.decode("#F2F2F2"));
        pack.setCursor(cursor);
        backgroundLabel.add(pack);

        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setBounds(x - 15, y + 60, 412, 324);
        descriptionLabel.setFont(font2);
        backgroundLabel.add(descriptionLabel);

        return pack;
    }

    private JButton createButton(String text, int x, int y, Font font, Color bgColor) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 300, 70);
        button.setFont(font);
        button.setCursor(cursor);
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        backgroundLabel.add(button);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InternationalJapan frame = new InternationalJapan();
            frame.setVisible(true);
        });
    }
}
