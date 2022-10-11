package org.simulation.util;

import org.junit.Assert;
import org.junit.Test;
import org.simulation.model.enums.Direction;

public class DirectionUtilTest {

    @Test
    public void testRotateRight() {
        final var startingDirection = Direction.NORTH;
        final var actualRotatedDirection = DirectionUtils.rotateDirection(startingDirection, 1);
        final var expectedRotatedDirection = Direction.EAST;
        Assert.assertEquals(expectedRotatedDirection, actualRotatedDirection);
    }

    @Test
    public void testRotateLeft() {
        final var startingDirection = Direction.NORTH;
        final var actualRotatedDirection = DirectionUtils.rotateDirection(startingDirection, -1);
        final var expectedRotatedDirection = Direction.WEST;
        Assert.assertEquals(expectedRotatedDirection, actualRotatedDirection);
    }

    @Test
    public void testRotate180Degrees() {
        final var startingDirection = Direction.NORTH;
        final var actualRotatedDirection = DirectionUtils.rotateDirection(startingDirection, -2);
        final var expectedRotatedDirection = Direction.SOUTH;
        Assert.assertEquals(expectedRotatedDirection, actualRotatedDirection);
    }

    @Test
    public void testGetDirectionStepNorth() {
        final var direction = Direction.NORTH;
        final var stepCordinates = DirectionUtils.getDirectionStepCordinates(direction, 1);
        Assert.assertEquals(0, stepCordinates.getX());
        Assert.assertEquals(-1, stepCordinates.getY());
    }

    @Test
    public void testGetDirectionMultipleStepsNorth() {
        final var direction = Direction.NORTH;
        final var stepCordinates = DirectionUtils.getDirectionStepCordinates(direction, 2);
        Assert.assertEquals(0, stepCordinates.getX());
        Assert.assertEquals(-2, stepCordinates.getY());
    }
}
