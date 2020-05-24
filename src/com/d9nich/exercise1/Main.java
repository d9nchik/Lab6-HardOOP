package com.d9nich.exercise1;

public class Main {
    public static void main(String[] args) {
        FigureInSpace[] figureInSpaces = {new Ellipsoid(1, 2, 3), new Tor(4, 3),
                new Sphere(5)};

        for (FigureInSpace figureInSpace : figureInSpaces)
            System.out.println(figureInSpace);
    }
}
