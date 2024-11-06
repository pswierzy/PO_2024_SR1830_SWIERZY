package agh.ics.oop.model;

import agh.ics.oop.World;

public class Animal implements WorldElement {
    private MapDirection direction;
    private Vector2d position;

    public Animal(Vector2d position) {
        this.direction = MapDirection.NORTH;
        this.position = position;
    }
    public Animal() {
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public String toString() {
        return switch(this.direction) {
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }
    boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public MapDirection getDirection() {
        return direction;
    }
    public Vector2d getPosition() {
        return position;
    }

    public void move(MoveDirection direction, MoveValidator validator) {

        switch (direction) {
            case FORWARD: {
                if (validator.canMoveTo(this.position.add(this.direction.toUnitVector()))){
                    this.position = this.position.add(this.direction.toUnitVector());
                }
                break;
            }
            case BACKWARD: {
                if (validator.canMoveTo(this.position.subtract(this.direction.toUnitVector()))) {
                    this.position = this.position.subtract(this.direction.toUnitVector());
                }
                break;
            }
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case LEFT:
                this.direction = this.direction.previous();
                break;
        }
    }
}
