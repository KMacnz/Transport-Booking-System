package bookingsystem.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StartPanel extends JPanel {

    GridBagConstraints grid = new GridBagConstraints();
    
    public static JPanel startPanel;
    public static HomePanel homePanel;
    
    public static EndPanel endPanel;

    public StartPanel() {
     
        homePanel = new HomePanel();
        add(homePanel);
        homePanel.setVisible(false);
        
        endPanel = new EndPanel();
        add(endPanel);
        endPanel.setVisible(false);
        
        
        
        startPanel = new JPanel();
        startPanel.setLayout(new GridBagLayout());
        startPanel.setOpaque(false);
        setOpaque(false);
        startPanel.setPreferredSize(new Dimension(525, 480));
        this.add(startPanel);

        //Title Label 
        JLabel titleLabel = new JLabel("-Welcome To Our Tour Booking System-");
        grid.gridx = 1;
        grid.gridy = 1;
        startPanel.add(titleLabel, grid);

        titleLabel.setFont(new java.awt.Font("Kannada MN", 1, 24));
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // add panel for bottom buttons
        JPanel btnPanel1 = new JPanel();
        btnPanel1.setLayout(new FlowLayout());
        btnPanel1.setOpaque(false);

        // Booking Button
        ImageIcon bookingimg = new ImageIcon("./resources/image/booking.png");
        JButton bookingBtn = new JButton("Book Here", bookingimg);
        bookingBtn.setBorderPainted(false);
        bookingBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        bookingBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPanel1.add(bookingBtn);
        
        // add listener
        bookingBtn.addActionListener(e -> {
            startPanel.setVisible(false);
            StartPanel.homePanel.setVisible(true);
        });
        
        
        // Receipt Button
        ImageIcon recimg = new ImageIcon("./resources/image/recipt.png");
        JButton recieptBtn = new JButton("Get Previous Receipt", recimg);
        recieptBtn.setBorderPainted(false);
        recieptBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        recieptBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPanel1.add(recieptBtn);
        
        // add listener
        recieptBtn.addActionListener(e -> {
            startPanel.setVisible(false);
            
        });
        
        // add panel for bottom buttons
        JPanel btnPanel2 = new JPanel();
        btnPanel2.setLayout(new FlowLayout());
        btnPanel2.setOpaque(false);

        // Log Button
        ImageIcon logimg = new ImageIcon("./resources/image/logs.png");
        JButton logBtn = new JButton("View Logs", logimg);
        logBtn.setBorderPainted(false);
        logBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        logBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPanel2.add(logBtn);
        
        // add listener
        logBtn.addActionListener(e -> {
            startPanel.setVisible(false);
        });
        
        // Quit Button
        ImageIcon quitimg = new ImageIcon("./resources/image/quit.png");
        JButton quitBtn = new JButton("Quit", quitimg);
        quitBtn.setBorderPainted(false);
        quitBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        quitBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPanel2.add(quitBtn);
        
        // add listener
        quitBtn.addActionListener(e -> {
            startPanel.setVisible(false);
            StartPanel.endPanel.setVisible(true);
        });

        grid.gridx = 1;
        grid.gridy = 2;
        startPanel.add(btnPanel1, grid);

        grid.gridx = 1;
        grid.gridy = 3;
        startPanel.add(btnPanel2, grid);
    }
}


