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

public class StartGui extends JPanel {

    GridBagConstraints grid = new GridBagConstraints();

    public StartGui() {

        JPanel indexPanel = new JPanel();
        indexPanel.setLayout(new GridBagLayout());
        indexPanel.setOpaque(false);
        setOpaque(false);
        indexPanel.setPreferredSize(new Dimension(525, 480));
        this.add(indexPanel);

        //Title Label 
        JLabel titleLabel = new JLabel("-Welcome To Our Tour Booking System-");
        grid.gridx = 1;
        grid.gridy = 1;
        indexPanel.add(titleLabel, grid);

        titleLabel.setFont(new java.awt.Font("Kannada MN", 1, 24));
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JPanel btnPanel1 = new JPanel();
        btnPanel1.setLayout(new FlowLayout());
        btnPanel1.setOpaque(false);

        // Booking Button
        ImageIcon bookingimg = new ImageIcon("./resources/image/booking.png");
        JButton bookingBtn = new JButton(bookingimg);
        bookingBtn.setBorderPainted(false);
        btnPanel1.add(bookingBtn);
        bookingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Booking");
            }
        });

        // Receipt Button
        ImageIcon recimg = new ImageIcon("./resources/image/recipt.png");
        JButton recieptBtn = new JButton(recimg);
        recieptBtn.setBorderPainted(false);
        btnPanel1.add(recieptBtn);
        recieptBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Receipt");
            }
        });

        JPanel btnPanel2 = new JPanel();
        btnPanel2.setLayout(new FlowLayout());
        btnPanel2.setOpaque(false);

        // Log Button
        ImageIcon logimg = new ImageIcon("./resources/image/logs.png");
        JButton logBtn = new JButton(logimg);
        logBtn.setBorderPainted(false);
        btnPanel2.add(logBtn);
        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Log");
            }
        });

        grid.gridx = 1;
        grid.gridy = 2;
        indexPanel.add(btnPanel1, grid);

        grid.gridx = 1;
        grid.gridy = 3;
        indexPanel.add(btnPanel2, grid);
    }
}


//HomePanel hpgui = new HomePanel();
       // bkPanel.add(hpgui);