package org.simulation.service.impl;

import org.simulation.model.TableResult;
import org.simulation.parser.InputParser;
import org.simulation.service.SimulationRunner;

public class SimulationRunnerImpl implements SimulationRunner {

    private final InputParser inputParser;

    public SimulationRunnerImpl(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TableResult runSimulation() {
        final var initData = inputParser.getInitializationData();
        final var tableController = new TableControllerServiceImpl(initData.table(), initData.startingPosition());
        final var simulationSteps = inputParser.getSteps();
        final var simulationService = new SimulationServiceImpl(tableController);
        return simulationService.runStepsAndGetResult(simulationSteps);
    }
}
