package bookingsystem.seat;

import bookingsystem.layout.SeatPosition;

public abstract class Seat {

    private final SeatPosition position;
    //private boolean reserved;
    private boolean empty;

    public abstract String seatType();

    public Seat(SeatPosition position) {
        this.position = position;
        this.empty = true;
    }

    // Get method for the position variable
    public SeatPosition getPosition() {
        return this.position;
    }

    // Get method for the reserved variable
    public boolean isReserved() {
        return !(this.empty);
//        return !(this instanceof EmptySeat);
    }

//    // Set method for the reserved variable
    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public boolean empty() {
        return this.empty;
    }

    // if seat is reserved add an X into the returned brackets
    public String toString() {
        String taken = " ";

        if (!this.empty) {
            taken = "X";
        }
        return "[" + taken + "]";
    }
}
