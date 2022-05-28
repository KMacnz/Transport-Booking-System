package bookingsystem.gui;

import bookingsystem.util.Cart;
import java.awt.*;
import javax.swing.*;

public class EndPanel extends JPanel {

    GridBagConstraints grid = new GridBagConstraints();
    private final JTextArea cartTxtFld;

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
        grid.ipady = 10;
        endPanel.add(saveLabel, grid);

        saveLabel.setFont(new java.awt.Font("Kannada MN", 1, 24));
        saveLabel.setForeground(new java.awt.Color(0, 0, 0));
        saveLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cartTxtFld = new JTextArea();
        cartTxtFld.setEditable(false);
        cartTxtFld.setFont(new java.awt.Font("Monospaced", 0, 15));
        cartTxtFld.setPreferredSize(new Dimension(400, 150));
        cartTxtFld.setLineWrap(true);
        cartTxtFld.setOpaque(false);
        cartTxtFld.setVisible(false);

        cartTxtFld.setText("Your ID is: " + BookSysGui.userID + "\n\n");
        if (!(Cart.busCart.isEmpty())) {
            cartTxtFld.append("Bus: " + Cart.busCart.toString() + "\n\n");
        }
        if (!(Cart.boatCart.isEmpty())) {
            cartTxtFld.append("Boat: " + Cart.boatCart.toString() + "\n\n");
        }
        if (!(Cart.tramCart.isEmpty())) {
            cartTxtFld.append("Tram: " + Cart.tramCart.toString() + "\n\n");
        }
        cartTxtFld.append("\nKeep your ID to view ur order in the future");

        grid.gridx = 1;
        grid.gridy = 2;
        endPanel.add(cartTxtFld, grid);

        // add panel for buttons
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());
        btnPanel.setOpaque(false);

        // Back Button
        ImageIcon backimg = new ImageIcon("./resources/image/back.png");
        JButton backBtn = new JButton("Back", backimg);
        backBtn.setBorderPainted(false);
        backBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        backBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPanel.add(backBtn);
        // add listener
        backBtn.addActionListener(e -> {
            StartPanel.endPanel.setVisible(false);
            StartPanel.startPanel.setVisible(true);
        });

        // Save Button
        ImageIcon saveimg = new ImageIcon("./resources/image/save.png");
        JButton saveBtn = new JButton("Save Booking", saveimg);
        saveBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        saveBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        saveBtn.setBorderPainted(false);

        // if carts have an item in them make the save button visible
        if (!(Cart.busCart.isEmpty() && Cart.boatCart.isEmpty() && Cart.tramCart.isEmpty())) {
            btnPanel.add(saveBtn);
            cartTxtFld.setVisible(true);
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
            Database dbManager = new Database();
            // close gui
            System.exit(0);
            dbManager.close();
        });

        grid.gridx = 1;
        grid.gridy = 3;
        endPanel.add(btnPanel, grid);

        // add listener
        saveBtn.addActionListener(e -> {
            saveLabel.setText("Your Booking has been Saved");
            saveBtn.setVisible(false);
            backBtn.setVisible(false);

            // add thank you message
            JLabel endLabel = new JLabel("-Thank you for your vist-");
            grid.gridx = 1;
            grid.gridy = 4;
            endPanel.add(endLabel, grid);

            String busData = "";
            String boatData = "";
            String tramData = "";

            if (!(Cart.busCart.isEmpty())) {
                for (String seat : Cart.busCart) {
                    busData += seat.trim().replace("(", "").replace(")", "") + " : ";
                }
                busData = busData.substring(0, busData.length() - 3);
            }

            if (!(Cart.boatCart.isEmpty())) {
                for (String seat : Cart.boatCart) {
                    boatData += seat.trim().replace("(", "").replace(")", "") + " : ";
                }
                boatData = boatData.substring(0, boatData.length() - 3);
            }

            if (!(Cart.tramCart.isEmpty())) {
                for (String seat : Cart.tramCart) {
                    tramData += seat.trim().replace("(", "").replace(")", "") + " : ";
                }
                tramData = tramData.substring(0, tramData.length() - 3);
            } else {
                tramData = null;
            }

            Database database = new Database();
            System.out.println("Saving Data");
            database.saveData(busData, boatData, tramData);
            System.out.println("View Data");
            database.seeData();
        });
    }
}
