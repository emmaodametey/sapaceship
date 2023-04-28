package org.example.seat;

import org.example.passenger.Passenger;

public abstract class Seat {
    private boolean booked;
    private int ID;
    private Passenger passenger;


    protected Seat(int ID){
        this.ID = ID;
    }

    public abstract String serveMeal();

    public boolean getBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public int getID() {
        return ID;
    }
}
