import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class RegisterPanel extends JPanel {
    public Register register = new Register();
    public JPanel inputPanel = new JPanel();
    public JTextField input = new JTextField("Hello World");
    public PursePanel changePanel = new PursePanel();
    private static final String DOUBLE_REGEX = "^[0-9]+(?:\\.[0-9]+)?$";

    // InputListener to attach to input source
    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Get input text
            if (e.getSource().getClass().equals(JTextField.class)) {
                JTextField source = (JTextField) e.getSource();
                String input_text = source.getText();

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

    // Constructor for RegisterPanel
    public RegisterPanel() {
        // Configure input JTextField
        input.setPreferredSize(new Dimension(200, 30));
        input.setFont(new Font("Serif", Font.BOLD, 20));
        input.addActionListener(new InputListener());

        // Configure input JPanel
        JLabel label = new JLabel("Enter a dollar amount to make change: $");
        inputPanel.add(label);
        inputPanel.add(input);

        this.add(inputPanel);
        this.add(changePanel);
    }
}
