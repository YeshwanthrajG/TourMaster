package TravelAgency;
import javax.swing.*;
import java.awt.*;

public class DomesticGoa extends JFrame {
    private ImageIcon background;
    private JLabel label1, backgroundLabel, label3, label3_1, label3_2;
    private JButton exitButton, backButton, payButton;
    private JRadioButton pack1, pack2, pack3;
    private ButtonGroup radioButtonGroup;
    private int selected = 0;

    DomesticGoa() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Agency - Goa");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        ImageIcon bgImage = new ImageIcon(getClass().getResource("/Goa.jpg"));
        Image scaledBg = bgImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        background = new ImageIcon(scaledBg);
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        getContentPane().add(backgroundLabel);


        label1 = new JLabel("3 Packs Available for Goa Tour!");
        label1.setBounds(100, 34, 1324, 70);
        label1.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
        label1.setHorizontalAlignment(JLabel.CENTER);
        backgroundLabel.add(label1);

        JLabel label2 = new JLabel("Select One:");
        label2.setBounds(671, 97, 500, 50);
        label2.setFont(new Font("Segoe UI", Font.BOLD, 30));
        backgroundLabel.add(label2);

        pack1 = createRadioButton("Pack 1", 115, 200);
        label3 = createLabel("<html>* First Class<br>* 5 Star Beach Resort<br>* By Flight<br>* 6 Persons<br>* 7 Days<br>* Cost: ₹1,20,000</html>", 100, 260);
        pack2 = createRadioButton("Pack 2", 674, 200);
        label3_1 = createLabel("<html>* Second Class<br>* 4 Star Hotel<br>* By Train<br>* 4 Persons<br>* 5 Days<br>* Cost: ₹80,000</html>", 640, 260);
        pack3 = createRadioButton("Pack 3", 1145, 200);
        label3_2 = createLabel("<html>* Third Class<br>* 3 Star Hotel<br>* By Bus<br>* 2 Persons<br>* 3 Days<br>* Cost: ₹45,000</html>", 1110, 260);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(pack1);
        radioButtonGroup.add(pack2);
        radioButtonGroup.add(pack3);

        exitButton = createButton("Exit", 30, 650, Color.decode("#C00000"));
        backButton = createButton("Back", 1150, 650, Color.decode("#2E75B6"));
        payButton = createButton("Pay", 630, 650, Color.decode("#2E75B6"));

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

    private JRadioButton createRadioButton(String text, int x, int y) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setBounds(x, y, 168, 50);
        radioButton.setFont(new Font("Segoe UI", Font.BOLD, 42));
        radioButton.setBackground(Color.decode("#F2F2F2"));
        backgroundLabel.add(radioButton);
        return radioButton;
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, 412, 324);
        label.setFont(new Font("Segoe UI", Font.BOLD, 40));
        backgroundLabel.add(label);
        return label;
    }

    private JButton createButton(String text, int x, int y, Color bgColor) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 300, 70);
        button.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        backgroundLabel.add(button);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DomesticGoa frame = new DomesticGoa();
            frame.setVisible(true);
        });
    }
}
