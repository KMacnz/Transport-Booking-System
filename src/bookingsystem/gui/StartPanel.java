package bookingsystem.gui;

import java.awt.*;
import javax.swing.*;

public class StartPanel extends JPanel {

    GridBagConstraints grid = new GridBagConstraints();

    public static JPanel startPanel;
    public static HomePanel homePanel;
    public static BusBookingPanel busBookingPanel;
    public static BoatBookingPanel boatBookingPanel;
    public static TramBookingPanel tramBookingPanel;
    public static ReciptPanel reciptPanel;
    public static CartPanel cartPanel;
    public static EndPanel endPanel;

    public StartPanel() {

        homePanel = new HomePanel();
        add(homePanel);
        homePanel.setVisible(false);

        busBookingPanel = new BusBookingPanel();
        add(busBookingPanel);
        busBookingPanel.setVisible(false);

        boatBookingPanel = new BoatBookingPanel();
        add(boatBookingPanel);
        boatBookingPanel.setVisible(false);

        tramBookingPanel = new TramBookingPanel();
        add(tramBookingPanel);
        tramBookingPanel.setVisible(false);

        reciptPanel = new ReciptPanel();
        add(reciptPanel);
        reciptPanel.setVisible(false);

        cartPanel = new CartPanel();
        add(cartPanel);
        cartPanel.setVisible(false);

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
            StartPanel.reciptPanel.setVisible(true);
        });

        // add panel for bottom buttons
        JPanel btnPanel2 = new JPanel();
        btnPanel2.setLayout(new FlowLayout());
        btnPanel2.setOpaque(false);

        // Cart Button
        ImageIcon cartImg = new ImageIcon("./resources/image/cartview.png");
        JButton cartBtn = new JButton("View Cart", cartImg);
        cartBtn.setBorderPainted(false);
        cartBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        cartBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPanel2.add(cartBtn);

        // add listener
        cartBtn.addActionListener(e -> {
            StartPanel.startPanel.setVisible(false);
            cartPanel = new CartPanel();
            add(cartPanel);
            cartPanel.setVisible(true);
        });

        // Quit Button
        ImageIcon quitimg = new ImageIcon("./resources/image/quit.png");
        JButton quitBtn = new JButton("Save & Quit", quitimg);
        quitBtn.setBorderPainted(false);
        quitBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        quitBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPanel2.add(quitBtn);

        // add listener
        quitBtn.addActionListener(e -> {
            startPanel.setVisible(false);
            endPanel = new EndPanel();
            add(endPanel);
            endPanel.setVisible(true);
        });

        grid.gridx = 1;
        grid.gridy = 2;
        startPanel.add(btnPanel1, grid);

        grid.gridx = 1;
        grid.gridy = 3;
        startPanel.add(btnPanel2, grid);
    }
}
