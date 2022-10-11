package org.simulation.model;

public class Cordinates {
    private int x;
    private int y;

    public Cordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Cordinates multiply(final int multiplyBy) {
        this.x *= multiplyBy;
        this.y *= multiplyBy;
        return this;
    }

    public Cordinates addCordinates(final int x, final int y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Cordinates addCordinates(final Cordinates cordinates) {
        addCordinates(cordinates.x, cordinates.y);
        return this;
    }
}
