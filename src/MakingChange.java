import javax.swing.*;
import java.awt.*;

public class MakingChange {
    public static void main(String[] args) {
        // Configure JFrame
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));

        // TEST - DELETE LATER
        ImageIcon img = new ImageIcon("img/penny.png");
        img.setImage(img.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        JLabel img_label = new JLabel(img);

        // Configure RegisterPanel
        RegisterPanel registerPanel = new RegisterPanel();
        registerPanel.setBackground(Color.BLUE);
        registerPanel.add(img_label);
        frame.add(registerPanel);

        // Pack and display the JFrame
        frame.pack();
        frame.setVisible(true);
    }
}
