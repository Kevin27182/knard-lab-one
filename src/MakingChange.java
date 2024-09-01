import javax.swing.*;
import java.awt.*;

public class MakingChange {
    public static void main(String[] args) {
        // Configure JFrame
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));

        // Configure RegisterPanel
        RegisterPanel registerPanel = new RegisterPanel();
        registerPanel.setBackground(Color.BLUE);
        frame.add(registerPanel);

        // Pack and display the JFrame
        frame.pack();
        frame.setVisible(true);
    }
}
