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

    @Override
    public String plutoBelief(Pluto pluto) {
        return pluto + "is a moon";
    }

}
