package agh.ics.oop.model;

import java.util.*;

import static java.util.Collections.swap;

public class TextMap implements WorldNumberPositionMap<String, Integer> {

    private List<String> texts;

    public TextMap(){
        texts = new ArrayList<>();
    }

    @Override
    public boolean canMoveTo(Integer position) {
        return position >= 0 && position < texts.size();
    }

    @Override
    public boolean place(String object) {
        texts.add(object);
        return true;
    }

    @Override
    public void move(String object, MoveDirection direction) {
        int objectIndex = texts.indexOf(object);
        if (objectIndex == -1) return;
        int moveDir = switch(direction){
            case LEFT, BACKWARD -> -1;
            case RIGHT, FORWARD -> 1;
        };
        if (canMoveTo(objectIndex+moveDir)){
            swap(texts, objectIndex, objectIndex + moveDir);
        }
    }

    @Override
    public boolean isOccupied(Integer position) {
        return position >= 0 && position < texts.size();
    }

    @Override
    public String objectAt(Integer position) {
        if (isOccupied(position)) {
            return texts.get(position);
        }return null;
    }

    @Override
    public void createObjectsList(List<Integer> positions, List<String> objects) {

    }

    public String toString(){
        return texts.toString();
    }
}
