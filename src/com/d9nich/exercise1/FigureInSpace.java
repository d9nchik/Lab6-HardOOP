package com.d9nich.exercise1;

public abstract class FigureInSpace {
    private final double radiusBig;
    private final double radiusSmall;

    public FigureInSpace(double radiusBig, double radiusSmall){
        this.radiusBig = radiusBig >0? radiusBig :1;
        this.radiusSmall = radiusSmall >0? radiusBig :1;
    }

    public FigureInSpace(double radiusBig) {
        this(radiusBig, 1);
    }

    public FigureInSpace() {
        this(1, 1);
    }

    protected double getRadiusBig() {
        return radiusBig;
    }

    protected double getRadiusSmall(){
        return radiusSmall;
    }

    public abstract double getFullArea();
    public abstract double getVolume();
}
