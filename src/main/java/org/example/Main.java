package org.example;

import org.example.passenger.Human;
import org.example.passenger.Martian;
import org.example.passenger.Passenger;
import org.example.spaceship.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Passenger human1 = new Human( "Emma");
        Passenger human2 = new Human( "Rose");
        Passenger human3 = new Human( "Judah");
        Passenger human4 = new Human( "Ana");
        Passenger martian1 = new Martian("Ekow");
        Passenger martian2 = new Martian("Debbie");
        Passenger martian3 = new Martian("Elisha");

        List<Passenger> passengers = new ArrayList<>();
        passengers.add(human1);
        passengers.add(human2);
        passengers.add(human3);
        passengers.add(human4);
        passengers.add(human4);
        passengers.add(human4);
        passengers.add(martian1);
        passengers.add(martian2);
        passengers.add(martian3);

        Spaceship zura = new Spaceship(5,3);

        for(Passenger passenger : passengers){
            try{
                zura.book(passenger);
            } catch (SpaceshipFullException h){
                System.out.println(h.getMessage());
            }
            System.out.println("the seat booked for " + passenger + " is "+ zura.getSeatType(passenger));
        }

            try{
                zura.book(martian1);
            } catch (SpaceshipFullException h){
                System.out.println(h.getMessage());
            }

//        System.out.println(zura.getSeatType(martian1).getID());
//        for(Seat seat : zura.getSeats()){
//            System.out.println("the meal served to " +  seat + " is " + seat.serveMeal());
//        }


//        System.out.println("the seat booked for " + martian + " is "+ zura.getSeatType(martian));
//        zura.bookSeat(human);
//        System.out.println("the seat booked for " + human + " is "+ zura.getSeatType(human));
//        Seat seat = zura.getSeatType(human);
//        System.out.println("the meal served to " + seat + " is " + seat.serveMeal());




//        Pluto pluto = new Pluto();

//        System.out.println(human.plutoBelief(pluto));



    }


}