package bookingsystem.gui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

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
