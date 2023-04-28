package org.example.spaceship;

import org.example.passenger.Human;
import org.example.passenger.Martian;
import org.example.passenger.Passenger;
import org.example.seat.HumanSeat;
import org.example.seat.MartianSeat;
import org.example.seat.Seat;

import java.util.ArrayList;
import java.util.List;

public class Spaceship {
    private List<Seat> seats;
    private final int capacity;
    private final int humancapacity;
    private final int martiancapacity;
    private int nextFreeSeatForHuman;
    private int nextFreeSeatForMartian;

    public Spaceship(int humancapacity, int martiancapacity){
        this.capacity = humancapacity + martiancapacity;
        this.humancapacity = humancapacity;
        this.martiancapacity = martiancapacity;
        createSpaceshipSeats();
        nextFreeSeatForMartian = humancapacity;
    }

    private void createSpaceshipSeats(){
        seats = new ArrayList<>(capacity);
        for(int i = 0; i < humancapacity; i++){
            seats.add(new HumanSeat(i));

        }

        for(int i = humancapacity; i < capacity; i++){
            seats.add(new MartianSeat(i));

        }
    }

    public void bookSeat(Passenger passenger) {
        for (Seat seat : seats) {
            if (passenger instanceof Human && seat instanceof HumanSeat ) {
                seat.setPassenger(passenger);
                seat.setBooked(true);
            } else if (passenger instanceof Martian && seat instanceof MartianSeat) {
                seat.setPassenger(passenger);
                seat.setBooked(true);
            }
        }
    }
    public void book(Passenger passenger) {
        if (passenger instanceof Human ){
            if(nextFreeSeatForHuman < humancapacity){
                seats.get(nextFreeSeatForHuman).setPassenger(passenger);
                nextFreeSeatForHuman ++;}
            else{
                System.out.println("plane full for humans");
            }
        }
        if (passenger instanceof Martian ){

            if(nextFreeSeatForMartian < capacity){
                seats.get(nextFreeSeatForMartian).setPassenger(passenger);
                nextFreeSeatForMartian ++;
            }
            else{
                System.out.println("spaceship full for martians");
            }

        }
    }



    public Seat getSeatType(Passenger passenger){
        for(Seat seat: seats){
            if(seat.getPassenger() == passenger){
                return seat;
            }
        }
        return null;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Passenger> flightlist(){
        List <Passenger> flightlist = new ArrayList();
        for(Seat seat: seats){
           if(seat.getBooked()) flightlist.add(seat.getPassenger());
        }
        return flightlist;
    }

}
