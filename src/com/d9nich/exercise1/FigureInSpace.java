package com.d9nich.exercise1;

public abstract class FigureInSpace {
    private final double aRadius;
    private final double bRadius;
    private final double cRadius;

    public FigureInSpace(double aRadius, double bRadius, double cRadius) {
        this.aRadius = aRadius > 0 ? aRadius : 1;
        this.bRadius = bRadius > 0 ? bRadius : 1;
        this.cRadius = cRadius > 0 ? cRadius : 1;
    }

    public FigureInSpace(double aRadius, double bRadius) {
        this(aRadius, bRadius, 1);
    }

    public FigureInSpace(double aRadius) {
        this(aRadius, 1);
    }

    public FigureInSpace() {
        this(1, 1);
    }

    protected double getCRadius() {
        return cRadius;
    }

    protected double getARadius() {
        return aRadius;
    }

    protected double getBRadius() {
        return bRadius;
    }

    public abstract double getFullArea();

    public abstract double getVolume();
}
