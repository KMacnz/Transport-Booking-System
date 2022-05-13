package bookingsystem.seat;

import bookingsystem.layout.SeatPosition;

//EmptySeat seats extends seat / just another verion of seat - unreserved seats tho
public class EmptySeat extends Seat {

    public EmptySeat(SeatPosition seatPosition) {
        super(seatPosition);
    }

    @Override
    public String seatType() {
        return "Empty";
    }

}
