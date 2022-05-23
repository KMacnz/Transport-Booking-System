package bookingsystem.layout;

import bookingsystem.util.Cart;
import bookingsystem.file.VehicleFiles;

public class SetReservation {

    static public Reserve reserveBus;
    static public Reserve reserveBoat;
    static public Reserve reserveTram;
    static public String busBooking;
    static public String boatBooking;
    static public String tramBooking;
    VehicleFiles vehicleFiles = new VehicleFiles();

    //goes to vehicle files and gets my seats from the files and stores them at the start of the project
    public void setUpReservations() {
        reserveBus = vehicleFiles.getSeats(new SeatLayout(8, 4), "./resources/Seatsbus.txt");
        reserveBoat = vehicleFiles.getSeats(new SeatLayout(7, 7), "./resources/Seatsboat.txt");
        reserveTram = vehicleFiles.getSeats(new SeatLayout(8, 3), "./resources/Seatstram.txt");
    }

    public void reserveBus(char bCol, int bRow) {
        boolean reserved = reserveBus.reserveSeat(new Row(bRow), new Column(bCol));
        busBooking = saveBus(busBooking, bRow, bCol);
        Cart.addBusCart();
    }

    public void reserveBoat(char btCol, int btRow) {
        boolean reserved = reserveBoat.reserveSeat(new Row(btRow), new Column(btCol));
        boatBooking = saveBus(boatBooking, btRow, btCol);
        Cart.addBoatCart();
    }

    public void reserveTram(char tCol, int tRow) {
        boolean reserved = reserveTram.reserveSeat(new Row(tRow), new Column(tCol));
        tramBooking = saveBus(tramBooking, tRow, tCol);
        Cart.addTramCart();
    }
    // saves the seat to a string and takes it to the add cart method
    public String saveBus(String busBooking, int bRow, char bCol) {
        busBooking = ("Bus (" + bRow + "," + bCol + ")");
        return busBooking;
    }

    // saves the seat to a string and takes it to the add cart method
    public String saveBoat(String boatBooking, int btRow, char btColumn) {
        boatBooking = ("Ferry (" + btRow + "," + btColumn + ")");
        return boatBooking;
    }

    // saves the seat to a string and takes it to the add cart method
    public String saveTram(String tramBooking, int tRow, char tColumn) {
        tramBooking = ("Tram (" + tRow + "," + tColumn + ")");
        return tramBooking;
    }
}
