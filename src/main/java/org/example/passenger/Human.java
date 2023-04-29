package org.example.passenger;

import org.example.space.Pluto;

public class Human extends Passenger {
    public Human(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Human " + getName();
    }

    public Pluto plutoBelief() {
        return Pluto.MOON;
    }
    @Override
    public String alienSpecie() {
        return "Humans";
    }

}
