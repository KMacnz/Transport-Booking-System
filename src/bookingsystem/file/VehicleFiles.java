package bookingsystem.file;

import bookingsystem.BookingSystem;
import bookingsystem.layout.Reserve;
import bookingsystem.layout.SeatLayout;
import bookingsystem.layout.SetReservation;
import bookingsystem.layout.Column;
import bookingsystem.layout.Row;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class VehicleFiles {

    // reads the file and saves the seats to the seatsLayout array with the reserved seats already reserved 
    public Reserve getSeats(SeatLayout seatLayout, String fileName) {
        //debug
//        BookingSystem.getLog().addEntry("Function: getSeats()");
        int filledSeats = 0;
        // add reserve var
        Reserve reserve = null;

        try {
            // create reservation
            reserve = new Reserve(seatLayout);

            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            boolean EOF = false;
            // initialise row counter
            int rowCount = 0;

            while (!EOF) {
                String line = br.readLine();

                if (line != null) {
                    String[] seats = line.split(":");
                    // iterate through each seat in row
                    for (int i = 0; i < seats.length; i++) {
                        // get seat char, remove [ and ]
                        String seatChar = seats[i].trim();
                        seatChar = seatChar.replace("[", "");
                        seatChar = seatChar.replace("]", "");

                        // if value is "X", reserve it
                        if (seatChar.equals("X")) {
                            reserve.reserveSeat(new Row(rowCount + 1), new Column((char) (65 + i)));
                            filledSeats++;
                        }
                    }
                    rowCount++;

                } else {
                    EOF = true;
                }
            }

            br.close();

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
        // if all the seats in the array are filled, a new empty seatlayout is made
        if (reserve != null) {
            if (seatLayout.getNumberOfRows() * seatLayout.getNumberOfColumns() == filledSeats) {
                reserve.setFilled(true);

                // fills each vehical seatlayout with the appropiate number of seats
                switch (fileName) {
                    case "./resources/Seatsbus.txt":
                        reserve = new Reserve(new SeatLayout(8, 4));
                        break;
                    case "./resources/Seatsboat.txt":
                        reserve = new Reserve(new SeatLayout(7, 7));
                        break;
                    case "./resources/Seatstram.txt":
                        reserve = new Reserve(new SeatLayout(10, 3));
                        break;
                    default:
                        break;
                }
            }
        }
        return reserve;
    }

    //writes the bus seatlayout to a file with ":" seperating each seat
    public static Reserve setBusSeats(String fileName) {
        //debug
//        BookingSystem.getLog().addEntry("Function: setBusSeats()");

        FileOutputStream fileoutput;
        PrintWriter pw;

        try {
            fileoutput = new FileOutputStream(fileName);
            pw = new PrintWriter(fileoutput);

            System.out.println(SetReservation.reserveBus);

            //write
            SeatLayout seatLayout = SetReservation.reserveBus.getSeatLayout();

            String finalLine = "";
            for (int i = 0; i < seatLayout.getNumberOfRows(); i++) {
                for (int j = 0; j < seatLayout.getNumberOfColumns(); j++) {
                    finalLine += seatLayout.getSeats()[i][j].toString();
                    if (j != seatLayout.getNumberOfColumns() - 1) {
                        finalLine += ":";
                    }
                }
                finalLine += "\n";
            }

            pw.write(finalLine);

            // close
            pw.close();

        } catch (IOException ex) {

        }
        return null;
    }

    //writes the boats seatlayout to a file with ":" seperating each seat
    public static Reserve setBoatSeats(String fileName) {
        //debug
//        BookingSystem.getLog().addEntry("Function: setBoatSeats()");

        FileOutputStream fileoutput;
        PrintWriter pw;

        try {
            fileoutput = new FileOutputStream(fileName);
            pw = new PrintWriter(fileoutput);

            System.out.println(SetReservation.reserveBoat);

            //write
            SeatLayout seatLayout = SetReservation.reserveBoat.getSeatLayout();

            String finalLine = "";
            for (int i = 0; i < seatLayout.getNumberOfRows(); i++) {
                for (int j = 0; j < seatLayout.getNumberOfColumns(); j++) {
                    finalLine += seatLayout.getSeats()[i][j].toString();
                    if (j != seatLayout.getNumberOfColumns() - 1) {
                        finalLine += ":";
                    }
                }
                finalLine += "\n";
            }

            pw.write(finalLine);

            // close
            pw.close();

        } catch (IOException ex) {

        }
        return null;
    }

    //writes the trams seatlayout to a file with ":" seperating each seat
    public static Reserve setTramSeats(String fileName) {
        //debug
//        BookingSystem.getLog().addEntry("Function: setTramSeats()");

        FileOutputStream fileoutput;
        PrintWriter pw;

        try {
            fileoutput = new FileOutputStream(fileName);
            pw = new PrintWriter(fileoutput);

            System.out.println(SetReservation.reserveTram);

            //write
            SeatLayout seatLayout = SetReservation.reserveTram.getSeatLayout();

            String finalLine = "";
            for (int i = 0; i < seatLayout.getNumberOfRows(); i++) {
                for (int j = 0; j < seatLayout.getNumberOfColumns(); j++) {
                    finalLine += seatLayout.getSeats()[i][j].toString();
                    if (j != seatLayout.getNumberOfColumns() - 1) {
                        finalLine += ":";
                    }
                }
                finalLine += "\n";
            }

            pw.write(finalLine);

            // close
            pw.close();

        } catch (IOException ex) {

        }
        return null;
    }
}
