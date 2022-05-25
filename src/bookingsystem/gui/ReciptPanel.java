package bookingsystem.gui;

import bookingsystem.file.PrintRecipt;
import java.awt.*;
import javax.swing.*;

public class ReciptPanel extends JPanel{
    
    public JTextArea reciptTxtFld;
    
    GridBagConstraints grid = new GridBagConstraints();

    public ReciptPanel() {
        JPanel reciptPanel = new JPanel();
        reciptPanel.setLayout(new GridBagLayout());
        reciptPanel.setOpaque(false);
        setOpaque(false);
        reciptPanel.setPreferredSize(new Dimension(525, 480));
        this.add(reciptPanel);
        
        //ID Label 
        JLabel idLabel = new JLabel("Enter Your Previous ID Here:");
        grid.gridx = 1;
        grid.gridy = 1;
        reciptPanel.add(idLabel, grid);

        idLabel.setFont(new java.awt.Font("Kannada MN", 1, 24));
        idLabel.setForeground(new java.awt.Color(0, 0, 0));
        idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        // User Input 
        JTextField userTypeFld = new JTextField();
        userTypeFld.setFont(new java.awt.Font("Monospaced", 0, 15));
        userTypeFld.setPreferredSize(new Dimension(100, 50));
        userTypeFld.setHorizontalAlignment(JTextField.CENTER);

        grid.gridx = 1;
        grid.gridy = 2;
        reciptPanel.add(userTypeFld, grid);
        
        // Recipt gets printed
        reciptTxtFld = new JTextArea();
        reciptTxtFld.setEditable(false);
        reciptTxtFld.setFont(new java.awt.Font("Monospaced", 0, 15));
        reciptTxtFld.setPreferredSize(new Dimension(200, 150));
        reciptTxtFld.setLineWrap(true);
        
        grid.gridx = 1;
        grid.gridy = 3;
        reciptPanel.add(reciptTxtFld, grid);
        
        JPanel dirrectionPanel = new JPanel();
        dirrectionPanel.setOpaque(false);
        dirrectionPanel.setLayout(new FlowLayout());
        
        // ID login Button
        ImageIcon goimg = new ImageIcon("./resources/image/go.png");
        JButton goBtn = new JButton("Unlock Recipt", goimg);
        goBtn.setBorderPainted(false);
        goBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        goBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        dirrectionPanel.add(goBtn);
        
        // Back Button
        ImageIcon backimg = new ImageIcon("./resources/image/back.png");
        JButton backBtn = new JButton("Back", backimg);
        backBtn.setBorderPainted(false);
        backBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        backBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        dirrectionPanel.add(backBtn);
        // add listener
        backBtn.addActionListener(e -> {
            StartPanel.reciptPanel.setVisible(false);
            StartPanel.startPanel.setVisible(true);
        });
        
        grid.gridx = 1;
        grid.gridy = 4;
        reciptPanel.add(dirrectionPanel, grid);
        
        
        goBtn.addActionListener(e -> {
            PrintRecipt printRecipt = new PrintRecipt();
            String id = userTypeFld.getText().trim();
            id = printRecipt.print(id);
        });
        
        
    }
}
