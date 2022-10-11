package org.simulation.service;

import org.simulation.model.TableResult;
import org.simulation.model.enums.SimulationStep;

import java.util.List;

public interface SimulationService {

    /**
     * Runs the simulation and returns the result.
     *
     * @param steps The steps that are going to take place in the simulation.
     *
     * @return  The results of the simulation.
     */
    TableResult runStepsAndGetResult(final List<SimulationStep> steps);
}
