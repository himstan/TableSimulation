package org.simulation.service;

import org.simulation.model.Position;

public interface TableControllerService {

    /**
     * Decides if the current position is on the table or not.
     *
     * @return  True if the current position is on the table, otherwise false.
     */
    boolean isCurrentPositionOnTable();

    /**
     * Steps forward in the current direction.
     */
    void stepForward();

    /**
     * Steps backwards in the opposite direction.
     */
    void stepBackward();

    /**
     * Rotates clockwise 90 degrees.
     */
    void rotateRight();

    /**
     * Rotates counterclockwise 90 degrees.
     */
    void rotateLeft();

    /**
     * Returns the current position of the object.
     *
     * @return The object's current position.
     */
    Position getCurrentPosition();
}
