package org.simulation.mapper;

import org.simulation.model.enums.SimulationStep;

public final class SimulationStepMapper {

    private SimulationStepMapper() {
    }

    public static SimulationStep mapToSimulationStep(int stepIndex) {
        return switch (stepIndex) {
            case 0 -> SimulationStep.STOP_SIMULATION;
            case 1 -> SimulationStep.STEP_FORWARD;
            case 2 -> SimulationStep.STEP_BACKWARDS;
            case 3 -> SimulationStep.ROTATE_RIGHT;
            case 4 -> SimulationStep.ROTATE_LEFT;
            default -> throw new IllegalArgumentException("Simulation step is not known.");
        };
    }
}
