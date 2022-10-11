package org.simulation.model;

public record TableResult(
    boolean isOnTable,
    Position lastPosition
) {

    @Override
    public String toString() {
        return String.format("[%d,%d]", lastPosition.getX(), lastPosition.getY());
    }
}
