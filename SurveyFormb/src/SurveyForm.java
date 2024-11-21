package survey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SurveyForm extends JFrame {
    public SurveyForm() {
        // Set up the frame
        setTitle("Survey Form");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for form elements
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel, BorderLayout.CENTER);

        // Name field
        panel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        panel.add(nameField);

        // Gender selection
        panel.add(new JLabel("Gender:"));
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        JRadioButton otherButton = new JRadioButton("Other");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        genderPanel.add(otherButton);
        panel.add(genderPanel);

        // Feedback field
        panel.add(new JLabel("Feedback:"));
        JTextArea feedbackArea = new JTextArea(5, 30);
        JScrollPane scrollPane = new JScrollPane(feedbackArea);
        panel.add(scrollPane);

        // Interests
        panel.add(new JLabel("Interests:"));
        JCheckBox codingCheckBox = new JCheckBox("Coding");
        JCheckBox musicCheckBox = new JCheckBox("Music");
        JCheckBox sportsCheckBox = new JCheckBox("Sports");
        JPanel interestsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        interestsPanel.add(codingCheckBox);
        interestsPanel.add(musicCheckBox);
        interestsPanel.add(sportsCheckBox);
        panel.add(interestsPanel);

        // Submit button
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);

        // Submit action
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String gender = maleButton.isSelected() ? "Male" :
                        femaleButton.isSelected() ? "Female" : "Other";
                String feedback = feedbackArea.getText();
                String interests = "";
                if (codingCheckBox.isSelected()) interests += "Coding ";
                if (musicCheckBox.isSelected()) interests += "Music ";
                if (sportsCheckBox.isSelected()) interests += "Sports ";

                JOptionPane.showMessageDialog(SurveyForm.this,
                        "Survey Submitted!\n" +
                                "Name: " + name + "\n" +
                                "Gender: " + gender + "\n" +
                                "Feedback: " + feedback + "\n" +
                                "Interests: " + interests);
            }
        });

        // Set the frame to be visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SurveyForm::new);
    }
}
