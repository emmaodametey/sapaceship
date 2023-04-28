package org.example.seat;

import org.example.passenger.Passenger;

public class MartianSeat extends Seat{

    public MartianSeat(int id) {
        super(id);
    }

    @Override
    public String serveMeal() {
        return "Martian meal";
    }

    @Override
    public String toString() {
        return "Martian Seat";
    }
}


