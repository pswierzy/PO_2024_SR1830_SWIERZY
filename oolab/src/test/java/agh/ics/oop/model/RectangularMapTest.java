package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void placeTest(){
        //given
        WorldMap map = new RectangularMap(5,5);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        //when
        boolean res1 = map.place(animal1);
        boolean res2 = map.place(animal2);
        //then
        assertTrue(res1);
        assertFalse(res2);
    }

    @Test
    void movingTest(){
        //given
        WorldMap map = new RectangularMap(5,5);
        Animal animal1 = new Animal();
        map.place(animal1);
        //when
        map.move(animal1, MoveDirection.FORWARD);
        //then
        assertEquals(animal1.getPosition(),new Vector2d(2,3));
        assertEquals(map.objectAt(animal1.getPosition()), animal1);
        assertTrue(map.objectAt(animal1.getPosition()) == animal1);
        assertFalse(map.isOccupied(new Vector2d(2,2)));
        assertTrue(map.isOccupied(new Vector2d(2,3)));
        assertTrue(map.canMoveTo(new Vector2d(2,2)));
        assertFalse(map.canMoveTo(new Vector2d(2,3)));
    }

    @Test
    void canMoveToTest(){
        //given
        WorldMap map = new RectangularMap(5,5);
        Animal animal1 = new Animal();
        map.place(animal1);
        //then
        assertTrue(map.canMoveTo(new Vector2d(2,3)));
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
        assertTrue(map.canMoveTo(new Vector2d(0,0)));
        assertFalse(map.canMoveTo(new Vector2d(-1,0)));
        assertFalse(map.canMoveTo(new Vector2d(0,-1)));
        assertFalse(map.canMoveTo(new Vector2d(-1,-1)));
        assertFalse(map.canMoveTo(new Vector2d(5,4)));
        assertFalse(map.canMoveTo(new Vector2d(5,5)));
        assertFalse(map.canMoveTo(new Vector2d(4,5)));
        assertTrue(map.canMoveTo(new Vector2d(4,4)));
    }
}