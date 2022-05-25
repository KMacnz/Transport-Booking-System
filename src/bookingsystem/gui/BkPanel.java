package bookingsystem.gui;

import java.awt.*;
import javax.swing.*;

public class BkPanel extends JPanel {

    public Image image;

    public BkPanel() {
        this.image = new ImageIcon("./resources/image/logo.png").getImage();
    }
    // Draw the background of this panel.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, null);
    }
}
