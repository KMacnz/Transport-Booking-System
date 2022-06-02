package bookingsystem.gui;

import bookingsystem.layout.Column;
import bookingsystem.layout.Reserve;
import bookingsystem.layout.Row;
import bookingsystem.layout.SeatLayout;
import java.sql.*;
import java.util.Random;

public class Database {

    private static final String URL = "jdbc:derby:BookingSys_Ebd; create=true";
    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc";
    public static int id;

    public static Connection conn;

    public void dbsetup() {
        try {
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement statement = conn.createStatement();

            // check if table exists
            if (!checkTableExisting("userInfo")) {
                statement.executeUpdate("CREATE TABLE userInfo(userid INTEGER, bus VARCHAR(100), boat VARCHAR(150), tram VARCHAR(100))");
            }
            statement.close();

        } catch (SQLException ex) {
        }
    }

    private boolean checkTableExisting(String tableName) {
        boolean exists = false;
        try {
            ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null);
            while (rs.next()) {
                String tName = rs.getString("TABLE_NAME");

                if (tName != null && tName.equals(tableName)) {
                    exists = true;
                    break;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return exists;
    }

    // close the database connection
    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // go through the database and check the generated id doesnt match another users one
    private boolean checkID(int id) {
        boolean exists = false;

        try {
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT userid FROM userInfo");
            while (rs.next()) {
                String userNum = rs.getString("userid");
                exists = (Integer.valueOf(userNum) == id);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return exists;
    }

    // generate the random number
    public int getNumber() {
        Random rand = new Random();
        id = rand.nextInt(1000000 - 100000) + 100000;

        //if it already exists it generates a new number
        while (checkID(id)) {
            id = rand.nextInt(1000000 - 100000) + 100000;
        }
        return id;
    }

    // print all the databases info if the id entered matches an id on the table
    public void printRecipt(int oldID) {

        try {
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM userInfo WHERE userid = " + oldID);

            int size = 0;

            while (rs.next()) {
                int userNum = rs.getInt("userid");
                String userbus = rs.getString("bus");
                String userboat = rs.getString("boat");
                String usertram = rs.getString("tram");

                StartPanel.reciptPanel.reciptTxtFld.setText("ID: " + userNum + " \n\nBus: " + userbus + "\nBoat: " + userboat + "\nTram: " + usertram);
                size++;
            }

            if (size == 0) {
                StartPanel.reciptPanel.reciptTxtFld.setText("ID does not exist");
            }

            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Reserve getBusSeats(SeatLayout seatLayout) {

        Reserve reserve = null;

        try {
            // create reservation
            reserve = new Reserve(seatLayout);

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT bus FROM userInfo");

            while (rs.next()) {
                String userbus = rs.getString("bus");

                String[] seatChar = userbus.split(": ");
                for (String eachseat : seatChar) {

                    if (!eachseat.equals("null")) {
                        // splits the string up so row holds the rows and col holds the columns
                        String[] eachSeatChar = eachseat.split(",");
                        int row = Integer.valueOf(String.valueOf(eachSeatChar[0]));
                        char col = eachSeatChar[1].charAt(0);

                        // reserve the seats 
                        reserve.reserveSeat(new Row(row), new Column(col));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return reserve;
    }

    public Reserve getBoatSeats(SeatLayout seatLayout) {

        Reserve reserve = null;

        try {
            // create reservation
            reserve = new Reserve(seatLayout);

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT boat FROM userInfo");

            while (rs.next()) {
                String userboat = rs.getString("boat");

                String[] seatChar = userboat.split(": ");
                for (String eachseat : seatChar) {

                    if (!eachseat.equals("null")) {
                        // splits the string up so row holds the rows and col holds the columns
                        String[] eachSeatChar = eachseat.split(",");
                        int row = Integer.valueOf(String.valueOf(eachSeatChar[0]));;
                        char col = eachSeatChar[1].charAt(0);

                        // reserve the seats 
                        reserve.reserveSeat(new Row(row), new Column(col));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return reserve;
    }

    public Reserve getTramSeats(SeatLayout seatLayout) {

        Reserve reserve = null;

        try {
            // create reservation
            reserve = new Reserve(seatLayout);

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT tram FROM userInfo");

            while (rs.next()) {
                String usertram = rs.getString("tram");

                String[] seatChar = usertram.split(": ");
                for (String eachseat : seatChar) {

                    if (!eachseat.equals("null")) {
                        // splits the string up so row holds the rows and col holds the columns
                        String[] eachSeatChar = eachseat.split(",");
                        int row = Integer.valueOf(String.valueOf(eachSeatChar[0]));;
                        char col = eachSeatChar[1].charAt(0);

                        // reserve the seats 
                        reserve.reserveSeat(new Row(row), new Column(col));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return reserve;
    }
    
    // save the id data into the database when saved is clicked
    public void saveID() {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO userInfo (userid) VALUES(" + id + ")");
            System.out.println("ID Saved");

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    // save the bus data into the database when saved is clicked
    public void saveBus(String busdata) {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE userInfo SET bus = '" + busdata + "' WHERE userid = " + id);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    // save the boat data into the database when saved is clicked
    public void saveBoat(String boatdata) {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE userInfo SET boat = '" + boatdata + "' WHERE userid = " + id);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    // save the tram data into the database when saved is clicked
    public void saveTram(String tramdata) {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE userInfo SET tram = '" + tramdata + "' WHERE userid = " + id);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
