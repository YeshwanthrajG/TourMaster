package TravelAgency;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Contribution extends JFrame {

    private JLabel imgLabel, contributionImgLabel;
    private JButton okButton;

    Contribution() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Agency - Contribution");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        ImageIcon bgImage = new ImageIcon(getClass().getResource("/ContributionBG.jpg"));
        Image img = bgImage.getImage();
        Image scaledImg = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        imgLabel = new JLabel(new ImageIcon(scaledImg));
        imgLabel.setBounds(0, 0, scaledImg.getWidth(null), scaledImg.getHeight(null));
        getContentPane().add(imgLabel);
        
        ImageIcon contributionImage = new ImageIcon(getClass().getResource("/Contribution.png"));
        Image contribImg = contributionImage.getImage();
        Image scaledContribImg = contribImg.getScaledInstance(600, 700, Image.SCALE_SMOOTH);
        contributionImgLabel = new JLabel(new ImageIcon(scaledContribImg));
        contributionImgLabel.setBounds(475, 20, 600, 700);
        imgLabel.add(contributionImgLabel);

        Font f1 = new Font("Segoe UI Black", Font.BOLD, 25);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        okButton = new JButton("OK");
        okButton.setBounds(675, 750, 180, 50);
        okButton.setFont(f1);
        okButton.setCursor(cursor);
        okButton.setForeground(Color.WHITE);
        okButton.setBackground(Color.decode("#2E75B6"));
        add(okButton);

        okButton.addActionListener(ae -> setVisible(false));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Contribution frame = new Contribution();
            frame.setVisible(true);
        });
    }
}
