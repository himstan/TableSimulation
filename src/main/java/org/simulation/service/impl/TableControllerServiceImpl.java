package org.simulation.service.impl;


import org.simulation.model.Position;
import org.simulation.model.Table;
import org.simulation.service.TableControllerService;

import java.time.temporal.ValueRange;

/**
 * Controls the object's movement on a table.
 */
public class TableControllerServiceImpl implements TableControllerService {

    private final ValueRange heightRange;
    private final ValueRange widthRange;
    private final Position currentPosition;

    public TableControllerServiceImpl(final Table table, final Position starterPosition) {
        this.currentPosition = starterPosition;
        this.heightRange = ValueRange.of(0, table.height() - 1);
        this.widthRange = ValueRange.of(0, table.width() - 1);
        validateTableRanges(table);
    }

    /**
     * {@inheritDoc}
     */
    public boolean isCurrentPositionOnTable() {
        return widthRange.isValidIntValue(currentPosition.getX())
            && heightRange.isValidIntValue(currentPosition.getY());
    }

    /**
     * {@inheritDoc}
     */
    public void stepForward() {
        currentPosition.step(1);
    }

    /**
     * {@inheritDoc}
     */
    public void stepBackward() {
        currentPosition.step(-1);
    }

    /**
     * {@inheritDoc}
     */
    public void rotateRight() {
        currentPosition.rotateRight();
    }

    /**
     * {@inheritDoc}
     */
    public void rotateLeft() {
        currentPosition.rotateLeft();
    }

    /**
     * {@inheritDoc}
     */
    public Position getCurrentPosition() {
        return currentPosition;
    }

    private void validateTableRanges(final Table table) {
        if (table.height() < 1 || table.width() < 1) {
            throw new IllegalArgumentException("Both table dimensions should be bigger than 0");
        }
    }
}
