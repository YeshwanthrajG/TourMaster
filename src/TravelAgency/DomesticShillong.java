package TravelAgency;
import javax.swing.*;
import java.awt.*;
public class DomesticShillong extends JFrame {

    private ImageIcon background;
    private JLabel label1, label2, label3, label3_1, label3_2, backgroundLabel;
    private Font f1, f2, f3, f4, f5;
    private JButton exitButton, backButton, payButton;
    private Cursor cursor;
    private JRadioButton pack1, pack2, pack3;
    private ButtonGroup radioButtonGroup;
    private int selected = 0;

    DomesticShillong() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Agency - Shillong");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        background = new ImageIcon(getClass().getResource("/Shillong.jpg"));
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);

        f1 = new Font("Segoe UI Black", Font.PLAIN, 50);
        f2 = new Font("Segoe UI", Font.BOLD, 30);
        f3 = new Font("Segoe UI", Font.BOLD, 42);
        f4 = new Font("Segoe UI", Font.BOLD, 40);
        f5 = new Font("Segoe UI Black", Font.PLAIN, 28);
        cursor = new Cursor(Cursor.HAND_CURSOR);

        label1 = new JLabel("3 Packs Available for Shillong Tour!");
        label1.setBounds(100, 34, 1324, 70);
        label1.setFont(f1);
        label1.setHorizontalAlignment(JLabel.CENTER);
        backgroundLabel.add(label1);

        label2 = new JLabel("Select One:");
        label2.setBounds(671, 97, 500, 50);
        label2.setFont(f2);
        backgroundLabel.add(label2);

        pack1 = new JRadioButton("Pack 1");
        pack1.setBounds(115, 200, 168, 50);
        pack1.setFont(f3);
        pack1.setBackground(Color.decode("#F2F2F2"));
        pack1.setCursor(cursor);
        backgroundLabel.add(pack1);
        label3 = new JLabel("<html>* First Class<br>* 5 Star Hotel<br>* By Flight<br>* 6 Persons<br>* 7 Days<br>* Cost: ₹90,000</html>");
        label3.setForeground(Color.WHITE);
        label3.setBounds(100, 260, 412, 324);
        label3.setFont(f4);
        backgroundLabel.add(label3);

        pack2 = new JRadioButton("Pack 2");
        pack2.setBounds(674, 200, 178, 50);
        pack2.setFont(f3);
        pack2.setBackground(Color.decode("#F2F2F2"));
        pack2.setCursor(cursor);
        backgroundLabel.add(pack2);
        label3_1 = new JLabel("<html>* Second Class<br>* 4 Star Hotel<br>* By Train<br>* 4 Persons<br>* 5 Days<br>* Cost: ₹60,000</html>");
        label3_1.setForeground(Color.WHITE);
        label3_1.setBounds(640, 260, 412, 324);
        label3_1.setFont(f4);
        backgroundLabel.add(label3_1);

        pack3 = new JRadioButton("Pack 3");
        pack3.setBounds(1145, 200, 168, 50);
        pack3.setFont(f3);
        pack3.setBackground(Color.decode("#F2F2F2"));
        pack3.setCursor(cursor);
        backgroundLabel.add(pack3);
        label3_2 = new JLabel("<html>* Third Class<br>* 3 Star Hotel<br>* By Bus<br>* 2 Persons<br>* 3 Days<br>* Cost: ₹30,000</html>");
        label3_2.setForeground(Color.WHITE);
        label3_2.setBounds(1110, 260, 412, 324);
        label3_2.setFont(f4);
        backgroundLabel.add(label3_2);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(pack1);
        radioButtonGroup.add(pack2);
        radioButtonGroup.add(pack3);

        exitButton = new JButton("Exit");
        exitButton.setBounds(30, 650, 300, 70);
        exitButton.setFont(f5);
        exitButton.setCursor(cursor);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Color.decode("#C00000"));
        backgroundLabel.add(exitButton);

        backButton = new JButton("Back");
        backButton.setBounds(1150, 650, 300, 70);
        backButton.setFont(f5);
        backButton.setCursor(cursor);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.decode("#2E75B6"));
        backgroundLabel.add(backButton);

        payButton = new JButton("Pay");
        payButton.setBounds(630, 650, 300, 70);
        payButton.setFont(f5);
        payButton.setCursor(cursor);
        payButton.setForeground(Color.WHITE);
        payButton.setBackground(Color.decode("#2E75B6"));
        backgroundLabel.add(payButton);

        exitButton.addActionListener(e -> System.exit(0));

        backButton.addActionListener(e -> {
            setVisible(false);
            new DomPlaces().setVisible(true);
        });

        payButton.addActionListener(e -> {
            selected = pack1.isSelected() ? 1 : pack2.isSelected() ? 2 : pack3.isSelected() ? 3 : 0;
            if (selected != 0) {
                setVisible(false);
                new Payment().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a package before proceeding!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DomesticShillong frame = new DomesticShillong();
            frame.setVisible(true);
        });
    }
}
