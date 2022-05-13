package bookingsystem.layout;

import bookingsystem.layout.SeatLayout;
import bookingsystem.layout.SeatPosition;
import bookingsystem.layout.Row;
import bookingsystem.layout.Column;

public class Reserve {

    private final SeatLayout seatLayout;
    private boolean isFilled;

    public SeatLayout getSeatLayout() {
        return this.seatLayout;
    }

    // reserves according to row and column returns true if reserves successful
    public boolean reserveSeat(Row row, Column column) {
        if ((this.seatLayout.getColumnOfSeats(column).length > 0) && (this.seatLayout.getRowOfSeats(row).length > 0)) {
            if (!this.seatLayout.getSeat(new SeatPosition(row, column)).isReserved()) {
                this.seatLayout.getSeat(new SeatPosition(row, column)).setEmpty(false);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public Reserve(SeatLayout seatLayout) {
        this.seatLayout = seatLayout;
        this.isFilled = false;
    }

    // prints out the seats
    public String toString() {
        String total = "";
        total += "----------------------------------\n";
        total += this.seatLayout.toString().trim() + "\n";
        total += "----------------------------------\n";

        return total;
    }

    public boolean getFilled() {
        return this.isFilled;
    }

    public void setFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

}
