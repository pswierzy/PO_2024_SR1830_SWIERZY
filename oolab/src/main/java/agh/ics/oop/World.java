package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.Arrays;
import java.util.List;

public class World {

    public static void main(String[] args) {

        List<MoveDirection> directions = OptionsParser.parse(args);
        List<String> strings = List.of("ala", "ma", "sowoniedźwiedzia");
        TextMap map = new TextMap();
        Simulation<String, Integer> simulation = new Simulation<>(directions, map, strings);
        simulation.run();
    }
}
