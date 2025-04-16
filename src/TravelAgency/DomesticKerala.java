package TravelAgency;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DomesticKerala extends JFrame {

    private ImageIcon background;
    private JLabel label1, backgroundLabel;
    private Font f1, f2, f3, f4, f5;
    private JButton exitButton, backButton, payButton;
    private Cursor cursor;
    private JRadioButton pack1, pack2, pack3;
    private ButtonGroup radioButtonGroup;
    private int selected = 0;

    DomesticKerala() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Agency - Kerala");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        setupBackground("/Kerala.jpg");
        setupFonts();
        setupCursor();
        setupTitle();
        setupPackOptions();
        setupButtons();
        setupActionListeners();
    }

    private void setupBackground(String imagePath) {
        ImageIcon bgImage = new ImageIcon(getClass().getResource(imagePath));
        Image img = bgImage.getImage();
        Image scaledImg = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        background = new ImageIcon(scaledImg);

        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(backgroundLabel);
    }

    private void setupFonts() {
        f1 = new Font("Segoe UI Black", Font.PLAIN, 50);
        f2 = new Font("Segoe UI", Font.BOLD, 30);
        f3 = new Font("Segoe UI", Font.BOLD, 42);
        f4 = new Font("Segoe UI", Font.BOLD, 40);
        f5 = new Font("Segoe UI Black", Font.PLAIN, 28);
    }

    private void setupCursor() {
        cursor = new Cursor(Cursor.HAND_CURSOR);
    }

    private void setupTitle() {
        label1 = new JLabel("3 Packs Available for Kerala Tour!");
        label1.setBounds(100, 34, 1324, 70);
        label1.setFont(f1);
        label1.setHorizontalAlignment(JLabel.CENTER);
        backgroundLabel.add(label1);
    }

    private void setupPackOptions() {
        pack1 = createPackOption("Pack 1", 115, 200, "<html>* First Class<br>* 5 Star Resort<br>* By Houseboat<br>* 2 Persons<br>* 6 Days<br>* Cost: ₹30,000</html>");
        pack2 = createPackOption("Pack 2", 674, 200, "<html>* Second Class<br>* 4 Star Hotel<br>* By Train<br>* 4 Persons<br>* 5 Days<br>* Cost: ₹20,000</html>");
        pack3 = createPackOption("Pack 3", 1145, 200, "<html>* Economy Class<br>* 3 Star Hotel<br>* By Bus<br>* 2 Persons<br>* 4 Days<br>* Cost: ₹15,000</html>");

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(pack1);
        radioButtonGroup.add(pack2);
        radioButtonGroup.add(pack3);
    }

    private JRadioButton createPackOption(String text, int x, int y, String description) {
        JRadioButton pack = new JRadioButton(text);
        pack.setBounds(x, y, 168, 50);
        pack.setFont(f3);
        pack.setBackground(Color.decode("#F2F2F2"));
        pack.setCursor(cursor);
        backgroundLabel.add(pack);
        
        JLabel label = new JLabel(description);
        label.setForeground(Color.WHITE);
        label.setBounds(x - 15, y + 60, 412, 324);
        label.setFont(f4);
        backgroundLabel.add(label);
        
        return pack;
    }

    private void setupButtons() {
        exitButton = createButton("Exit", 30, 650, "#C00000");
        backButton = createButton("Back", 1150, 650, "#2E75B6");
        payButton = createButton("Pay", 630, 650, "#2E75B6");

        backgroundLabel.add(exitButton);
        backgroundLabel.add(backButton);
        backgroundLabel.add(payButton);
    }

    private JButton createButton(String text, int x, int y, String color) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 300, 70);
        button.setFont(f5);
        button.setCursor(cursor);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode(color));
        return button;
    }

    private void setupActionListeners() {
        exitButton.addActionListener(e -> System.exit(0));
        
        backButton.addActionListener(e -> {
            setVisible(false);
            DomPlaces frame = new DomPlaces();
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DomesticKerala frame = new DomesticKerala();
            frame.setVisible(true);
        });
    }
}
