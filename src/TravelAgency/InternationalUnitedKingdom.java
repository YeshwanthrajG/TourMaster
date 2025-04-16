package TravelAgency;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class InternationalUnitedKingdom extends JFrame {
    private ImageIcon background;
    private JLabel label1, label2, label3,backgroundLabel;
    private Font f1, f3, f4, f5;
    private JButton btn1, btn2, btn3;
    private ButtonGroup radioButtonGroup;
    private JRadioButton pack1, pack2, pack3;
    private int selected = 0;

    InternationalUnitedKingdom() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency - United Kingdom");
        this.setSize(1536, 864);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.decode("#F2F2F2"));

        ImageIcon bgImage = new ImageIcon(getClass().getResource("/UnitedKingdom.jpg"));
        Image scaledBg = bgImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        background = new ImageIcon(scaledBg);
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        getContentPane().add(backgroundLabel);


        f1 = new Font("Segoe UI Black", Font.PLAIN, 50);
        f3 = new Font("Segoe UI", Font.BOLD, 42);
        f4 = new Font("Segoe UI", Font.BOLD, 40);
        f5 = new Font("Segoe UI Black", Font.PLAIN, 28);

        label1 = new JLabel("3 Packs Available for United Kingdom Tour!");
        label1.setBounds(100, 29, 1324, 70);
        label1.setFont(f1);
        label1.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(label1);

        label2 = new JLabel("Select One:");
        label2.setBounds(671, 97, 500, 50);
        label2.setFont(new Font("Segoe UI Bold", Font.BOLD, 40));
        getContentPane().add(label2);

        pack1 = new JRadioButton("Pack 1");
        pack1.setBounds(115, 200, 168, 50);
        pack1.setFont(f3);
        pack1.setForeground(Color.WHITE);
        pack1.setBackground(Color.decode("#1A1A1A"));
        getContentPane().add(pack1);
        
        label3 = new JLabel("<html>* First Class<br>* 5 Star Hotel<br>* By Airplane<br>* 5 Persons<br>* 7 Days<br>* Cost: £4500<html>");
        label3.setBounds(100, 260, 412, 324);
        label3.setFont(f4);
        label3.setForeground(Color.WHITE);
        getContentPane().add(label3);

        pack2 = new JRadioButton("Pack 2");
        pack2.setBounds(674, 200, 178, 50);
        pack2.setFont(f3);
        pack2.setForeground(Color.WHITE);
        pack2.setBackground(Color.decode("#1A1A1A"));
        getContentPane().add(pack2);

        label3 = new JLabel("<html>* Second Class<br>* 4 Star Hotel<br>* By Airplane<br>* 4 Persons<br>* 5 Days<br>* Cost: £3000<html>");
        label3.setBounds(640, 260, 412, 324);
        label3.setFont(f4);
        label3.setForeground(Color.WHITE);
        getContentPane().add(label3);

        pack3 = new JRadioButton("Pack 3");
        pack3.setBounds(1145, 200, 168, 50);
        pack3.setFont(f3);
        pack3.setForeground(Color.WHITE);
        pack3.setBackground(Color.decode("#1A1A1A"));
        getContentPane().add(pack3);

        label3 = new JLabel("<html>* Third Class<br>* 3 Star Hotel<br>* By Airplane<br>* 3 Persons<br>* 4 Days<br>* Cost: £2000<html>");
        label3.setBounds(1110, 260, 412, 324);
        label3.setFont(f4);
        label3.setForeground(Color.WHITE);
        getContentPane().add(label3);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(pack1);
        radioButtonGroup.add(pack2);
        radioButtonGroup.add(pack3);

        btn1 = new JButton("Exit");
        btn1.setBounds(30, 650, 300, 70);
        btn1.setFont(f5);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        getContentPane().add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(1150, 650, 300, 70);
        btn2.setFont(f5);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        getContentPane().add(btn2);

        btn3 = new JButton("Pay");
        btn3.setBounds(630, 650, 300, 70);
        btn3.setFont(f5);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2E75B6"));
        getContentPane().add(btn3);

        btn1.addActionListener(ae -> System.exit(0));
        
        btn2.addActionListener(ae -> {
            setVisible(false);
            IntCountries frame = new IntCountries();  
            frame.setVisible(true);
        });

        btn3.addActionListener(ae -> {
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

        getContentPane().add(backgroundLabel);
    }

    public static void main(String[] args) {
        InternationalUnitedKingdom frame = new InternationalUnitedKingdom();
        frame.setVisible(true);
    }
}
