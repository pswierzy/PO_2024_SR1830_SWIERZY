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
        this.MapID = NextMapID;
        NextMapID++;
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
    public List<WorldElement> getElements() {
        List<WorldElement> elements = super.getElements();
        elements.addAll(grassMap.values());
        return elements;
    }

    @Override
    public Boundary getCurrentBounds(){
        int maxX = (int) sqrt(numberOfGrass*10);
        int maxY = (int) sqrt(numberOfGrass*10);
        Vector2d up_right = new Vector2d(maxX, maxY);
        Vector2d down_left = new Vector2d(0, 0);
        for(Vector2d position : animals.keySet()){
            up_right = up_right.upperRight(position);
            down_left = down_left.lowerLeft(position);
        }
        return new Boundary(down_left, up_right);
    }
}
