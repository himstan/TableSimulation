package org.simulation;

import org.junit.Assert;
import org.junit.Test;
import org.simulation.model.Position;
import org.simulation.model.Table;
import org.simulation.model.enums.Direction;
import org.simulation.model.enums.SimulationStep;
import org.simulation.service.SimulationService;
import org.simulation.service.TableControllerService;
import org.simulation.service.impl.SimulationServiceImpl;
import org.simulation.service.impl.TableControllerServiceImpl;

import java.util.List;

public class SimulationServiceTest {

    @Test
    public void test_runValidSimulation1() {
        final var simulationService = getSimulationService();
        final var steps = List.of(
            SimulationStep.STEP_FORWARD,
            SimulationStep.ROTATE_RIGHT,
            SimulationStep.STEP_FORWARD,
            SimulationStep.STOP_SIMULATION);
        final var resultPosition = simulationService.runStepsAndGetResult(steps).lastPosition();
        Assert.assertEquals(3, resultPosition.getX());
        Assert.assertEquals(1, resultPosition.getY());
        Assert.assertEquals(Direction.EAST, resultPosition.getDirection());
    }

    @Test
    public void test_runValidSimulation2() {
        final var simulationService = getSimulationService();
        final var steps = List.of(
            SimulationStep.STEP_FORWARD,
            SimulationStep.ROTATE_LEFT,
            SimulationStep.STEP_FORWARD,
            SimulationStep.ROTATE_RIGHT,
            SimulationStep.ROTATE_RIGHT,
            SimulationStep.STEP_BACKWARDS,
            SimulationStep.STOP_SIMULATION);
        final var resultPosition = simulationService.runStepsAndGetResult(steps).lastPosition();
        Assert.assertEquals(0, resultPosition.getX());
        Assert.assertEquals(1, resultPosition.getY());
        Assert.assertEquals(Direction.EAST, resultPosition.getDirection());
    }

    @Test
    public void test_runInvalidSimulation() {
        final var simulationService = getSimulationService();
        final var steps = List.of(
            SimulationStep.STEP_FORWARD,
            SimulationStep.ROTATE_RIGHT,
            SimulationStep.STEP_FORWARD);
        Assert.assertThrows(RuntimeException.class, () -> simulationService.runStepsAndGetResult(steps));
    }

    private SimulationService getSimulationService() {
        final var tableController = getTableController();
        return new SimulationServiceImpl(tableController);
    }

    private TableControllerService getTableController() {
        final var table = new Table(4,4);
        final var starterPosition = new Position(2,2);
        return new TableControllerServiceImpl(table, starterPosition);
    }
}
