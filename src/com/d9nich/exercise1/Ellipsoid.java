package com.d9nich.exercise1;

public class Ellipsoid extends FigureInSpace {
    private final static double P = 1.6075;

    public Ellipsoid(double aRadius, double bRadius, double cRadius) {
        super(aRadius, bRadius, cRadius);
    }

    public Ellipsoid() {
    }

    /**
     * Thanks to site for given information: https://planetcalc.ru/149/
     */
    @Override
    public double getFullArea() {
        final double ap = Math.pow(getARadius(), P);
        final double bp = Math.pow(getBRadius(), P);
        final double cp = Math.pow(getCRadius(), P);
        final double fraction = (ap * bp + ap * cp + bp * cp) / 3;
        return 4 * Math.PI * Math.pow(fraction, 1 / P);
    }

    @Override
    public double getVolume() {
        return 4 * Math.PI / 3 * getARadius() * getBRadius() * getCRadius();
    }

    @Override
    public double getARadius() {
        return super.getARadius();
    }

    @Override
    public double getBRadius() {
        return super.getBRadius();
    }

    @Override
    public double getCRadius() {
        return super.getCRadius();
    }

    @Override
    public String toString() {
        return "Ellipsoid{} " + super.toString();
    }
}
