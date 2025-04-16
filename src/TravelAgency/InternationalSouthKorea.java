package TravelAgency;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InternationalSouthKorea extends JFrame {
    private ImageIcon background;
    private JLabel label1, backgroundLabel, label3, label3_1, label3_2;
    private JButton exitButton, backButton, payButton;
    private JRadioButton pack1, pack2, pack3;
    private ButtonGroup radioButtonGroup;
    private int selected = 0;

    InternationalSouthKorea() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Agency - South Korea");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        background = new ImageIcon(new ImageIcon(getClass().getResource("/South Korea.jpg")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);

        label1 = new JLabel("3 Packs Available for South Korea Tour!");
        label1.setBounds(83, 25, 1324, 70);
        label1.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
        label1.setHorizontalAlignment(JLabel.CENTER);
        backgroundLabel.add(label1);

        JLabel label2 = new JLabel("Select One:");
        label2.setBounds(678, 94, 500, 50);
        label2.setFont(new Font("Segoe UI", Font.BOLD, 30));
        backgroundLabel.add(label2);

        pack1 = new JRadioButton("Pack 1");
        pack1.setBounds(115, 200, 168, 50);
        pack1.setFont(new Font("Segoe UI", Font.BOLD, 42));
        backgroundLabel.add(pack1);
        label3 = new JLabel("<html>* First Class<br>* 5 Star Hotel<br>* By Airplane<br>* 6 Persons<br>* 10 Days<br>* Cost: ₩6,000,000</html>");
        label3.setForeground(Color.WHITE);
        label3.setBounds(100, 260, 412, 324);
        label3.setFont(new Font("Segoe UI", Font.BOLD, 40));
        backgroundLabel.add(label3);

        pack2 = new JRadioButton("Pack 2");
        pack2.setBounds(674, 200, 178, 50);
        pack2.setFont(new Font("Segoe UI", Font.BOLD, 42));
        backgroundLabel.add(pack2);
        label3_1 = new JLabel("<html>* Second Class<br>* 4 Star Hotel<br>* By Airplane<br>* 4 Persons<br>* 7 Days<br>* Cost: ₩4,500,000</html>");
        label3_1.setForeground(Color.WHITE);
        label3_1.setBounds(640, 260, 412, 324);
        label3_1.setFont(new Font("Segoe UI", Font.BOLD, 40));
        backgroundLabel.add(label3_1);

        pack3 = new JRadioButton("Pack 3");
        pack3.setBounds(1145, 200, 168, 50);
        pack3.setFont(new Font("Segoe UI", Font.BOLD, 42));
        backgroundLabel.add(pack3);
        label3_2 = new JLabel("<html>* Third Class<br>* 3 Star Hotel<br>* By Airplane<br>* 3 Persons<br>* 5 Days<br>* Cost: ₩3,000,000</html>");
        label3_2.setForeground(Color.WHITE);
        label3_2.setBounds(1110, 260, 412, 324);
        label3_2.setFont(new Font("Segoe UI", Font.BOLD, 40));
        backgroundLabel.add(label3_2);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(pack1);
        radioButtonGroup.add(pack2);
        radioButtonGroup.add(pack3);

        exitButton = new JButton("Exit");
        exitButton.setBounds(30, 650, 300, 70);
        exitButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Color.decode("#C00000"));
        backgroundLabel.add(exitButton);

        backButton = new JButton("Back");
        backButton.setBounds(1150, 650, 300, 70);
        backButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.decode("#2E75B6"));
        backgroundLabel.add(backButton);

        payButton = new JButton("Pay");
        payButton.setBounds(630, 650, 300, 70);
        payButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
        payButton.setForeground(Color.WHITE);
        payButton.setBackground(Color.decode("#2E75B6"));
        backgroundLabel.add(payButton);

        exitButton.addActionListener(e -> System.exit(0));

        backButton.addActionListener(e -> {
            setVisible(false);
            new IntCountries().setVisible(true);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InternationalSouthKorea().setVisible(true));
    }
}
