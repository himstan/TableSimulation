package org.simulation.parser.impl;

import org.simulation.mapper.SimulationStepMapper;
import org.simulation.model.InitializationData;
import org.simulation.model.Position;
import org.simulation.model.Table;
import org.simulation.model.enums.SimulationStep;
import org.simulation.parser.InputParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * An input org.simulation.parser that accepts input from the console.
 */
public class ConsoleInputParserImpl implements InputParser {

    private final String SPLIT_CHAR = ",";
    private final int INIT_DATA_LENGTH = 4;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * {@inheritDoc}
     */
    @Override
    public InitializationData getInitializationData() {
        System.out.println("Please type in the table's width and height, and the starter x and y cordinates. Example: [4,4,2,2]");
        final var input = getInputFromConsole();
        final var inputList = validateAndReturnInitData(input);
        final var table = getTable(inputList);
        final var starterPosition = getStarterPosition(inputList);
        return new InitializationData(table, starterPosition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SimulationStep> getSteps() {
        printStepInstructions();
        final var input = getInputFromConsole();
        return validateAndReturnSteps(input);
    }

    private void printStepInstructions() {
        System.out.println("Please type in the commands that will be executed during the simulation! Example: [1,4,1,3,2,3,2,4,1,0]");
        System.out.println("Available commands:");
        System.out.println("    0 -> Quit the simulation and print the results.");
        System.out.println("    1 -> Move forward one step.");
        System.out.println("    2 -> Move backwards one step.");
        System.out.println("    3 -> Rotate left.");
        System.out.println("    4 -> Rotate right.");
    }

    private Position getStarterPosition(final List<Integer> inputList) {
        return new Position(inputList.get(2), inputList.get(3));
    }

    private Table getTable(final List<Integer> inputList) {
        return new Table(inputList.get(0), inputList.get(1));
    }

    private List<SimulationStep> validateAndReturnSteps(final String input) {
        final var splitData = splitInput(input);
        return mapInputsToSteps(splitData);
    }

    private List<SimulationStep> mapInputsToSteps(final String[] inputs) {
        return Arrays.stream(inputs)
            .map(Integer::parseInt)
            .map(SimulationStepMapper::mapToSimulationStep)
            .toList();
    }

    private List<Integer> validateAndReturnInitData(final String input) {
        final var splitData = splitInput(input);
        if (splitData.length != INIT_DATA_LENGTH) {
            throw new IllegalArgumentException("A parameter is missing from the table size or the starter cordinates!");
        }
        return Arrays.stream(splitData).map(Integer::parseInt).toList();
    }

    private String[] splitInput(final String input) {
        return input.split(SPLIT_CHAR);
    }

    private String getInputFromConsole() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("There was a problem while trying to read the input.");
            throw new RuntimeException(e);
        }
    }
}
