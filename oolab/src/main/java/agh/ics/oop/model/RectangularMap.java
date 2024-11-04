package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import javax.swing.text.Position;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangularMap implements WorldMap<Animal, Vector2d> {

    private Map<Vector2d, Animal> animals = new HashMap<>();
    private final int height;
    private final int width;

    public RectangularMap(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getPosition())) return false;
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
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public void createObjectsList(List<Vector2d> positions, List<Animal> objects) {
        for(Vector2d position : positions) {
            objects.add(new Animal(position));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (isOccupied(position)) return false;
        int x = position.getX();
        int y = position.getY();
        return (x<width && x>=0 && y<height && y>=0);
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(new Vector2d(0,0), new Vector2d(width-1,height-1));
    }
}
