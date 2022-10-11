package org.simulation.service.impl;

import org.simulation.model.Position;
import org.simulation.model.TableResult;
import org.simulation.model.enums.SimulationStep;
import org.simulation.service.SimulationService;
import org.simulation.service.TableControllerService;

import java.util.List;

public class SimulationServiceImpl implements SimulationService {

    private final TableControllerService tableController;

    public SimulationServiceImpl(final TableControllerService tableControllerService) {
        this.tableController = tableControllerService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TableResult runStepsAndGetResult(List<SimulationStep> steps) {
        final var stepsIterator = steps.listIterator();
        var currentStep = stepsIterator.next();
        while (currentStep != SimulationStep.STOP_SIMULATION) {
            switch (currentStep) {
                case STEP_FORWARD -> tableController.stepForward();
                case STEP_BACKWARDS -> tableController.stepBackward();
                case ROTATE_LEFT -> tableController.rotateLeft();
                case ROTATE_RIGHT -> tableController.rotateRight();
            }
            if (stepsIterator.hasNext()) {
                currentStep = stepsIterator.next();
            } else {
                throw new RuntimeException("Step list didn't end with the step " + SimulationStep.STOP_SIMULATION);
            }
        }
        final var isOnTable = tableController.isCurrentPositionOnTable();
        final var currentPosition = isOnTable
            ? tableController.getCurrentPosition()
            : new Position(-1, -1);
        return new TableResult(isOnTable, currentPosition);
    }
}
