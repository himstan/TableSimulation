package org.simulation.parser;

import org.simulation.model.InitializationData;
import org.simulation.model.enums.SimulationStep;

import java.util.List;

/**
 * The interface for the input parsers.
 */
public interface InputParser {

    /**
     * Returns the data that is needed for the simulation to initialize.
     *
     * @return  The data record the simulation needs to start.
     */
    InitializationData getInitializationData();

    /**
     * Returns a list of steps which will occur in the simulation.
     *
     * @return  The list of simulation steps.
     */
    List<SimulationStep> getSteps();
}
