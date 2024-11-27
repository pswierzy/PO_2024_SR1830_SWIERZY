package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.Arrays;
import java.util.List;

public class World {
    public static void main(String[] args) {

        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(2,3));
        WorldMap field = new GrassField(10);
        field.registerObserver(new ConsoleMapDisplay());
        Simulation simulation = new Simulation(positions, directions, field);

        WorldMap rect = new RectangularMap(10, 7);
        rect.registerObserver(new ConsoleMapDisplay());
        Simulation simulation1 = new Simulation(positions, directions, rect);

        List<Simulation>SimList = List.of(simulation, simulation1);
        SimulationEngine SimEng = new SimulationEngine(SimList);
        SimEng.runAsync();
        SimEng.awaitSimulationsEnd();

        System.out.println("KONIEC DZIALANIA SYSTEMU");
    }
}
