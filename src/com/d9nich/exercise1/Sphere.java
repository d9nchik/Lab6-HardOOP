package com.d9nich.exercise1;

public class Sphere extends FigureInSpace {
    public Sphere(double radius) {
        super(radius);
    }

    public Sphere() {
    }

    @Override
    public double getFullArea() {
        return 4 * Math.PI * Math.pow(getRadiusBig(), 2);
    }

    @Override
    public double getVolume() {
        return 4 * Math.PI / 3 * Math.pow(getRadiusBig(), 3);
    }

    public double getRadius(){
        return getRadiusBig();
    }
}
