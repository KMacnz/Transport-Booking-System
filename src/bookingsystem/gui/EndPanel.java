package bookingsystem.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        JButton saveBtn = new JButton(saveimg);
        saveBtn.setBorderPainted(false);
        btnPanel.add(saveBtn);

        // add listener
        saveBtn.addActionListener(e -> {
            saveLabel.setText("Your Booking has been Saved");
            saveBtn.setVisible(false);

            // add thank you message
            JLabel endLabel = new JLabel("-Thank you for your vist-");
            grid.gridx = 1;
            grid.gridy = 3;
            endPanel.add(endLabel, grid);

        });

        // Quit Button
        ImageIcon quitimg = new ImageIcon("./resources/image/noSave.png");
        JButton noSaveBtn = new JButton(quitimg);
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
    }
}
