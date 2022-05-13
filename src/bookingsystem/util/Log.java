package bookingsystem.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class Log {

    private final HashSet<String> log;

    //add the log to a hashset to make storing easier
    public Log() {
        this.log = new HashSet<>();
    }

    public void addEntry(String entry) {
        log.add(entry);
    }

    // write out the log of what methods, from the hashset with the timestamps from the current run of the project
    public void writelog() {
        FileOutputStream fileoutput;
        PrintWriter pw;
        //get the time/date and format it in the way wanted
        LocalDateTime lDT = LocalDateTime.now();
        DateTimeFormatter fObject = DateTimeFormatter.ofPattern("HH:mm dd-MM-yy");
        String fLDT = lDT.format(fObject);

        try {
            fileoutput = new FileOutputStream("./resources/Logger.txt", true);
            pw = new PrintWriter(fileoutput);

            //write
            pw.append("----------------------------------\n");
            for (String entry : log) {
                pw.append(entry + " " + fLDT + "\n");
            }
            // close
            pw.close();

        } catch (IOException ex) {

        }
    }

    // prints out the whole log of what methods are being called with the timestamps they were saved with
    public void getlog() {
        FileReader fr;
        BufferedReader br;

        try {
            fr = new FileReader("./resources/Logger.txt");
            br = new BufferedReader(fr);
            boolean EOF = false;

            while (!EOF) {
                String line = br.readLine();

                if (line != null) {
                    System.out.println(line);

                } else {
                    EOF = true;
                }
            }

            br.close();

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }
}
