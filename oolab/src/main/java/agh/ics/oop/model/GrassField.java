package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {

    private Map<Vector2d, Grass> grassMap = new HashMap<>();
    private int numberOfGrass;

    public GrassField(int numberOfGrass) {
        this.numberOfGrass = numberOfGrass;
        createGrassMap();
    }
    private void createGrassMap() {
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator((int)sqrt(10*numberOfGrass), (int)sqrt(10*numberOfGrass), numberOfGrass);
        for(Vector2d grassPosition : randomPositionGenerator) {
            grassMap.put(grassPosition, new Grass(grassPosition));
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || grassMap.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if(animals.containsKey(position)) return super.objectAt(position);
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

    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> elements = super.getElements();
        elements.addAll(grassMap.values());
        return elements;
    }
}
