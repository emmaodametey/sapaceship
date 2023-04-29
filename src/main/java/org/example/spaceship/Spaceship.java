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
    private final int humanCapacity;
    private final int martianCapacity;
    private int nextFreeSeatForHuman;
    private int nextFreeSeatForMartian;
    private int availableSeats;
    private List<Passenger> flightList;

    public Spaceship(int humanCapacity, int martianCapacity){
        this.capacity = humanCapacity + martianCapacity;
        this.humanCapacity = humanCapacity;
        this.martianCapacity = martianCapacity;
        createSpaceshipSeats();
        availableSeats = capacity;
        nextFreeSeatForMartian = humanCapacity;
        flightList = new ArrayList<>();
    }

    private void createSpaceshipSeats(){
        seats = new ArrayList<>(capacity);
        for(int i = 0; i < humanCapacity; i++){
            seats.add(new HumanSeat(i+1));

        }

        for(int i = humanCapacity; i < capacity; i++){
            seats.add(new MartianSeat(i+1));

        }
    }


    public void book(Passenger passenger) throws SpaceshipFullException {
        if (passenger instanceof Human && nextFreeSeatForHuman < humanCapacity ){
                seats.get(nextFreeSeatForHuman).setPassenger(passenger);
                seats.get(nextFreeSeatForHuman).setBooked(true);
                nextFreeSeatForHuman ++;
        }
        else if (passenger instanceof Martian && nextFreeSeatForMartian < capacity ){
                seats.get(nextFreeSeatForMartian).setPassenger(passenger);
                seats.get(nextFreeSeatForMartian).setBooked(true);
                nextFreeSeatForMartian ++;
        }
        else{
            throw new SpaceshipFullException("Spaceship at capacity for " + passenger.alienSpecie());
        }
        flightList.add(passenger);
        availableSeats--;
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

    public int getAvailableSeats() {
        return availableSeats;
    }

    public List<Passenger> flightlistOfSpaceship(){
        return flightList;
    }

    public String serveMeal(Seat seat) throws SeatIsEmptyException {
        try{
            if(seat.getBooked()){
                return seat.serveMeal();
            }
        }catch (NullPointerException e){
            throw new SeatIsEmptyException("Passenger not on flight or seat does not exist");
        }

        throw new SeatIsEmptyException("Cannot serve meal to an Empty seat");
    }

}
