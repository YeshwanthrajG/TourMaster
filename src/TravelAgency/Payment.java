package TravelAgency;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class Payment extends JFrame {
    private ImageIcon icon, background;
    private JLabel titleLabel, nameOnCardLabel, cardNumberLabel, cvvCodeLabel, validOnLabel;
    private JLabel acceptLabel, cardDetailsLabel, imgLabel, backgroundLabel, travelDateLabel;
    private JTextField nameField, cardNumberField, validOnField;
    private JPasswordField cvvField;
    private JSpinner travelDateSpinner;
    private JButton exitButton, backButton, confirmButton;
    private Cursor handCursor;

    public Payment() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(1536, 864);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);

        ImageIcon bgImage = new ImageIcon(getClass().getResource("/Register.jpg"));
        Image scaledBg = bgImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        background = new ImageIcon(scaledBg);

        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        getContentPane().add(backgroundLabel);

        ImageIcon visaImage = new ImageIcon(getClass().getResource("/VisaCard.png"));
        imgLabel = new JLabel(visaImage);
        imgLabel.setBounds(630, 120, visaImage.getIconWidth(), visaImage.getIconHeight());
        backgroundLabel.add(imgLabel);

        ImageIcon masterCardImage = new ImageIcon(getClass().getResource("/MasterCard.png"));
        imgLabel = new JLabel(masterCardImage);
        imgLabel.setBounds(720, 120, masterCardImage.getIconWidth(), masterCardImage.getIconHeight());
        backgroundLabel.add(imgLabel);

        Font titleFont = new Font("Segoe UI Black", Font.PLAIN, 30);
        Font labelFont = new Font("Segoe UI Semibold", Font.PLAIN, 25);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 20);
        Font smallFont = new Font("Segoe UI", Font.PLAIN, 15);

        titleLabel = new JLabel("Complete Your Payment");
        titleLabel.setBounds(500, 20, 500, 50);
        titleLabel.setFont(titleFont);
        backgroundLabel.add(titleLabel);

        handCursor = new Cursor(Cursor.HAND_CURSOR);

        exitButton = createButton("Exit", 150, 700, handCursor, Color.WHITE, Color.decode("#C00000"), titleFont);
        backgroundLabel.add(exitButton);

        backButton = createButton("Back", 700, 700, handCursor, Color.WHITE, Color.decode("#2E75B6"), titleFont);
        backgroundLabel.add(backButton);

        confirmButton = createButton("Confirm Payment", 1150, 700, handCursor, Color.WHITE, Color.decode("#2E75B6"), titleFont);
        confirmButton.setBounds(1150, 700, 350, 50);
        backgroundLabel.add(confirmButton);

        travelDateLabel = new JLabel("Travel Date");
        travelDateLabel.setBounds(409, 480, 500, 50);
        travelDateLabel.setFont(fieldFont);
        backgroundLabel.add(travelDateLabel);

        travelDateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(travelDateSpinner, "yyyy-MM-dd");
        travelDateSpinner.setEditor(dateEditor);
        travelDateSpinner.setBounds(600, 493, 120, 30);
        travelDateSpinner.setFont(smallFont);
        backgroundLabel.add(travelDateSpinner);

        validOnLabel = new JLabel("Valid On");
        validOnLabel.setBounds(387, 536, 500, 50);
        validOnLabel.setFont(fieldFont);
        backgroundLabel.add(validOnLabel);

        validOnField = createTextField(541, 549, 90, 30, smallFont);
        backgroundLabel.add(validOnField);
        
        cvvCodeLabel = new JLabel("CVV Code");
        cvvCodeLabel.setBounds(672, 536, 500, 50);
        cvvCodeLabel.setFont(fieldFont);
        backgroundLabel.add(cvvCodeLabel);

        cvvField = new JPasswordField();
        cvvField.setBounds(776, 550, 80, 30);
        cvvField.setFont(smallFont);
        cvvField.setHorizontalAlignment(JPasswordField.CENTER);
        cvvField.setEchoChar('*');
        backgroundLabel.add(cvvField);

        cardNumberLabel = new JLabel("Card Number");
        cardNumberLabel.setBounds(409, 418, 500, 50);
        cardNumberLabel.setFont(fieldFont);
        backgroundLabel.add(cardNumberLabel);

        cardNumberField = createTextField(600, 431, 235, 30, smallFont);
        backgroundLabel.add(cardNumberField);

        nameOnCardLabel = new JLabel("Name On Card");
        nameOnCardLabel.setBounds(409, 358, 500, 50);
        nameOnCardLabel.setFont(fieldFont);
        backgroundLabel.add(nameOnCardLabel);

        nameField = createTextField(600, 371, 235, 30, smallFont);
        backgroundLabel.add(nameField);

        cardDetailsLabel = new JLabel("Card Details");
        cardDetailsLabel.setBounds(409, 235, 500, 50);
        cardDetailsLabel.setFont(labelFont);
        backgroundLabel.add(cardDetailsLabel);

        acceptLabel = new JLabel("We Accept Only");
        acceptLabel.setBounds(387, 116, 500, 50);
        acceptLabel.setFont(labelFont);
        backgroundLabel.add(acceptLabel);

        exitButton.addActionListener(e -> System.exit(0));
        confirmButton.addActionListener(e -> {
            try {
                validateFields();
                Date travelDate = (Date) travelDateSpinner.getValue();
                String ticketNumber = generateTicketNumber(); // Generate or retrieve a ticket number
                PaySuccess successFrame = new PaySuccess(travelDate.toString(), ticketNumber);
                successFrame.setVisible(true);
                this.dispose(); 
            } catch (InvalidYearException | InvalidCVVException | InvalidCardNumberException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private JButton createButton(String text, int x, int y, Cursor cursor, Color fgColor, Color bgColor, Font font) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 190, 50);
        button.setFont(font);
        button.setCursor(cursor);
        button.setForeground(fgColor);
        button.setBackground(bgColor);
        return button;
    }

    private JTextField createTextField(int x, int y, int width, int height, Font font) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setFont(font);
        textField.setHorizontalAlignment(JTextField.CENTER);
        return textField;
    }

    private boolean areFieldsEmpty(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private void validateFields() throws InvalidYearException, InvalidCVVException, InvalidCardNumberException {
        if (areFieldsEmpty(nameField, cardNumberField, validOnField, cvvField)) {
            throw new IllegalArgumentException("Please fill all of the fields.");
        }
        String validOnText = validOnField.getText();
        if (validOnText.length() != 4 || !validOnText.matches("\\d{4}")) {
            throw new InvalidYearException("Valid On must be a valid year (4 digits).");
        }
        String cvvText = new String(cvvField.getPassword());
        if (cvvText.length() != 3 || !cvvText.matches("\\d{3}")) {
            throw new InvalidCVVException("CVV must be a 3-digit number.");
        }
        String cardNumberText = cardNumberField.getText();
        if (cardNumberText.length() != 16 || !cardNumberText.matches("\\d{16}")) {
            throw new InvalidCardNumberException("Card number must be a 16-digit number.");
        }
    }

    private String generateTicketNumber() {
        return "TK" + System.currentTimeMillis();
    }
    class InvalidYearException extends Exception {
        public InvalidYearException(String message) {
            super(message);
        }
    }

    class InvalidCVVException extends Exception {
        public InvalidCVVException(String message) {
            super(message);
        }
    }

    class InvalidCardNumberException extends Exception {
        public InvalidCardNumberException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        Payment paymentFrame = new Payment();
        paymentFrame.setVisible(true);
    }
}
