package org.simulation.model;

/**
 * The initialization data the simulation needs to start.
 *
 * @param table             The table the simulation is going to start in.
 * @param startingPosition  The position the simulation is going to start from.
 */
public record InitializationData(
    Table table,
    Position startingPosition
) {
}
