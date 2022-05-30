package bookingsystem.layout;

import bookingsystem.Cart;
import bookingsystem.gui.Database;

public class SetReservation {

    static public Reserve reserveBus;
    static public Reserve reserveBoat;
    static public Reserve reserveTram;
    static public String busBooking;
    static public String boatBooking;
    static public String tramBooking;

    //goes to vehicle files and gets my seats from the files and stores them at the start of the project
    public void setUpReservations() {
        Database dbManager = new Database();
        reserveBus = dbManager.getBusSeats(new SeatLayout(8, 4));
        reserveBoat = dbManager.getBoatSeats(new SeatLayout(7, 7));
        reserveTram = dbManager.getTramSeats(new SeatLayout(8, 3));
    }

    public void reserveBus(char bCol, int bRow) {
        boolean reserved = reserveBus.reserveSeat(new Row(bRow), new Column(bCol));
        busBooking = saveBus(busBooking, bRow, bCol);
        Cart.addBusCart();
    }

    public void reserveBoat(char btCol, int btRow) {
        boolean reserved = reserveBoat.reserveSeat(new Row(btRow), new Column(btCol));
        boatBooking = saveBoat(boatBooking, btRow, btCol);
        Cart.addBoatCart();
    }

    public void reserveTram(char tCol, int tRow) {
        boolean reserved = reserveTram.reserveSeat(new Row(tRow), new Column(tCol));
        tramBooking = saveTram(tramBooking, tRow, tCol);
        Cart.addTramCart();
    }

    // saves the seat to a string and takes it to the add cart method
    public String saveBus(String busBooking, int bRow, char bCol) {
        busBooking = ("(" + bRow + "," + bCol + ")");
        return busBooking;
    }

    // saves the seat to a string and takes it to the add cart method
    public String saveBoat(String boatBooking, int btRow, char btColumn) {
        boatBooking = ("(" + btRow + "," + btColumn + ")");
        return boatBooking;
    }

    // saves the seat to a string and takes it to the add cart method
    public String saveTram(String tramBooking, int tRow, char tColumn) {
        tramBooking = ("(" + tRow + "," + tColumn + ")");
        return tramBooking;
    }
}
