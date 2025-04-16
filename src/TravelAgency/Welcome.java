package TravelAgency;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Welcome extends JFrame implements ActionListener {
    private ImageIcon background;
    private JLabel backgroundLabel, gmail, phno;
    private Font f1;
    private JButton btn1, btn2, btn3;

    Welcome() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(1536, 864);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        ImageIcon bgImage = new ImageIcon(getClass().getResource("/WelcomeBG.jpg"));
        Image scaledBg = bgImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        background = new ImageIcon(scaledBg);
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        getContentPane().add(backgroundLabel);

        f1 = new Font("Arial Black", Font.BOLD, 25);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        int buttonY = this.getHeight() - 150;
        int buttonHeight = 50;

        btn1 = new JButton("Exit");
        btn1.setBounds(100, buttonY, 200, buttonHeight);
        btn1.setFont(f1);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        backgroundLabel.add(btn1);

        gmail = new JLabel("Gmail :tourmaster134@gmail.com");
        gmail.setFont(f1);
        gmail.setForeground(Color.BLACK);
        gmail.setBounds(100, 30, 500, 50);
        backgroundLabel.add(gmail);

        btn2 = new JButton("Contribution");
        btn2.setBounds((this.getWidth() - 245) / 2 - 50, buttonY, 245, buttonHeight);
        btn2.setFont(f1);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        backgroundLabel.add(btn2);

        btn3 = new JButton("Next");
        btn3.setBounds(this.getWidth() - 300, buttonY, 200, buttonHeight);
        btn3.setFont(f1);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2E75B6"));
        backgroundLabel.add(btn3);

        phno = new JLabel("Contact no : 9876543210");
        phno.setFont(f1);
        phno.setForeground(Color.BLACK);
        phno.setBounds(this.getWidth() - 500, 30, 400, 50);
        backgroundLabel.add(phno);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn2) {
            try {
                new Contribution().setVisible(true);
            } catch (Exception ex) {
                System.err.println("Error opening Contribution frame: " + ex.getMessage());
            }
        } else if (e.getSource() == btn3) {
            setVisible(false);
            try {
                new Home().setVisible(true);
            } catch (Exception ex) {
                System.err.println("Error opening Home frame: " + ex.getMessage());
            }
        } else if (e.getSource() == btn1) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Welcome().setVisible(true);
    }
}
