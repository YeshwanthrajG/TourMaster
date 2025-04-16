package TravelAgency;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DefPackTypes extends JFrame {

    private JButton exitButton, backButton, nextButton;
    private JRadioButton international, domestic;
    private ButtonGroup radioButtonGroup;
    private int defPack = 0;

    DefPackTypes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Agency - Choose Tour Plan");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        ImageIcon bgImage = new ImageIcon(getClass().getResource("/International.jpg"));
        Image img = bgImage.getImage();
        Image scaledImg = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImg));
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        add(backgroundLabel);

        JLabel label1 = new JLabel("Choose Tour Plan");
        label1.setBounds(510, 63, 691, 100);
        label1.setFont(new Font("Segoe UI Black", Font.PLAIN, 60));
        backgroundLabel.add(label1);

        international = new JRadioButton("International");
        international.setBounds(230, 169, 423, 139);
        international.setFont(new Font("Segoe UI Italic", Font.PLAIN, 50));
        international.setOpaque(false);
        backgroundLabel.add(international);

        domestic = new JRadioButton("Domestic");
        domestic.setBounds(1000, 169, 423, 139);
        domestic.setFont(new Font("Segoe UI Italic", Font.PLAIN, 50));
        domestic.setOpaque(false);
        backgroundLabel.add(domestic);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(international);
        radioButtonGroup.add(domestic);

        exitButton = new JButton("Exit");
        exitButton.setBounds(200, 728, 215, 50);
        exitButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 35));
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Color.decode("#C00000"));
        backgroundLabel.add(exitButton);

        backButton = new JButton("Back");
        backButton.setBounds(700, 728, 215, 50);
        backButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 35));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.decode("#2E75B6"));
        backgroundLabel.add(backButton);

        nextButton = new JButton("Next");
        nextButton.setBounds(1200, 730, 215, 50);
        nextButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 35));
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(Color.decode("#2E75B6"));
        backgroundLabel.add(nextButton);

        Handler handler = new Handler();
        international.addActionListener(handler);
        domestic.addActionListener(handler);
        exitButton.addActionListener(handler);
        backButton.addActionListener(handler);
        nextButton.addActionListener(handler);
    }

    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backButton) {
                new Packs().setVisible(true);
                setVisible(false);
            } else if (e.getSource() == nextButton) {
                if (defPack == 1) {
                    new IntCountries().setVisible(true);
                    setVisible(false);
                } else if (defPack == 2) {
                    new DomPlaces().setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a package type!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == exitButton) {
                System.exit(0);
            } else if (e.getSource() == international) {
                defPack = 1;
            } else if (e.getSource() == domestic) {
                defPack = 2;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DefPackTypes frame = new DefPackTypes();
            frame.setVisible(true);
        });
    }
}
