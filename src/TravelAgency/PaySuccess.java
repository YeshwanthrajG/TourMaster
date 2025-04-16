package TravelAgency;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PaySuccess extends JFrame {

    private JLabel titleLabel, travelDateLabel, ticketNumberLabel, subtitleLabel, happyTravelLabel, backgroundLabel;
    private Font titleFont, subtitleFont;
    private JButton finishButton, homeButton;
    private Cursor cursor;

    public PaySuccess(String travelDate, String ticketNumber) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(1536, 864);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        getContentPane().setLayout(null);


        ImageIcon bgImage = new ImageIcon(getClass().getResource("/PaySuccess.jpg"));
        backgroundLabel = new JLabel(new ImageIcon(bgImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));
        backgroundLabel.setBounds(0, 0, 1536, 864);
        getContentPane().add(backgroundLabel);

        titleFont = new Font("Segoe UI Black", Font.PLAIN, 35);
        subtitleFont = new Font("Segoe UI Black", Font.PLAIN, 25);

        int centerX = this.getWidth() / 2 - 250; 


        titleLabel = new JLabel("Your Payment Has Successfully Completed", SwingConstants.CENTER);
        titleLabel.setBounds(250, 80, 1000, 50);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.BLACK);
        backgroundLabel.add(titleLabel);

        happyTravelLabel = new JLabel("Happy Travel :)", SwingConstants.CENTER);
        happyTravelLabel.setBounds(centerX, 560, 500, 50);
        happyTravelLabel.setFont(titleFont);
        happyTravelLabel.setForeground(Color.BLACK);
        backgroundLabel.add(happyTravelLabel);

        travelDateLabel = new JLabel("Travel Date: " + travelDate, SwingConstants.CENTER);
        travelDateLabel.setBounds(centerX, 630, 500, 50);
        travelDateLabel.setFont(subtitleFont);
        travelDateLabel.setForeground(Color.BLACK);
        backgroundLabel.add(travelDateLabel);

        ticketNumberLabel = new JLabel("Ticket Number: " + ticketNumber, SwingConstants.CENTER);
        ticketNumberLabel.setBounds(centerX, 700, 500, 50);
        ticketNumberLabel.setFont(subtitleFont);
        ticketNumberLabel.setForeground(Color.BLACK);
        backgroundLabel.add(ticketNumberLabel);
        
        cursor = new Cursor(Cursor.HAND_CURSOR);

        finishButton = createButton("Finish", centerX + 60, 760, cursor);
        backgroundLabel.add(finishButton);

        homeButton = createButton("Home", centerX + 260, 760, cursor);
        backgroundLabel.add(homeButton);

        finishButton.addActionListener(e -> System.exit(0)); 
        homeButton.addActionListener(e -> {
            this.setVisible(false); 
            new Home().setVisible(true); 
        });
    }

    private JButton createButton(String text, int x, int y, Cursor cursor) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 150, 50);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        button.setCursor(cursor);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode("#2E75B6"));
        return button;
    }

    public static void main(String[] args) {
        PaySuccess frame = new PaySuccess("2024-12-30", "TK123456");
        frame.setVisible(true);
    }
}
