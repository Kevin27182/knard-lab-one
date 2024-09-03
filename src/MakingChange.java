
// Title: MakingChange.java
// Author: Kevin Nard
// GUI implementation of the Register class
//      public static void main(String[] args) - Constructs interactive GUI elements

import javax.swing.*;
import java.awt.*;

public class MakingChange {

    // Creates the default interactive GUI view
    public static void main(String[] args) {

        // Configure JFrame
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700, 1000));

        // Configure RegisterPanel
        RegisterPanel registerPanel = new RegisterPanel();
        registerPanel.setBackground(Color.DARK_GRAY);
        frame.add(registerPanel);

        // Pack and display the JFrame
        frame.pack();
        frame.setVisible(true);
    }
}
