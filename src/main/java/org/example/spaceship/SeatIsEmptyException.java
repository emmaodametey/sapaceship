package org.example.spaceship;

public class SeatIsEmptyException extends Exception{
    public SeatIsEmptyException(String message){
        super(message);
    }
}
