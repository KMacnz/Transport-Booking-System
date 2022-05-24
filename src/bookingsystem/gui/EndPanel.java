package bookingsystem.gui;

import bookingsystem.util.Cart;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class EndPanel extends JPanel {

    GridBagConstraints grid = new GridBagConstraints();

    public EndPanel() {
        JPanel endPanel = new JPanel();
        endPanel.setLayout(new GridBagLayout());
        endPanel.setOpaque(false);
        setOpaque(false);
        endPanel.setPreferredSize(new Dimension(525, 480));
        this.add(endPanel);

        //Question Label 
        JLabel saveLabel = new JLabel("Confirm your Booking?");
        grid.gridx = 1;
        grid.gridy = 1;
        endPanel.add(saveLabel, grid);

        saveLabel.setFont(new java.awt.Font("Kannada MN", 1, 24));
        saveLabel.setForeground(new java.awt.Color(0, 0, 0));
        saveLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // add panel for buttons
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());
        btnPanel.setOpaque(false);

        // Save Button
        ImageIcon saveimg = new ImageIcon("./resources/image/save.png");
        JButton saveBtn = new JButton("Save Booking", saveimg);
        saveBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        saveBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        saveBtn.setBorderPainted(false);
        
        // if carts have an item in them make the save button visible
        if (!(Cart.busCart.isEmpty() && Cart.boatCart.isEmpty() && Cart.tramCart.isEmpty())) {
            btnPanel.add(saveBtn);
        }

        // Quit Button
        ImageIcon quitimg = new ImageIcon("./resources/image/noSave.png");
        JButton noSaveBtn = new JButton("Quit", quitimg);
        noSaveBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        noSaveBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        noSaveBtn.setBorderPainted(false);
        btnPanel.add(noSaveBtn);

        // add listener
        noSaveBtn.addActionListener(e -> {
            // close gui
            System.exit(0);
        });

        grid.gridx = 1;
        grid.gridy = 2;
        endPanel.add(btnPanel, grid);
        
        // Back Button
        ImageIcon backimg = new ImageIcon("./resources/image/back.png");
        JButton backBtn = new JButton("Back", backimg);
        backBtn.setBorderPainted(false);
        backBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        backBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        // add listener
        backBtn.addActionListener(e -> {
            StartPanel.endPanel.setVisible(false);
            StartPanel.startPanel.setVisible(true);
        });
        
        grid.gridx = 1;
        grid.gridy = 4;
        endPanel.add(backBtn, grid);
        
        
        // add listener
        saveBtn.addActionListener(e -> {
            saveLabel.setText("Your Booking has been Saved");
            saveBtn.setVisible(false);
            backBtn.setVisible(false);

            // add thank you message
            JLabel endLabel = new JLabel("-Thank you for your vist-");
            grid.gridx = 1;
            grid.gridy = 3;
            endPanel.add(endLabel, grid);

        });
        
        
    }
}
