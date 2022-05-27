package bookingsystem.gui;

import javax.swing.JFrame;
import bookingsystem.layout.SetReservation;

public class BookSysGui extends JFrame {

    public BookSysGui() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tour Booking System");

        // Set up the panel
        this.setSize(525, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //set background image
        BkPanel bkPanel = new BkPanel();
        this.add(bkPanel);
        bkPanel.setBackground(new java.awt.Color(200, 255, 255));

        StartPanel startGui = new StartPanel();
        bkPanel.add(startGui);
    }

    public static void main(String args[]) {
        SetReservation booking = new SetReservation();
        booking.setUpReservations();
        
        
        Database dbManager = new Database();
        dbManager.dbsetup();
        System.out.println("Data base setup complete");

        BookSysGui bsgui = new BookSysGui();
        bsgui.setVisible(true);
    }
}
