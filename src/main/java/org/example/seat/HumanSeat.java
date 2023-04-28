package org.example.seat;

import org.example.passenger.Passenger;

public class HumanSeat extends Seat{

    public HumanSeat(int id) {
        super(id);
    }

    @Override
    public String serveMeal() {
        return "Human meal";
    }

    @Override
    public String toString() {
        return "Human Seat";
    }
}
