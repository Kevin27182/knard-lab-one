
// Title: PursePanel.java
// Author: Kevin Nard
// Draws currency derived from purse field
//      private Purse purse - holds the currency to draw
//      public PursePanel() - default constructor for configuring PursePanel
//      public void paintComponent(Graphics g) - draws currency from purse field
//      public void setPurse(Purse p) - purse setter
//      public Purse getPurse() - purse getter

import javax.swing.*;
import java.awt.*;

public class PursePanel extends JPanel {

    // Holds currency to draw
    private Purse purse;

    // Constructor for configuring PursePanel
    public PursePanel() {

        this.setPreferredSize(new Dimension(600, 1000));
        this.setBackground(Color.BLUE);
    }

    // Draws images of the currency in the purse field
    public void paintComponent(Graphics g) {

        // Do nothing if no Purse object exists
        if (this.purse == null)
            return;

        // Clear all existing images
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0, 600, 1000);

        int yOffset = 0;

        // Loop through each denomination and append to return_string if exists
        for (Denomination denomination : Register.DENOMINATION_ARRAY) {

            // Skip if cash does not contain denomination
            if (!purse.cash.containsKey(denomination))
                continue;

            // Get image from denomination img path
            ImageIcon img = new ImageIcon(denomination.img());

            // Scale according to denomination form
            if (denomination.form() == Form.COIN)
                img.setImage(img.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
            else if (denomination.form() == Form.NOTE)
                img.setImage(img.getImage().getScaledInstance(200, 80, Image.SCALE_SMOOTH));

            // Draw number of pictures specified in each entry
            for (int i = 0; i < purse.cash.get(denomination); i++) {
                g.drawImage(img.getImage(), 20 * i, yOffset, null);
            }

            // Adjust yOffset
            yOffset += img.getIconHeight();
        }
    }

    // Setter for purse field
    public void setPurse(Purse p) {
        purse = p;
    }

    // Getter for purse field
    public Purse getPurse() {
        return purse;
    }
}
