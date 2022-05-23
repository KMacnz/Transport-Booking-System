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
        reserveTram = vehicleFiles.getSeats(new SeatLayout(10, 3), "./resources/Seatstram.txt");
    }

    public void reserveBus(char bCol, int bRow) {
        boolean reserved = reserveBus.reserveSeat(new Row(bRow), new Column(bCol));

        // if the seat is already reserved print message for user and prompt them to choose another
        if (!reserved) {
            System.out.println("\nThis seat is already taken!");
        } else {

            busBooking = saveBus(busBooking, bRow, bCol);
            Cart.addBusCart();

        }
    }

//    public void reserveBoat() {
//        //debug
//        BookingSystem.getLog().addEntry("Function: ReserveBoat()");
//
//        //print out seatlayout so users can see what seats are free
//        System.out.println(reserveBoat);
//        Scanner scanner = new Scanner(System.in);
//
//        try {
//            System.out.println("Enter a row number (1-7)");
//            int btRow = scanner.nextInt();
//
//            System.out.println("Enter a column number (A-G)");
//            char btColumn = scanner.next().charAt(0);
//            btColumn = Character.toUpperCase(btColumn);
//
//            // check for valid input
//            if (!((btRow >= 1 && btRow <= 7) && (btColumn >= 'A' && btColumn <= 'G'))) {
//                System.out.println("Not a valid Seat! Please choose a seat in the range");
//                reserveBoat();
//            } else {
//                // if valid asks user if they want to select that seat and save
//                boatBooking = saveBoat(boatBooking, btRow, btColumn);
//                boolean userSaved = BookingSystem.menus.menu3();
//
//                // if saved set the seat to reserved
//                if (userSaved) {
//                    boolean reserved = reserveBoat.reserveSeat(new Row(btRow), new Column(btColumn));
//
//                    // if the seat is already reserved print message for user and prompt them to choose another
//                    if (!reserved) {
//                        System.out.println("\nThis seat is already taken!");
//                        reserveBoat();
//                    } else {
//                        Cart.addBoatCart();
//                    }
//                    // print out new updated seatlayout
//                    System.out.println(reserveBoat);
//                }
//            }
//        } catch (InputMismatchException e) {
//            System.out.println("Please enter a valid number");
//        }
//    }
//
//    public void reserveTram() {
//        //debug
//        BookingSystem.getLog().addEntry("Function: ReserveTram()");
//
//        //print out seatlayout so users can see what seats are free
//        System.out.println(reserveTram);
//        Scanner scanner = new Scanner(System.in);
//
//        try {
//            System.out.println("Enter a row number (1-10)");
//            int tRow = scanner.nextInt();
//
//            System.out.println("Enter a column number (A-C)");
//            char tColumn = scanner.next().charAt(0);
//            tColumn = Character.toUpperCase(tColumn);
//
//            // check for valid input
//            if (!((tRow >= 1 && tRow <= 10) && (tColumn >= 'A' && tColumn <= 'C'))) {
//                System.out.println("Not a valid Seat! Please choose a seat in the range");
//                reserveTram();
//            } else {
//                // if valid asks user if they want to select that seat and save
//                tramBooking = saveTram(tramBooking, tRow, tColumn);
//                boolean userSaved = BookingSystem.menus.menu3();
//                // if saved set the seat to reserved
//                if (userSaved) {
//                    boolean reserved = reserveTram.reserveSeat(new Row(tRow), new Column(tColumn));
//
//                    // if the seat is already reserved print message for user and prompt them to choose another
//                    if (!reserved) {
//                        System.out.println("\nThis seat is already taken!");
//                        reserveTram();
//                    } else {
//                        Cart.addTramCart();
//                    }
//                    // print out new updated seatlayout
//                    System.out.println(reserveTram);
//                }
//            }
//        } catch (InputMismatchException e) {
//            System.out.println("Please enter a valid number");
//        }
//    }
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
