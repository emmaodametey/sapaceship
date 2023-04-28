package org.example.passenger;

import org.example.space.Pluto;

public class Martian extends Passenger {
    public Martian(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Martian " + getName();
    }

    @Override
    public String plutoBelief(Pluto pluto) {
        return pluto + "is a planet";
    }


}
