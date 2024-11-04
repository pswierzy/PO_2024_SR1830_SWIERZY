package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation <T,P>{

    private WorldMap<T,P> map;
    private final List<P> startPositions;
    private final List<MoveDirection> moves;
    private List<T> objects;

    public Simulation(List <P> startPositions, List <MoveDirection> moves, WorldMap<T,P> map) {
        this.startPositions = startPositions;
        this.moves = moves;
        this.map = map;

        objects = new ArrayList<>(startPositions.size());
        map.createObjectsList(startPositions, objects);
    }
    public Simulation(List<MoveDirection> moves, WorldMap<T,P> map, List<T> objects) {
        this.startPositions = new ArrayList<>();
        this.moves = moves;
        this.map = map;
        this.objects = objects;
    }

    public void run(){
        int numberOfObjects = objects.size();
        int currentObjectIndex = 0;

        for (T object : objects) {
            map.place(object);
        }

        for (MoveDirection move : moves) {

            if (currentObjectIndex == numberOfObjects) currentObjectIndex = 0;

            map.move(objects.get(currentObjectIndex), move);
            System.out.println(map);

            currentObjectIndex++;
        }
    }
}
