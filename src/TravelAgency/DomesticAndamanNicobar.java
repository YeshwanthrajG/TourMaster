package TravelAgency;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DomesticAndamanNicobar extends JFrame {

    private JButton exitButton, backButton, payButton;
    private JRadioButton pack1, pack2, pack3;
    private ButtonGroup radioButtonGroup;
    private int selected = 0;

    DomesticAndamanNicobar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Agency - Andaman & Nicobar");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        ImageIcon bgImage = new ImageIcon(getClass().getResource("/AndamanNicobar.jpg"));
        Image scaledImg = bgImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImg));
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(backgroundLabel);

        JLabel label1 = new JLabel("3 Packs Available for Andaman & Nicobar Tour!", JLabel.CENTER);
        label1.setBounds(100, 34, 1324, 70);
        label1.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
        backgroundLabel.add(label1);

        JLabel label2 = new JLabel("Select One:");
        label2.setBounds(671, 97, 500, 50);
        label2.setFont(new Font("Segoe UI", Font.BOLD, 30));
        backgroundLabel.add(label2);

        pack1 = createRadioButton("Pack 1", 115, 200, backgroundLabel);
        JLabel label3 = createPackageLabel("<html>* First Class<br>* 5 Star Resort<br>* By Flight<br>* 6 Persons<br>* 7 Days<br>* Cost: ₹1,50,000</html>", 100, 260, backgroundLabel);
        
        pack2 = createRadioButton("Pack 2", 674, 200, backgroundLabel);
        JLabel label3_1 = createPackageLabel("<html>* Second Class<br>* 4 Star Hotel<br>* By Ship<br>* 4 Persons<br>* 5 Days<br>* Cost: ₹90,000</html>", 640, 260, backgroundLabel);
        
        pack3 = createRadioButton("Pack 3", 1145, 200, backgroundLabel);
        JLabel label3_2 = createPackageLabel("<html>* Third Class<br>* 3 Star Hotel<br>* By Ship<br>* 2 Persons<br>* 3 Days<br>* Cost: ₹60,000</html>", 1110, 260, backgroundLabel);
        
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(pack1);
        radioButtonGroup.add(pack2);
        radioButtonGroup.add(pack3);

        exitButton = createButton("Exit", 30, 650, Color.decode("#C00000"), backgroundLabel);
        backButton = createButton("Back", 1150, 650, Color.decode("#2E75B6"), backgroundLabel);
        payButton = createButton("Pay", 630, 650, Color.decode("#2E75B6"), backgroundLabel);

        exitButton.addActionListener(e -> System.exit(0));
        backButton.addActionListener(e -> {
            setVisible(false);
            new DomPlaces().setVisible(true);
        });
        payButton.addActionListener(e -> {
            if (pack1.isSelected()) selected = 1;
            else if (pack2.isSelected()) selected = 2;
            else if (pack3.isSelected()) selected = 3;

            if (selected != 0) {
                setVisible(false);
                new Payment().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a package before proceeding!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    private JRadioButton createRadioButton(String text, int x, int y, Container container) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setBounds(x, y, 168, 50);
        radioButton.setFont(new Font("Segoe UI", Font.BOLD, 42));
        radioButton.setBackground(Color.decode("#F2F2F2"));
        container.add(radioButton);
        return radioButton;
    }

    private JLabel createPackageLabel(String text, int x, int y, Container container) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, 412, 324);
        label.setFont(new Font("Segoe UI", Font.BOLD, 40));
        container.add(label);
        return label;
    }

    private JButton createButton(String text, int x, int y, Color bgColor, Container container) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 300, 70);
        button.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        container.add(button);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DomesticAndamanNicobar frame = new DomesticAndamanNicobar();
            frame.setVisible(true);
        });
    }
}
