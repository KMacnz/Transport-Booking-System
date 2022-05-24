package bookingsystem.file;

import bookingsystem.gui.StartPanel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class PrintRecipt extends Printer {

    //make hasmap
    public static HashMap<String, String> recipts;

    //read from file and save to hashmap
    @Override
    public String print(String id) {
        FileReader fr;
        BufferedReader br;

        if (recipts == null) {
            recipts = new HashMap<>();
        }

        try {
            fr = new FileReader("./resources/StoreRecipts.txt");
            br = new BufferedReader(fr);
            boolean EOF = false;

            while (!EOF) {
                String line = br.readLine();

                if (line != null) {
                    //splits the lime at the : and save each part to hashmap
                    String[] entry = line.trim().split(":");
                    String lineID = entry[0].trim();
                    String content = entry[1].trim();

                    // if user input id is equal to one of the ids in the hashmap 
                    if (lineID.equals(String.valueOf(id))) {
                        StartPanel.reciptPanel.reciptTxtFld.setText("ID: " + lineID + "\n" + content);

                    } else {
                        StartPanel.reciptPanel.reciptTxtFld.setText("ID does not exist");
                    }
                } else {
                    EOF = true;
                }
            }
            br.close();

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return "";
    }

//    @Override
//    //write to file if items from cart is saved
//    public void write() {
//
//        FileOutputStream fileoutput;
//        PrintWriter printwriter;
//
//        try {
//            fileoutput = new FileOutputStream("./resources/StoreRecipts.txt", true);
//            printwriter = new PrintWriter(fileoutput);
//
//            //write
//            printwriter.append("\n" + BookingSystem.id + " : ");
//            if (!Cart.boatCart.isEmpty()) {
//                printwriter.append(Cart.boatCart + " ");
//            }
//            if (!Cart.busCart.isEmpty()) {
//                printwriter.append(Cart.busCart + " ");
//            }
//            if (!Cart.tramCart.isEmpty()) {
//                printwriter.append(Cart.tramCart + "");
//            }
//
//            // close
//            printwriter.close();
//
//        } catch (IOException ex) {
//        }
//    }
//    //write out the cart items to CLI 
//    public void printRecipt() {
//        //debug
//        BookingSystem.getLog().addEntry("Function: printRecipt()");
//
//        System.out.println("");
//        System.out.println("----------------------------------");
//        System.out.println("     Here's your booking info     ");
//        System.out.println(("ID: " + BookingSystem.id));
//        if (!Cart.boatCart.isEmpty()) {
//            System.out.println(Cart.boatCart);
//        }
//        if (!Cart.busCart.isEmpty()) {
//            System.out.println(Cart.busCart);
//        }
//        if (!Cart.tramCart.isEmpty()) {
//            System.out.println(Cart.tramCart);
//        }
//        System.out.println("----------------------------------");
//    }
    @Override
    public void write() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
