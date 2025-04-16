package TravelAgency;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InternationalThailand extends JFrame {
    private ImageIcon icon, background;
    private JLabel label1, label2, label3;
    private JButton btn1, btn2, btn3;
    private Cursor cursor;
    private ButtonGroup radioButtonGroup;
    private JRadioButton pack1, pack2, pack3;
    private int selected = 0;

    InternationalThailand() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency - Thailand");
        this.setSize(1536, 864);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.decode("#F2F2F2"));

        icon = new ImageIcon("src/TravelAgency/images/Icon.png");
        this.setIconImage(icon.getImage());
        ImageIcon bgImage = new ImageIcon(getClass().getResource("/Thailand.jpg"));
        Image scaledBg = bgImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        background = new ImageIcon(scaledBg);
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());

        label1 = new JLabel("3 Packs Available for Thailand Tour!");
        label1.setBounds(115, 28, 1324, 70);
        label1.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
        label1.setForeground(Color.WHITE);
        label1.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(label1);

        label2 = new JLabel("Select One:");
        label2.setBounds(671, 97, 500, 50);
        label2.setFont(new Font("Segoe UI", Font.BOLD, 40));
        label2.setForeground(Color.WHITE);
        getContentPane().add(label2);

        pack1 = new JRadioButton("Pack 1");
        pack1.setBounds(115, 200, 168, 50);
        pack1.setFont(new Font("Segoe UI", Font.BOLD, 42));
        pack1.setForeground(Color.WHITE);
        pack1.setBackground(Color.decode("#1A1A1A"));
        pack1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        getContentPane().add(pack1);
        label3 = new JLabel("<html>* First Class<br>* 5 Star Hotel<br>* By Airplane<br>* 5 Persons<br>* 7 Days<br>* Cost: $3500<html>");
        label3.setBounds(100, 260, 412, 324);
        label3.setFont(new Font("Segoe UI", Font.BOLD, 40));
        label3.setForeground(Color.WHITE);
        getContentPane().add(label3);

        pack2 = new JRadioButton("Pack 2");
        pack2.setBounds(674, 200, 178, 50);
        pack2.setFont(new Font("Segoe UI", Font.BOLD, 42));
        pack2.setForeground(Color.WHITE);
        pack2.setBackground(Color.decode("#1A1A1A"));
        pack2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        getContentPane().add(pack2);
        label3 = new JLabel("<html>* Second Class<br>* 4 Star Hotel<br>* By Airplane<br>* 4 Persons<br>* 5 Days<br>* Cost: $2500<html>");
        label3.setBounds(640, 260, 412, 324);
        label3.setFont(new Font("Segoe UI", Font.BOLD, 40));
        label3.setForeground(Color.WHITE);
        getContentPane().add(label3);

        pack3 = new JRadioButton("Pack 3");
        pack3.setBounds(1145, 200, 168, 50);
        pack3.setFont(new Font("Segoe UI", Font.BOLD, 42));
        pack3.setForeground(Color.WHITE);
        pack3.setBackground(Color.decode("#1A1A1A"));
        pack3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        getContentPane().add(pack3);
        label3 = new JLabel("<html>* Third Class<br>* 3 Star Hotel<br>* By Bus<br>* 3 Persons<br>* 4 Days<br>* Cost: $1500<html>");
        label3.setBounds(1110, 260, 412, 324);
        label3.setFont(new Font("Segoe UI", Font.BOLD, 40));
        label3.setForeground(Color.WHITE);
        getContentPane().add(label3);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(pack1);
        radioButtonGroup.add(pack2);
        radioButtonGroup.add(pack3);

        btn1 = new JButton("Exit");
        btn1.setBounds(30, 650, 300, 70);
        btn1.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        getContentPane().add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(1150, 650, 300, 70);
        btn2.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
        btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        getContentPane().add(btn2);

        btn3 = new JButton("Pay");
        btn3.setBounds(630, 650, 300, 70);
        btn3.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
        btn3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2E75B6"));
        getContentPane().add(btn3);

        btn1.addActionListener(e -> System.exit(0));
        btn2.addActionListener(e -> {
            setVisible(false);
            new IntCountries().setVisible(true);
        });

        btn3.addActionListener(e -> {
            selected = pack1.isSelected() ? 1 : pack2.isSelected() ? 2 : pack3.isSelected() ? 3 : 0;
            if (selected != 0) {
                setVisible(false);
                new Payment().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a package before proceeding!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        });

        getContentPane().add(backgroundLabel);
    }

    public static void main(String[] args) {
        new InternationalThailand().setVisible(true);
    }
}
