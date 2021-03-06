package com.d9nich.exercise1;

public class Tor extends FigureInSpace {

    public Tor(double bigRadius, double smallRadius) {
        super(bigRadius, smallRadius);
    }

    public double getBigRadius() {
        return super.getARadius();
    }

    public double getSmallRadius() {
        return super.getBRadius();
    }

    public Tor() {
        this(1, 1);
    }

    /**
     * Information has been provided by Wikipedia:
     * https://ru.wikipedia.org/wiki/%D0%A2%D0%BE%D1%80_(%D0%BF%D0%BE%D0%B2%D0%B5%D1%80%D1%85%D0%BD%D0%BE%D1%81%D1%82%D1%8C)
     */
    @Override
    public double getFullArea() {
        return 4 * Math.pow(Math.PI, 2) * getBigRadius() * getSmallRadius();
    }

    @Override
    public double getVolume() {
        return 2 * Math.pow(Math.PI, 2) * getBigRadius() * Math.pow(getSmallRadius(), 2);
    }

    @Override
    public String toString() {
        return "Tor{} " + super.toString();
    }
}
