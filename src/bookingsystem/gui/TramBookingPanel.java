package bookingsystem.gui;

import bookingsystem.layout.Column;
import bookingsystem.layout.Row;
import bookingsystem.layout.SetReservation;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class TramBookingPanel extends JPanel{
    private final DrawPanel drawPanel;
    public JButton[][] eachSeat;
    private final GridBagConstraints grid = new GridBagConstraints();
    public JTextField seatTxtFld;
    public JButton cartBtn;

    public char tCol;
    public int tRow;

    public TramBookingPanel() {

        JPanel tramBookingPanel = new JPanel(new GridBagLayout());
        tramBookingPanel.setOpaque(false);
        setOpaque(false);
        drawPanel = new DrawPanel();

        // repaint the panel
        drawPanel.repaint();

        //initialize elements
        eachSeat = new JButton[3][8];
        for (int i = 0; i < eachSeat.length; i++) {
            for (int j = 0; j < eachSeat[i].length; j++) {
                eachSeat[i][j] = new JButton();
                eachSeat[i][j].setBackground(Color.GREEN);
                eachSeat[i][j].setOpaque(true);
                drawPanel.add(eachSeat[i][j]);

                char col = (char) (65 + i);
                int row = j + 1;
                String a = "Seat: (" + col + ", " + row + ")";

                if (SetReservation.reserveTram.isReserved(new Row(row), new Column(col))) {
                    eachSeat[i][j].setEnabled(false);
                    eachSeat[i][j].setOpaque(false);
                }

                eachSeat[i][j].addActionListener(e -> {
                    seatTxtFld.setText(a);
                    cartBtn.setEnabled(true);
                    tCol = col;
                    tRow = row;
                });
            }
        }

        JPanel seatPanel = new JPanel();
        seatPanel.setOpaque(false);
        seatPanel.setLayout(new FlowLayout());

        JPanel bookerPanel = new JPanel();
        bookerPanel.setOpaque(false);
        bookerPanel.setLayout(new BoxLayout(bookerPanel, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new FlowLayout());

        this.add(tramBookingPanel);

        //Tram Label 
        JLabel tramLabel = new JLabel("Choose your Tram Seats");
        grid.gridx = 1;
        grid.gridy = 1;
        grid.ipady = 50;
        tramBookingPanel.add(tramLabel, grid);

        tramLabel.setFont(new java.awt.Font("Kannada MN", 1, 24));
        tramLabel.setForeground(new java.awt.Color(0, 0, 0));
        tramLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        //Seat Text Area 
        seatTxtFld = new JTextField();
        seatTxtFld.setEditable(false);
        seatTxtFld.setFont(new java.awt.Font("Monospaced", 0, 15));
        seatTxtFld.setText("Seat:");
        seatTxtFld.setPreferredSize(new Dimension(150, 100));
        seatTxtFld.setHorizontalAlignment(JTextField.CENTER);

        // Cart Button
        ImageIcon cartimg = new ImageIcon("./resources/image/cart.png");
        cartBtn = new JButton("Add To Cart", cartimg);
        cartBtn.setBorderPainted(false);
        cartBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        cartBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        cartBtn.setEnabled(false);
        // add listener
        cartBtn.addActionListener(e -> {
            SetReservation setReservation = new SetReservation();
            setReservation.reserveTram(tCol, tRow);
            cartBtn.setEnabled(false);
            SetReservation.reserveTram.reserveSeat(new Row(tRow), new Column(tCol));
            eachSeat[tCol - 65][tRow - 1].setBackground(Color.RED);
            eachSeat[tCol - 65][tRow - 1].setOpaque(true);
            eachSeat[tCol - 65][tRow - 1].setEnabled(false);
        });

        // Back Button
        ImageIcon backimg = new ImageIcon("./resources/image/back.png");
        JButton backBtn = new JButton("Back", backimg);
        backBtn.setBorderPainted(false);
        backBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        backBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        // add listener
        backBtn.addActionListener(e -> {
            StartPanel.tramBookingPanel.setVisible(false);
            StartPanel.startPanel.setVisible(true);
        });

        seatPanel.add(drawPanel);
        seatPanel.add(Box.createHorizontalStrut(50));
        bookerPanel.add(seatTxtFld);
        bookerPanel.add(bottomPanel);
        bottomPanel.add(cartBtn);
        bottomPanel.add(backBtn);
        seatPanel.add(bookerPanel);

        grid.gridx = 1;
        grid.gridy = 2;
        tramBookingPanel.add(seatPanel, grid);
    }

    public class DrawPanel extends JPanel {

        public DrawPanel() {
            super.setPreferredSize(new Dimension(129, 355));
            super.setOpaque(false);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (int i = 0; i < eachSeat.length; i++) {
                for (int j = 0; j < eachSeat[i].length; j++) {
                    eachSeat[i][j].setBounds(i * 42, j * 42, 45, 45);
                }
            }
        }
    }
}
