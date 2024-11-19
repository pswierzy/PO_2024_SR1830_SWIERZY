package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void isAtTest() {
        //given
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(2,4));
        Animal animal3 = new Animal(new Vector2d(100,4));
        //then
        assertTrue(animal1.isAt(new Vector2d(2,2)));
        assertFalse(animal1.isAt(new Vector2d(2,4)));
        assertTrue(animal2.isAt(new Vector2d(2,4)));
        assertTrue(animal3.isAt(new Vector2d(100,4)));
    }

    @Test
    void moveTest(){
        //given
        WorldMap map = new RectangularMap(5,5);
        Animal animal1 = new Animal(new Vector2d(1,1));
        Animal animal2 = new Animal(new Vector2d(2,2));
        Animal animal3 = new Animal(new Vector2d(3,3));
        Animal animal4 = new Animal(new Vector2d(4,4));
        //when
        animal1.move(MoveDirection.FORWARD, map);
        animal2.move(MoveDirection.BACKWARD, map);
        animal3.move(MoveDirection.RIGHT, map);
        animal4.move(MoveDirection.LEFT, map);
        //then
        assertEquals(MapDirection.NORTH,animal1.getDirection());
        assertEquals(new Vector2d(1,2), animal1.getPosition());
        assertEquals(new Vector2d(2,1), animal2.getPosition());
        assertEquals(new Vector2d(3,3), animal3.getPosition());
        assertEquals(MapDirection.EAST, animal3.getDirection());
        assertEquals(MapDirection.WEST, animal4.getDirection());
    }

}