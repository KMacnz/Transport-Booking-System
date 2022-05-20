package bookingsystem.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class BusBookingPanel extends JPanel {

    private final DrawPanel drawPanel;
    public JButton[][] eachSeat;
    GridBagConstraints grid = new GridBagConstraints();
    public JTextArea seatTxtArea;

    public BusBookingPanel() {
        super(new GridBagLayout());
        drawPanel = new DrawPanel();

        // repaint the panel
        drawPanel.repaint();

        //initialize elements
        eachSeat = new JButton[4][8];
        for (int i = 0; i < eachSeat.length; i++) {
            for (int j = 0; j < eachSeat[i].length; j++) {
                eachSeat[i][j] = new JButton();
                drawPanel.add(eachSeat[i][j]);

                String a = "Seat: (" + String.valueOf(new Character((char) (65 + i))) + ", " + (j + 1) + ")";
                eachSeat[i][j].addActionListener(e -> {
                    seatTxtArea.setText(a);
                });
            }
        }

        JPanel endPanel = new JPanel();
        JPanel seatPanel = new JPanel();
        seatPanel.setLayout(new FlowLayout());

        //Bus Label 
        JLabel busLabel = new JLabel("Choose your Seats");
        grid.gridx = 1;
        grid.gridy = 1;
        endPanel.add(busLabel, grid);
        super.add(endPanel);

        busLabel.setFont(new java.awt.Font("Kannada MN", 1, 24));
        busLabel.setForeground(new java.awt.Color(0, 0, 0));
        busLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        //Seat Text Area 
        seatTxtArea = new JTextArea();
        seatTxtArea.setEditable(false);
        seatTxtArea.setFont(new java.awt.Font("Monospaced", 0, 15));
        seatTxtArea.setText("OWO");
        seatTxtArea.setPreferredSize(new Dimension(126, 254));

        grid.gridx = 1;
        grid.gridy = 2;

        seatPanel.add(drawPanel);
        seatPanel.add(seatTxtArea);
        endPanel.add(seatPanel, grid);
    }

    public class DrawPanel extends JPanel {

        public DrawPanel() {
            super.setPreferredSize(new Dimension(126, 254));
            super.setBackground(Color.PINK);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (int i = 0; i < eachSeat.length; i++) {
                for (int j = 0; j < eachSeat[i].length; j++) {
                    eachSeat[i][j].setBounds(i * 32, j * 32, 30, 30);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bus Booking Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(525, 480);
        frame.setLocationRelativeTo(null);

        BusBookingPanel bsgui = new BusBookingPanel();
        bsgui.setVisible(true);

        frame.add(bsgui);
        frame.setVisible(true);
    }
}
