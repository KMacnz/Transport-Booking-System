package bookingsystem.seat;

import bookingsystem.layout.SeatPosition;

//premium seats extends seat / just another verion of seat
public class PremiumSeat extends Seat {

    public PremiumSeat(SeatPosition seatPosition) {
        super(seatPosition);
    }

    @Override
    public String seatType() {
        return "Premium";
    }
}
