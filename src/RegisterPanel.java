import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    public Register register = new Register();
    public JPanel inputPanel = new JPanel();
    public JTextField input = new JTextField();
    public PursePanel changePanel = new PursePanel();

    public static class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }
}
