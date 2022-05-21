package bookingsystem.layout;

import bookingsystem.BookingSystem;
import bookingsystem.seat.PoorSeat;
import bookingsystem.seat.PremiumSeat;
import bookingsystem.seat.Seat;
import javax.swing.JPanel;

public class SeatLayout {

    private final char OFFSET_LETTER = 'A';
    private final int numberOfRows;
    private final int numberOfColumns;
    private Seat[][] seats;

    //takes input and sets the number of rows and columns
    public SeatLayout(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.initialise();
    }

    private void initialise() {
        //debug
//        BookingSystem.getLog().addEntry("Function: initialise()");

        this.seats = new Seat[this.numberOfRows][this.numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                SeatPosition position = translate(i, j);
                Seat seat;
                if (i < ((int) ((numberOfRows) / 2))) {
                    seat = new PremiumSeat(position);
                } else {
                    seat = new PoorSeat(position);
                }
                this.seats[i][j] = seat;
            }
        }
    }

    /*
    translate(0,0) returns Row = 1 and Column = 'A'
    translate(1,2) returns Row = 2 and Column = 'B'
     */
    private SeatPosition translate(int i, int j) {
        return new SeatPosition(new Row(i + 1), new Column((char) (j + OFFSET_LETTER)));
    }

    /*
    translate(1) = 0
    translate(2) = 1
     */
    private int translate(Row row) {
        return row.getNumber() - 1;
    }

    /*
    translate('A') = 0
    translate('B') = 1
     */
    private int translate(Column column) {
        return column.getLetter() - 65;
    }

    // if the postion exists returns the seat otherwise returns null
    public Seat getSeat(SeatPosition p) {
        if ((translate(p.getRow()) < numberOfRows) && (translate(p.getColumn()) < numberOfColumns)) {
            return seats[translate(p.getRow())][translate(p.getColumn())];
        } else {
            return null;
        }
    }

    // returns string that repesents the seats
    public String toString() {
        String finalText = "";
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                finalText += seats[i][j].toString();
            }
            finalText += "\n";
        }

        return finalText;
    }

    // get method for seats
    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    // returns the row of seat objects
    public Seat[] getRowOfSeats(Row row) {
        Seat[] output = new Seat[numberOfColumns];
        if (translate(row) < numberOfRows && translate(row) >= 0) {
            for (int i = 0; i < numberOfColumns; i++) {
                output[i] = this.seats[translate(row)][i];
            }
        } else {
            output = new Seat[0];
        }
        return output;
    }

    // returns the column of seat objects
    public Seat[] getColumnOfSeats(Column column) {
        Seat[] output = new Seat[numberOfRows];
        if (translate(column) < numberOfColumns && translate(column) >= 0) {
            for (int i = 0; i < numberOfRows; i++) {
                output[i] = this.seats[i][translate(column)];
            }
        } else {
            output = new Seat[0];
        }
        return output;
    }

    // get method for the number of rows
    public int getNumberOfRows() {
        return this.numberOfRows;
    }

    // get method for the number of columns
    public int getNumberOfColumns() {
        return this.numberOfColumns;
    }

    // counts the number of unreserved seats
    public int getAvailableAmount() {
        int output = 0;
        for (int i = 0; i < this.numberOfRows; i++) {
            for (int j = 0; j < this.numberOfColumns; j++) {
                if (!this.seats[i][j].isReserved()) {
                    output++;
                }
            }
        }
        return output;
    }
}
