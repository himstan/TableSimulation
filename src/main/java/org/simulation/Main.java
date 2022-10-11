package org.simulation;

import org.simulation.parser.impl.ConsoleInputParserImpl;
import org.simulation.service.impl.SimulationRunnerImpl;

public class Main {

    public static void main(final String[] args) {
        final var inputParser = new ConsoleInputParserImpl();
        final var simulationService = new SimulationRunnerImpl(inputParser);
        final var result = simulationService.runSimulation();
        System.out.println(result);
    }
}
