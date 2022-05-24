package bookingsystem.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class IdNum {

    //sorts through the file to check if the id number already exists
    public static boolean getId(int id) {
        FileReader fr;
        BufferedReader br;
        boolean exists = false;

        try {
            fr = new FileReader("./resources/IDnumbers.txt");
            br = new BufferedReader(fr);
            boolean EOF = false;

            while (!EOF) {
                String line = br.readLine();

                if (line != null) {
                    int checkId = Integer.parseInt(line.split(" ")[0]);
                    exists = (checkId == id);

                } else {
                    EOF = true;
                }
            }

            br.close();

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
        return exists;
    }

    // when called get a 6 digit id number
    public static int getNumber(int id) {
        Random rand = new Random();
        id = rand.nextInt(1000000 - 100000) + 100000;

        //if it already exists it generates a new number
        while (getId(id)) {
            System.out.println(getId(id));
            id = rand.nextInt(1000000 - 100000) + 100000;
        }

        return id;
    }

    // appends the idnumber file and adds the new ID to the bottom if saved
    public static void saveId(int id) {

        FileOutputStream fileoutput;
        PrintWriter pw;

        try {
            fileoutput = new FileOutputStream("./resources/IDnumbers.txt", true);
            pw = new PrintWriter(fileoutput);

            //write
            pw.append(id + "\n");
            // close
            pw.close();

        } catch (IOException ex) {

        }
    }

}
