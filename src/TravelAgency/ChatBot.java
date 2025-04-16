package TravelAgency;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

class Chatbot extends JFrame {
    private JComboBox<String> topicSelector;
    private JPanel questionPanel, radioPanel;
    private JTextArea feedbackArea;
    private JButton submitButton;
    private JLabel questionLabel, subQuestionLabel;
    private JRadioButton option1, option2, option3, otherOption;
    private ButtonGroup optionsGroup;
    private Packs packsFrame;
    private JFrame feedbackFrame; 
    private HashMap<String, String> solutionsMap;
    Chatbot(Packs packsFrame) {
        this.packsFrame = packsFrame;
        this.setTitle("Feedback Chatbot - TourMaster");
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                packsFrame.setEnabled(true);
                packsFrame.setVisible(true);
                if (feedbackFrame != null) {
                    feedbackFrame.dispose();
                }
                
                dispose(); // Close Chatbot frame
            }
        });

        String[] topics = { "Select a Topic", "Refund Issue", "Tour Details Inquiry", "Booking Problems", "Suggestions" };
        topicSelector = new JComboBox<>(topics);

        questionLabel = new JLabel("Please select a topic to start:");
        subQuestionLabel = new JLabel("");
        radioPanel = new JPanel(new GridLayout(0, 1));

        option1 = new JRadioButton();
        option2 = new JRadioButton();
        option3 = new JRadioButton();
        otherOption = new JRadioButton("Other (Specify below)");

        optionsGroup = new ButtonGroup();
        optionsGroup.add(option1);
        optionsGroup.add(option2);
        optionsGroup.add(option3);
        optionsGroup.add(otherOption);

        feedbackArea = new JTextArea(5, 30);
        feedbackArea.setLineWrap(true);
        feedbackArea.setWrapStyleWord(true);
        feedbackArea.setEnabled(false);
        JScrollPane feedbackScrollPane = new JScrollPane(feedbackArea);
        feedbackScrollPane.setVisible(false);

        submitButton = new JButton("Submit Feedback");
        submitButton.setEnabled(false);

        topicSelector.addActionListener(e -> updateSubQuestions());

        ActionListener radioListener = e -> {
            if (otherOption.isSelected()) {
                openOtherFeedbackFrame();
            } else if (optionsGroup.getSelection() != null) {
                submitButton.setEnabled(true);
            }
        };

        option1.addActionListener(radioListener);
        option2.addActionListener(radioListener);
        option3.addActionListener(radioListener);
        otherOption.addActionListener(radioListener);

        submitButton.addActionListener(e -> submitFeedback());

        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(questionLabel, BorderLayout.NORTH);
        topPanel.add(topicSelector, BorderLayout.CENTER);

        questionPanel = new JPanel(new BorderLayout());
        questionPanel.add(subQuestionLabel, BorderLayout.NORTH);
        questionPanel.add(radioPanel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(questionPanel, BorderLayout.CENTER);
        add(feedbackScrollPane, BorderLayout.SOUTH);
        add(submitButton, BorderLayout.PAGE_END);

        setupSolutions();
    }

    private void setupSolutions() {
        solutionsMap = new HashMap<>();
        solutionsMap.put("Delayed Refund", "Our refund process usually takes 7-10 business days. Please check with your bank if delayed.");
        solutionsMap.put("Incorrect Amount Refunded", "Please email your booking ID to support@tourmaster.com, and we will investigate further.");
        solutionsMap.put("Refund Not Processed", "It might be pending verification. Contact customer support if over 10 days.");
        solutionsMap.put("Tour Inclusions", "For tour inclusions, visit the details page of your chosen tour on our website.");
        solutionsMap.put("Departure Dates", "Check the 'Dates and Availability' section on our website or call our support for exact dates.");
        solutionsMap.put("Accommodation Details", "Accommodation info is available under the 'Stay Details' section of each tour package.");
        solutionsMap.put("Booking Confirmation Delay", "Confirmations can take up to 24 hours. Contact us if you do not receive it within that time.");
        solutionsMap.put("Incorrect Details in Booking", "Please go to 'My Bookings' to edit your booking details or contact support.");
        solutionsMap.put("Unable to Modify Booking", "Some tours have restrictions on modifications. Please check our terms or contact support.");
    }

    private void updateSubQuestions() {
        String selectedTopic = (String) topicSelector.getSelectedItem();
        subQuestionLabel.setText("Select the specific issue:");

        radioPanel.removeAll();
        feedbackArea.setEnabled(false);
        feedbackArea.setText("");
        feedbackArea.setVisible(false);
        submitButton.setEnabled(false);

        switch (selectedTopic) {
            case "Refund Issue":
                option1.setText("Delayed Refund");
                option2.setText("Incorrect Amount Refunded");
                option3.setText("Refund Not Processed");
                break;

            case "Tour Details Inquiry":
                option1.setText("Tour Inclusions");
                option2.setText("Departure Dates");
                option3.setText("Accommodation Details");
                break;

            case "Booking Problems":
                option1.setText("Booking Confirmation Delay");
                option2.setText("Incorrect Details in Booking");
                option3.setText("Unable to Modify Booking");
                break;

            case "Suggestions":
                subQuestionLabel.setText("Share your suggestions:");
                openOtherFeedbackFrame();
                return;

            default:
                feedbackArea.setEnabled(false);
                feedbackArea.setVisible(false);
                submitButton.setEnabled(false);
                feedbackArea.setText("");
                return;
        }

        radioPanel.add(option1);
        radioPanel.add(option2);
        radioPanel.add(option3);
        radioPanel.add(otherOption);
        optionsGroup.clearSelection();
        questionPanel.revalidate();
        questionPanel.repaint();
    }

    private void openOtherFeedbackFrame() {
        feedbackFrame = new JFrame("Other Feedback"); // Assign to feedbackFrame
        feedbackFrame.setSize(400, 300);
        feedbackFrame.setLocationRelativeTo(null);
        feedbackFrame.setResizable(false);

        JTextArea otherFeedbackArea = new JTextArea(10, 30);
        otherFeedbackArea.setLineWrap(true);
        otherFeedbackArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(otherFeedbackArea);

        JButton submitOtherButton = new JButton("Submit");
        submitOtherButton.addActionListener(e -> {
            String feedback = otherFeedbackArea.getText();
            JOptionPane.showMessageDialog(feedbackFrame, "Thank you for your feedback or suggestion:\n" + feedback);
            feedbackFrame.dispose();
            this.dispose();
            packsFrame.setEnabled(true);
            packsFrame.setVisible(true);
        });

        feedbackFrame.setLayout(new BorderLayout());
        feedbackFrame.add(new JLabel("Please specify your feedback or suggestions below:"), BorderLayout.NORTH);
        feedbackFrame.add(scrollPane, BorderLayout.CENTER);
        feedbackFrame.add(submitOtherButton, BorderLayout.SOUTH);

        feedbackFrame.setVisible(true);
    }

    private void submitFeedback() {
        String selectedTopic = (String) topicSelector.getSelectedItem();
        String specificIssue = "";

        if (option1.isSelected()) specificIssue = option1.getText();
        else if (option2.isSelected()) specificIssue = option2.getText();
        else if (option3.isSelected()) specificIssue = option3.getText();
        else if (otherOption.isSelected()) specificIssue = "Other: Please specify your feedback.";

        String solution = solutionsMap.getOrDefault(specificIssue, "Thank you for your feedback! Our team will review your input.");

        JOptionPane.showMessageDialog(this, "Feedback submitted for " + selectedTopic + ": " + specificIssue + "\n\n" + solution);

        topicSelector.setSelectedIndex(0);
        optionsGroup.clearSelection();
        feedbackArea.setText("");
        feedbackArea.setEnabled(false);
        feedbackArea.setVisible(false);
        submitButton.setEnabled(false);

        this.dispose();
        packsFrame.setEnabled(true);
        packsFrame.setVisible(true);
    }
}
