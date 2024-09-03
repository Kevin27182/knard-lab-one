
// Title: RegisterPanel.java
// Author: Kevin Nard
// Contains input/output GUI elements and user input validation
//      private final Register register - driver for change-making computation
//      private final PursePanel changePanel - draws currency to the screen
//      private final JTextField input - gets input from the user
//      private final JPanel inputPanel - wrapper for input field
//      public RegisterPanel() - default constructor that configures child UI elements
//      private class InputListener implements ActionListener - listener for input field

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class RegisterPanel extends JPanel {

    // Computation / GUI elements
    private final Register register = new Register();
    private final PursePanel changePanel = new PursePanel();
    private final JTextField input = new JTextField();
    private final JPanel inputPanel = new JPanel();

    // Constructor for configuring UI elements
    public RegisterPanel() {

        // Configure input JTextField
        input.setPreferredSize(new Dimension(200, 30));
        input.setFont(new Font("Serif", Font.BOLD, 20));
        input.addActionListener(new InputListener());

        // Configure input JPanel
        JLabel label = new JLabel("Enter the amount of change you wish to make and press <ENTER>: $");
        inputPanel.add(label);
        inputPanel.add(input);

        // Add panels to RegisterPanel
        this.add(inputPanel);
        this.add(changePanel);
    }

    // InputListener to attach to input source
    private class InputListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Get input text
            if (e.getSource().getClass().equals(JTextField.class)) {
                JTextField source = (JTextField) e.getSource();
                String input_text = source.getText();

                // NOTE: I'm allowing negatives with this Regex
                // because the instructions said to allow negatives
                final String DOUBLE_REGEX = "^-?(?:[0-9]+)?(?:\\.[0-9]+)?$";

                // Validate that input can be converted to double and run makeChange
                if (Pattern.matches(DOUBLE_REGEX, input_text)) {
                    double amt = Double.parseDouble(input_text);
                    Purse input_purse = register.makeChange(amt);
                    changePanel.setPurse(input_purse);
                    changePanel.paintComponent(changePanel.getGraphics());
                }
            }
        }
    }
}
