package bookingsystem.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel {

    GridBagConstraints grid = new GridBagConstraints();

    public HomePanel() {

        JPanel homePanel = new JPanel();
        homePanel.setLayout(new GridBagLayout());
        homePanel.setOpaque(false);
        setOpaque(false);
        homePanel.setPreferredSize(new Dimension(525, 480));
        this.add(homePanel);

        //Title Label 
        JLabel titleLabel = new JLabel("-Welcome To Our Tour Booking System-");
        grid.gridx = 1;
        grid.gridy = 1;
        homePanel.add(titleLabel, grid);

        titleLabel.setFont(new java.awt.Font("Kannada MN", 1, 24));
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // Vehicle Label
        JLabel vehicleLabel = new JLabel("-Choose Your Vehicle Type-");
        grid.gridx = 1;
        grid.gridy = 2;
        grid.ipady = 25;
        homePanel.add(vehicleLabel, grid);
        vehicleLabel.setFont(new java.awt.Font("Kannada MN", 0, 18));
        vehicleLabel.setForeground(new java.awt.Color(0, 0, 0));
        vehicleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());
        btnPanel.setOpaque(false);

        // Boat Button
        ImageIcon boatimg = new ImageIcon("./resources/image/boat.png");
        JButton boatBtn = new JButton(boatimg);
        boatBtn.setBorderPainted(false);
        btnPanel.add(boatBtn);
        boatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Boat");
            }
        });

        // Bus Button
        ImageIcon busimg = new ImageIcon("./resources/image/bus.png");
        JButton busBtn = new JButton(busimg);
        busBtn.setBorderPainted(false);
        btnPanel.add(busBtn);
        busBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bus");
            }
        });

        // Tram Button
        ImageIcon tramimg = new ImageIcon("./resources/image/tram.png");
        JButton tramBtn = new JButton(tramimg);
        tramBtn.setBorderPainted(false);
        btnPanel.add(tramBtn);
        tramBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tram");
            }
        });

        JPanel btnPanel2 = new JPanel();
        btnPanel2.setOpaque(false);

        // Back Button
        ImageIcon backimg = new ImageIcon("./resources/image/back.png");
        JButton backBtn = new JButton(backimg);
        backBtn.setBorderPainted(false);
        btnPanel2.add(backBtn);
        // add listener
        backBtn.addActionListener(e -> {
            StartPanel.homePanel.setVisible(false);
            StartPanel.startPanel.setVisible(true);
        });

        grid.gridx = 1;
        grid.gridy = 3;
        homePanel.add(btnPanel, grid);

        grid.gridx = 1;
        grid.gridy = 4;
        homePanel.add(btnPanel2, grid);

    }
}
