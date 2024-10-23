package agh.ics.oop.model;

public class Animal {
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
        return direction.toString() + " " + position.toString();
    }
    boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    void move(MoveDirection direction) {
        switch (direction) {
            case FORWARD: {
                this.position.add(this.direction.toUnitVector());
                if (this.position.getX()<0||this.position.getY()<0||this.position.getX()>4||this.position.getY()>4) {
                    this.position.subtract(this.direction.toUnitVector());
                }
            }
            case BACKWARD: {
                this.position.subtract(this.direction.toUnitVector());
                if (this.position.getX()<0||this.position.getY()<0||this.position.getX()>4||this.position.getY()>4) {
                    this.position.add(this.direction.toUnitVector());
                }
            }
            case RIGHT:
                this.direction = this.direction.next();
            case LEFT:
                this.direction = this.direction.previous();
        }
    }

}
