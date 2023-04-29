package org.example.passenger;

import org.example.seat.Seat;
import org.example.space.Pluto;

public abstract class Passenger {
    private final String name;
    private boolean hasBookedSeat;
    private Seat passengerSeat;
    protected Passenger(String name){
        this.name = name;
        }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Passenger " + name;
    }

    public abstract Pluto plutoBelief();

    public Seat getPassengerSeat() {
        return passengerSeat;
    }

    public void setPassengerSeat(Seat passengerSeat) {
        this.passengerSeat = passengerSeat;
    }
    public abstract String alienSpecie();
}

