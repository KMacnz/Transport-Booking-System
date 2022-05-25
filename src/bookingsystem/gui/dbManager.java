package bookingsystem.gui;

import java.sql.*;

public class dbManager {

    private static final String URL = "jdbc:derby://localhost:1527/BookingSys";
    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc";

    Connection conn;

    public dbManager() {
        establishConnection();
    }

    public static void main(String[] args) {
        dbManager dbManager = new dbManager();
        System.out.println(dbManager.getConnection());
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " Get Connected Successfully ....");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
