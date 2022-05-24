package bookingsystem.util;

import bookingsystem.BookingSystem;
import bookingsystem.file.PrintRecipt;
import bookingsystem.layout.SetReservation;
import static bookingsystem.BookingSystem.saveData;
import java.util.Scanner;

public class Menus {

    static String transport;
    PrintRecipt printRecipt = new PrintRecipt();
    Log log = new Log();

    //prints main menu to CLI
    public void menu1() {
        //debug
        BookingSystem.getLog().addEntry("Function: menu1()");

        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("Would you like to");
        System.out.println("(a) Book a Tour with Us");
        System.out.println("(b) View past Orders");
        System.out.println("(c) View Log");
        System.out.println("(q) Quit Program");

        String userm1 = String.valueOf(scan.next().charAt(0));

        if (userm1.equalsIgnoreCase("a")) {
            menu2();

        } else if (userm1.equalsIgnoreCase("b")) {
            recipt();

        } else if (userm1.equalsIgnoreCase("c")) {
            log.getlog();

        } else if (userm1.equalsIgnoreCase("q")) {
            BookingSystem.running = false;

        } else {
            menu1();
        }
    }

    // prints menu 2 to CLI
    public void menu2() {
        //debug
        BookingSystem.getLog().addEntry("Function: menu2()");

        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("Choose Your Tour Type");
        System.out.println("(a) Tram");
        System.out.println("(b) Bus");
        System.out.println("(c) Ferry");
        System.out.println("(q) Quit Program");

        String userm2 = String.valueOf(scan.next().charAt(0));
        System.out.println("");

        // if tram is selected go to tram menu
        if (userm2.equalsIgnoreCase("a") || userm2.equalsIgnoreCase("t")) {
            transport = "tram";
            menuTram();

            // if bus is selected go to bus menu
        } else if (userm2.equalsIgnoreCase("b")) {
            transport = "bus";
            menuBus();

            // if boat is selected go to boat menu
        } else if (userm2.equalsIgnoreCase("c") || userm2.equalsIgnoreCase("f")) {
            transport = "boat";
            menuBoat();

        } else if (userm2.equalsIgnoreCase("q")) {
            BookingSystem.running = false;
        }

    }

    // asks user if they want to save the selected set
    public boolean menu3() {
        //debug
        BookingSystem.getLog().addEntry("Function: menu3()");

        Scanner scan = new Scanner(System.in);
        boolean save = false;

        if (transport.equals("tram")) {
            System.out.println("Save the seat " + SetReservation.tramBooking + "? (Y/N)");
            String userm3 = String.valueOf(scan.next().charAt(0));
            System.out.println("");

            if (!(userm3.equalsIgnoreCase("Y"))) {
                save = false;
            } else {
                save = true;
                saveData = true;
            }

        } else if (transport.equals("bus")) {

            System.out.println("Save the seat " + SetReservation.busBooking + "? (Y/N)");

            String userm3 = String.valueOf(scan.next().charAt(0));
            System.out.println("");

            if (!(userm3.equalsIgnoreCase("Y"))) {
                save = false;
            } else {
                save = true;
                saveData = true;
            }

        } else if (transport.equals("boat")) {

            System.out.println("Save the seat " + SetReservation.boatBooking + "? (Y/N)");
            String userm3 = String.valueOf(scan.next().charAt(0));
            System.out.println("");

            if (!(userm3.equalsIgnoreCase("Y"))) {
                save = false;
            } else {
                save = true;
                saveData = true;
            }
        }
        return save;
    }

    // prints menu 4 for final booking confirmation
    public void menu4() {
        //debug
        BookingSystem.getLog().addEntry("Function: menu4()");

        Scanner scan = new Scanner(System.in);
        System.out.println("Confirm your Booking (Y/N)");
        String userm4 = String.valueOf(scan.next().charAt(0));
        if ((userm4.equalsIgnoreCase("N"))) {
            saveData = false;
        } else if (!(userm4.equalsIgnoreCase("Y"))) {
            menu4();
        }
    }

    // take the user to the tram booking page
    public void menuTram() {
        System.out.println("Tram Booker");
        BookingSystem.setReservation.reserveTram();
    }

    // take the user to the bus booking page
    public void menuBus() {
        System.out.println("Bus Booker");
        BookingSystem.setReservation.reserveBus();
    }

    // take the user to the boat booking page
    public void menuBoat() {
        System.out.println("Ferry Booker");
        BookingSystem.setReservation.reserveBoat();
    }

     requests old id from user and then if it exists prints the booking info for that previous user
    public void recipt() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your previous ID number here: ");
        String id = scan.nextLine().trim();

        id = printRecipt.print(id);
    }
}
