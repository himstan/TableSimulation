package org.simulation.model;

import org.simulation.model.enums.Direction;
import org.simulation.util.DirectionUtils;

/**
 * Respresents the object's current position-
 *
 * @param x The object's position on the x axis.
 * @param y The object's position on the y axis.
 * @param direction The direction the object is currently facing.
 */
public class Position {
    private Cordinates cordinates;
    private Direction direction;

    public Position(int x, int y) {
        this.cordinates = new Cordinates(x, y);
        this.direction = Direction.NORTH;
    }

    public int getX() {
        return cordinates.getX();
    }

    public int getY() {
        return cordinates.getY();
    }

    public Direction getDirection() {
        return direction;
    }

    public void rotateLeft() {
        this.direction = DirectionUtils.rotateDirection(this.direction, -1);
    }

    public void rotateRight() {
        this.direction = DirectionUtils.rotateDirection(this.direction, 1);
    }

    public void step(final int steps) {
        final var directionStep = DirectionUtils.getDirectionStepCordinates(this.direction, steps);
        this.cordinates = this.cordinates.addCordinates(directionStep);
    }
}
