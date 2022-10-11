package org.simulation.util;

import org.simulation.model.Cordinates;
import org.simulation.model.enums.Direction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DirectionUtils {

    private static List<Direction> directionList = List.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
    private static Map<Direction, Cordinates> cordinatesMap = new HashMap<>();

    static {
        cordinatesMap.put(Direction.NORTH, new Cordinates(0, -1));
        cordinatesMap.put(Direction.EAST, new Cordinates(1, 0));
        cordinatesMap.put(Direction.SOUTH, new Cordinates(0, 1));
        cordinatesMap.put(Direction.WEST, new Cordinates(-1, 0));
    }

    private DirectionUtils() {
    }

    /**
     * Get the cordination steps in a direction.
     *
     * @param direction The direction you want to step in.
     * @param steps     The steps you want to take in that direction.
     *
     * @return  The step cordinates.
     */
    public static Cordinates getDirectionStepCordinates(final Direction direction, final int steps) {
        final var cordinates = cordinatesMap.get(direction);
        final var directionCords = new Cordinates(cordinates.getX(), cordinates.getY());
        return directionCords.multiply(steps);
    }

    /**
     * Rotates a direction and returns the new direction.
     *
     * @param direction The direction you are rotating from.
     * @param rotate    The amount the direction is being rotated, the direction is based on the number's sign.
     *
     * @return  The new direction.
     */
    public static Direction rotateDirection(final Direction direction, final int rotate) {
        final var indexOfDirection = getIndexOfDirection(direction);
        final var newIndexDirection = Math.floorMod((indexOfDirection + rotate), directionList.size());
        return directionList.get(newIndexDirection);
    }

    private static int getIndexOfDirection(final Direction direction) {
        return directionList.indexOf(direction);
    }
}
