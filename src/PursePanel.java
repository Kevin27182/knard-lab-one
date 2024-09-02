import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse;

    public void paintComponent(Graphics g) {
        // Do nothing if no purse object exists
        if (this.purse == null)
            return;

        // Clear all existing images
        g.setColor(Color.BLUE);
        g.fillRect(0,0, 500, 500);

        int yOffset = 0;

        // Loop through all entries and display
        for (Map.Entry<Denomination, Integer> entry : purse.cash.entrySet()) {
            // Get denomination and image
            Denomination denomination = entry.getKey();
            ImageIcon img = new ImageIcon(denomination.img());

            // Scale according to denomination form
            if (denomination.form() == Form.COIN)
                img.setImage(img.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            else if (denomination.form() == Form.NOTE)
                img.setImage(img.getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH));

            // Add img to PursePanel
            g.drawImage(img.getImage(), 0, yOffset, null);

            System.out.println("Drew image at 0, " + yOffset);

            // Adjust yOffset
            yOffset += img.getIconHeight();
        }
    }

    public PursePanel() {
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.BLUE);
    }

    public void setPurse(Purse p) {
        purse = p;
    }

    public Purse getPurse() {
        return purse;
    }
}
