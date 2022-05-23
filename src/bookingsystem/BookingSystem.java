//package bookingsystem;
//
//import bookingsystem.util.IdNum;
//import bookingsystem.util.Log;
//import bookingsystem.util.Menus;
//import bookingsystem.file.PrintRecipt;
//import bookingsystem.file.VehicleFiles;
//import bookingsystem.layout.SetReservation;
//
//public class BookingSystem {
//
//    public static boolean running = true;
//    public static int id;
//    public static boolean saveData = false;
//    public static SetReservation setReservation = new SetReservation();
//    public static Menus menus = new Menus();
//
//    private static Log log;
//
//    // log constructor
//    private static void setLogger() {
//        log = new Log();
//    }
//
//    public static Log getLog() {
//        return log;
//    }
//
//    public static void main(String[] args) {
//        setLogger();
//        PrintRecipt printRecipt = new PrintRecipt();
//
//        // setup seats from files
//        setReservation.setUpReservations();
//
//        //Get ID check it doesnt exist
//        id = IdNum.getNumber(id);
//
//        System.out.println("========================================");
//        System.out.println("  -Welcome To Our Tour Booking System-  ");
//
//        //keeps running program till quited
//        while (running) {
//            menus.menu1();
//        }
//        // asks user if they want to save the data if there is a booking been completed
//        if (saveData) {
//            printRecipt.printRecipt();
//            menus.menu4();
//            //if saved write everything to file
//            if (saveData) {
//                //save id to file
//                IdNum.saveId(id);
//                //save recipt to file
//                printRecipt.write();
//                System.out.println("Your Booking has been Saved");
//                VehicleFiles.setBusSeats("./resources/Seatsbus.txt");
//                VehicleFiles.setBoatSeats("./resources/Seatsboat.txt");
//                VehicleFiles.setTramSeats("./resources/Seatstram.txt");
//            }
//        }
//        // save logger entries to file
//        log.writelog();
//
//        System.out.println("");
//        System.out.println("       -Thank you for your vist-       ");
//        System.out.println("========================================");
//    }
//}
