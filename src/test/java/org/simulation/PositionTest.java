package org.simulation;

import org.junit.Assert;
import org.junit.Test;
import org.simulation.model.Position;
import org.simulation.model.enums.Direction;

public class PositionTest {

    @Test
    public void test_stepOnceNorth() {
        final var position = new Position(2,2);
        position.step(1);
        Assert.assertEquals(Direction.NORTH, position.getDirection());
        Assert.assertEquals(2, position.getX());
        Assert.assertEquals(1, position.getY());
    }

    @Test
    public void test_rotateLeft() {
        final var position = new Position(2,2);
        position.rotateLeft();
        Assert.assertEquals(Direction.WEST, position.getDirection());
        Assert.assertEquals(2, position.getX());
        Assert.assertEquals(2, position.getY());
    }

    @Test
    public void test_rotateRight() {
        final var position = new Position(2,2);
        position.rotateRight();
        Assert.assertEquals(Direction.EAST, position.getDirection());
        Assert.assertEquals(2, position.getX());
        Assert.assertEquals(2, position.getY());
    }

    @Test
    public void test_rotateRightTwice() {
        final var position = new Position(2,2);
        position.rotateRight();
        position.rotateRight();
        Assert.assertEquals(Direction.SOUTH, position.getDirection());
        Assert.assertEquals(2, position.getX());
        Assert.assertEquals(2, position.getY());
    }

    @Test
    public void test_stepOnceEast() {
        final var position = new Position(2,2);
        position.rotateRight();
        position.step(1);
        Assert.assertEquals(Direction.EAST, position.getDirection());
        Assert.assertEquals(3, position.getX());
        Assert.assertEquals(2, position.getY());
    }

    @Test
    public void test_stepOnceWest() {
        final var position = new Position(2,2);
        position.rotateLeft();
        position.step(1);
        Assert.assertEquals(Direction.WEST, position.getDirection());
        Assert.assertEquals(1, position.getX());
        Assert.assertEquals(2, position.getY());
    }

    @Test
    public void test_stepOnceSouth() {
        final var position = new Position(2,2);
        position.rotateRight();
        position.rotateRight();
        position.step(1);
        Assert.assertEquals(Direction.SOUTH, position.getDirection());
        Assert.assertEquals(2, position.getX());
        Assert.assertEquals(3, position.getY());
    }
}
