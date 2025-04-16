package TravelAgency;
import javax.swing.*;
import java.awt.*;
public class DomPlaces extends JFrame {
    private ImageIcon background;
    private JLabel backgroundLabel, label1;
    private JButton btnExit, btnBack, btnNext;
    private JRadioButton place1, place2, place3, place4, place5;
    private ButtonGroup buttonGroup;
    private int place = 0;

    DomPlaces() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Agency");
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        ImageIcon bgImage = new ImageIcon(getClass().getResource("/Domestic.jpg"));
        Image scaledBg = bgImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        background = new ImageIcon(scaledBg);
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);

        label1 = new JLabel("Which Place Would You Like to Visit?");
        label1.setForeground(Color.WHITE);
        label1.setBounds(334, 31, 1004, 50);
        label1.setFont(new Font("Segoe UI Black", Font.PLAIN, 45));
        backgroundLabel.add(label1);

        place1 = createRadioButton("Tamil Nadu", 150, 1);
        place2 = createRadioButton("Goa", 250, 2);
        place3 = createRadioButton("Shillong", 350, 3);
        place4 = createRadioButton("Andaman & Nicobar", 450, 4);
        place5 = createRadioButton("Kerala", 550, 5);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(place1);
        buttonGroup.add(place2);
        buttonGroup.add(place3);
        buttonGroup.add(place4);
        buttonGroup.add(place5);

        btnExit = createButton("Exit", 90, 710, Color.decode("#C00000"));
        btnBack = createButton("Back", 650, 710, Color.decode("#2E75B6"));
        btnNext = createButton("Next", 1250, 710, Color.decode("#2E75B6"));

        btnExit.addActionListener(e -> System.exit(0));
        btnBack.addActionListener(e -> {
            setVisible(false);
            new DefPackTypes().setVisible(true);
        });
        btnNext.addActionListener(e -> handleNextAction());

        backgroundLabel.add(place1);
        backgroundLabel.add(place2);
        backgroundLabel.add(place3);
        backgroundLabel.add(place4);
        backgroundLabel.add(place5);
        backgroundLabel.add(btnExit);
        backgroundLabel.add(btnBack);
        backgroundLabel.add(btnNext);
    }

    private JRadioButton createRadioButton(String text, int yPosition, int placeIndex) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setForeground(Color.WHITE);
        radioButton.setBounds(565, yPosition, 600, 50);
        radioButton.setFont(new Font("Segoe UI Bold", Font.PLAIN, 35));
        radioButton.setOpaque(false);
        radioButton.addActionListener(e -> place = placeIndex); // Set place based on the index
        return radioButton;
    }

    private JButton createButton(String text, int xPosition, int yPosition, Color bgColor) {
        JButton button = new JButton(text);
        button.setBounds(xPosition, yPosition, 215, 50);
        button.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        return button;
    }

    private void handleNextAction() {
        switch (place) {
            case 1: openNextFrame(new DomesticTamilNadu()); break;
            case 2: openNextFrame(new DomesticGoa()); break;
            case 3: openNextFrame(new DomesticShillong()); break;
            case 4: openNextFrame(new DomesticAndamanNicobar()); break;
            case 5: openNextFrame(new DomesticKerala()); break;
            default: JOptionPane.showMessageDialog(null, "Please select a place.", "Warning!!!", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void openNextFrame(JFrame frame) {
        setVisible(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DomPlaces frame = new DomPlaces();
            frame.setVisible(true);
        });
    }
}
