package bookingsystem.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BookSysGui extends JFrame {
    public JLabel titleLabel;

    public BookSysGui() {
        titleLabel = new JLabel("-Welcome To Our Tour Booking System-");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tour Booking System");
        
        //set background image
        BkPanel bkPanel = new BkPanel();
        this.add(bkPanel);
        bkPanel.setBackground(new java.awt.Color(200, 255, 255));
        
        this.setSize(525, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        bkPanel.add(titleLabel);

        titleLabel.setFont(new java.awt.Font("Kannada MN", 0, 18));
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    }

    public static void main(String args[]) {
        BookSysGui bsgui = new BookSysGui();
        bsgui.setVisible(true);
    }
}
