package bookingsystem.seat;

import bookingsystem.layout.SeatPosition;

//poor seats extends seat / just another verion of seat
public class PoorSeat extends Seat {

    public PoorSeat(SeatPosition seatPosition) {
        super(seatPosition);
    }

    @Override
    public String seatType() {
        return "Regular";
    }
}
