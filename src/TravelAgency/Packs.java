package TravelAgency;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Packs extends JFrame {
    private ImageIcon background;
    private JLabel label1, backgroundLabel;
    private Font f1, f3;
    private JButton btn1, btn2, btn3, feedbackBtn;
    private Cursor cursor;
    private JRadioButton defPacks, selfChosenPacks;
    private ButtonGroup jButtonGroup;
    private int pack = 0;

    Packs() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(1536, 864);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);

        background = new ImageIcon(new ImageIcon(getClass().getResource("/Domestic.jpg")).getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        getContentPane().add(backgroundLabel);

        f1 = new Font("Segoe UI Black", Font.PLAIN, 40);
        f3 = new Font("Segoe UI Black", Font.PLAIN, 25);
        cursor = new Cursor(Cursor.HAND_CURSOR);

        label1 = new JLabel("Choose the Package Type");
        label1.setBounds(530, 90, 1000, 50);
        label1.setFont(f1);
        label1.setForeground(Color.WHITE);
        backgroundLabel.add(label1);

        defPacks = new JRadioButton("Default Packs");
        defPacks.setBounds(620, 200, 300, 50);
        defPacks.setFont(f3);
        defPacks.setCursor(cursor);
        backgroundLabel.add(defPacks);

        selfChosenPacks = new JRadioButton("Self-Chosen Packs");
        selfChosenPacks.setBounds(620, 400, 300, 50);
        selfChosenPacks.setFont(f3);
        selfChosenPacks.setCursor(cursor);
        backgroundLabel.add(selfChosenPacks);

        jButtonGroup = new ButtonGroup();
        jButtonGroup.add(defPacks);
        jButtonGroup.add(selfChosenPacks);

        btn1 = new JButton("Exit");
        btn1.setBounds(100, 600, 215, 50);
        btn1.setFont(f3);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        backgroundLabel.add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(830, 600, 215, 50);
        btn2.setFont(f3);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        backgroundLabel.add(btn2);

        btn3 = new JButton("Next");
        btn3.setBounds(1200, 600, 215, 50);
        btn3.setFont(f3);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2E75B6"));
        backgroundLabel.add(btn3);

        feedbackBtn = new JButton("Feedback");
        feedbackBtn.setBounds(500, 600, 215, 50);
        feedbackBtn.setFont(f3);
        feedbackBtn.setCursor(cursor);
        feedbackBtn.setForeground(Color.WHITE);
        feedbackBtn.setBackground(Color.decode("#2E75B6"));
        backgroundLabel.add(feedbackBtn);

        Handler handler = new Handler();
        defPacks.addActionListener(handler);
        selfChosenPacks.addActionListener(handler);

        btn1.addActionListener(e -> System.exit(0));
        btn2.addActionListener(e -> {
            setVisible(false);
            new Login().setVisible(true);
        });
        btn3.addActionListener(e -> {
            if (pack == 1) {
                setVisible(false);
                new DefPackTypes().setVisible(true);
            } else if (pack == 2) {
                setVisible(false);
                new SelfChoosenPacks().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "You forgot to select a package type!", "Warning!!!", JOptionPane.WARNING_MESSAGE);
            }
        });

        feedbackBtn.addActionListener(e -> openChatbot());
    }

    private void openChatbot() {
        Chatbot chatbot = new Chatbot(this);
        chatbot.setVisible(true);
        this.setEnabled(false);
    }

    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pack = e.getSource() == defPacks ? 1 : 2;
        }
    }

    public static void main(String[] args) {
        new Packs().setVisible(true);
    }
}
