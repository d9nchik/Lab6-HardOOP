package com.d9nich.exercise1;

public class Sphere extends FigureInSpace {
    public Sphere(double radius) {
        super(radius);
    }

    public Sphere() {
    }

    @Override
    public double getFullArea() {
        return 4 * Math.PI * Math.pow(getARadius(), 2);
    }

    @Override
    public double getVolume() {
        return 4 * Math.PI / 3 * Math.pow(getARadius(), 3);
    }

    public double getRadius() {
        return getARadius();
    }

    @Override
    public String toString() {
        return "Sphere{} " + super.toString();
    }
}
