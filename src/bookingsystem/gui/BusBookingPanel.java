package bookingsystem.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class BusBookingPanel extends JPanel {

    private final DrawPanel drawPanel;
    public JButton[][] eachSeat;
    private final GridBagConstraints grid = new GridBagConstraints();
    public JTextField seatTxtFld;

    public BusBookingPanel() {
        drawPanel = new DrawPanel();

        // repaint the panel
        drawPanel.repaint();

        //initialize elements
        eachSeat = new JButton[4][8];
        for (int i = 0; i < eachSeat.length; i++) {
            for (int j = 0; j < eachSeat[i].length; j++) {
                eachSeat[i][j] = new JButton();
                drawPanel.add(eachSeat[i][j]);

                String a = "Seat: (" + String.valueOf(((char) (65 + i))) + ", " + (j + 1) + ")";
                eachSeat[i][j].addActionListener(e -> {
                    seatTxtFld.setText(a);
                });
            }
        }

        JPanel endPanel = new JPanel(new GridBagLayout());
        JPanel seatPanel = new JPanel();
        seatPanel.setLayout(new FlowLayout());
        super.add(endPanel);

        //Bus Label 
        JLabel busLabel = new JLabel("Choose your Seats");
        grid.gridx = 1;
        grid.gridy = 1;
        grid.ipady = 50;
        endPanel.add(busLabel, grid);

        busLabel.setFont(new java.awt.Font("Kannada MN", 1, 24));
        busLabel.setForeground(new java.awt.Color(0, 0, 0));
        busLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        //Seat Text Area 
        seatTxtFld = new JTextField();
        seatTxtFld.setEditable(false);
        seatTxtFld.setFont(new java.awt.Font("Monospaced", 0, 15));
        seatTxtFld.setText("Seat:");
        seatTxtFld.setPreferredSize(new Dimension(175, 100));
        seatTxtFld.setHorizontalAlignment(JTextField.CENTER);

        seatPanel.add(drawPanel);
        seatPanel.add(Box.createHorizontalStrut(50));
        seatPanel.add(seatTxtFld);

        grid.gridx = 1;
        grid.gridy = 2;
        endPanel.add(seatPanel, grid);
    }

    public class DrawPanel extends JPanel {

        public DrawPanel() {
            super.setPreferredSize(new Dimension(175, 355));
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
