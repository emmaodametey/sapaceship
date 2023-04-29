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
    public Pluto plutoBelief() {
        return Pluto.PLANET;
    }

    @Override
    public String alienSpecie() {
        return "Martians";
    }


}
