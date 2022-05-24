package bookingsystem.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class CartPanel extends JPanel{
    
    public JTextField reciptTxtFld;
    
    GridBagConstraints grid = new GridBagConstraints();

    public CartPanel() {
        JPanel reciptPanel = new JPanel();
        reciptPanel.setLayout(new GridBagLayout());
        reciptPanel.setOpaque(false);
        setOpaque(false);
        reciptPanel.setPreferredSize(new Dimension(525, 480));
        this.add(reciptPanel);
        
        JTextField userTypeFld = new JTextField();
        userTypeFld.setFont(new java.awt.Font("Monospaced", 0, 15));
        userTypeFld.setPreferredSize(new Dimension(100, 50));
        userTypeFld.setHorizontalAlignment(JTextField.CENTER);

        grid.gridx = 1;
        grid.gridy = 2;
        reciptPanel.add(userTypeFld, grid);
        
        reciptTxtFld = new JTextField();
        reciptTxtFld.setEditable(false);
        reciptTxtFld.setFont(new java.awt.Font("Monospaced", 0, 15));
        reciptTxtFld.setPreferredSize(new Dimension(200, 150));
        
        grid.gridx = 1;
        grid.gridy = 3;
        reciptPanel.add(reciptTxtFld, grid);
}
}
