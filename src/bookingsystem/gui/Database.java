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

            //REMOVE ONCE DONE
//            statement.executeUpdate("DROP TABLE userInfo");

            if (!checkTableExisting("userInfo")) {
                statement.executeUpdate("CREATE TABLE userInfo(userid INTEGER, bus VARCHAR(100), boat VARCHAR(100), tram VARCHAR(100))");
                System.out.println("Create Table userInfo");
            }

            statement.executeUpdate("INSERT INTO userInfo VALUES(123456, '4,D : 6,B', '7,F', '8,B : 5,C')");
            statement.executeUpdate("INSERT INTO userInfo VALUES(987654, '2,A : 2,C', '2,B : 3,C : 6,A', '2,A : 3,B')");
            System.out.println("Insert data");

            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean checkID(int id) {
        boolean exists = false;

        try {
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT userid FROM userInfo");
            while (rs.next()) {
                String userNum = rs.getString("userid");
                System.out.println("ID " + userNum);
                exists = (Integer.valueOf(userNum) == id);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return exists;
    }

    public int getNumber() {
        Random rand = new Random();
        id = rand.nextInt(1000000 - 100000) + 100000;

        //if it already exists it generates a new number
        while (checkID(id)) {
            id = rand.nextInt(1000000 - 100000) + 100000;
        }
        return id;
    }

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

                System.out.println("Row: " + userbus);

                String[] seatChar = userbus.split(": ");
                for (String eachseat : seatChar) {
                    System.out.println(eachseat);

                    String[] eachSeatChar = eachseat.split(",");
                    int row = Integer.valueOf(String.valueOf(eachSeatChar[0]));;
                    char col = eachSeatChar[1].charAt(0);

                    System.out.println("row: " + row + " col: " + col);
                    reserve.reserveSeat(new Row(row), new Column(col));
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

                System.out.println("Row: " + userboat);

                String[] seatChar = userboat.split(": ");
                for (String eachseat : seatChar) {
                    System.out.println(eachseat);

                    String[] eachSeatChar = eachseat.split(",");
                    int row = Integer.valueOf(String.valueOf(eachSeatChar[0]));;
                    char col = eachSeatChar[1].charAt(0);

                    System.out.println("row: " + row + " col: " + col);
                    reserve.reserveSeat(new Row(row), new Column(col));
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

                System.out.println("Row: " + usertram);

                String[] seatChar = usertram.split(": ");
                for (String eachseat : seatChar) {
                    System.out.println(eachseat);

                    String[] eachSeatChar = eachseat.split(",");
                    int row = Integer.valueOf(String.valueOf(eachSeatChar[0]));;
                    char col = eachSeatChar[1].charAt(0);

                    System.out.println("row: " + row + " col: " + col);
                    reserve.reserveSeat(new Row(row), new Column(col));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return reserve;
    }

    public void saveData(String busdata, String boatdata, String tramdata) {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO userInfo VALUES(" + id + ", '" + busdata + "', '" + boatdata + "', '" + tramdata + "')");

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void seeData() {
        try {
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM userInfo");

            while (rs.next()) {
                int userNum = rs.getInt("userid");
                String userbus = rs.getString("bus");
                String userboat = rs.getString("boat");
                String usertram = rs.getString("tram");

                System.out.println("ID: " + userNum + " Bus: " + userbus + " Boat: " + userboat + " Tram: " + usertram);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
