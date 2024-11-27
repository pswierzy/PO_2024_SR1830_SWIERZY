package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {

    private int amountOfChanges;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        System.out.println("Changes on map " + worldMap.getID() + ": " + message + "\n");
        System.out.println(worldMap);
        System.out.println("Amount of changes: " + ++amountOfChanges + "\n");
    }
}