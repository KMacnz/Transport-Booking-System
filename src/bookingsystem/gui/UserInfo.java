package bookingsystem.gui;

import java.sql.*;
import java.util.Random;

public class UserInfo {

    private static final String URL = "jdbc:derby:BookingSys_Ebd; create=true";
    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc";
    public static int id;
    
    private Connection conn;

    public void dbsetup() {
        try {
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement statement = conn.createStatement();

            //REMOVE ONCE DONE
//            statement.executeUpdate("DROP TABLE userInfo");

            if (!checkTableExisting("userInfo")) {
                statement.executeUpdate("CREATE TABLE userInfo(userid INTEGER, seats VARCHAR(100))");
                System.out.println("Create Table userInfo");
            }

            statement.executeUpdate("INSERT INTO userInfo VALUES(1, 'testytest')");
            statement.executeUpdate("INSERT INTO userInfo VALUES(2, 'testttttt')");
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
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return exists;
    }
    
    public void close() {
        try {
            if (this.conn != null) {
                conn.close();
            }
        } catch(SQLException e) {
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
        System.out.println(id);
        return id;
    }

    public void saveData(String booking) {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO UserInfo " + "VALUES(" + id + ", '" + booking + "')");
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }
    
    
    
    
    
    public static void main(String[] args){
        UserInfo dbManager = new UserInfo();

        System.out.println("SETTING UP DATABASE");
        dbManager.dbsetup();
        System.out.println("\nCHECKING ID");
        dbManager.getNumber();
        System.out.println("\nSave ID");
        dbManager.saveData("amongus");
        System.out.println("\nCHECKING ID");
        dbManager.getNumber();
        
        dbManager.close();
    }
}
