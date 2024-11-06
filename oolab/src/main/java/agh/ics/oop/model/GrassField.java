package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField implements WorldMap {

    private Map<Vector2d, Grass> grassMap = new HashMap<>();
    private Map<Vector2d, Animal> animals = new HashMap<>();
    private int numberOfGrass;

    public GrassField(int numberOfGrass) {
        this.numberOfGrass = numberOfGrass;
        createGrassMap();
        grassMap.put(new Vector2d(3,3), new Grass(new Vector2d(3,3)));
    }
    private void createGrassMap() {
        Random rand = new Random();
        for (int i = 0; i < numberOfGrass; i++) {
            while(true){
                int x = rand.nextInt((int) sqrt(numberOfGrass*10)+1);
                int y = rand.nextInt((int) sqrt(numberOfGrass*10)+1);
                Vector2d pos = new Vector2d(x, y);
                if (!grassMap.containsKey(pos)){
                    Grass grass = new Grass(pos);
                    grassMap.put(pos, grass);
                    break;
                }
            }
        }
    }

    @Override
    public boolean place(Animal animal) {
        if(!canMoveTo(animal.getPosition())) return false;
        animals.put(animal.getPosition(), animal);
        return true;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        animals.remove(animal.getPosition());
        animal.move(direction, this);
        place(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position) || grassMap.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if(animals.containsKey(position)) return animals.get(position);
        return grassMap.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public String toString() {
        int maxX = (int) sqrt(numberOfGrass*10);
        int maxY = (int) sqrt(numberOfGrass*10);
        for(Vector2d position : grassMap.keySet()){
            if (position.getX()>maxX) maxX = position.getX();
            if (position.getY()>maxY) maxY = position.getY();
        }
        return new MapVisualizer(this).draw(new Vector2d(0,0), new Vector2d(maxX,maxY));
    }
}
