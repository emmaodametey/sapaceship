package org.example.spaceship;

import org.assertj.core.api.Assertions;
import org.example.passenger.Human;
import org.example.passenger.Martian;
import org.example.passenger.Passenger;
import org.example.space.Pluto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SpaceshipTest {
    int humanCapacity = 5;
    int martianCapacity = 5;
    Spaceship spaceship = new Spaceship(humanCapacity,martianCapacity);
    Passenger human1 = new Human( "Emma");
    Passenger human2 = new Human( "Rose");
    Passenger martian1 = new Martian("Ekow");
    Passenger martian2 = new Martian("Debbie");


    @Test
    void testSpaceshipCapacity(){
        assertEquals(10, spaceship.getSeats().size());
    }

    @Test
    void bookingIsSuccessfulTest() throws SpaceshipFullException {
        spaceship.book(human1);
        spaceship.book(martian2);
        assertTrue(spaceship.getSeatType(0).getBooked());
        assertTrue(spaceship.getSeatType(5).getBooked());
        assertEquals(8, spaceship.getAvailableSeats());
        Assertions.assertThat(spaceship.flightlistOfSpaceship()).contains(human1);
        Assertions.assertThat(spaceship.flightlistOfSpaceship()).contains(martian2);


    }

    @Test
    void SpaceshipIsFullForMartian() throws SpaceshipFullException {
        for(int i = 0; i < 5; i++ ){
            spaceship.book(martian1);
        }
        assertThrows(SpaceshipFullException.class, ()-> spaceship.book(martian2), "Spaceship at capacity for Martians");
        assertEquals(5, spaceship.getAvailableSeats());
        assertEquals(5, spaceship.flightlistOfSpaceship().size());
        Assertions.assertThat(spaceship.flightlistOfSpaceship()).doesNotContain(martian2);
        assertFalse(spaceship.getSeatType(0).getBooked());

    }

    @Test
    void SpaceshipIsFullForHuman() throws SpaceshipFullException {
        for(int i = 0; i < 5; i++ ){
            spaceship.book(human1);
        }
        spaceship.book(martian1);
        assertThrows(SpaceshipFullException.class, ()-> spaceship.book(human2), "Spaceship at capacity for Humans");
        assertEquals(4, spaceship.getAvailableSeats());
        assertEquals(6, spaceship.flightlistOfSpaceship().size());
        Assertions.assertThat(spaceship.flightlistOfSpaceship()).doesNotContain(human2);
        assertTrue(spaceship.getSeatType(0).getBooked());

    }



    @Test
    void serveMealToBookedSeatTest() throws SeatIsEmptyException, SpaceshipFullException {
       spaceship.book(human1);
       spaceship.book(martian1);
       assertEquals("Human meal", spaceship.serveMeal(spaceship.getSeatType(human1)));
       assertEquals("Martian meal", spaceship.serveMeal(spaceship.getSeatType(martian1)));

    }

    @Test
    void serveMealToEmptySeatTest() throws SpaceshipFullException {
        spaceship.book(human1);
        spaceship.book(martian1);
        assertThrows(SeatIsEmptyException.class, ()-> spaceship.serveMeal(spaceship.getSeats().get(1)));
        assertThrows(SeatIsEmptyException.class, ()-> spaceship.serveMeal(spaceship.getSeats().get(6)));
        assertThrows(SeatIsEmptyException.class, ()-> spaceship.serveMeal(spaceship.getSeatType(martian2)), "Passenger not on flight or seat does not exist");


    }

    @Test
    void testPlutoIsAMoonForHumans(){
        assertThat(human1.plutoBelief()).isEqualTo(Pluto.MOON);
    }

    @Test
    void testPlutoIsAPlanetForMartians(){
        assertThat(martian1.plutoBelief()).isEqualTo(Pluto.PLANET);
    }
}