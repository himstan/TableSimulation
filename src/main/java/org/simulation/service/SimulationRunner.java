package org.simulation.service;

import org.simulation.model.TableResult;

/**
 * Service class for handling simulations.
 */
public interface SimulationRunner {

    /**
     * Runs a simulation on a table with the given steps.
     *
     * @param table The table the simulation is going to take place on.
     * @param starterPosition The object's starter position on the table.
     * @param steps The steps the object is going to take in the simulation.
     *
     * @return The result of the simulation.
     */
    TableResult runSimulation();
}
